package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CombatArtRequirementAsset

internal object CombatArtRequirementAssetTransformer {

    object UniversalLearn : AbstractAssetTransformer<CombatArtRequirementAsset.UniversalLearn>() {

        override fun getAssetFile() = "combatarts_req_universallearn.tsv"
        override fun getColumnCount() = 3

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.UniversalLearn(
            combatArtId = rawValues[0],
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset()
        )

    }

    object PersonalLearn : AbstractAssetTransformer<CombatArtRequirementAsset.PersonalLearn>() {

        override fun getAssetFile() = "combatarts_req_personallearn.tsv"
        override fun getColumnCount() = 3

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.PersonalLearn(
            combatArtId = rawValues[0],
            skillRequired = rawValues[1].toSkillAsset(),
            rankRequired = rawValues[2].toRankAsset(),
            characterIds = rawValues[3].split()
        )

    }

    object ClassMastered : AbstractAssetTransformer<CombatArtRequirementAsset.ClassMastered>() {

        override fun getAssetFile() = "combatarts_red_classmastered.tsv"
        override fun getColumnCount() = 2

        override fun internalBuildAsset(rawValues: List<String>) = CombatArtRequirementAsset.ClassMastered(
            combatArtId = rawValues[0],
            classId = rawValues[1]
        )

    }

}