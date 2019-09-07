package com.illuminator.kotlintest.test2.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.illuminator.kotlintest.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import timber.log.Timber;

/**
 * Created by LiGe
 * Date: 2019/8/26
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> imageList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<String> descriptionList = new ArrayList<>();

    public TestRecyclerViewAdapter(Context mContext, List<String> imageList, List<String> nameList, List<String> descriptionList) {
        this.mContext = mContext;
        this.imageList = imageList;
        this.nameList = nameList;
        this.descriptionList = descriptionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Timber.d("onBindViewHolder called");

        if(mContext != null && imageList != null && imageList.size() != 0){
            Glide.with(mContext)
                    .asBitmap()
                    .load(imageList.get(position))
                    .into(holder.circleImageView);
        }

        if(nameList != null && nameList.size() != 0){
            holder.nameTextView.setText(nameList.get(position));
        }

        if(descriptionList != null && descriptionList.size() != 0){
            holder.descriptionTextView.setText(descriptionList.get(position));
        }

        holder.linearLayout.setOnClickListener((v -> {
            if(nameList != null && nameList.size() != 0) {
                Toast.makeText(mContext, nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        if(nameList != null && nameList.size() != 0){
            return nameList.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        CircleImageView circleImageView;
        TextView nameTextView;
        TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.recyclerview_linearLayout);
            circleImageView = itemView.findViewById(R.id.avatar_circleimageview);
            nameTextView = itemView.findViewById(R.id.name_textview);
            descriptionTextView = itemView.findViewById(R.id.description_textview);
        }
    }
}
