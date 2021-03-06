package it.rokettoapp.roketto.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity(tableName = "launch")
public class Launch implements Serializable {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private String mId;

    @SerializedName("slug")
    private String mSlug;

    @SerializedName("name")
    private String mName;

    @Embedded(prefix = "status_")
    @SerializedName("status")
    private LaunchStatus mLaunchStatus;

    @SerializedName("last_updated")
    private Date mLastUpdated;

    @SerializedName("updates")
    private List<Update> mUpdateList;

    @SerializedName("net")
    private Date mNet;

    @SerializedName("window_end")
    private Date mWindowEnd;

    @SerializedName("window_start")
    private Date mWindowStart;

    @SerializedName("probability")
    private int mProbability;

    @SerializedName("holdreason")
    private String mHoldReason;

    @SerializedName("failreason")
    private String mFailReason;

    @SerializedName("hashtag")
    private String mHashtag;

    @SerializedName("launch_service_provider")
    private Agency mLaunchServiceProvider;

    @SerializedName("rocket")
    private Rocket mRocket;

    @Embedded(prefix = "mission_")
    @SerializedName("mission")
    private Mission mMission;

    @SerializedName("pad")
    private Pad mPad;

    @SerializedName("infoURLs")
    private List<Url> mInfoUrl;

    @SerializedName("vidURLs")
    private List<Url> mVideoUrl;

    @SerializedName("webcast_live")
    private boolean mWebcastLive;

    @SerializedName("image")
    private String mImage;

    @SerializedName("infographic")
    private String mInfographic;

    @SerializedName("program")
    private List<Program> mProgramList;

    @SerializedName("orbital_launch_attempt_count")
    private int mOrbitalLaunchAttemptCount;

    @SerializedName("location_launch_attempt_count")
    private int mLocationLaunchAttemptCount;

    @SerializedName("pad_launch_attempt_count")
    private int mPadLaunchAttemptCount;

    @SerializedName("agency_launch_attempt_count")
    private int mAgencyLaunchAttemptCount;

    @SerializedName("orbital_launch_attempt_count_year")
    private int mOrbitalLaunchAttemptCountYear;

    @SerializedName("location_launch_attempt_count_year")
    private int mLocationLaunchAttemptCountYear;

    @SerializedName("pad_launch_attempt_count_year")
    private int mPadLaunchAttemptCountYear;

    @SerializedName("agency_launch_attempt_count_year")
    private int mAgencyLaunchAttemptCountYear;

    @SerializedName("mission_patches")
    private List<MissionPatch> mMissionPathList;

    @SerializedName("notifications_enabled")
    private boolean mNotificationEnabled;

    @Ignore
    public Launch(@NonNull String id) {
        this.mId = id;
    }

    public Launch(@NonNull String id, String slug, String name, LaunchStatus launchStatus,
                  Date lastUpdated, List<Update> updateList, Date net, Date windowEnd,
                  Date windowStart, int probability, String holdReason, String failReason,
                  String hashtag, Agency launchServiceProvider, Rocket rocket, Mission mission,
                  Pad pad, List<Url> infoUrl, List<Url> videoUrl, boolean webcastLive,
                  String image, String infographic, List<Program> programList,
                  int orbitalLaunchAttemptCount, int locationLaunchAttemptCount,
                  int padLaunchAttemptCount, int agencyLaunchAttemptCount,
                  int orbitalLaunchAttemptCountYear, int locationLaunchAttemptCountYear,
                  int padLaunchAttemptCountYear, int agencyLaunchAttemptCountYear,
                  List<MissionPatch> missionPathList, boolean notificationEnabled) {

        this.mId = id;
        this.mSlug = slug;
        this.mName = name;
        this.mLaunchStatus = launchStatus;
        this.mLastUpdated = lastUpdated;
        this.mUpdateList = updateList;
        this.mNet = net;
        this.mWindowEnd = windowEnd;
        this.mWindowStart = windowStart;
        this.mProbability = probability;
        this.mHoldReason = holdReason;
        this.mFailReason = failReason;
        this.mHashtag = hashtag;
        this.mLaunchServiceProvider = launchServiceProvider;
        this.mRocket = rocket;
        this.mMission = mission;
        this.mPad = pad;
        this.mInfoUrl = infoUrl;
        this.mVideoUrl = videoUrl;
        this.mWebcastLive = webcastLive;
        this.mImage = image;
        this.mInfographic = infographic;
        this.mProgramList = programList;
        this.mOrbitalLaunchAttemptCount = orbitalLaunchAttemptCount;
        this.mLocationLaunchAttemptCount = locationLaunchAttemptCount;
        this.mPadLaunchAttemptCount = padLaunchAttemptCount;
        this.mAgencyLaunchAttemptCount = agencyLaunchAttemptCount;
        this.mOrbitalLaunchAttemptCountYear = orbitalLaunchAttemptCountYear;
        this.mLocationLaunchAttemptCountYear = locationLaunchAttemptCountYear;
        this.mPadLaunchAttemptCountYear = padLaunchAttemptCountYear;
        this.mAgencyLaunchAttemptCountYear = agencyLaunchAttemptCountYear;
        this.mMissionPathList = missionPathList;
        this.mNotificationEnabled = notificationEnabled;
    }

