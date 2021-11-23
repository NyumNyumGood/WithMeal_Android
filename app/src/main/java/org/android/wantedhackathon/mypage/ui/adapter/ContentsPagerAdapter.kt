package org.android.wantedhackathon.mypage.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.android.wantedhackathon.mypage.ui.fragment.VisitPlaceFragment
import org.android.wantedhackathon.mypage.ui.fragment.WishPlaceFragment

class ContentsPagerAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    private val tabCreators : Map<Int, ()-> Fragment> = mapOf(
        VISITED to { VisitPlaceFragment() },
        WISHED to { WishPlaceFragment() }
    )
    override fun getItemCount() = tabCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
    companion object {
        const val VISITED= 0
        const val WISHED= 1
    }
}