package it.rokettoapp.roketto.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SpacecraftConfigType implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    public SpacecraftConfigType(int id, String name) {

        this.mId = id;
        this.mName = name;
    }

    public int getId() {

        return mId;
    }

    public void setId(int id) {

        this.mId = id;
    }

    public String getName() {

        return mName;
    }

    public void setName(String name) {

        this.mName = name;
    }
}
