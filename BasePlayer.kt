package com.example.swaragame

open class Player(val name: String) {
    val cards = mutableListOf<Card>()
    var balance: Int = 10000
    var currentBet: Int = 0

    fun receiveCards(newCards: List<Card>) {
        cards.clear()
        cards.addAll(newCards)
    }

    fun makeBet(amount: Int): Boolean {
        return if (balance >= amount) {
            currentBet += amount
            balance -= amount
            true
        } else {
            false
        }
    }

    fun winPot(potAmount: Int) {
        balance += potAmount
    }

    fun resetBet() {
        currentBet = 0
    }

    fun getCardInfo(): String {
        return cards.joinToString { "${it.rank}${it.suit}" }
    }
}
