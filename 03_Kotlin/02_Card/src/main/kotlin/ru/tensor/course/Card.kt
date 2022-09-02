package ru.tensor.course

data class Card(val rank: Rank, val suit: Suit): Comparable<Card> {

    fun isStronger(card: Card): Boolean{
        if(suit == card.suit && rank > card.rank) return true
        return false
    }

    override operator fun compareTo(card: Card): Int {
        if(this == card) return 0
        val power: (Card)->Int = { card: Card ->  card.rank.value + card.suit.ordinal * Suit.values().size }
        return power(this).compareTo(power(card))
    }
}