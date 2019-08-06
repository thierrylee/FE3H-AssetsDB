package me.thierrylee.fe3hdb.core.entity

internal data class CharacterEntity(
    val id: String,
    val name: String,
    val faction: String,
    val gender: GenderEntity,
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
    val swordProficiency: ProficiencyEntity,
    val lanceProficiency: ProficiencyEntity,
    val axeProficiency: ProficiencyEntity,
    val bowProficiency: ProficiencyEntity,
    val brawlingProficiency: ProficiencyEntity,
    val reasonProficiency: ProficiencyEntity,
    val faithProficiency: ProficiencyEntity,
    val authorityProficiency: ProficiencyEntity,
    val armorProficiency: ProficiencyEntity,
    val ridingProficiency: ProficiencyEntity,
    val flyingProficiency: ProficiencyEntity,
    val baseSwordSkill: RankEntity,
    val baseLanceSkill: RankEntity,
    val baseAxeSkill: RankEntity,
    val baseBowSkill: RankEntity,
    val baseBrawlingSkill: RankEntity,
    val baseReasonSkill: RankEntity,
    val baseFaithSkill: RankEntity,
    val baseAuthoritySkill: RankEntity,
    val baseArmorSkill: RankEntity,
    val baseRidingSkill: RankEntity,
    val baseFlyingSkill: RankEntity,
    val majorCrest: String,
    val minorCrest: String
)