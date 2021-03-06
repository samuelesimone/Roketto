package it.rokettoapp.roketto.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LandingLocation implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("abbrev")
    private String mAbbreviation;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("location")
    private Location mLocation;

    @SerializedName("successful_landings")
    private String mSuccessfulLandings;

    public LandingLocation(int id, String name, String abbreviation, String description,
                           Location location, String successfulLandings) {

        this.mId = id;
        this.mName = name;
        this.mAbbreviation = abbreviation;
        this.mDescription = description;
        this.mLocation = location;
        this.mSuccessfulLandings = successfulLandings;
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

    public String getAbbreviation() {

        return mAbbreviation;
    }

    public void setAbbreviation(String abbreviation) {

        this.mAbbreviation = abbreviation;
    }

    public String getDescription() {

        return mDescription;
    }

    public void setDescription(String description) {

        this.mDescription = description;
    }

    public Location getLocation() {

        return mLocation;
    }

    public void setLocation(Location location) {

        this.mLocation = location;
    }

    public String getSuccessfulLandings() {

        return mSuccessfulLandings;
    }

    public void setSuccessfulLandings(String successfulLandings) {

        this.mSuccessfulLandings = successfulLandings;
    }
}
