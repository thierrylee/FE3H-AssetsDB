package me.thierrylee.fe3hdb.assets.model

sealed class CombatArtRequirementAsset(open val combatArtId: String) {

    data class UniversalLearn(
        override val combatArtId: String,
        val skillRequired: SkillAsset,
        val rankRequired: RankAsset
    ) : CombatArtRequirementAsset(combatArtId)

    data class PersonalLearn(
        override val combatArtId: String,
        val skillRequired: SkillAsset,
        val rankRequired: RankAsset,
        val characterIds: List<String>
    ) : CombatArtRequirementAsset(combatArtId)

    data class BuddingTalent(
        override val combatArtId: String,
        val skillRequired: SkillAsset,
        val characterIds: List<String>
    ) : CombatArtRequirementAsset(combatArtId)

    data class ClassMastered(
        override val combatArtId: String,
        val classId: String
    ) : CombatArtRequirementAsset(combatArtId)

}