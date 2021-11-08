package org.android.wantedhackathon.frame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentMainFrameBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class MainFrameFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentMainFrameBinding>()
    private val viewModel: MainFrameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainFrameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initViewPager()
        configureBottomNavigation()
    }

    private fun observeViewModel(){
        viewModel.pageIndex.observe(viewLifecycleOwner){ pageIndex ->
            binding.viewpagerMainFrame.currentItem = pageIndex
            selectBottomNavigationMenu(pageIndex)
        }
    }

    private fun selectBottomNavigationMenu(pageIndex: Int) {
        binding.bottomNavigation.selectedItemId = when (pageIndex) {
            0 -> R.id.homeFragment
            1 -> R.id.mapFragment
            2 -> R.id.reviewFragment
            3 -> R.id.myPageFragment
            else -> throw RuntimeException("Bottom Navigation Load Error")
        }
    }

    private fun initViewPager() = binding.viewpagerMainFrame.run{
        isUserInputEnabled = false
        offscreenPageLimit = 3
        adapter = MainFrameAdapter(this@MainFrameFragment)
        registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.changePageIdx(position)
            }
        })
    }

    private fun configureBottomNavigation() = binding.bottomNavigation.run {
        setOnItemSelectedListener { item->
            viewModel.changePageIdx(
                when(item.itemId){
                    R.id.homeFragment -> 0
                    R.id.mapFragment -> 1
                    R.id.reviewFragment -> 2
                    R.id.myPageFragment -> 3
                    else -> throw java.lang.RuntimeException("Bottom Navigation Item Error")
                }
            )
            true
        }
    }
}