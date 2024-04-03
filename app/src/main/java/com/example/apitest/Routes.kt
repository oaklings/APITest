package com.example.apitest

sealed class Routes (val route: String){
    object ListScreen : Routes ("ListScreen")
    object DetailScreen : Routes ("DetailScreen/{mount.name}") {
        fun createRoute(mount: String) = "DetailScreen/$mount.name" //no se com passar el mount.name be haha sorry
    }
}