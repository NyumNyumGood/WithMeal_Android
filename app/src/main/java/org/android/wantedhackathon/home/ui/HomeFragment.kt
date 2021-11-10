package org.android.wantedhackathon.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentHomeBinding
import org.android.wantedhackathon.home.viewmodel.HomeViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class HomeFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentHomeBinding>()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? ? =  FragmentHomeBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        loadFollowing()
    }
    private fun loadFollowing(){
        binding.recyclerviewUserFollowing.run {
            this.adapter = FollowingUserAdpater()
            viewModel.followingUserList.observe(viewLifecycleOwner){
                (adapter as FollowingUserAdpater).submitList(it)
            }
        }
    }
}