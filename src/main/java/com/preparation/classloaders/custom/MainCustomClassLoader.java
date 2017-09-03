package com.preparation.classloaders.custom;

import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Created by vlados on 9/3/2017.
 */
public class MainCustomClassLoader {
    public final static String CLASS_TO_LOAD = "com.preparation.classloaders.custom.UserServiceImpl";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        CustomClassLoader classLoader = new CustomClassLoader();
        Class<?> userServiceImpl = classLoader.loadClass(CLASS_TO_LOAD);

        UserService userService = (UserService) userServiceImpl.newInstance();
        userService.printFirstName();
        userService.printLastName();

        System.out.println("UserService instance loader: " + userService.getClass().getClassLoader());
        System.out.println("UserServiceImpl loader: " + UserServiceImpl.class.getClassLoader());
        System.out.println("UserService loader: " + UserService.class.getClassLoader());
        System.out.println("Object class Loader: " + Object.class.getClassLoader());
        System.out.println("Path form where we load classes by system class loader: " + (Arrays.toString(((URLClassLoader)UserService.class.getClassLoader()).getURLs())));
    }
}
