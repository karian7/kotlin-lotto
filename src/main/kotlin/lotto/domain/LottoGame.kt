package lotto.domain

import kotlin.math.truncate

class LottoGame(winningNumbers: WinningNumbers, pickLottoNumbers: List<LottoNumbers>) {
    val result: Result =
        Result(pickLottoNumbers.map { Ranking(winningNumbers, it).rank() })

    class Result(private val ranks: List<Ranking.Rank>) : List<Ranking.Rank> by ranks {
        fun entries(): Map<Ranking.Rank, Int> = ranks.groupingBy { it }
            .eachCount()

        fun income(): Long = entries().map { (rank, count) -> rank.prize(count) }.sum()

        fun profit(): Double = (income() / TicketAmount(entries().values.sum()) * 100).truncate

        private operator fun Long.div(ticketAmount: TicketAmount): Double = this / ticketAmount.amount.toDouble()

        private val Double.truncate: Double
            get() = truncate(this) / 100

        private fun List<Money>.sum(): Long = map { it.amount }.sum()
    }
}
