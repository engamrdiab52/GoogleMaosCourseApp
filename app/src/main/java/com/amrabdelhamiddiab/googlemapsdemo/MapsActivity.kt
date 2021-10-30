package com.amrabdelhamiddiab.googlemapsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.amrabdelhamiddiab.googlemapsdemo.databinding.ActivityMapsBinding
import com.amrabdelhamiddiab.googlemapsdemo.misc.CameraAndViewPort
import com.amrabdelhamiddiab.googlemapsdemo.misc.TypeAndStyle
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback/*, GoogleMap.OnMarkerDragListener*//*, GoogleMap.OnMarkerClickListener */ {
    companion object {
        const val TAG = "MapsActivity"
    }

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val typeAndStyle by lazy {
        TypeAndStyle()
    }
    private val cameraAndViewPort by lazy {
        CameraAndViewPort()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.maps_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, map)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val alexandria = LatLng(31.205297328351207, 29.918485040419384)
        val cairo = LatLng(30.047448757531424, 31.234773164975618)
        val alexMarker =
            map.addMarker(
                MarkerOptions()
                    .position(alexandria)
                    .title("Marker in Alexandria")
                    .draggable(true)
            )
        alexMarker?.tag = "Restaurant"
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(alexandria, 10f))
        //  map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewPort.alexandria))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(map, this)
        //  map.setMinZoomPreference(15f)
        //   map.setMaxZoomPreference(17f)

        /* lifecycleScope.launch{
             delay(2000)
             map.moveCamera(CameraUpdateFactory.zoomBy(3f))
         }*/
        /*  lifecycleScope.launch{
              delay(2000)
              map.moveCamera(CameraUpdateFactory.newLatLng(cairo))
          }*/
        /* lifecycleScope.launch{
             delay(2000)
             map.moveCamera(CameraUpdateFactory.scrollBy(-200f,100f))
             }*/
        /*lifecycleScope.launch {
            delay(2000)
            map.moveCamera(
                CameraUpdateFactory.newLatLngBounds(
                    cameraAndViewPort.alexandriaBounds,
                    0
                )
            )
        }*/

        /*  lifecycleScope.launch {
              delay(2000)
              map.moveCamera(
                  CameraUpdateFactory.newLatLngZoom(
                      cameraAndViewPort.alexandriaBounds.center,
                      20f
                  )
              )
          }*/
        /* lifecycleScope.launch {
             delay(2000)
             map.moveCamera(
                 CameraUpdateFactory.newLatLngBounds(
                     cameraAndViewPort.alexandriaBounds,
                     100
                 )
             )
             map.setLatLngBoundsForCameraTarget(cameraAndViewPort.alexandriaBounds)
         }*/
        /*  lifecycleScope.launch {
              delay(2000)
              map.animateCamera(
                  CameraUpdateFactory.newLatLngBounds(
                      cameraAndViewPort.alexandriaBounds,
                      100
                  ), 2000, null
              )

          }*/
        /* lifecycleScope.launch {
             delay(2000)
             map.animateCamera(
                 CameraUpdateFactory.zoomTo(15f), 2000, null
             )
         }*//*
        lifecycleScope.launch {
            delay(2000)
            map.animateCamera(
                CameraUpdateFactory.scrollBy(200f, 0f), 2000, null
            )
        }*/
        /*lifecycleScope.launch {
            delay(2000)
            map.animateCamera(
                CameraUpdateFactory.newCameraPosition(cameraAndViewPort.alexandria),
                2000, object : GoogleMap.CancelableCallback {
                    override fun onCancel() {
                        Toast.makeText(this@MapsActivity,
                            "Canceled", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFinish() {
                        Toast.makeText(this@MapsActivity,
                            " Finished", Toast.LENGTH_SHORT).show()
                    }

                }
            )
        }*/
        //  onMapClicked()
        //onMapLongClicked()
        /*lifecycleScope.launch {
            delay(2000)
            alexMarker?.remove()
        }*/
        //   map.setOnMarkerClickListener(this)
     //   map.setOnMarkerDragListener(this)
    }

/*    override fun onMarkerDrag(p0: Marker) {
       Log.d(TAG, "Start")
    }

    override fun onMarkerDragEnd(p0: Marker) {
        Log.d(TAG, "Drag")
    }

    override fun onMarkerDragStart(p0: Marker) {
        Log.d(TAG, "End")
    }*/

    /*  override fun onMarkerClick(p0: Marker): Boolean {
          Log.d(TAG, p0.tag as String ?: "Empty")
          return false
      }*/

    /* private fun onMapClicked() {
         map.setOnMapClickListener {
             Toast.makeText(this, "single Click", Toast.LENGTH_SHORT).show()
         }
     }

     private fun onMapLongClicked() {
         map.setOnMapLongClickListener {
             //  Toast.makeText(this, "${it.longitude}  ${it.latitude}", Toast.LENGTH_SHORT).show()
             map.addMarker(MarkerOptions().position(it).title("New Marker"))
         }
     }
 */
}