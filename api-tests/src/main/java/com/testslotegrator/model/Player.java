package com.testslotegrator.model;

import com.github.javafaker.Faker;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Base64;

@Data
public class Player {
    @SerializedName("surname")
    private String surname;

    @SerializedName("name")
    private String name;

    @SerializedName("password_change")
    private String password;

    @SerializedName("password_repeat")
    private String passwordRepeat;

    private String encodedPasswordString;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    public Player() {
        Faker faker = new Faker();

        name = faker.name().firstName();
        surname = faker.name().lastName();
        username = name + surname + System.currentTimeMillis() % 100000;
        encodedPasswordString = Base64.getEncoder().encodeToString("!Good1Password@".getBytes());
        password = encodedPasswordString;
        passwordRepeat = encodedPasswordString;
        email = username + "@gmail.com";
    }
}
