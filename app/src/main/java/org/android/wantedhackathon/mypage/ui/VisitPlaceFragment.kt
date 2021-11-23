package org.android.wantedhackathon.mypage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentVisitPlaceBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class VisitPlaceFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentVisitPlaceBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentVisitPlaceBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}