package org.android.wantedhackathon.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentLoginBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentLoginBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(inflater, container, false).let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}