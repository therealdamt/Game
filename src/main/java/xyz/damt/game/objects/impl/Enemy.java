package xyz.damt.game.objects.impl;

import xyz.damt.game.objects.Object;
import xyz.damt.game.objects.ObjectId;

import java.awt.*;
import java.util.Random;

public class Enemy extends Object {

    public Enemy(int x, int y, ObjectId objectId) {
        super(x, y, objectId);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 32, 32);
    }


}
