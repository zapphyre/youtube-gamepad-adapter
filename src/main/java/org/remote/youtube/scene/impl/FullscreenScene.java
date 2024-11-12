package org.remote.youtube.scene.impl;

import lombok.extern.slf4j.Slf4j;
import org.remote.youtube.scene.Scene;

@Slf4j
public class FullscreenScene extends VideoPlayerScene {

    @Override
    public Scene rotaryDouble() {

        return this;
    }

    @Override
    public Scene analogLeftR() {

        return this;
    }

    @Override
    public Scene analogLeftL() {

        return this;
    }
}
