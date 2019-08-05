package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.entity.RankEntity

internal object RankEntityValue {
    const val E = "E"
    const val E_ALT = "-"
    const val E_PLUS = "E+"
    const val D = "D"
    const val D_PLUS = "D+"
    const val C = "C"
    const val C_PLUS = "C+"
    const val B = "B"
    const val B_PLUS = "B+"
    const val A = "A"
    const val A_PLUS = "A+"
    const val S = "S"
    const val S_PLUS = "S+"
}

internal fun String.toRankEntity() = when (this) {
    RankEntityValue.E, RankEntityValue.E_ALT -> RankEntity.E
    RankEntityValue.E_PLUS -> RankEntity.E_PLUS
    RankEntityValue.D -> RankEntity.D
    RankEntityValue.D_PLUS -> RankEntity.D_PLUS
    RankEntityValue.C -> RankEntity.C
    RankEntityValue.C_PLUS -> RankEntity.C_PLUS
    RankEntityValue.B -> RankEntity.B
    RankEntityValue.B_PLUS -> RankEntity.B_PLUS
    RankEntityValue.A -> RankEntity.A
    RankEntityValue.A_PLUS -> RankEntity.A_PLUS
    RankEntityValue.S -> RankEntity.S
    RankEntityValue.S_PLUS -> RankEntity.S_PLUS
    else -> throw IllegalArgumentException("Invalid rank : $this")
}