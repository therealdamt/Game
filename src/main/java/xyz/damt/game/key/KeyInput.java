package xyz.damt.game.key;

import xyz.damt.game.Game;
import xyz.damt.game.objects.Object;
import xyz.damt.game.objects.ObjectId;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final Game game;

    public KeyInput(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Object object = game.getObjectHandler().getObject(ObjectId.PLAYER);

        if (object == null) return;

        switch (event.getKeyChar()) {
            case 'w':
                object.setY(object.getY() - 1);
                break;
            case 's':
                object.setY(object.getY() + 1);
                break;
            case 'a':
                object.setX(object.getX() - 1);
                break;
            case 'd':
                object.setX(object.getX() + 1);
                break;
            default:
                break;
        }
    }

}
