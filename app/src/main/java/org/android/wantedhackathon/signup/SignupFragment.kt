package org.android.wantedhackathon.signup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentSignupBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentSignupBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSignupBinding.inflate(inflater, container, false).let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSelectEntranceSpinner()
    }

    private fun showSelectEntranceSpinner(){
        val entrance = resources.getStringArray(R.array.spinner_entrance_year)
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_dropdown_item , entrance)
        binding.buttonDown.adapter = adapter
    }
}