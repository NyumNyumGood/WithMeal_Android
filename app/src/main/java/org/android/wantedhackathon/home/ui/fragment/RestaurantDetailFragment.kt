package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentRestaurantDetailBinding
import org.android.wantedhackathon.home.ui.adapter.FeedReviewAdapter
import org.android.wantedhackathon.home.ui.adapter.RestaurantReviewAdapter
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class RestaurantDetailFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentRestaurantDetailBinding>()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRestaurantDetailBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchFeedReviews()
        popBackStack()
        viewModel.fetchRestaurantReviewList()
    }

    private fun fetchFeedReviews(){
        binding.recyclerviewReviewDetail.run {
            isNestedScrollingEnabled = false
            this.adapter = RestaurantReviewAdapter()
            viewModel.feedReviewList.observe(viewLifecycleOwner){
                (adapter as RestaurantReviewAdapter).submitList(it)
            }
        }
    }

    private fun popBackStack(){
        with(binding) { buttonReturn.setOnClickListener { findNavController().popBackStack() }}
    }
}