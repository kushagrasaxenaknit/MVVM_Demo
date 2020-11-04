package kushagra.demo.sliceit.Services;


import kushagra.demo.sliceit.Models.TwiterApiResponse;
import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface ApiCalls {
    @GET("/tweets")
    Call<TwiterApiResponse> searchTweets(

    );
}
