package kushagra.demo.sliceit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TweetDetail {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("handle")
    @Expose
    private String handle;

    @SerializedName("favoriteCount")
    @Expose
    private int favoriteCount;

    @SerializedName("retweetCount")
    @Expose
    private String retweetCount;

    @SerializedName("profileImageUrl")
    @Expose
    private String profileImageUrl;

    public String getName() {
        return name;
    }

    public String getHandle() {
        return handle;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public String getRetweetCount() {
        return retweetCount;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getText() {
        return text;
    }

    @SerializedName("text")
    @Expose
    private String text;
}
