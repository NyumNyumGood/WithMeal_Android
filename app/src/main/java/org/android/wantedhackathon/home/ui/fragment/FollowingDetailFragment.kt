package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentFollowingDetailBinding
import org.android.wantedhackathon.home.data.FollowingEntity
import org.android.wantedhackathon.home.ui.adapter.FeedReviewAdapter
import org.android.wantedhackathon.home.ui.adapter.FollowingDetailAdapter
import org.android.wantedhackathon.home.viewmodel.FollowingViewModel
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class FollowingDetailFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentFollowingDetailBinding>()
    private val viewModel by viewModels<FollowingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentFollowingDetailBinding.inflate(inflater, container, false)?.let {
        binding= it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchFeedReviews()
        popBackStack()
        viewModel.fetchFeedReviewList()
    }

    private fun popBackStack(){
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun fetchFeedReviews(){
        binding.recyclerviewFollowingDetail.run {
            isNestedScrollingEnabled = false
            this.adapter = FollowingDetailAdapter()
            viewModel.followingDetailInfo.observe(viewLifecycleOwner){
                (adapter as FollowingDetailAdapter).submitList(it)
            }
        }
    }

}