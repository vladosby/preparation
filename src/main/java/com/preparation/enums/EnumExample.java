package com.preparation.enums;

/**
 * Description of class EnumExample
 *
 * @created: 9/20/2017
 */
public enum EnumExample {
    SMALL(2), MEDIUM(4), BIG(8);

    private int size;

    EnumExample(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println(EnumExample.BIG);
        System.out.println(EnumExample.BIG.getSize());
        System.out.println(EnumExample.BIG.name());
        System.out.println(EnumExample.BIG.ordinal());
    }
}
