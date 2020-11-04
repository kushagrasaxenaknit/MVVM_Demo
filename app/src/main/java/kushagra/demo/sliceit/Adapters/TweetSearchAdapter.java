package kushagra.demo.sliceit.Adapters;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kushagra.demo.sliceit.Models.TweetDetail;
import kushagra.demo.sliceit.R;

public class TweetSearchAdapter extends RecyclerView.Adapter<TweetSearchAdapter.BookSearchResultHolder> {
    private List<TweetDetail> results = new ArrayList<>();

    @NonNull
    @Override
    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweet_item, parent, false);

        return new BookSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {
        TweetDetail tweetDetail = results.get(position);

        holder.tweetNameTextView.setText(tweetDetail.getName());
        holder.tweetTextTextView.setText(tweetDetail.getText());

        if (tweetDetail.getProfileImageUrl() != null) {
            String imageUrl = tweetDetail.getProfileImageUrl();
                   // .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.smallThumbnailImageView);


        }

        if (tweetDetail.getHandle() != null) {

            String handle = tweetDetail.getHandle();
            holder.tweetHandleTextView.setText(handle);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<TweetDetail> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class BookSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView tweetNameTextView;
        private TextView tweetTextTextView;
        private TextView tweetHandleTextView;
        private ImageView smallThumbnailImageView;

        public BookSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            tweetNameTextView = itemView.findViewById(R.id.tweet_name);
            tweetTextTextView = itemView.findViewById(R.id.tweet_text);
            tweetHandleTextView = itemView.findViewById(R.id.tweet_handle);
            smallThumbnailImageView = itemView.findViewById(R.id.pic);
        }
    }
}
