# News App

News App is an offline-first application that shows a list of news and details using the [NewsAPI]( https://newsapi.org/). The app is based on [Android developers architecture]( https://developer.android.com/topic/architecture) and and developed with Kotlin language, Clean Arch, MVVM, Corourines, Flow, Hilt, Navigation, … 
- News App implemented as an offline_fist application, that the source of truth for application data is a database.

## Architecture
This repository contains the code and resources for a project that implements the Clean Architecture pattern and utilizes the MVVM architectural pattern for presentation.

## Libraries
- Kotlin (Language)
- Hilt (Dependency Injection)
- Retrofite,The network API requests are made using [Retrofit](https://github.com/square/retrofit) 
- Room, news cach and read with [Room](https://developer.android.com/training/data-storage/room)
- Coroutines, Flow
- MVVM [Viewmodel]
- Navigation
- JUnit
- picasso

## Requirement
  - Android Studio
  - Android SDK 30 or later, minSdk = 24, compileSdk = 34
  - gradle 8

## ScreenShot 
<div style="display: flex;">
  <div style="flex-grow: 1; margin-right: 10px;">
    <img src="https://i.postimg.cc/nzGYDrdx/Screenshot-package-code.png" alt="Screenshot-package-code" width="400" />
  </div>
  <div style="flex-grow: 1;">
    <img src="https://i.postimg.cc/4yvyWHDL/Screenshot-news.png" alt="Screenshot-news" width="400" />
  </div>
</div>

