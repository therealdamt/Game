package xyz.damt.game.objects;

import lombok.Getter;
import lombok.Setter;
import xyz.damt.game.util.NumberConversions;

import java.awt.*;

@Getter
@Setter
public abstract class Object {

    public abstract void render(Graphics graphics);


    protected int x, y;
    protected int velocityX, velocityY;
    private ObjectId objectId;

    protected int speed;
    private final int originalX, originalY;

    public Object(int x, int y, ObjectId objectId) {
        this.x = x;
        this.y = y;
        this.objectId = objectId;

        this.originalX = x;
        this.originalY = y;

        this.speed = 0;
    }

    public void tick() {
        this.x += speed;
        this.y += speed;
    }

    public boolean isClose(Object object) {
        return distance(object) <= 31;
    }

    public int speed(Object object) {
        return (speed - object.getSpeed());
    }

    //Credits to bukkit/spigot for this method
    public double distance(Object object) {
        return Math.sqrt(distanceSquared(object));
    }

    //Credits to bukkit/spigot for this method
    public double distanceSquared(Object object) {
        if (object == null) throw new IllegalArgumentException("The object specified is null");
        return NumberConversions.square(this.x - object.x) + NumberConversions.square(this.y - object.y);
    }

}