    public static Launch buildMinLaunch(Launch launch) {

        Launch minLaunch = new Launch(launch.getId());
        minLaunch.setName(launch.getName());
        minLaunch.setMission(Mission.buildMinMission(launch.getMission()));
        minLaunch.setNet(launch.getNet());
        minLaunch.setLaunchStatus(LaunchStatus.buildMinLaunchStatus(launch.getLaunchStatus()));
        minLaunch.setImage(launch.getImage());
        minLaunch.setLaunchServiceProvider(Agency.buildMinAgency(launch.getLaunchServiceProvider()));
        minLaunch.setRocket(Rocket.buildMinRocket(launch.getRocket()));
        return minLaunch;
    }

    public String getId() {

        return mId;
    }

    public void setId(String id) {

        this.mId = id;
    }

    public String getSlug() {

        return mSlug;
    }

    public void setSlug(String slug) {

        this.mSlug = slug;
    }

    public String getName() {

        return mName;
    }

    public void setName(String name) {

        this.mName = name;
    }

    public LaunchStatus getLaunchStatus() {

        return mLaunchStatus;
    }

    public void setLaunchStatus(LaunchStatus launchStatus) {

        this.mLaunchStatus = launchStatus;
    }

    public Date getLastUpdated() {

        return mLastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {

        this.mLastUpdated = lastUpdated;
    }

    public List<Update> getUpdateList() {

        return mUpdateList;
    }

    public void setUpdateList(List<Update> updateList) {

        this.mUpdateList = updateList;
    }

    public Date getNet() {

        return mNet;
    }

    public void setNet(Date net) {

        this.mNet = net;
    }

    public Date getWindowEnd() {

        return mWindowEnd;
    }

    public void setWindowEnd(Date windowEnd) {

        this.mWindowEnd = windowEnd;
    }

    public Date getWindowStart() {

        return mWindowStart;
    }

    public void setWindowStart(Date windowStart) {

        this.mWindowStart = windowStart;
    }

    public int getProbability() {

        return mProbability;
    }

    public void setProbability(int probability) {

        this.mProbability = probability;
    }

    public String getHoldReason() {

        return mHoldReason;
    }

    public void setHoldReason(String holdReason) {

        this.mHoldReason = holdReason;
    }

    public String getFailReason() {

        return mFailReason;
    }

    public void setFailReason(String failReason) {

        this.mFailReason = failReason;
    }

    public String getHashtag() {

        return mHashtag;
    }

    public void setHashtag(String hashtag) {

        this.mHashtag = hashtag;
    }

    public Agency getLaunchServiceProvider() {

        return mLaunchServiceProvider;
    }

    public void setLaunchServiceProvider(Agency launchServiceProvider) {

        this.mLaunchServiceProvider = launchServiceProvider;
    }

    public Rocket getRocket() {

        return mRocket;
    }

    public void setRocket(Rocket rocket) {

        this.mRocket = rocket;
    }

    public Mission getMission() {

        return mMission;
    }

    public void setMission(Mission mission) {

        this.mMission = mission;
    }

    public Pad getPad() {

        return mPad;
    }

    public void setPad(Pad pad) {

        this.mPad = pad;
    }

    public List<Url> getInfoUrl() {

        return mInfoUrl;
    }

    public void setInfoUrl(List<Url> infoUrl) {

        this.mInfoUrl = infoUrl;
    }

    public List<Url> getVideoUrl() {

        return mVideoUrl;
    }

    public void setVideoUrl(List<Url> videoUrl) {

        this.mVideoUrl = videoUrl;
    }

    public boolean isWebcastLive() {

        return mWebcastLive;
    }

    public void setWebcastLive(boolean webcastLive) {

        this.mWebcastLive = webcastLive;
    }

    public String getImage() {

        return mImage;
    }

    public void setImage(String image) {

        this.mImage = image;
    }

    public String getInfographic() {

        return mInfographic;
    }

    public void setInfographic(String infographic) {

        this.mInfographic = infographic;
    }

    public List<Program> getProgramList() {

        return mProgramList;
    }

    public void setProgramList(List<Program> programList) {

        this.mProgramList = programList;
    }

    public int getOrbitalLaunchAttemptCount() {

        return mOrbitalLaunchAttemptCount;
    }

    public void setOrbitalLaunchAttemptCount(int orbitalLaunchAttemptCount) {

        this.mOrbitalLaunchAttemptCount = orbitalLaunchAttemptCount;
    }

    public int getLocationLaunchAttemptCount() {

        return mLocationLaunchAttemptCount;
    }

    public void setLocationLaunchAttemptCount(int locationLaunchAttemptCount) {

        this.mLocationLaunchAttemptCount = locationLaunchAttemptCount;
    }

    public int getPadLaunchAttemptCount() {

        return mPadLaunchAttemptCount;
    }

    public void setPadLaunchAttemptCount(int padLaunchAttemptCount) {

        this.mPadLaunchAttemptCount = padLaunchAttemptCount;
    }

    public int getAgencyLaunchAttemptCount() {

        return mAgencyLaunchAttemptCount;
    }

    public void setAgencyLaunchAttemptCount(int agencyLaunchAttemptCount) {

        this.mAgencyLaunchAttemptCount = agencyLaunchAttemptCount;
    }

    public int getOrbitalLaunchAttemptCountYear() {

        return mOrbitalLaunchAttemptCountYear;
    }

    public void setOrbitalLaunchAttemptCountYear(int orbitalLaunchAttemptCountYear) {

        this.mOrbitalLaunchAttemptCountYear = orbitalLaunchAttemptCountYear;
    }

    public int getLocationLaunchAttemptCountYear() {

        return mLocationLaunchAttemptCountYear;
    }

    public void setLocationLaunchAttemptCountYear(int locationLaunchAttemptCountYear) {

        this.mLocationLaunchAttemptCountYear = locationLaunchAttemptCountYear;
    }

    public int getPadLaunchAttemptCountYear() {

        return mPadLaunchAttemptCountYear;
    }

    public void setPadLaunchAttemptCountYear(int padLaunchAttemptCountYear) {

        this.mPadLaunchAttemptCountYear = padLaunchAttemptCountYear;
    }

    public int getAgencyLaunchAttemptCountYear() {

        return mAgencyLaunchAttemptCountYear;
    }

    public void setAgencyLaunchAttemptCountYear(int agencyLaunchAttemptCountYear) {

        this.mAgencyLaunchAttemptCountYear = agencyLaunchAttemptCountYear;
    }

    public List<MissionPatch> getMissionPathList() {

        return mMissionPathList;
    }

    public void setMissionPathList(List<MissionPatch> missionPathList) {

        this.mMissionPathList = missionPathList;
    }

    public boolean isNotificationEnabled() {

        return mNotificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {

        this.mNotificationEnabled = notificationEnabled;
    }
}
