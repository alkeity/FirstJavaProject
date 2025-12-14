package net.alkeity.classwork.helloworld;

public final class Student extends Person {
    public Student(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello! My name is " + name + ", I'm a student!");
    }
}
