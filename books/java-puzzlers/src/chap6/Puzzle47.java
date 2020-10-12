package chap6;

import common.AbstractPuzzle;

public class Puzzle47 extends AbstractPuzzle {

    public Puzzle47() {
        super(new Object(){}.getClass().getEnclosingClass().getName());
    }

    @Override
    public void showExample() {
        Dog[] dogs = {new Dog(), new Dog()};
        for (Dog dog : dogs) {
            dog.woof();
        }
        Cat[] cats = {new Cat(), new Cat(), new Cat()};
        for (Cat cat : cats) {
            cat.woof();
        }
        System.out.println(Dog.getCount());
        System.out.println(Cat.getCount());
    }

    private static class Counter {
        private static int count = 0;
        public static final synchronized void increment() {
            count++;
        }
        public static final synchronized int getCount() {
            return count;
        }
    }

    private class Dog extends Counter {
        public Dog() {}
        public void woof() {
            increment();
        }
    }

    private class Cat extends Counter {
        public Cat() {}
        public void woof() {
            increment();
        }
    }

    @Override
    public void showCorrect() {
        DogCorrect[] dogs = {new DogCorrect(), new DogCorrect()};
        for (DogCorrect dog : dogs) {
            dog.woof();
        }
        CatCorrect[] cats = {new CatCorrect(), new CatCorrect(), new CatCorrect()};
        for (CatCorrect cat : cats) {
            cat.meow();
        }
        System.out.println(DogCorrect.woofCount());
        System.out.println(CatCorrect.meowCount());
    }

    private static class DogCorrect {
        private static int woofCounter;
        public DogCorrect() {}
        public static int woofCount() {
            return woofCounter;
        }
        public void woof() {
            woofCounter++;
        }
    }

    private static class CatCorrect {
        private static int meowCount;
        public CatCorrect() {}
        public static int meowCount() {
            return meowCount;
        }
        public void meow() {
            meowCount++;
        }
    }
}
