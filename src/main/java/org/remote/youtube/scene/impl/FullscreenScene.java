package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.scene.Scene;

import static org.remote.youtube.actuate.xDoToolUtil.*;

@Slf4j
public class FullscreenScene extends VideoPlayerScene {

    @Override
    public Scene rotaryDouble() {

        return this;
    }

    @Override
    public Scene analogLeftR() {
        keyRight();

        return this;
    }

    @Override
    public Scene analogLeftL() {
        keyLeft();

        return this;
    }

    @Override
    public Scene analogLeftD() {
        pageDown();

        return this;
    }

    @Override
    public Scene analogLeftU() {
        pageUp();

        return this;
    }
}
