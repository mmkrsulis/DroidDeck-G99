package com.droiddeck.launcher.session

object ProgramLaunch {
    enum class Route { START, RESUME, SWITCH, BUSY }

    fun route(running: Boolean, stopRequested: Boolean, mode: String, program: String?, requestedProgram: String): Route = when {
        !running -> Route.START
        stopRequested -> Route.BUSY
        mode == SessionService.MODE_RUN && program == requestedProgram -> Route.RESUME
        else -> Route.SWITCH
    }
}
