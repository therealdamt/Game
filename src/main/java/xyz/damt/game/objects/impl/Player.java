package xyz.damt.game.objects.impl;

import xyz.damt.game.Game;
import xyz.damt.game.objects.Object;
import xyz.damt.game.objects.ObjectId;

import javax.swing.*;
import java.awt.*;

public class Player extends Object {

    private final int originalX, originalY;

    public Player(int x, int y, ObjectId objectId) {
        super(x, y, objectId);

        this.originalX = x;
        this.originalY = y;
    }

    @Override
    public void tick() {
        Object object = Game.getInstance().getObjectHandler().getObject(ObjectId.ENEMY);

        if (object == null) {
            return;
        }

        if (object.isClose(this)) {
            setX(originalX);
            setY(originalY);

            JOptionPane.showMessageDialog(null, "You have lost!\nClick 'ok' to try again!", "Lost", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, 32, 32);
    }
}
