package net.alkeity.helloworld;

public class Person {
    protected String name;

    public Person(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello! My name is ".concat(name));
    }
}
