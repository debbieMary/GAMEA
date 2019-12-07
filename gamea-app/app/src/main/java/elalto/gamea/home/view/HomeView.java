package elalto.gamea.home.view;

import elalto.network.entities.TokenManager;

public interface HomeView {
    void logout();
    void succesSend(String message);
    void errorSend(String message);
}
