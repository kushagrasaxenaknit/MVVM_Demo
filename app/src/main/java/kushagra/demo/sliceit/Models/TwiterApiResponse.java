package kushagra.demo.sliceit.Models;


import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;

public class TwiterApiResponse {
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("data")
    @Expose
    List<TweetDetail> data = null;



    public String getSuccess() {
        return success;
    }

    public List<TweetDetail> getData() {
        return data;
    }


}
