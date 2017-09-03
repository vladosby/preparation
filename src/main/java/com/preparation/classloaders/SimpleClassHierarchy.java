package com.preparation.classloaders;

/**
 * Created by vlados on 9/3/2017.
 */


public class SimpleClassHierarchy {

    public static void main(String[] args) {

        System.out.println("class loader for HashMap(Bootstrap Class Loade, have to be null): "
                + java.util.HashMap.class.getClassLoader());
        System.out.println("class loader for DNSNameService(Extensions Class Loader): "
                + sun.net.spi.nameservice.dns.DNSNameService.class
                .getClassLoader());

        System.out.println("class loader for SimpleClassHierarchy(System Class Loader): " + SimpleClassHierarchy.class.getClassLoader());
    }
}
