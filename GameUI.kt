package com.example.swaragame

object GameUI {
    fun showPlayerHand(player: Player) {
        println("${player.name} kartlary: ${player.hand.joinToString(", ")}")
    }

    fun showBalance(player: Player) {
        println("${player.name} balansy: ${player.balance} manat")
    }

    fun askToRaise(): Int {
        println("Goýmak isleýän puluňyzy giriziň (0 - geçmek): ")
        return readln().toIntOrNull() ?: 0
    }

    fun showSwaraQuestion(question: String): Boolean {
        println("Sorag: $question (Howa / Ýok)")
        val answer = readln().trim().lowercase()
        return answer == "howa"
    }

    fun showWinner(winner: Player) {
        println("Ýeňiji: ${winner.name} 🎉")
    }
}
