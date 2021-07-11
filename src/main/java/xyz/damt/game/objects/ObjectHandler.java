package xyz.damt.game.objects;

import lombok.Getter;
import xyz.damt.game.objects.impl.Player;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
public class ObjectHandler {

    private final List<Object> objects = new LinkedList<>();

    public void tickAll() {
        objects.forEach(Object::tick);
    }

    public void renderAll(Graphics graphics) {
        objects.forEach(object -> object.render(graphics));
    }

    public void addObjects(Object... objects) {
        this.objects.addAll(Arrays.asList(objects));
    }

    public void removeObjects(Object... objects) {
        this.objects.removeAll(Arrays.asList(objects));
    }

    public Object getObject(ObjectId objectId) {
        return objects.stream().filter(object -> object.getObjectId().equals(objectId)).findFirst().orElse(null);
    }

}
