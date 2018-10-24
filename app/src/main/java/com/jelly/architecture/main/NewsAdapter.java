package com.jelly.architecture.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jelly.architecture.R;
import com.jelly.architecture.listener.RVOnItemClickListener;
import com.jelly.domian.news.bean.NewsList;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<NewsList.DataBean.NewListBean> newListBeans;
    private RVOnItemClickListener itemClickListener;

    public NewsAdapter(Context context, List<NewsList.DataBean.NewListBean> newListBeans) {
        this.context = context;
        this.newListBeans = newListBeans;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
        NewsList.DataBean.NewListBean newListBean = newListBeans.get(i);
        viewHolder.tvTitle.setText(newListBean.getNewTitle());
        viewHolder.tvAuthor.setText(newListBean.getSourceName());
        viewHolder.tvTime.setText(" - " + newListBean.getPublishTime());
        viewHolder.tvContent.setText(newListBean.getIntro().replace(" ",""));

        viewHolder.itemView.setTag(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                itemClickListener.itemClick(view,position);
            }
        });

    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_new,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return newListBeans.size();
    }

    public void setItemClickListener(RVOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvTime;
        TextView tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

}
