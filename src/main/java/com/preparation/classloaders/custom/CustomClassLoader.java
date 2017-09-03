package com.preparation.classloaders.custom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.preparation.classloaders.custom.MainCustomClassLoader.CLASS_TO_LOAD;

/**
 * Created by vlados on 9/3/2017.
 */
public class CustomClassLoader extends ClassLoader {
    private final static String COMPILED_CLASS_DIRECTORY = "C:\\projects\\preparation\\target\\classes\\com\\preparation\\classloaders\\custom";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        // load using system loader
        if (!CLASS_TO_LOAD.equals(name)) {
            return super.findSystemClass(name);
        }

        System.out.printf("loadClass (%s)\n", name);
        String[] splittedName = name.split("\\.");
        String file = splittedName[splittedName.length - 1] + ".class";

        Path path = Paths.get(COMPILED_CLASS_DIRECTORY, file);
        try {
            byte[] bytes = Files.readAllBytes(path);
            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

