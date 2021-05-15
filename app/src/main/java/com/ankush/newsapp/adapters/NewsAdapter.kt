package com.ankush.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankush.newsapp.R
import com.ankush.newsapp.model.ArticleResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(val items:ArticleResponse): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder( listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val valItem = items.articles[position]
        if(valItem.title.length>30){
            holder.itemView.tv_title.text = "This is long text"
        }else{
            holder.itemView.tv_title.text = valItem.title
        }

        holder.itemView.tv_description.text = valItem.description
        Glide.with(holder.itemView.context).load(valItem.urlToImage).into(holder.itemView.iv_news)

    }

    override fun getItemCount(): Int {
      return items.articles.size
    }
}

