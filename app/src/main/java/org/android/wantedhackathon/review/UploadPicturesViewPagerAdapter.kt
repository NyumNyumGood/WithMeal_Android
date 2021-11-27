package org.android.wantedhackathon.review

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.ItemUploadPictureReviewBinding
import org.android.wantedhackathon.util.DiffCallback

class UploadPicturesViewPagerAdapter: ListAdapter<Uri, UploadPicturesViewPagerAdapter.UploadPicturesViewHolder>(
    DiffCallback<Uri>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadPicturesViewHolder {
        val binding = ItemUploadPictureReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UploadPicturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UploadPicturesViewHolder, position: Int) {
        val imageUri = getItem(position)
        holder.binding.setVariable(BR.imageUri, imageUri)
    }

    class UploadPicturesViewHolder(val binding: ItemUploadPictureReviewBinding): RecyclerView.ViewHolder(binding.root)
}