package com.example.swaragame

class Player(
    val name: String,
    var balance: Int = 10000,
    var isBot: Boolean = false
) {
    val hand: MutableList<Card> = mutableListOf()
    var passed = false
    var currentBet = 0

    fun receiveCard(card: Card) {
        hand.add(card)
    }

    fun resetForNewRound() {
        hand.clear()
        passed = false
        currentBet = 0
    }

    fun placeBet(amount: Int): Boolean {
        return if (amount <= balance) {
            balance -= amount
            currentBet = amount
            true
        } else {
            false
        }
    }

    fun win(amount: Int) {
        balance += amount
    }

    override fun toString(): String {
        return "$name (Balance: $balance) | Cards: $hand"
    }
}
