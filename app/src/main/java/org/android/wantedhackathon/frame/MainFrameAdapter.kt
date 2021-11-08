package org.android.wantedhackathon.frame

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.android.wantedhackathon.HomeFragment
import org.android.wantedhackathon.MapFragment
import org.android.wantedhackathon.MyPageFragment
import org.android.wantedhackathon.ReviewFragment

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