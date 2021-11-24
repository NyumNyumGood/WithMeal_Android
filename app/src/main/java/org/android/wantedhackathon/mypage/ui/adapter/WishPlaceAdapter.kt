package org.android.wantedhackathon.mypage.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemWishPlaceBinding
import org.android.wantedhackathon.mypage.data.WishPlaceEntity
import org.android.wantedhackathon.util.DiffCallback

class WishPlaceAdapter() : ListAdapter<WishPlaceEntity, WishPlaceAdapter.WishPlaceViewHolder>(
    DiffCallback<WishPlaceEntity>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishPlaceViewHolder {
        val binding = ItemWishPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishPlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WishPlaceViewHolder, position: Int) {
        val item = getItem(position)
        val list = ArrayList<String>()
        list.add("https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg")
        list.add("https://www.irreverentgent.com/wp-content/uploads/2018/03/Awesome-Profile-Pictures-for-Guys-look-away2.jpg")
        list.add("https://i.ytimg.com/vi/L3wKzyIN1yk/maxresdefault.jpg")
        list.add("https://i.ytimg.com/vi/0EnrFe3Zb6k/maxresdefault.jpg")
        holder.binding.run {
            setVariable(BR.data, item)
            imageListFollowers.setImageCount(4,3)
            imageListFollowers.setImageSize(30)
            imageListFollowers.setImageList(list)
        }
    }
    class WishPlaceViewHolder(val binding: ItemWishPlaceBinding) :
        RecyclerView.ViewHolder(binding.root)

}