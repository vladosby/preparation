package com.preparation.classloaders.custom;

/**
 * Created by vlados on 9/3/2017.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void printFirstName() {
        System.out.println("First Name");
    }

    @Override
    public void printLastName() {
        System.out.println("Last Name");
    }
}
