package com.example.swaragame

object GameResult {

    fun determineWinner(players: List<Player>): Player {
        var bestPlayer: Player = players.first()
        var bestScore = SwaraLogic.calculateScore(bestPlayer.hand)

        for (player in players.drop(1)) {
            val score = SwaraLogic.calculateScore(player.hand)
            if (score > bestScore) {
                bestScore = score
                bestPlayer = player
            } else if (score == bestScore) {
                bestPlayer = compareBySuit(bestPlayer, player)
            }
        }

        println("Ýeňiji: ${bestPlayer.name} bilen $bestScore bal!")
        return bestPlayer
    }

    private fun compareBySuit(p1: Player, p2: Player): Player {
        val p1Max = p1.hand.maxByOrNull { cardPower(it) } ?: p1.hand.first()
        val p2Max = p2.hand.maxByOrNull { cardPower(it) } ?: p2.hand.first()

        return if (cardPower(p1Max) >= cardPower(p2Max)) p1 else p2
    }

    private fun cardPower(card: Card): Int {
        val rankValue = when (card.rank) {
            "A" -> 110
            "K" -> 100
            "Q" -> 90
            "J" -> 80
            "10" -> 70
            "9" -> 60
            "8" -> 50
            "7" -> 40
            "6" -> 30
            else -> 0
        }
        val suitValue = when (card.suit) {
            "♣" -> 4
            "♥" -> 3
            "♠" -> 2
            "♦" -> 1
            else -> 0
        }
        return rankValue * 10 + suitValue
    }
}
