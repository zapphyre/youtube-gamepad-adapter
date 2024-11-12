package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.scene.Scene;

import static org.remote.youtube.actuate.xDoToolUtil.pressF;

@Slf4j
public class VideoPlayerScene extends BaseScene {

    @Override
    public Scene leftStickClick() {
        pressF();

        return new FullscreenScene();
    }
}
