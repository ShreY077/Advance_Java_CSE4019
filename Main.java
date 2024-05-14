class Animal {
    public void eat() {
        System.out.println("Eating...");
    }

    protected void reproduce() {
        System.out.println("Reproducing...");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Barking...");
    }

    public void doActions() {
        eat();
        bark();
        reproduce();
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("Meowing...");
    }

    public void doActions() {
        eat();
        meow();
        reproduce();
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.doActions();

        Cat cat = new Cat();
        cat.doActions();
    }
}