package StackandQueue;


import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

class Pet {
    private String type;

    Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {

    Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    Cat() {
        super("cat");
    }
}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.count = count;
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}

public class DogCatQueue {
    private long count;
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;

    public DogCatQueue() {
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err,not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        }else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty");
        }
    }

    public Dog pollDog() {
        if (!this.dogQ.isEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("dog queue is empty");
        }
    }

    public Cat pollCat() {
        if (!this.catQ.isEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("cat is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }
}
