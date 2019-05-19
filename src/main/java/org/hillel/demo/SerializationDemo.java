package org.hillel.demo;

import java.io.*;
import java.util.Arrays;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User(1, "string");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        user.setStringVar("SOME STRING VAR VALUE");
        user.setParentVar("2222");
        oos.writeObject(user);

        System.out.println(Arrays.toString(bos.toByteArray()));
        String objectAsString = new String(bos.toByteArray());
        System.out.println(objectAsString);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        User restored = (User) ois.readObject();
        System.out.println(restored);
    }
}
