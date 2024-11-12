package org.remote.youtube.manager;

import org.asmus.model.QualifiedEType;
import org.remote.youtube.scene.Scene;
import org.remote.youtube.scene.impl.BaseScene;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class YoutubeSceneManager {

    private Scene currentScene = new BaseScene();

    public Disposable handle(Flux<QualifiedEType> fluxButtonEvents) {
        return fluxButtonEvents
                .subscribe(e ->  (currentScene = switch (e.getType()) {
                    case LEFT_STICK_LEFT -> currentScene.analogLeftL();
                    case LEFT_STICK_RIGHT -> currentScene.analogLeftR();
                    case LEFT_STICK_DOWN -> currentScene.analogLeftD();
                    case LEFT_STICK_UP -> currentScene.analogLeftU();
                    case LEFT_STICK_CLICK -> currentScene.leftStickClick();
                    case A -> currentScene.buttonA();
                    case B -> currentScene.buttonB();
                    case X -> currentScene.buttonX();
                    case Y -> currentScene.buttonY();
                    default -> currentScene;
                }).setPrevious(currentScene));
    }
}
