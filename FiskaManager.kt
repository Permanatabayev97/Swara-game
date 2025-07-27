package com.example.swaragame

object FiskaManager {

    val fiskaValues = mapOf(
        "⚪️" to 1,
        "🟤" to 5,
        "🔴" to 10,
        "🟣" to 20,
        "🟢" to 50,
        "🔵" to 100,
        "💸" to -1 // Karz soramak üçin aýratyn bellik
    )

    fun getFiskaValue(symbol: String): Int {
        return fiskaValues[symbol] ?: 0
    }

    fun placeFiskaBet(player: Player, selectedFiskas: List<String>): Int {
        var total = 0
        for (symbol in selectedFiskas) {
            val value = getFiskaValue(symbol)
            if (value > 0 && player.balance >= value) {
                total += value
                player.balance -= value
            } else if (value == -1) {
                println("${player.name} 💸 karz fiskasy arkaly karz sorady!")
                player.balance += 100 // Mysal üçin karz möçberi
            }
        }
        player.currentBet = total
        println("${player.name} fiskalar arkaly $total manat goýdy.")
        return total
    }

    fun showAvailableFiskas() {
        println("Elýeterli fiskalar:")
        for ((symbol, value) in fiskaValues) {
            val label = if (value == -1) "Karz soramak" else "$value manat"
            println("  $symbol — $label")
        }
    }
}
