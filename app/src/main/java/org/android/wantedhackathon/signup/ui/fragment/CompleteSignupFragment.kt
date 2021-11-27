package org.android.wantedhackathon.signup.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentCompleteSignupBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class CompleteSignupFragment : Fragment(){
    private var binding by AutoClearedValue<FragmentCompleteSignupBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = FragmentCompleteSignupBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popBackStack()
        setNickName()
        activateCompleteButton()
    }

    private fun popBackStack(){
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setNickName(){
        binding.buttonComplete.setOnClickListener { findNavController().navigate(R.id.action_completeSignupFragment_to_setNickNameFragment) }
    }
    private fun activateCompleteButton() {
        with(binding) {
            edittextPasswordCheck.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    buttonComplete.isActivated = true
                }
                override fun afterTextChanged(s: Editable?) {
                }
            })
        }}
}