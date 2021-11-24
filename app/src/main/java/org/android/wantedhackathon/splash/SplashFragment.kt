package org.android.wantedhackathon.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentSplashBinding
import org.android.wantedhackathon.util.AutoClearedValue
import org.android.wantedhackathon.util.Extensions.applyVisibilityAnimation
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashFragment : Fragment(), CoroutineScope {
    private var binding by AutoClearedValue<FragmentSplashBinding>()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSplashBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        launchSplash()
        animateLogo()
    }

    private fun launchSplash(){
        launch {
            delay(1500)
            withContext(Dispatchers.Main){
                findNavController().navigate(R.id.action_splashFragment_to_mainFrameFragment)
            }
        }
    }

    private fun animateLogo() {
        val animationSet = binding.imageviewLogo.applyVisibilityAnimation(1000L)
        animationSet.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                binding.imageviewLogo.visibility = View.VISIBLE
            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })
    }
}