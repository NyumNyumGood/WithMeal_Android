package org.android.wantedhackathon.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentHomeBinding
import org.android.wantedhackathon.home.ui.adapter.FeedPagerAdapter
import org.android.wantedhackathon.home.ui.adapter.FollowingUserAdpater
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
    ): View?  =  FragmentHomeBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        loadFollowing()
        setTabLayoutMediator()
        addFollowing()
        viewModel.getToken()
    }
    private fun setTabLayoutMediator(){
        binding.viewpagerTabLayout.adapter = FeedPagerAdapter(this)
        TabLayoutMediator(binding.tabLayoutHome, binding.viewpagerTabLayout) { tab, position ->
            when(position) {
                0 -> tab.text = "FEED"
                1 -> tab.text = "HOT"
                2 -> tab.text = "NEW"
            }
        }.attach()
    }
    private fun loadFollowing(){
        binding.recyclerviewUserFollowing.run {
            this.adapter = FollowingUserAdpater(object : FollowingUserAdpater.OnItemClickListener{
                override fun itemClick() {
                    findNavController().navigate(R.id.action_mainFrameFragment_to_followingDetailFragment)
                }
            })
            viewModel.followingUserList.observe(viewLifecycleOwner){
                (adapter as FollowingUserAdpater).submitList(it)
            }
        }
    }
    private fun addFollowing(){
        with(binding) {buttonPlusFriend.setOnClickListener { findNavController().navigate(R.id.action_mainFrameFragment_to_addFollowingFragment) }}
    }

}