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
        //TODO: REFACTOR & FIX
        val list = ArrayList<String>()
        list.add("https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg")
        list.add("https://www.irreverentgent.com/wp-content/uploads/2018/03/Awesome-Profile-Pictures-for-Guys-look-away2.jpg")
        list.add("https://i.ytimg.com/vi/L3wKzyIN1yk/maxresdefault.jpg")
        list.add("https://i.ytimg.com/vi/0EnrFe3Zb6k/maxresdefault.jpg")
        holder.binding.run {
            setVariable(BR.data, item)
        }
        holder.binding.imageListUser.setImageCount(4,3)
        holder.binding.imageListUser.setImageSize(30)
        holder.binding.imageListUser.setImageList(list)
        holder.binding.imageListUser.setTextSize(8)
    }
}



