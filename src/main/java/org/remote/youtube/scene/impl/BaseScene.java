package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.scene.Scene;

import static org.remote.youtube.actuate.xDoToolUtil.*;

@Slf4j
public class BaseScene implements Scene {

    private Scene previous;
    private boolean back;

    @Override
    public Scene analogLeftR() {
        pageUp();

        return this;
    }

    @Override
    public Scene analogLeftL() {
        pageDown();

        return this;
    }

    @Override
    public Scene rotaryClick() {
        click();

        return this;
    }

    public Scene leftStickClick() {
        tabSwitchOn();

        return new TabSwitchScene();
    }

    @Override
    public Scene buttonRed() {
        return this;
    }

    @Override
    public Scene buttonRedLong() {
        return this;
    }

    @Override
    public Scene buttonX() {
        log.debug("base green click");

        pressCtrlT();

        return new NewTabScene();
    }

    @Override
    public Scene buttonY() {
        log.debug("base green long click");

        pressCtrlW();

        return new NewTabScene();
    }

    public Scene buttonA() {
        log.debug("base yellow click");

        togglePlayYoutube();

        return this;
    }

    public Scene buttonB() {
        pressF();

        return new FullscreenScene();
    }

    @Override
    public Scene rotaryDouble() {

        return previous;
    }

    @Override
    public Scene goBack() {
        if (back = !back)
            ffBack();
        else
            ffFwd();

        return previous;
    }

    @Override
    public void setPrevious(Scene previous) {
        this.previous = previous;
    }

    @Override
    public Scene analogLeftD() {
        return null;
    }

    @Override
    public Scene analogLeftU() {
        return null;
    }
}
