package kushagra.demo.sliceit.ViewModels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import kushagra.demo.sliceit.Models.TwiterApiResponse;
import kushagra.demo.sliceit.Services.TwitterServerResponse;

public class TweetViewModel extends AndroidViewModel {
    private TwitterServerResponse twitterServerResponse;
    private LiveData<TwiterApiResponse> twiterApiResponseLiveData;

    public TweetViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        twitterServerResponse = new TwitterServerResponse();
        twiterApiResponseLiveData = twitterServerResponse.getTweetsResponseLiveData();
    }

    public void searchTweets() {
        twitterServerResponse.searchTweets();
    }

    public LiveData<TwiterApiResponse> getVolumesResponseLiveData() {
        return twiterApiResponseLiveData;
    }
}
