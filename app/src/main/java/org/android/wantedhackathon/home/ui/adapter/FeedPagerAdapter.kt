package org.android.wantedhackathon.home.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.android.wantedhackathon.home.ui.fragment.FeedFragment
import org.android.wantedhackathon.home.ui.fragment.HotContentFragment
import org.android.wantedhackathon.home.ui.fragment.NewContentFragment

class FeedPagerAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    private val tabCreators : Map<Int, ()->Fragment> = mapOf(
        FEED_INDEX to {FeedFragment()},
        HOT_FEED_INDEX to {HotContentFragment()},
        NEW_FEED_INDEX to {NewContentFragment()}
    )
    override fun getItemCount() = tabCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
    companion object {
        const val FEED_INDEX = 0
        const val HOT_FEED_INDEX = 1
        const val NEW_FEED_INDEX = 2
    }
}