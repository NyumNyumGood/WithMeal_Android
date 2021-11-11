package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentFeedBinding
import org.android.wantedhackathon.home.ui.adapter.FeedReviewAdapter
import org.android.wantedhackathon.home.ui.adapter.FollowingUserAdpater
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class FeedFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentFeedBinding>()
    private val viewmodel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  FragmentFeedBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        fetchFeedReviews()
    }

    private fun fetchFeedReviews(){
        binding.recyclerviewFeed.run {
            this.adapter = FeedReviewAdapter()
            viewmodel.feedReviewList.observe(viewLifecycleOwner){
                (adapter as FeedReviewAdapter).submitList(it)
            }
        }
    }
}