package com.amrabdelhamiddiab.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewPort {
    val alexandria: CameraPosition = CameraPosition.Builder()
        .target(LatLng(31.205297328351207, 29.918485040419384))
        .zoom(17f)
        .bearing(0f)
        .tilt(45f)
        .build()
    val alexandriaBounds = LatLngBounds(
        LatLng(31.16034938006103, 29.86358927458474),//SW
        LatLng(31.274845956535955, 30.024320410873948)
    )
}