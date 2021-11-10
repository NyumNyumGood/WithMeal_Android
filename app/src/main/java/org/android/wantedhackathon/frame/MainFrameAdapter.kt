package org.android.wantedhackathon.frame

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.android.wantedhackathon.home.ui.HomeFragment
import org.android.wantedhackathon.map.ui.MapFragment
import org.android.wantedhackathon.mypage.MyPageFragment
import org.android.wantedhackathon.review.ReviewFragment

class MainFrameAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount() = 4
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> MapFragment()
            2 -> ReviewFragment()
            3 -> MyPageFragment()
            else -> throw RuntimeException("Fragment Load Error")
        }
    }
}