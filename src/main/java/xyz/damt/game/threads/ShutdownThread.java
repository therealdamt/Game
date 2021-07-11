package xyz.damt.game.threads;

public class ShutdownThread extends Thread {

    public ShutdownThread() {
        this.setDaemon(false);
    }

    @Override
    public void run() {

    }

}
