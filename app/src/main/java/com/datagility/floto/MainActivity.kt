package com.datagility.floto

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 999
    }

    private var longitude: Double = 0.0
    private var latitude: Double = 0.0

    @Inject
    lateinit var client: NotesClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btn_send)
        val txtNote = findViewById<EditText>(R.id.txt_note)

        btnSend.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                txtNote.text.toString() + " | " + latitude.toString() + " | " + longitude.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onStart() {
        super.onStart()
        when {
            Permission.isAccessFineLocationGranted(this) -> {
                when {
                    Permission.isLocationEnabled(this) -> {
                        setUpLocationListener()
                    }
                    else -> {
                        Permission.showGPSNotEnabledDialog(this)
                    }
                }
            }
            else -> {
                Permission.requestAccessFineLocationPermission(
                    this,
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    when {
                        Permission.isLocationEnabled(this) -> {
                            setUpLocationListener()
                        }
                        else -> {
                            Permission.showGPSNotEnabledDialog(this)
                        }
                    }
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.location_permission_not_granted),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    fun postNote(noteText: String) {
        client.post(Note(noteText, true, latitude, longitude))
    }

    @SuppressLint("MissingPermission")
    private fun setUpLocationListener() {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val locationRequest = LocationRequest.create().apply {
            interval = 20000
            fastestInterval = 2000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    for (location in locationResult.locations) {
                        latitude = location.latitude
                        longitude = location.longitude
                    }
                }
            },
            Looper.myLooper()!!
        )
    }
}
