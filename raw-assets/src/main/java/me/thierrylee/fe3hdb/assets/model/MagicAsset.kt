package me.thierrylee.fe3hdb.assets.model

data class MagicAsset(
    val id: String,
    val name: String,
    val useSkill: SkillAsset,
    val type: String,
    val might: Int,
    val hit: Int,
    val crit: Int,
    val range: String,
    val weight: Int,
    val level: RankAsset,
    val use: Int,
    val description: String
)