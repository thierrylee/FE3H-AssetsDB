package me.thierrylee.fe3hdb.assets.model

sealed class AbilityRequirementAsset(open val abilityId: String) {

    data class UniversalLearn(
        override val abilityId: String,
        val skillRequired: SkillAsset,
        val rankRequired: RankAsset
    ) : AbilityRequirementAsset(abilityId)

    data class Personal(
        override val abilityId: String,
        val characterId: String
    ) : AbilityRequirementAsset(abilityId)

    data class PersonalLearn(
        override val abilityId: String,
        val skillRequired: SkillAsset,
        val rankRequired: RankAsset,
        val characterIds: List<String>
    ) : AbilityRequirementAsset(abilityId)

    data class BuddingTalent(
        override val abilityId: String,
        val skillRequired: SkillAsset,
        val characterIds: List<String>
    ) : AbilityRequirementAsset(abilityId)

    data class ClassUse(
        override val abilityId: String,
        val classIds: List<String>
    ) : AbilityRequirementAsset(abilityId)

    data class ClassMastered(
        override val abilityId: String,
        val classIds: List<String>
    ) : AbilityRequirementAsset(abilityId)

}