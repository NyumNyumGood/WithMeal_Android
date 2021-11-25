package org.android.wantedhackathon.signup


import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentSignupBinding
import org.android.wantedhackathon.util.AutoClearedValue
import org.android.wantedhackathon.util.DatePickerDialog

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
    }
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun selectEntranceYear() {
//        binding.textInputLayout.setOnClickListener {
//            val datePicker = DatePickerDialog(object : DialogInterface {
//                override fun applyDate(year: String) {
//                    binding.edittextEntrance.setText("$year")
//                }
//            })
//            datePicker.show(requireParentFragment().parentFragmentManager, "picker")
//        }
//    }
}