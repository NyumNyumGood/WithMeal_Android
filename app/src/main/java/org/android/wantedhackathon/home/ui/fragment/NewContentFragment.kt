package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentNewContentBinding
import org.android.wantedhackathon.home.ui.adapter.FeedReviewAdapter
import org.android.wantedhackathon.home.ui.adapter.NewReviewAdapter
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class NewContentFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentNewContentBinding>()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  =  FragmentNewContentBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        fetchNewReviewList()
    }
    private fun fetchNewReviewList(){
        binding.recyclerviewUpdatedReview.run{
            this.adapter = NewReviewAdapter(object : NewReviewAdapter.OnItemClickListener{
                override fun itemClick() {
                    findNavController().navigate(R.id.action_mainFrameFragment_to_restaurantDetailFragment)
                }

            })
            viewModel.newReviewList.observe(viewLifecycleOwner){
                (adapter as NewReviewAdapter).submitList(it)
            }
        }
    }
}