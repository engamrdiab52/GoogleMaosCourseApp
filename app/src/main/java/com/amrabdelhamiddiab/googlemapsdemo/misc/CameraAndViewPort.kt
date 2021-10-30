package com.amrabdelhamiddiab.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewPort {
    val alexandria: CameraPosition = CameraPosition.Builder()
        .target(LatLng(31.205297328351207, 29.918485040419384))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()
}