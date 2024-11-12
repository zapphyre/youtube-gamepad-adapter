package org.remote.youtube.scene;

public interface Scene {

    Scene analogLeftR();

    Scene analogLeftL();

    Scene rotaryClick();

    Scene leftStickClick();

    Scene buttonRed();

    Scene buttonRedLong();

    Scene buttonX();

    Scene buttonY();

    Scene buttonA();

    Scene buttonB();

    Scene rotaryDouble();

    Scene goBack();

    void setPrevious(Scene previous);

    Scene analogLeftD();

    Scene analogLeftU();
}
