package com.example.root.sectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.root.sectionedrecyclerview.HeaderAdapter.mainCount;


public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder> {


    private Context context;
    private ArrayList<Model> arrayList;
    onClickCountUpdate onClickCountUpdate;

    public ItemRecyclerViewAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_row_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.itemLabel.setText(arrayList.get(position).getAbc());
        holder.item_desc.setText(arrayList.get(position).getDef());
        Picasso.with(context)
                .load(arrayList.get(position).getImg_url()).
                placeholder(R.drawable.ic_launcher_background).
                into(holder.image);

        holder.tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainCount <10) {
                    int cnt = arrayList.get(position).getCount() + 1;
                    arrayList.get(position).setCount(cnt);
                    holder.tv_count.setText("" + cnt);
                    mainCount = mainCount + 1;
                    ((MainActivity)context).getCount(mainCount);

                }
            }
        });


        holder.tv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrayList.get(position).getCount() > 0 && mainCount > 0) {
                    int cnt = arrayList.get(position).getCount() - 1;
                    arrayList.get(position).setCount(cnt);
                    holder.tv_count.setText("" + cnt);
                    mainCount = mainCount - 1;
                    ((MainActivity)context).getCount(mainCount);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return null != arrayList ? arrayList.size() : 0;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        private TextView itemLabel, item_desc, tv_minus, tv_add, tv_count;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemLabel = (TextView) itemView.findViewById(R.id.item_label);
            item_desc = (TextView) itemView.findViewById(R.id.item_desc);
            tv_minus = (TextView) itemView.findViewById(R.id.tv_minus);
            tv_add = (TextView) itemView.findViewById(R.id.tv_add);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }


}
