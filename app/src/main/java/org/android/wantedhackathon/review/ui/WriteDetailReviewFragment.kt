package org.android.wantedhackathon.review.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.android.wantedhackathon.databinding.FragmentWriteDetailReviewBinding
import org.android.wantedhackathon.util.AutoClearedValue

class WriteDetailReviewFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentWriteDetailReviewBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteDetailReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}