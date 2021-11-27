package org.android.wantedhackathon.util

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import org.android.wantedhackathon.R

object BindingAdapter {
    private const val HASH_TAG = "#"
    private const val SPACING = " "

    @JvmStatic
    @BindingAdapter("setImageUri")
    fun ImageView.setImageUri(uri: Uri?) {
        uri?.let {
            load(uri)
        }
    }

    @JvmStatic
    @BindingAdapter("setImageURL")
    fun ImageView.setImageURL(url: String?) {
        if(url == null) {
            background = ContextCompat.getDrawable(context, R.color.transparent)
        } else {
            load(url)
        }
    }

    @JvmStatic
    @BindingAdapter("corner_radius")
    fun ShapeableImageView.setCornerRadius(radius: Float) {
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
    }

    @JvmStatic
    @BindingAdapter("loadDrawable")
    fun loadDrawable(imageView: ImageView, drawable: Int?) {
        if (drawable == null) {
            imageView.load(R.color.transparent)
        } else {
            imageView.load(drawable)
        }
    }
    @JvmStatic
    @BindingAdapter("text_with_string_resources")
    fun TextView.setTextWithStringResources(resourceId: Int) {
        text = resources.getString(resourceId)
    }

    @JvmStatic
    @BindingAdapter("list_to_hash_tag")
    fun TextView.listToHashTagString(list: List<String>?){
        val hashTagList = list?.map { HASH_TAG + it }
        with(hashTagList) {
            text = if (list?.size ?: 0 <= 3) this?.joinToString(SPACING) else this?.subList(0, 3)?.joinToString(SPACING)
        }
    }
}
