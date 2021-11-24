package org.android.wantedhackathon.map.ui

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.databinding.FragmentMapBinding
import org.android.wantedhackathon.map.viewmodel.MapViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class MapFragment :Fragment(), OnMapReadyCallback{
    private var binding by AutoClearedValue<FragmentMapBinding>()
    private val viewModel by viewModels<MapViewModel>()
    private lateinit var map: NaverMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? ? =  FragmentMapBinding.inflate(inflater, container, false)?.let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        requestLocationPermission.launch(REQUEST_PERMISSIONS)
        setImageList()
    }

    private val requestLocationPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissions.forEach { permission ->
                if (permission.value == false) {
                    Toast.makeText(requireContext(), "Access Denied: ${permission.key}", Toast.LENGTH_SHORT).show()
                }
            }

            if (permissions.values.all { it == true }) { }
        }

    override fun onMapReady(map: NaverMap) {
        this.map = map
        map.uiSettings.isZoomControlEnabled = false
        map.uiSettings.isLocationButtonEnabled = false
        binding.locationButton.map = map
    }

    private fun setImageList(){
        val list = ArrayList<String>()
        list.add("https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg")
        list.add("https://www.irreverentgent.com/wp-content/uploads/2018/03/Awesome-Profile-Pictures-for-Guys-look-away2.jpg")
        list.add("https://i.ytimg.com/vi/L3wKzyIN1yk/maxresdefault.jpg")
        list.add("https://i.ytimg.com/vi/0EnrFe3Zb6k/maxresdefault.jpg")

        with(binding.imageListUser){
            setImageCount(4,3)
            setImageSize(30)
            setImageList(list)
        }
    }

    companion object {
        private val REQUEST_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}