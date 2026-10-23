package com.droiddeck.launcher.session

import org.junit.Assert.assertEquals
import org.junit.Test

class ProgramLaunchTest {
    private val armsx2 = "/opt/appimages/armsx2.AppImage"

    @Test fun startsRunProgramWhenNoSessionExists() {
        assertEquals(ProgramLaunch.Route.START,
            ProgramLaunch.route(false, false, SessionService.MODE_STEAM, null, armsx2))
    }

    @Test fun switchesAwayFromActiveSteamSession() {
        assertEquals(ProgramLaunch.Route.SWITCH,
            ProgramLaunch.route(true, false, SessionService.MODE_STEAM, null, armsx2))
    }

    @Test fun resumesOnlyTheSameRunProgram() {
        assertEquals(ProgramLaunch.Route.RESUME,
            ProgramLaunch.route(true, false, SessionService.MODE_RUN, armsx2, armsx2))
        assertEquals(ProgramLaunch.Route.SWITCH,
            ProgramLaunch.route(true, false, SessionService.MODE_RUN, "/usr/bin/rpcs3", armsx2))
    }

    @Test fun refusesLaunchWhileSessionIsStopping() {
        assertEquals(ProgramLaunch.Route.BUSY,
            ProgramLaunch.route(true, true, SessionService.MODE_STEAM, null, armsx2))
    }
}
