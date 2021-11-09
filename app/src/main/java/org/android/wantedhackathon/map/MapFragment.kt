package org.android.wantedhackathon.map

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
import org.android.wantedhackathon.databinding.FragmentMapBinding
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
        requestLocationPermission.launch(REQUEST_PERMISSIONS)
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

    companion object {
        private val REQUEST_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}