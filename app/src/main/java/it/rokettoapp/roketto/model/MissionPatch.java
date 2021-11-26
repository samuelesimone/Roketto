package it.rokettoapp.roketto.model;

import com.google.gson.annotations.SerializedName;

public class MissionPatch {

    @SerializedName("id")
    String mId;

    @SerializedName("name")
    String mName;

    @SerializedName("priority")
    int mPriority;

    @SerializedName("image_url")
    String mImageUrl;

    @SerializedName("agency")
    Agency mAgency;

    public MissionPatch(String id, String name, int priority, String imageUrl, Agency agency) {

        this.mId = id;
        this.mName = name;
        this.mPriority = priority;
        this.mImageUrl = imageUrl;
        this.mAgency = agency;
    }

    public String getId() {

        return mId;
    }

    public void setId(String id) {

        this.mId = id;
    }

    public String getName() {

        return mName;
    }

    public void setName(String name) {

        this.mName = name;
    }

    public int getPriority() {

        return mPriority;
    }

    public void setPriority(int priority) {

        this.mPriority = priority;
    }

    public String getImageUrl() {

        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.mImageUrl = imageUrl;
    }

    public Agency getAgency() {

        return mAgency;
    }

    public void setAgency(Agency agency) {

        this.mAgency = agency;
    }
}
