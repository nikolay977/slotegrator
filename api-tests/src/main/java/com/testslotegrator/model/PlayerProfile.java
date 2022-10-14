package com.testslotegrator.model;

import com.google.gson.annotations.SerializedName;

public class PlayerProfile {

    @SerializedName("bonuses_allowed")
    private Boolean bonusesAllowed;

    @SerializedName("birthdate")
    private Object birthdate;

    @SerializedName("gender")
    private Object gender;

    @SerializedName("surname")
    private String surname;

    @SerializedName("timezone_id")
    private Object timezoneId;

    @SerializedName("name")
    private String name;

    @SerializedName("phone_number")
    private Object phoneNumber;

    @SerializedName("id")
    private Integer id;

    @SerializedName("is_verified")
    private Boolean isVerified;

    @SerializedName("country_id")
    private Object countryId;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;
}