package com.example.swaragame

object GameRules {

    fun calculateScore(hand: List<Card>): Int {
        if (hand.isEmpty()) return 0

        val jokers = hand.filter { it.rank == "🃏" }
        val nonJokers = hand.filter { it.rank != "🃏" }

        val groupedBySuit = nonJokers.groupBy { it.suit }
        val bestSuitGroup = groupedBySuit.maxByOrNull { it.value.size }

        val cardsToScore = bestSuitGroup?.value ?: nonJokers

        val baseScore = cardsToScore.sumOf {
            when (it.rank) {
                "A" -> 11
                "K", "Q", "J" -> 10
                else -> it.rank.toIntOrNull() ?: 0
            }
        }

        return baseScore + (jokers.size * 11)
    }

    fun compareHands(p1: Player, p2: Player): Player {
        val score1 = calculateScore(p1.hand)
        val score2 = calculateScore(p2.hand)

        return when {
            score1 > score2 -> p1
            score2 > score1 -> p2
            else -> {
                // Deňlik ýagdaýynda iň güýçli kartlaryň güli bilen deňeşdirilýär
                val highest1 = getHighestCard(p1.hand)
                val highest2 = getHighestCard(p2.hand)
                if (compareSuits(highest1.suit, highest2.suit) > 0) p1 else p2
            }
        }
    }

    private fun getHighestCard(hand: List<Card>): Card {
        return hand.maxByOrNull {
            when (it.rank) {
                "A" -> 14
                "K" -> 13
                "Q" -> 12
                "J" -> 11
                else -> it.rank.toIntOrNull() ?: 0
            }
        } ?: hand.first()
    }

    private fun compareSuits(s1: String, s2: String): Int {
        val suitPower = mapOf("♣️" to 4, "♥️" to 3, "♠️" to 2, "♦️" to 1)
        return (suitPower[s1] ?: 0) - (suitPower[s2] ?: 0)
    }
}
