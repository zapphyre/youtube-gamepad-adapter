package org.remote.youtube;

import org.asmus.facade.TimedButtonGamepadFactory;
import org.remote.youtube.manager.YoutubeSceneManager;
import reactor.core.Disposable;

public class YoutubeRemoteMain {

    private final static YoutubeSceneManager sceneManager = new YoutubeSceneManager();

    public static void main(String[] args) {
        Disposable disposable = sceneManager.handle(TimedButtonGamepadFactory.createGamepadEventStream());

        Runtime.getRuntime().addShutdownHook(new Thread(disposable::dispose));
    }
}
