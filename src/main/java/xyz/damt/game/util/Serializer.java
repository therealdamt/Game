package xyz.damt.game.util;

import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.Base64;

@UtilityClass
public class Serializer {

    public final String serialize(Object object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(object);
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    public final Object deserialize(String string) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(string));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        return objectInputStream.readObject();
    }

    public final String serializeArray(Object[] objects) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        for (Object object : objects)
            objectOutputStream.writeObject(object);

        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    public final Object[] deserializeArray(String data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(data));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        Object[] objects = new Object[objectInputStream.readInt()];

        for (int i = 0; i < objects.length; i++)
            objects[i] = objectInputStream.readObject();

        return objects;
    }

}
