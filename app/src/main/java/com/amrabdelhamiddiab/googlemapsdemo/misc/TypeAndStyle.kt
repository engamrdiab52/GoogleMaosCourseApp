package com.amrabdelhamiddiab.googlemapsdemo.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.amrabdelhamiddiab.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class TypeAndStyle {
     fun setMapStyle(googleMap: GoogleMap, context: Context) {
        try {
            //true : means the style has successfully enabled
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.style
                )
            )
            if (! success){
                Log.d("MainActivity", " failed to add style")
            }
        } catch (e: Exception) {
            Log.d("MainActivity", e.message.toString())
        }
    }

    fun setMapType(item: MenuItem, map: GoogleMap){
        when (item.itemId) {
            R.id.normal_map -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.hybrid_map -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.satellite_map -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain_map -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none_map -> {
                map.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }
    }
}