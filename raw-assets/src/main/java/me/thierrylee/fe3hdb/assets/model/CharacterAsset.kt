package me.thierrylee.fe3hdb.assets.model

data class CharacterAsset(
    val id: String,
    val name: String,
    val faction: FactionAsset,
    val gender: GenderAsset,
    val recruitmentRequirements: String,
    val growthHp: Int,
    val growthStr: Int,
    val growthMag: Int,
    val growthDex: Int,
    val growthSpd: Int,
    val growthLck: Int,
    val growthDef: Int,
    val growthRes: Int,
    val growthCha: Int,
    val maxHp: Int,
    val maxStr: Int,
    val maxMag: Int,
    val maxDex: Int,
    val maxSpd: Int,
    val maxLck: Int,
    val maxDef: Int,
    val maxRes: Int,
    val maxCha: Int,
    val swordProficiency: ProficiencyAsset,
    val lanceProficiency: ProficiencyAsset,
    val axeProficiency: ProficiencyAsset,
    val bowProficiency: ProficiencyAsset,
    val brawlingProficiency: ProficiencyAsset,
    val reasonProficiency: ProficiencyAsset,
    val faithProficiency: ProficiencyAsset,
    val authorityProficiency: ProficiencyAsset,
    val armorProficiency: ProficiencyAsset,
    val ridingProficiency: ProficiencyAsset,
    val flyingProficiency: ProficiencyAsset,
    val baseSwordSkill: RankAsset,
    val baseLanceSkill: RankAsset,
    val baseAxeSkill: RankAsset,
    val baseBowSkill: RankAsset,
    val baseBrawlingSkill: RankAsset,
    val baseReasonSkill: RankAsset,
    val baseFaithSkill: RankAsset,
    val baseAuthoritySkill: RankAsset,
    val baseArmorSkill: RankAsset,
    val baseRidingSkill: RankAsset,
    val baseFlyingSkill: RankAsset,
    val majorCrest: String,
    val minorCrest: String
)