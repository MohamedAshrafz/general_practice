package org.example;

public class initClass {
    public initClass(int hi, int they, int are) {
        this.integer1 = hi;
        this.integer2 = they;
        this.integer3 = are;
    }

    int integer1;
    int integer2;
    int integer3;

    public int getInteger1() {
        return integer1;
    }

    public void setInteger1(int integer1) {
        this.integer1 = integer1;
    }

    public int getInteger2() {
        return integer2;
    }

    public void setInteger2(int integer2) {
        this.integer2 = integer2;
    }

    public int getInteger3() {
        return integer3;
    }

    public void setInteger3(int integer3) {
        this.integer3 = integer3;
    }

    public static void main(String[] args) {
        System.out.println("hi");
    }

}
