package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemRecommendFollowingBinding
import org.android.wantedhackathon.home.data.AddFollowingEntity
import org.android.wantedhackathon.util.DiffCallback

class AddFollowingAdapter() :
    ListAdapter<AddFollowingEntity, AddFollowingAdapter.AddFollowingViewHolder>(DiffCallback<AddFollowingEntity>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFollowingViewHolder {
        val binding = ItemRecommendFollowingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddFollowingViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AddFollowingViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run { setVariable(BR.data, item) }
    }
    class AddFollowingViewHolder(val binding: ItemRecommendFollowingBinding) : RecyclerView.ViewHolder(binding.root)
}