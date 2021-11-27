package org.android.wantedhackathon.review

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.StoreTagEnum
import org.android.wantedhackathon.databinding.ItemSelectStoreTagReviewBinding

class TagDescriptionListAdapter(private val listener: (TagInfoEntity) -> Unit ): RecyclerView.Adapter<TagDescriptionListAdapter.TagDescriptionListViewHolder>() {
    var tags = StoreTagEnum.values().map { TagInfoEntity(it.tag, it.image, it.description) }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TagDescriptionListViewHolder {
        val binding = ItemSelectStoreTagReviewBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return TagDescriptionListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagDescriptionListViewHolder, position: Int) {
        val tag = tags[position]
        holder.binding.setVariable(BR.tagInfo, tag)
        holder.binding.checkboxTag.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(button: CompoundButton?, isChecked: Boolean) {
                listener(tag)
            }
        })
    }

    override fun getItemCount(): Int = tags.size

    class TagDescriptionListViewHolder(val binding: ItemSelectStoreTagReviewBinding): RecyclerView.ViewHolder(binding.root)
}