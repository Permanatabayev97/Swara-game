package com.example.swaragame

class Deck {

    private val cards: MutableList<Card> = mutableListOf()

    init {
        generateDeck()
        shuffle()
    }

    private fun generateDeck() {
        val suits = Suit.values()
        val ranks = listOf(
            Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN,
            Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE
        )

        for (suit in suits) {
            for (rank in ranks) {
                cards.add(Card(suit, rank))
            }
        }

        // 1 sany Joker goşulýar
        cards.add(Card(null, Rank.JOKER))
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun drawCard(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(0) else null
    }

    fun remainingCards(): Int = cards.size
}
