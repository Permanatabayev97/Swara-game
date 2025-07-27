package com.example.swaragame

enum class Suit { CLUBS, HEARTS, SPADES, DIAMONDS }

data class Card(val value: String, val suit: Suit) {
    fun getPoints(): Int {
        return when (value) {
            "A" -> 11
            "K", "Q", "J" -> 10
            "10", "9", "8", "7", "6" -> value.toInt()
            "🃏" -> 11 // Joker
            else -> 0
        }
    }
}

class GameEngine {

    fun calculatePoints(cards: List<Card>): Int {
        val suitsGrouped = cards.groupBy { it.suit }

        return when {
            suitsGrouped.size == 1 -> cards.sumOf { it.getPoints() } // 3 birmeňzeş gül
            suitsGrouped.size == 2 -> {
                // 2 gül birmeňzeş bolsa, şol ikisiniň balyny al
                val mostCommonSuit = suitsGrouped.maxByOrNull { it.value.size }?.value ?: emptyList()
                mostCommonSuit.sumOf { it.getPoints() }
            }
            else -> {
                // 3 dürli gül: iň ýokary 2 kartoçkanyň balyny jemle
                cards.sortedByDescending { it.getPoints() }
                    .take(2)
                    .sumOf { it.getPoints() }
            }
        }
    }

    fun determineWinner(playersCards: Map<String, List<Card>>): String {
        val scores = playersCards.mapValues { calculatePoints(it.value) }
        val winner = scores.maxByOrNull { it.value }
        return winner?.key ?: "No winner"
    }
}
