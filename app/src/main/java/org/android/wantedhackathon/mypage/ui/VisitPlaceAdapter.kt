package org.android.wantedhackathon.mypage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemVisitPlaceBinding
import org.android.wantedhackathon.mypage.VisitedPlaceEntity
import org.android.wantedhackathon.util.DiffCallback

class VisitPlaceAdapter() : ListAdapter<VisitedPlaceEntity, VisitPlaceAdapter.VisitPlaceViewHolder>(DiffCallback<VisitedPlaceEntity>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitPlaceViewHolder {
        val binding = ItemVisitPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VisitPlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VisitPlaceViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run {
            setVariable(BR.data, item)
        }
    }
    class VisitPlaceViewHolder(val binding: ItemVisitPlaceBinding) :
        RecyclerView.ViewHolder(binding.root)

}