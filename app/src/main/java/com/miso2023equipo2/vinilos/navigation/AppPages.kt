package com.miso2023equipo2.vinilos.navigation

sealed class AppPages(val route: String) {
    object HomePage: AppPages(route = "home")
    object AlbumCataloguePage: AppPages(route = "albumCatalogue")
    object AlbumDetailPage: AppPages(route = "albumDetail")
}