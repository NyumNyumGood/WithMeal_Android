package org.android.wantedhackathon.home.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemFeedContentBinding
import org.android.wantedhackathon.home.data.FeedEntity
import org.android.wantedhackathon.util.DiffCallback

class FeedReviewAdapter() :
    ListAdapter<FeedEntity, FeedReviewAdapter.FeedReviewViewHolder>(DiffCallback<FeedEntity>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedReviewViewHolder {
        val binding = ItemFeedContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedReviewViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FeedReviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
        holder.binding.recyclerviewReviewTag.apply {
            this.adapter = TagAdapter()
            (adapter as TagAdapter).tagList = item.keyword
        }
    }
    class FeedReviewViewHolder(val binding: ItemFeedContentBinding) : RecyclerView.ViewHolder(binding.root)

}