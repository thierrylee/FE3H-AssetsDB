package me.thierrylee.fe3hdb.assets.model

data class AbilityAsset(
    val id: String,
    val name: String,
    val description: String,
    val skill: SkillAsset,
    val hiddenAbilities: List<String>
)