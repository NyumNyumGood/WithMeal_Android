package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemRestaurantReviewBinding
import org.android.wantedhackathon.home.data.FeedEntity
import org.android.wantedhackathon.util.DiffCallback

class RestaurantReviewAdapter() :
    ListAdapter<FeedEntity, RestaurantReviewAdapter.RestaurantReviewViewHolder>(DiffCallback<FeedEntity>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantReviewViewHolder {
        val binding = ItemRestaurantReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantReviewViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RestaurantReviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
        holder.binding.recyclerviewReviewTag.apply {
            this.adapter = TagAdapter()
            (adapter as TagAdapter).tagList = item.keyword
        }
    }
    class RestaurantReviewViewHolder(val binding: ItemRestaurantReviewBinding) : RecyclerView.ViewHolder(binding.root)
}