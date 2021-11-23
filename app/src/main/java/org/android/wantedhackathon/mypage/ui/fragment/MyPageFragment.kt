package org.android.wantedhackathon.mypage.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentMypageBinding
import org.android.wantedhackathon.mypage.ui.adapter.ContentsPagerAdapter
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class MyPageFragment: Fragment(){
    private var binding by AutoClearedValue<FragmentMypageBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? ? =  FragmentMypageBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setTabLayoutMediator()
    }

    private fun setTabLayoutMediator(){
        binding.viewpagerMyPage.adapter = ContentsPagerAdapter(this)
        TabLayoutMediator(binding.tabLayoutMypage, binding.viewpagerMyPage){ tab, position ->
            when(position) {
                0 -> tab.text = "가봤어요"
                1 -> tab.text = "가고 싶어요"
            }
        }.attach()
    }
}