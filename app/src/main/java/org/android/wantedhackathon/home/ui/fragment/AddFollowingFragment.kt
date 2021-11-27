package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentAddFollowingBinding
import org.android.wantedhackathon.home.ui.adapter.AddFollowingAdapter
import org.android.wantedhackathon.home.ui.adapter.FollowingDetailAdapter
import org.android.wantedhackathon.home.viewmodel.FollowingViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class AddFollowingFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentAddFollowingBinding>()
    private val viewModel by viewModels<FollowingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentAddFollowingBinding.inflate(inflater, container, false).let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchFeedReviews()
        popBackStack()
    }

    private fun fetchFeedReviews(){
        binding.recyclerviewRecommendFollowing.run {
            isNestedScrollingEnabled = false
            this.adapter = AddFollowingAdapter()
            viewModel.addFollowing.observe(viewLifecycleOwner){
                (adapter as AddFollowingAdapter).submitList(it)
            }
        }
    }

    private fun popBackStack(){
        with(binding){ buttonReturn.setOnClickListener { findNavController().popBackStack() }}
    }
}