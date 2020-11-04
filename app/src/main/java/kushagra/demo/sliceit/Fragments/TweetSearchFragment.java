package kushagra.demo.sliceit.Fragments;


import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.lifecycle.Observer;
        import androidx.lifecycle.ViewModelProviders;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.android.material.textfield.TextInputEditText;

import kushagra.demo.sliceit.Adapters.TweetSearchAdapter;
import kushagra.demo.sliceit.Models.TwiterApiResponse;
import kushagra.demo.sliceit.R;
import kushagra.demo.sliceit.ViewModels.TweetViewModel;

public class TweetSearchFragment extends Fragment {
    private TweetViewModel viewModel;
    private TweetSearchAdapter adapter;

    private TextInputEditText keywordEditText;
    private Button searchButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new TweetSearchAdapter();

        viewModel = ViewModelProviders.of(this).get(TweetViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer<TwiterApiResponse>() {
            @Override
            public void onChanged(TwiterApiResponse tweApiResponse) {
                if (tweApiResponse != null) {
                    adapter.setResults(tweApiResponse.getData());
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_tweetSearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        keywordEditText = view.findViewById(R.id.fragment_tweetSearch_keyword);

        searchButton = view.findViewById(R.id.fragment_tweet_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return view;
    }

    public void performSearch() {
        String keyword = keywordEditText.getEditableText().toString();

        viewModel.searchTweets();
    }
}
