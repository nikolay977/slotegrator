package com.testslotegrator.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Credentials {

    @SerializedName("password")
    private String password;

    @SerializedName("grant_type")
    private String grantType;

    @SerializedName("username")
    private String username;

    public Credentials(Player player) {
        this.setGrantType("password");
        this.setUsername(player.getUsername());
        this.setPassword(player.getPassword());
    }
}