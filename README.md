# 13_Working_With_Sensors

This project demonstrates how to work with location sensors in an Android app using Kotlin and Jetpack Compose. The app fetches the last known location of the device and displays the latitude and longitude coordinates on the screen.

## Features

- Fetches the last known location using the Fused Location Provider API.
- Requests location permissions at runtime if not granted.
- Displays latitude and longitude coordinates on the screen using Jetpack Compose.

## Prerequisites

  In Dependencies - Adds google play services location libary
  implementation("com.google.android.gms:play-services-location:21.2.0")

  In Android Manifest - Allows application to ask for permission to fetch location
  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
  <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
