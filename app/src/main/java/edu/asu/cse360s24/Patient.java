package edu.asu.cse360s24;

import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {

    String id;
    String firstName;
    String lastName;
    String password;
    String dateOfBirth; // "YYYY-MM-DD"
    int age;
    String phoneNumber; // "###-###-####"
    ArrayList<Message> messages;

    public Patient(String id) {
        this.id = id;
        this.messages = new ArrayList<Message>();
    }

    private static Random rand = new Random();

    static String generateID() {
        return String.valueOf(rand.nextInt(99999));
    }
}