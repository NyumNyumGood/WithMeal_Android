package org.android.wantedhackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentReviewBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class ReviewFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentReviewBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? ? =  FragmentReviewBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}