package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemFeedContentBinding
import org.android.wantedhackathon.home.data.FeedEntity
import org.android.wantedhackathon.util.DiffCallback

class FollowingDetailAdapter() :
    ListAdapter<FeedEntity, FollowingDetailAdapter.FollowingDetailViewHolder>(DiffCallback<FeedEntity>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingDetailViewHolder {
        val binding = ItemFeedContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowingDetailViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
        holder.binding.recyclerviewReviewTag.apply {
            this.adapter = TagAdapter()
            (adapter as TagAdapter).tagList = item.keyword
        }
    }

    class FollowingDetailViewHolder(val binding: ItemFeedContentBinding) : RecyclerView.ViewHolder(binding.root)
}