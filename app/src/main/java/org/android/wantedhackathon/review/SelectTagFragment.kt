package org.android.wantedhackathon.review

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentSelectTagBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SelectTagFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentSelectTagBinding>()
    private val viewModel: ReviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectTagBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTagDescriptionList()
    }

    private fun initTagDescriptionList() {
        binding.recyclerviewTagDescriptionList.run {
            adapter = TagDescriptionListAdapter {
                viewModel.changeSelectedTag(it)
            }
            viewModel.selectedTagList.observe(viewLifecycleOwner) {
                Log.e("dfsda", "$it")
                it?.let {
                    (requireParentFragment() as WriteReviewFragment).changeSelectedTag(it)
                } ?: (requireParentFragment() as WriteReviewFragment).changeSelectedTag(listOf())
            }
        }
    }
}