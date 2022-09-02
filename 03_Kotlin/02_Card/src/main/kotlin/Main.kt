import ru.tensor.course.*

fun main(args: Array<String>) {

    val card = Card(Rank.JACK, Suit.CLUBS)
    val card2 = Card(Rank.QUEEN, Suit.CLUBS)
    println(card.rank.value)
    println(card.toString())
    println(card < card2)
    println(card2.isStronger(card))
    println(card.hashCode())
    var list = listOf(Card(Rank.THREE, Suit.HEARTS), card2, card)
    println(list)
    println(list.toSortedSet())
}