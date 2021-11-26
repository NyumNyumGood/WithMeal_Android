package org.android.wantedhackathon

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SetNickNameFragment : Fragment() {
    private var binding by AutoClearedValue<SetNickNameFragment>()
}