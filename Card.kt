package com.example.swaragame

enum class Suit {
    CLUBS, HEARTS, SPADES, DIAMONDS
}

enum class Rank(val value: Int) {
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11),
    JOKER(11)  // Joker aýratyn bal bilen işlenýär
}

data class Card(
    val suit: Suit?,
    val rank: Rank
) {
    override fun toString(): String {
        return if (rank == Rank.JOKER) "🃏" else "${rank.name} of ${suit?.name}"
    }
}
