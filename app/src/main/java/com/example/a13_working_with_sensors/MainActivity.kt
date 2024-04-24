package com.example.a13_working_with_sensors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.a13_working_with_sensors.ui.theme._13_Working_With_SensorsTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult



class MainActivity : ComponentActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var latitude by mutableStateOf("")
    private var longitude by mutableStateOf("")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)



        setContent {
            _13_Working_With_SensorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(text = "latitude: ${latitude}")
                        Text(text = "longitude: ${longitude}")

                    }

                }
            }
        }

        getLastLocation()
    }

    private fun getLastLocation() {

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Request Permission
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }

        // Get last location
        val lastLocation = fusedLocationProviderClient.lastLocation

        // Check the response / Success or not
        lastLocation.addOnSuccessListener {
            if ( it != null) {
                println("Latitude ${it.latitude}")
                println("Longitude ${it.longitude}")

                latitude = it.latitude.toString()
                longitude = it.longitude.toString()
            }

        }

        lastLocation.addOnFailureListener{
            println("Cannot find location")

        }
    }


}
