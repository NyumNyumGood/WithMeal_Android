package org.android.wantedhackathon.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemNewContentBinding
import org.android.wantedhackathon.home.data.NewContentEntity
import org.android.wantedhackathon.util.DiffCallback

class NewReviewAdapter(val listener : NewReviewAdapter.OnItemClickListener) :
    ListAdapter<NewContentEntity, NewReviewAdapter.NewReviewViewHolder>(DiffCallback<NewContentEntity>()){
    interface OnItemClickListener{
        fun itemClick()
    }
    class NewReviewViewHolder(val binding : ItemNewContentBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReviewViewHolder {
        val binding = ItemNewContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewReviewViewHolder, position: Int) {
        val item = getItem(position)
        val list = ArrayList<String>()
        list.add("https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg")
        list.add("https://www.irreverentgent.com/wp-content/uploads/2018/03/Awesome-Profile-Pictures-for-Guys-look-away2.jpg")
        list.add("https://i.ytimg.com/vi/L3wKzyIN1yk/maxresdefault.jpg")
        list.add("https://i.ytimg.com/vi/0EnrFe3Zb6k/maxresdefault.jpg")
        holder.binding.run {
            setVariable(BR.data, item)
        }
        holder.binding.imageListFollowers.setImageCount(4,3)
        holder.binding.imageListFollowers.setImageSize(30)
        holder.binding.imageListFollowers.setImageList(list)
        holder.binding.imageListFollowers.setTextSize(8)
        holder.binding.root.setOnClickListener { listener.itemClick()}

    }
}
