package com.droiddeck.launcher.gpu

object GamescopeBackend {
    fun forImportedDriver(adreno: Boolean, driverName: String): String? =
        "sdl".takeIf { !adreno && driverName.contains("panvk", ignoreCase = true) }
}
