package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemHotContentBinding
import org.android.wantedhackathon.home.data.HotContentEntity
import org.android.wantedhackathon.util.DiffCallback

class HotReviewAdapter() :
ListAdapter<HotContentEntity, HotReviewAdapter.HotReviewViewHolder>(DiffCallback<HotContentEntity>()){
    class HotReviewViewHolder(val binding : ItemHotContentBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotReviewViewHolder {
        val binding = ItemHotContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HotReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotReviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run {
            setVariable(BR.data, item)
        }
    }
}