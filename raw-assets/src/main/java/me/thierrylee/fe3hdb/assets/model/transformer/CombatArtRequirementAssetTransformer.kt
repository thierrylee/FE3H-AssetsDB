package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CombatArtRequirementAsset

internal object CombatArtRequirementAssetTransformer {

    object UniversalLearn : AbstractAssetTransformer<CombatArtRequirementAsset.UniversalLearn>() {

        override fun getAssetFile() = "combatarts_req_universallearn"
        override fun getColumnCount() = 3

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.UniversalLearn(
            combatArtId = rawValues[0].toId(),
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset()
        )

    }

    object PersonalLearn : AbstractAssetTransformer<CombatArtRequirementAsset.PersonalLearn>() {

        override fun getAssetFile() = "combatarts_req_personallearn"
        override fun getColumnCount() = 4

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.PersonalLearn(
            combatArtId = rawValues[0].toId(),
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset(),
            characterIds = rawValues[3].split().map { it.toId() }
        )

    }

    object ClassMastered : AbstractAssetTransformer<CombatArtRequirementAsset.ClassMastered>() {

        override fun getAssetFile() = "combatarts_req_classmastered"
        override fun getColumnCount() = 2

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.ClassMastered(
            combatArtId = rawValues[0].toId(),
            classId = rawValues[1].toId()
        )

    }

}