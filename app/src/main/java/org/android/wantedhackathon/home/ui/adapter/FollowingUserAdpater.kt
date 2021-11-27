package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemUserFollowingBinding
import org.android.wantedhackathon.home.data.FollowingEntity
import org.android.wantedhackathon.util.DiffCallback

class FollowingUserAdpater(val listener : FollowingUserAdpater.OnItemClickListener) : ListAdapter<FollowingEntity, FollowingUserAdpater.FollowingUserViewHolder>
    (DiffCallback<FollowingEntity>()) {
    interface OnItemClickListener{
        fun itemClick()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding = ItemUserFollowingBinding.inflate(LayoutInflater.from(parent.context),parent, false )
        return FollowingUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run{ setVariable(BR.data,item) }
        holder.binding.root.setOnClickListener { listener.itemClick()}
    }
    class FollowingUserViewHolder(val binding: ItemUserFollowingBinding): RecyclerView.ViewHolder(binding.root)

}