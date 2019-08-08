package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.*

data class AssetDatabase(
    val genderAssets: List<GenderAsset> = GenderAsset.values().toList(),
    val skillAssets: List<SkillAsset> = SkillAsset.values().toList(),
    val rankAssets: List<RankAsset> = RankAsset.values().toList(),
    val characterAssets: List<CharacterAsset>,
    val crestAssets: List<CrestAsset>,
    val classAssets: List<ClassAsset>,
    val abilityAssets: List<AbilityAsset>
)