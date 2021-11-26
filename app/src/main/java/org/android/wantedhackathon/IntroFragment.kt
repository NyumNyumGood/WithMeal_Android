package org.android.wantedhackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import org.android.wantedhackathon.databinding.FragmentIntroBinding
import org.android.wantedhackathon.util.AutoClearedValue
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class IntroFragment : Fragment(), CoroutineScope {
    private var binding by AutoClearedValue<FragmentIntroBinding>()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentIntroBinding.inflate(inflater, container, false).let{
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        launchScope()
    }
    private fun launchScope() {
        launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                findNavController().navigate(R.id.action_introFragment_to_loginFragment)
            }
        }
    }
}