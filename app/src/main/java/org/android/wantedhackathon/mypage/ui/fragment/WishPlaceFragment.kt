package org.android.wantedhackathon.mypage.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentWishPlaceBinding
import org.android.wantedhackathon.mypage.ui.adapter.WishPlaceAdapter
import org.android.wantedhackathon.mypage.viewmodel.MyPageViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class WishPlaceFragment :Fragment(){
    private var binding by AutoClearedValue<FragmentWishPlaceBinding>()
    private val viewModel by viewModels<MyPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentWishPlaceBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        fetchWishPlaces()
    }

    private fun fetchWishPlaces(){
        with(binding){
            recyclerviewWishPlace.run {
                this.adapter = WishPlaceAdapter()
                viewModel.wishList.observe(viewLifecycleOwner){
                    (adapter as WishPlaceAdapter).submitList(it)
                }
            }
        }
    }

}