package org.android.wantedhackathon.review.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.databinding.FragmentRegisterRestaurantBinding
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class RegisterRestaurantFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentRegisterRestaurantBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentRegisterRestaurantBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showKeywordResult()
        popBackStack()
    }

    private fun showKeywordResult(){
        binding.edittextSearchKeyword.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.imageviewSearchResult.isVisible = true
            }
            false
        }
    }

    private fun popBackStack(){
        binding.buttonDismiss.setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set("storeName", "dfd")
            findNavController().popBackStack()
        }
    }
}