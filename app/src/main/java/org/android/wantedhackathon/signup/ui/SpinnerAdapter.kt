package org.android.wantedhackathon.signup.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.ItemEntranceSpinnerBinding
import org.android.wantedhackathon.signup.data.EntranceSpinnerModel

class SpinnerAdapter(
    context: Context,
    @LayoutRes private val resId: Int,
    private val values: MutableList<EntranceSpinnerModel>
) : ArrayAdapter<EntranceSpinnerModel>(context, resId, values) {

    override fun getCount() = values.size

    override fun getItem(position: Int) = values[position]

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemEntranceSpinnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val model = values[position]
        try {
            binding.textviewEntranceYear.text = model.entrance
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemEntranceSpinnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val model = values[position]
        try {
            binding.textviewEntranceYear.text = model.entrance
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }

}