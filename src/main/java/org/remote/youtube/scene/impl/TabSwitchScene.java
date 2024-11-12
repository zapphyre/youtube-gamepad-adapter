package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.scene.Scene;

import static org.remote.youtube.actuate.xDoToolUtil.*;

@Slf4j
public class TabSwitchScene extends BaseScene {

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
    public Scene rotaryClick() {
        pressSpace();
        tabSwitchOff();

        return new VideoPlayerScene();
    }
}
