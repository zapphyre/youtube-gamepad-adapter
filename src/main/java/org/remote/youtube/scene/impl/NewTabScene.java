package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.actuate.xDoToolUtil;
import org.remote.youtube.scene.Scene;

import java.awt.*;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static org.remote.youtube.actuate.xDoToolUtil.*;

@Slf4j
public class NewTabScene extends BaseScene {

    private final Map<Integer, Dimension> mousePositionMap = Map.of(
        0, new Dimension(562, 853),
        1, new Dimension(1506, 853)
    );
    private final AtomicInteger mousePosition = new AtomicInteger();

    Function<Integer, Integer> round = curr -> curr > mousePositionMap.size() - 1 ? 0 : curr;

    @Override
    public Scene analogLeftR() {
        Optional.of(togglePointerLocation()).ifPresent(xDoToolUtil::setPointerLocation);
        if (mousePosition.get() == mousePositionMap.size() - 1) {
            pageUp();
        }

        return this;
    }

    @Override
    public Scene analogLeftL() {
        Optional.of(togglePointerLocation()).ifPresent(xDoToolUtil::setPointerLocation);
        log.info("mousePosition: {}", mousePosition);
        if (mousePosition.get() == 1) {
            pageDown();
        }

        return this;
    }

    @Override
    public Scene rotaryClick() {
        click();

        return new VideoPlayerScene();
    }

    Dimension togglePointerLocation() {
        return round.andThen(q -> {
                    mousePosition.set(q);
                    return mousePosition;
                })
                .andThen(AtomicInteger::getAndIncrement)
                .andThen(mousePositionMap::get)
                .apply(mousePosition.get());
    }
}
