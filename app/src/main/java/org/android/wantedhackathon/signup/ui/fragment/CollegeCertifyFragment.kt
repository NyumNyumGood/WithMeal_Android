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
import org.android.wantedhackathon.databinding.FragmentCollegeCertifyBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class CollegeCertifyFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentCollegeCertifyBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentCollegeCertifyBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popBackStack()
        completeSignup()
        activateValidateButton()
    }

    private fun popBackStack() {
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun completeSignup() {
        binding.buttonComplete.setOnClickListener { findNavController().navigate(R.id.action_collegeCertifyFragment_to_completeSignupFragment) }
    }

    private fun activateValidateButton() {
        with(binding) {
            edittextWebMail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    buttonSendMail.isActivated = true
                }
                override fun afterTextChanged(s: Editable?) {
                }
            })
            edittextVerificationNumber.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    buttonComplete.isActivated = true
                }
                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }
}
