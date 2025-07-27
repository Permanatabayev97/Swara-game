package com.example.swaragame

class Admin(
    var minBet: Int = 100,
    var maxBet: Int = 500,
    var stepBet: Int = 5,
    var initialBalance: Int = 10000
) {
    fun updateRules(min: Int, max: Int, step: Int) {
        minBet = min
        maxBet = max
        stepBet = step
    }

    fun resetPlayerBalances(players: List<Player>) {
        for (player in players) {
            player.balance = initialBalance
        }
    }

    fun forceRestart(players: List<Player>, deck: Deck) {
        for (player in players) {
            player.resetForNewRound()
        }
        deck.shuffle()
    }

    override fun toString(): String {
        return "Admin (MinBet: $minBet, MaxBet: $maxBet, Step: $stepBet, StartBalance: $initialBalance)"
    }
}
