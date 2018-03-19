package com.khtn.hang.homeworkweek3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nhyml on 3/17/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Result> mResults;
    private int layout;
    private Context context;
    private static final String HEADER_PATH = "https://image.tmdb.org/t/p/w500/";
    private RecyclerViewItemClickListener listener;

    public interface RecyclerViewItemClickListener {
        void onItemClick(Result result);
    }

    public RecyclerViewAdapter(List<Result> results, int layout, Context context, RecyclerViewItemClickListener listener) {
        this.mResults = results;
        this.layout = layout;
        this.context = context;
        this.listener = listener;

    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        Result result = mResults.get(position);
        //holder.imgMovie.setImageResource(R.drawable.movie);
        Picasso.get().load(HEADER_PATH+result.getPoster_path())
                .fit()
                .centerCrop()
                .into(holder.imgMovie);
        holder.tvTitle.setText(result.getTitle());
        holder.tvOverView.setText(result.getOverview());
        holder.itemView.setOnClickListener(v->listener.onItemClick(result));
        holder.imgPlay.setVisibility(result.isVideo()?View.VISIBLE:View.GONE);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvOverView;
        private ImageView imgMovie;
        private ImageView imgPlay;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvOverView = (TextView) itemView.findViewById(R.id.tvOverView);
            imgMovie = (ImageView) itemView.findViewById(R.id.imgMovie);
            imgPlay = (ImageView) itemView.findViewById(R.id.imgPlay);

        }
    }
}
