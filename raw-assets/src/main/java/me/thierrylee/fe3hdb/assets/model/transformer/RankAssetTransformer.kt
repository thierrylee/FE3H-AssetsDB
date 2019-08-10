package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.RankAsset

internal object RankValue {
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

internal fun String.toRankAsset() = when (this.toUpperCase().trim()) {
    RankValue.E, RankValue.E_ALT -> RankAsset.E
    RankValue.E_PLUS -> RankAsset.E_PLUS
    RankValue.D -> RankAsset.D
    RankValue.D_PLUS -> RankAsset.D_PLUS
    RankValue.C -> RankAsset.C
    RankValue.C_PLUS -> RankAsset.C_PLUS
    RankValue.B -> RankAsset.B
    RankValue.B_PLUS -> RankAsset.B_PLUS
    RankValue.A -> RankAsset.A
    RankValue.A_PLUS -> RankAsset.A_PLUS
    RankValue.S -> RankAsset.S
    RankValue.S_PLUS -> RankAsset.S_PLUS
    else -> throw IllegalArgumentException("Invalid rank : $this")
}