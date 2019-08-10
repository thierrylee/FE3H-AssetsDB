package me.thierrylee.fe3hdb.assets.model

data class MagicRequirementAsset(
    val magicId: String,
    val requiredSkill: SkillAsset,
    val requiredRank: RankAsset,
    val characterIds: List<String>
)