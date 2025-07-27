package com.example.swaragame

object GameConfig {
    const val STARTING_BALANCE = 10000
    const val DEFAULT_BET = 200
    const val MIN_RAISE = 5
    const val MAX_RAISE = 50
    const val PASS_AMOUNT = 100
    const val MAX_PLAYERS = 6
    const val ROUND_TIME_LIMIT = 60 // sekunt bilen, eger wagt çägi bar bolsa

    const val ADMIN_USERNAME = "admin"
    const val ADMIN_PASSWORD = "admin123" // Islenilse, has ygtybarly usul bilen saklansa bolýar

    fun isAdmin(username: String, password: String): Boolean {
        return username == ADMIN_USERNAME && password == ADMIN_PASSWORD
    }
}
