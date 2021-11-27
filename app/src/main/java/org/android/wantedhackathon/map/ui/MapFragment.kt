package org.android.wantedhackathon.map.ui

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import dagger.hilt.android.AndroidEntryPoint
import org.android.wantedhackathon.BR
import org.android.wantedhackathon.R
import org.android.wantedhackathon.databinding.FragmentMapBinding
import org.android.wantedhackathon.map.viewmodel.MapViewModel
import org.android.wantedhackathon.util.AutoClearedValue

@AndroidEntryPoint
class MapFragment :Fragment(), OnMapReadyCallback{
    private var binding by AutoClearedValue<FragmentMapBinding>()
    private val viewModel by viewModels<MapViewModel>()
    private var map: NaverMap? =null
    private lateinit var mapView: MapView
    private lateinit var locationSource: FusedLocationSource


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
        mapView = binding.mapView
        mapView.getMapAsync(this)
        requestLocationPermission.launch(REQUEST_PERMISSIONS)
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
        map.uiSettings.isZoomControlEnabled = true
        map.uiSettings.isLocationButtonEnabled = false
        binding.locationButton.map = map
        setWithMealMarker()
    }

    private fun setWithMealMarker(){
        val marker = Marker()
        val marker2 = Marker()
        val marker3 = Marker()
        val marker4 = Marker()
        val marker5 = Marker()

        marker.position = LatLng(37.5670135, 126.9783740)
        marker2.position = LatLng(37.5670130, 126.9753960)
        marker3.position = LatLng(37.5660127, 126.9753660)
        marker4.position = LatLng(37.5667130, 126.9798740)
        marker5.position = LatLng(37.5630057, 126.9743660)

        marker.icon = OverlayImage.fromResource(R.drawable.pin_icn_selected)
        marker2.icon = OverlayImage.fromResource(R.drawable.pin_icn_notselected_bookmark)
        marker3.icon = OverlayImage.fromResource(R.drawable.pin_icn_notselected_bookmark)
        marker4.icon = OverlayImage.fromResource(R.drawable.pin_icn_notselected_myreview)
        marker5.icon = OverlayImage.fromResource(R.drawable.pin_icn_notselected_friendreview)

        marker.width = 120
        marker.height = 138
        marker2.height = 70
        marker2.width = 70
        marker3.height = 70
        marker3.width = 70
        marker4.height = 70
        marker4.width = 70
        marker5.height = 70
        marker5.width = 70

        marker.map=  map
        marker2.map = map
        marker3.map = map
        marker4.map = map
        marker5.map = map

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