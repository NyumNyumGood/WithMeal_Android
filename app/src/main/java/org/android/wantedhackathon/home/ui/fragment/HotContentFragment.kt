package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentHotContentBinding
import org.android.wantedhackathon.home.ui.adapter.HotReviewAdapter
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class HotContentFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentHotContentBinding>()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  =  FragmentHotContentBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        fetchHotReviewList()
    }

    private fun fetchHotReviewList(){
        binding.recyclerviewHotContent.run{
            this.adapter = HotReviewAdapter()
            viewModel.hotReviewList.observe(viewLifecycleOwner){
                (adapter as HotReviewAdapter).submitList(it)
            }
        }
    }

}