package it.rokettoapp.roketto.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(tableName = "program")
public class Program implements Serializable {

    @PrimaryKey
    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("agencies")
    private List<Agency> mAgencies;

    @SerializedName("image_url")
    private String mImageUrl;

    @SerializedName("start_date")
    private Date mStartDate;

    @SerializedName("end_date")
    private Date mEndDate;

    @SerializedName("info_url")
    private String mInfoUrl;

    @SerializedName("wiki_url")
    private String mWikipedia;

    @SerializedName("mission_patches")
    private List<MissionPatch> mMissionPatch;

    @Ignore
    public Program(int id) {

        this.mId = id;
    }

    public Program(int id, String name, String description, List<Agency> agencies, String imageUrl,
                   Date startDate, Date endDate, String infoUrl, String wikipedia,
                   List<MissionPatch> missionPatch) {

        this.mId = id;
        this.mName = name;
        this.mDescription = description;
        this.mAgencies = agencies;
        this.mImageUrl = imageUrl;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
        this.mInfoUrl = infoUrl;
        this.mWikipedia = wikipedia;
        this.mMissionPatch = missionPatch;
    }

    public static Program buildMinProgram(Program program) {

        Program minProgram = new Program(program.getId());
        minProgram.setName(program.getName());
        minProgram.setDescription(program.getDescription());
        minProgram.setStartDate(program.getStartDate());
        return minProgram;
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

    public String getDescription() {

        return mDescription;
    }

    public void setDescription(String description) {

        this.mDescription = description;
    }

    public List<Agency> getAgencies() {

        return mAgencies;
    }

    public void setAgencies(List<Agency> agencies) {

        this.mAgencies = agencies;
    }

    public String getImageUrl() {

        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.mImageUrl = imageUrl;
    }

    public Date getStartDate() {

        return mStartDate;
    }

    public void setStartDate(Date startDate) {

        this.mStartDate = startDate;
    }

    public Date getEndDate() {

        return mEndDate;
    }

    public void setEndDate(Date endDate) {

        this.mEndDate = endDate;
    }

    public String getInfoUrl() {

        return mInfoUrl;
    }

    public void setInfoUrl(String infoUrl) {

        this.mInfoUrl = infoUrl;
    }

    public String getWikipedia() {

        return mWikipedia;
    }

    public void setWikipedia(String wikipedia) {

        this.mWikipedia = wikipedia;
    }

    public List<MissionPatch> getMissionPatch() {

        return mMissionPatch;
    }

    public void setMissionPatch(List<MissionPatch> missionPatch) {

        this.mMissionPatch = missionPatch;
    }
}
