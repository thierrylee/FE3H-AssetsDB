package me.thierrylee.fe3hdb.assets.model

data class ClassAsset(
    val id: String,
    val name: String,
    val requiredLevel: Int,
    val requiredSkillRanks: List<Pair<SkillAsset, RankAsset>>,
    val isOneRequirementOnly: Boolean,
    val availableGenders: List<GenderAsset>,
    val characterExclusive: List<String>,
    val unitTypes: List<UnitTypeAsset>,
    val swordProficiency: Int,
    val lanceProficiency: Int,
    val axeProficiency: Int,
    val bowProficiency: Int,
    val brawlingProficiency: Int,
    val reasonProficiency: Int,
    val faithProficiency: Int,
    val authorityProficiency: Int,
    val armorProficiency: Int,
    val ridingProficiency: Int,
    val flyingProficiency: Int,
    val growthHp: Int,
    val growthStr: Int,
    val growthMag: Int,
    val growthDex: Int,
    val growthSpd: Int,
    val growthLck: Int,
    val growthDef: Int,
    val growthRes: Int,
    val growthCha: Int,
    val movement: Int,
    val isDlc: Boolean
)