package com.ankush.newsapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankush.newsapp.R
import com.ankush.newsapp.model.ArticleResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.search_news_item.view.*

class SearchNewsAdapter(val items: ArticleResponse):RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder>() {


    inner class SearchNewsViewHolder( listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchNewsViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.search_news_item,parent,false)
        return SearchNewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchNewsViewHolder, position: Int) {
       val itemsVal = items.articles[position]
        holder.itemView.tv2_title.text = itemsVal.title
        holder.itemView.tv2_description.text = itemsVal.description
        Log.e("Image",itemsVal.urlToImage.toString())
//        Glide.with(holder.itemView.context).load(itemsVal.urlToImage+"jpg").into(holder.itemView.iv_news)
//        Glide.with(holder.itemView.context).load(itemsVal.urlToImage).into(holder.itemView.iv_news)
    }

    override fun getItemCount(): Int {
        return items.articles.size

    }


}