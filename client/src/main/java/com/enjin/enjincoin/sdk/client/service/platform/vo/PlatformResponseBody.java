package com.enjin.enjincoin.sdk.client.service.platform.vo;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Platform Config used throughout the sdk.
 * </p>
 */
public class PlatformResponseBody {

    @SerializedName("platform")
    private PlatformDetails platformDetails;

    @SerializedName("notifications")
    private NotificationDetails notificationDetails;

    @SerializedName("apps")
    private AppDetail[] appDetails;

    /**
     * Class constructor.
     * @param platformDetails
     * @param notificationDetails
     * @param appDetails
     */
    public PlatformResponseBody(PlatformDetails platformDetails, NotificationDetails notificationDetails, AppDetail[] appDetails) {
        super();
        this.platformDetails = platformDetails;
        this.notificationDetails = notificationDetails;
        this.appDetails = appDetails;
    }

    /**
     * @return the platformDetails
     */
    public PlatformDetails getPlatformDetails() {
        return platformDetails;
    }

    /**
     * @return the notificationDetails
     */
    public NotificationDetails getNotificationDetails() {
        return notificationDetails;
    }

    /**
     * @return the appDetails
     */
    public AppDetail[] getAppDetails() {
        return appDetails;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlatformResponseBody [platformDetails=" + platformDetails + ", notificationDetails=" + notificationDetails + ", appDetails=" + Arrays.toString(appDetails) + "]";
    }


}