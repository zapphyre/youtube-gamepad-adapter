package org.remote.youtube;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.asmus.facade.TimedButtonGamepadFactory;
import org.remote.youtube.manager.YoutubeSceneManager;
import reactor.core.Disposable;

@Slf4j
public class YoutubeRemoteMain {

    private final static YoutubeSceneManager sceneManager = new YoutubeSceneManager();

    @SneakyThrows
    public static void main(String[] args) {
        Disposable disposable = sceneManager.handle(TimedButtonGamepadFactory.createGamepadEventStream());

        Runtime.getRuntime().addShutdownHook(new Thread(disposable::dispose));

        log.info("jpad-youtube-remote running!");
    }
}
