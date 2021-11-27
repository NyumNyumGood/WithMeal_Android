package org.android.wantedhackathon.signup.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentSignupBinding
import org.android.wantedhackathon.signup.viewmodel.SignupViewModel
import org.android.wantedhackathon.signup.data.EntranceSpinnerModel
import org.android.wantedhackathon.signup.data.UniversitySpinnerModel
import org.android.wantedhackathon.signup.ui.adapter.SearchUniversityAdapter
import org.android.wantedhackathon.signup.ui.adapter.SpinnerAdapter
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentSignupBinding>()
    private val listOfYear = ArrayList<EntranceSpinnerModel>()
    private val listOfSchool = ArrayList<UniversitySpinnerModel>()
    private val viewModel: SignupViewModel by viewModels()
    private lateinit var spinnerAdapterYear: SpinnerAdapter
    private lateinit var spinnerAdapterSchool: SearchUniversityAdapter

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
        startCertifyCollege()
        showSelectUniversitySpinner()
        activeButton()
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

    private fun showSelectUniversitySpinner() {
        val entrance = resources.getStringArray(R.array.spinner_select_university)
        for (i in entrance.indices) {
            val school = UniversitySpinnerModel(entrance[i])
            listOfSchool.add(school)
        }
        spinnerAdapterSchool = SearchUniversityAdapter(requireActivity(), R.layout.item_university_spinner, listOfSchool)
        binding.spinnerUniversity.adapter = spinnerAdapterSchool
       binding.spinnerUniversity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
           override fun onItemSelected(
               parent: AdapterView<*>?,
               view: View?,
               position: Int,
               id: Long
           ) {
               viewModel.changeSchoolIdx(position)
               Log.e("dsaf", "${position}")
           }

           override fun onNothingSelected(parent: AdapterView<*>?) {
               TODO("Not yet implemented")
           }
       }
    }

    private fun activeButton() {
        viewModel.schoolIdx.observe(viewLifecycleOwner) {
            binding.buttonComplete.isActivated = it != 0
        }
    }
    private fun popBackStack() {
        binding.buttonReturn.setOnClickListener { findNavController().popBackStack() }
    }

    private fun startCertifyCollege() {
        with(binding) { buttonComplete.setOnClickListener { findNavController().navigate(R.id.action_signupFragment_to_collegeCertifyFragment)} }
    }


}