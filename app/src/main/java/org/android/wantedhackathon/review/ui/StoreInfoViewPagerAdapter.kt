package org.android.wantedhackathon.review.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.android.wantedhackathon.review.ui.SelectTagFragment
import org.android.wantedhackathon.review.ui.WriteDetailReviewFragment
import java.lang.IllegalArgumentException

class StoreInfoViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SelectTagFragment()
            1 -> WriteDetailReviewFragment()
            else -> throw IllegalArgumentException("cannot found write review fragment ")
        }
    }
}