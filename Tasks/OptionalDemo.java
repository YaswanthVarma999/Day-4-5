package com.streamex;

import java.util.Optional;

class Individual {
    private String fullName;

    public Individual(String fullName) {
        this.fullName = fullName;
    }

    public Optional<String> getFullName() {
        return Optional.ofNullable(fullName);
    }
}

public class OptionalDemo {
    public static void main(String[] args) {
        Individual personWithName = new Individual("Yaswanth");
        String name = personWithName.getFullName().orElse("Unknown");
        System.out.println("Full Name: " + name);

        if (personWithName.getFullName().isPresent() && personWithName.getFullName().get().equalsIgnoreCase("Yaswanth")) {
            System.out.println("Full Name is equal to Yaswanth");
        } else {
            System.out.println("Full Name is not equal to Yaswanth");
        }

        Individual personWithoutName = new Individual(null);
        String noName = personWithoutName.getFullName().orElse("No Name Provided");
        System.out.println("Full Name: " + noName);
    }
}

