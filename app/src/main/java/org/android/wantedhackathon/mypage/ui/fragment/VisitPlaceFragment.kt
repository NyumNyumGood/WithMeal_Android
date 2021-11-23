package org.android.wantedhackathon.mypage.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentVisitPlaceBinding
import org.android.wantedhackathon.mypage.ui.adapter.VisitPlaceAdapter
import org.android.wantedhackathon.mypage.viewmodel.MyPageViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class VisitPlaceFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentVisitPlaceBinding>()
    private val viewModel by viewModels<MyPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentVisitPlaceBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchVisitedPlaces()
    }

    private fun fetchVisitedPlaces(){
        binding.recyclerviewVisitedPlace.run{
            this.adapter = VisitPlaceAdapter()
            viewModel.visitedPlaceList.observe(viewLifecycleOwner) {
                (adapter as VisitPlaceAdapter).submitList(it)
            }
        }
    }
}