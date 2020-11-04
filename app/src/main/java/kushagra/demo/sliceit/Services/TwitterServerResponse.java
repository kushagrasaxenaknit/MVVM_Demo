package kushagra.demo.sliceit.Services;



import android.util.Log;

        import androidx.lifecycle.LiveData;
        import androidx.lifecycle.MutableLiveData;

import kushagra.demo.sliceit.Models.TwiterApiResponse;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterServerResponse {
    private static final String Tweet_UR = "https://6f8a2fec-1605-4dc7-a081-a8521fad389a.mock.pstmn.io";

    private ApiCalls apiCalls;
    private MutableLiveData<TwiterApiResponse> twiterApiResponseMutableLiveData;

    public TwitterServerResponse() {
        twiterApiResponseMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        apiCalls = new retrofit2.Retrofit.Builder()
                .baseUrl(Tweet_UR)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCalls.class);

    }

    public void searchTweets() {
        apiCalls.searchTweets()
                .enqueue(new Callback<TwiterApiResponse>() {
                    @Override
                    public void onResponse(Call<TwiterApiResponse> call, Response<TwiterApiResponse> response) {
                        if (response.body() != null) {
                            twiterApiResponseMutableLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TwiterApiResponse> call, Throwable t) {
                        twiterApiResponseMutableLiveData.postValue(null);
                    }
                });
    }

    public LiveData<TwiterApiResponse> getTweetsResponseLiveData() {
        return twiterApiResponseMutableLiveData;
    }
}
