package com.example.swaragame

object BettingManager {
    fun canPlaceBet(player: Player, amount: Int): Boolean {
        return amount in GameConfig.MIN_RAISE..GameConfig.MAX_RAISE && player.balance >= amount
    }

    fun placeBet(player: Player, amount: Int): Boolean {
        if (canPlaceBet(player, amount)) {
            player.balance -= amount
            player.currentBet = amount
            println("${player.name} $amount manat goýdy.")
            return true
        }
        println("${player.name} goýup bilmedi (balans ýa düzgün meselesi).")
        return false
    }

    fun pass(player: Player) {
        player.passed = true
        println("${player.name} geçdi.")
    }

    fun requestLoan(player: Player): Boolean {
        if (player.balance == 0) {
            println("${player.name} karz isledi 💸")
            // Karz logikasy soň goşular
            return true
        }
        return false
    }
}
