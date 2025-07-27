package com.example.swaragame

object SwaraLogic {

    fun canRevealCard(answer: String): Boolean {
        return answer.lowercase() == "howa"
    }

    fun canWithdrawPassedBet(answer: String): Boolean {
        return answer.lowercase() == "howa"
    }

    fun isJoker(card: Card, openedCard: Card?): Boolean {
        return when {
            card.rank == "6" && card.suit == openedCard?.suit -> true
            card.rank == "7" && openedCard?.rank == "6" && card.suit == openedCard.suit -> true
            else -> false
        }
    }

    fun calculateScore(hand: List<Card>): Int {
        val groupedBySuit = hand.groupBy { it.suit }
        val sameSuit = groupedBySuit.values.maxByOrNull { it.size } ?: emptyList()

        val topCards = when (sameSuit.size) {
            3 -> sameSuit
            2 -> sameSuit
            else -> hand.sortedByDescending { cardValue(cardRank = it.rank) }.take(2)
        }

        return topCards.sumOf { cardValue(it.rank) }
    }

    private fun cardValue(cardRank: String): Int {
        return when (cardRank) {
            "A" -> 11
            "K", "Q", "J" -> 10
            "10", "9", "8", "7", "6" -> cardRank.toInt()
            else -> 0
        }
    }
}
