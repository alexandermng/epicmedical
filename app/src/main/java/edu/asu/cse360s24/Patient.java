package edu.asu.cse360s24;

import java.util.Random;
import java.util.ArrayList;

public class Patient {

    private String patientId = "";
    private String firstName = "";
    private String lastName = "";
    private String dateOfBirth = ""; // "MM/DD/YYYY"
    private int age = 0;
    private int phoneNumber = 0;
    private String password = "";

    private ArrayList<Message> messages;

    public Patient(String patientId, String firstName, String lastName, String dateOfBirth, int age,
            ArrayList<Message> messages, int phoneNumber, String password) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.messages = messages;
    }

    public Patient(String patientId, String firstName, String lastName, String dateOfBirth, int age, int phoneNumber,
            String password) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.messages = new ArrayList<Message>();
    }

    private void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private int getPhoneNumber() {
        return phoneNumber;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getPassword() {
        return password;
    }

    private void generatePatientID() {
        Random random = new Random(System.currentTimeMillis());
        int id = ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
        this.patientId = String.valueOf(id);
    }

    public String getPatientID() {
        return this.patientId;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getFirstName() {
        return this.firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private void setDateofBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String getDateofBirth() {
        return this.dateOfBirth;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private int getAge() {
        return this.age;
    }

}