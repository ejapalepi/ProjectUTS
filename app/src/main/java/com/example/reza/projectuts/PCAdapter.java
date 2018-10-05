package com.example.reza.projectuts;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.List;




public class PCAdapter extends RecyclerView.Adapter<PCAdapter.MyViewHolder> {

    private Context mContext;
    private List<PC> PCList;

    public PCAdapter(Context mContext, List<PC> PCList) {
        this.mContext = mContext;
        this.PCList = PCList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, rating;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            rating= (TextView) view.findViewById(R.id.rating);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    @Override
    public PCAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pc_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PCAdapter.MyViewHolder holder, int position) {
        PC movie = PCList.get(position);
        holder.name.setText(movie.getName());
        holder.rating.setText("Rating : "+String.valueOf( movie.getRating()));


        Glide.with(mContext).load(movie.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return PCList.size();
    }


    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_movie, popup.getMenu());
        //popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /*class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_rate:
                    Toast.makeText(mContext, "Rate", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_share:
                    Toast.makeText(mContext, "Share", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }*/
    }
