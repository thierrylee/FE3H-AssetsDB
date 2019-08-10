package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.AbilityRequirementAsset

internal object AbilityRequirementAssetTransformer {

    object UniversalLearn : AbstractAssetTransformer<AbilityRequirementAsset.UniversalLearn>() {

        override fun getAssetFile() = "abilities_req_universallearn"
        override fun getColumnCount() = 3

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.UniversalLearn(
            abilityId = rawValues[0].toId(),
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset()
        )

    }

    object Personal : AbstractAssetTransformer<AbilityRequirementAsset.Personal>() {

        override fun getAssetFile() = "abilities_req_personal"
        override fun getColumnCount() = 2

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.Personal(
            abilityId = rawValues[0].toId(),
            characterId = rawValues[1].toId()
        )

    }

    object BuddingTalent : AbstractAssetTransformer<AbilityRequirementAsset.BuddingTalent>() {

        override fun getAssetFile() = "abilities_req_buddingtalents"
        override fun getColumnCount() = 3

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.BuddingTalent(
            abilityId = rawValues[0].toId(),
            skillRequired = rawValues[1].toSkillAsset(),
            characterIds = rawValues[2].split().map { it.toId() }
        )

    }

    object PersonalLearn : AbstractAssetTransformer<AbilityRequirementAsset.PersonalLearn>() {

        override fun getAssetFile() = "abilities_req_personallearn"
        override fun getColumnCount() = 4

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.PersonalLearn(
            abilityId = rawValues[0].toId(),
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset(),
            characterIds = rawValues[3].split().map { it.toId() }
        )

    }

    object ClassUse : AbstractAssetTransformer<AbilityRequirementAsset.ClassUse>() {

        override fun getAssetFile() = "abilities_req_classuse"
        override fun getColumnCount() = 2

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.ClassUse(
            abilityId = rawValues[0].toId(),
            classIds = rawValues[1].split().map { it.toId() }
        )

    }

    object ClassMastered : AbstractAssetTransformer<AbilityRequirementAsset.ClassMastered>() {

        override fun getAssetFile() = "abilities_req_classmastered"
        override fun getColumnCount() = 2

        override fun internalBuildAsset(rawValues: List<String>) = AbilityRequirementAsset.ClassMastered(
            abilityId = rawValues[0].toId(),
            classId = rawValues[1].toId()
        )

    }

}