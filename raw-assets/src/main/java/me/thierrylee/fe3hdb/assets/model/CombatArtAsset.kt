package me.thierrylee.fe3hdb.assets.model

data class CombatArtAsset(
    val id: String,
    val name: String,
    val useSkill: SkillAsset,
    val might: Int,
    val hit: Int,
    val crit: Int,
    val range: String,
    val cost: Int,
    val description: String
)