package com.droiddeck.launcher.gpu

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GamescopeBackendTest {
    @Test fun importedPanvkUsesSdlOnMali() {
        assertEquals("sdl", GamescopeBackend.forImportedDriver(false, "PanVK-Mali-JM (Linux, glibc)"))
        assertEquals("sdl", GamescopeBackend.forImportedDriver(false, "PanVK Kbase G57 MC2"))
    }

    @Test fun adrenoAndOtherImportedDriversKeepTheirBackend() {
        assertNull(GamescopeBackend.forImportedDriver(true, "PanVK test"))
        assertNull(GamescopeBackend.forImportedDriver(false, "RADV Xclipse"))
        assertNull(GamescopeBackend.forImportedDriver(false, "Runtime default"))
    }
}
