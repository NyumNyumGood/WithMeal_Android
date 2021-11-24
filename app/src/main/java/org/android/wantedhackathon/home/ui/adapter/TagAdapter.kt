package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemTagFeedBinding
import org.android.wantedhackathon.home.data.TagEntity
import org.android.wantedhackathon.util.DiffCallback

class TagAdapter() :
ListAdapter<TagEntity, TagAdapter.TagViewHolder>(DiffCallback<TagEntity>()){
    var tagList = listOf<TagEntity>()
    class TagViewHolder(val binding : ItemTagFeedBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val binding = ItemTagFeedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val tag = tagList[position]
        holder.binding.setVariable(BR.data,tag)
    }
    override fun getItemCount(): Int = tagList.size
}