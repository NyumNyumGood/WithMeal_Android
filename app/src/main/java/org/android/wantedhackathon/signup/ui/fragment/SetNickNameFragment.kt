package org.android.wantedhackathon.signup.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentSetNickNameBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SetNickNameFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentSetNickNameBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSetNickNameBinding.inflate(inflater, container, false).let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popBackStack()
        initMain()
    }

    private fun popBackStack(){
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun initMain(){
        with(binding){ buttonComplete.setOnClickListener { findNavController().navigate(R.id.action_setNickNameFragment_to_mainFrameFragment) }}
    }


}