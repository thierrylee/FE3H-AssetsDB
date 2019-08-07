package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.RankAsset

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

fun String.toRankAsset() = when (this) {
    RankEntityValue.E, RankEntityValue.E_ALT -> RankAsset.E
    RankEntityValue.E_PLUS -> RankAsset.E_PLUS
    RankEntityValue.D -> RankAsset.D
    RankEntityValue.D_PLUS -> RankAsset.D_PLUS
    RankEntityValue.C -> RankAsset.C
    RankEntityValue.C_PLUS -> RankAsset.C_PLUS
    RankEntityValue.B -> RankAsset.B
    RankEntityValue.B_PLUS -> RankAsset.B_PLUS
    RankEntityValue.A -> RankAsset.A
    RankEntityValue.A_PLUS -> RankAsset.A_PLUS
    RankEntityValue.S -> RankAsset.S
    RankEntityValue.S_PLUS -> RankAsset.S_PLUS
    else -> throw IllegalArgumentException("Invalid rank : $this")
}