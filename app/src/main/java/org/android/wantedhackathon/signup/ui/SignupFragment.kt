package org.android.wantedhackathon.signup.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentSignupBinding
import org.android.wantedhackathon.signup.data.EntranceSpinnerModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentSignupBinding>()
    private val listOfYear = ArrayList<EntranceSpinnerModel>()
    private lateinit var spinnerAdapterYear: SpinnerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSignupBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSelectEntranceSpinner()
        popBackStack()
    }

    private fun showSelectEntranceSpinner() {
        val entrance = resources.getStringArray(R.array.spinner_entrance_year)
        for (i in entrance.indices) {
            val year = EntranceSpinnerModel(entrance[i])
            listOfYear.add(year)
        }
        spinnerAdapterYear =
            SpinnerAdapter(requireActivity(), R.layout.item_entrance_spinner, listOfYear)
        binding.spinnerEntranceYear.adapter = spinnerAdapterYear
    }

    private fun popBackStack() {
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun startCertifyCollege() {
        with(binding) { binding.buttonComplete.setOnClickListener { } }
    }

}