package org.android.wantedhackathon.review.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentWriteDetailReviewBinding
import org.android.wantedhackathon.frame.MainFrameFragmentDirections
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

        (requireParentFragment() as WriteReviewFragment).findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("storeName")?.observe(viewLifecycleOwner) {
            binding.textviewSelectRestaurant.text = "세겹먹는날"
            binding.textviewMust.isVisible = false
            binding.textviewPlus.isVisible = false

        }


        registerRestaurant()
    }

    private fun registerRestaurant(){
        binding.constraintlayoutSelectRestaurant.setOnClickListener {
            val action = WriteReviewFragmentDirections.actionWriteReviewFragmentToRegisterRestaurantFragment()
            findNavController().navigate(action)
        }
    }





}