package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.*

data class AssetDatabase(
    val genderAssets: List<GenderAsset> = GenderAsset.values().toList(),
    val skillAssets: List<SkillAsset> = SkillAsset.values().toList(),
    val rankAssets: List<RankAsset> = RankAsset.values().toList(),
    val characterAssets: List<CharacterAsset>,
    val crestAssets: List<CrestAsset>,
    val classAssets: List<ClassAsset>,
    val abilityAssets: List<AbilityAsset>,
    val combatArtAssets: List<CombatArtAsset>,
    val magicAssets: List<MagicAsset>,
    val combatArtRequirementAssets: List<CombatArtRequirementAsset>,
    val abilityRequirementAssets: List<AbilityRequirementAsset>,
    val magicRequirementAssets: List<MagicRequirementAsset>
) {

    fun getCombatArtsAndRequirements(): Map<CombatArtAsset, List<CombatArtRequirementAsset>> {
        return combatArtAssets.map { combatArt ->
            combatArt to combatArtRequirementAssets.filter { it.combatArtId == combatArt.id }
        }.toMap()
    }

    fun getAbilitiesAndRequirements(): Map<AbilityAsset, List<AbilityRequirementAsset>> {
        return abilityAssets.map { ability ->
            ability to abilityRequirementAssets.filter { it.abilityId == ability.id }
        }.toMap()
    }

    fun getMagicsAndRequirements(): Map<MagicAsset, List<MagicRequirementAsset>> {
        return magicAssets.map { magicAsset ->
            magicAsset to magicRequirementAssets.filter { it.magicId == magicAsset.id }
        }.toMap()
    }

    fun getCharacterClasses(character: CharacterAsset): List<ClassAsset> {
        return classAssets.filter { it.isClassAvailable(character) }
    }

    fun getCharacterCombatArts(character: CharacterAsset): Map<CombatArtAsset, List<CombatArtRequirementAsset>> {
        return getCombatArtsAndRequirements().filter { (_, requirements) ->
            requirements.any { requirement ->
                when (requirement) {
                    is CombatArtRequirementAsset.UniversalLearn -> true
                    is CombatArtRequirementAsset.PersonalLearn -> requirement.characterIds.contains(character.id)
                    is CombatArtRequirementAsset.ClassMastered -> getCharacterClasses(character).map { it.id }.contains(
                        requirement.classId
                    )
                }
            }
        }
    }

    fun getCharacterAbilities(character: CharacterAsset): Map<AbilityAsset, List<AbilityRequirementAsset>> {
        return getAbilitiesAndRequirements().filter { (_, requirements) ->
            requirements.any { requirement ->
                when (requirement) {
                    is AbilityRequirementAsset.UniversalLearn -> true
                    is AbilityRequirementAsset.Personal -> (requirement.characterId == character.id)
                    is AbilityRequirementAsset.PersonalLearn -> requirement.characterIds.contains(character.id)
                    is AbilityRequirementAsset.ClassUse -> getCharacterClasses(character).map { it.id }.intersect(
                        requirement.classIds
                    ).isNotEmpty()
                    is AbilityRequirementAsset.ClassMastered -> getCharacterClasses(character).map { it.id }.contains(
                        requirement.classId
                    )
                }
            }
        }
    }

    fun getCharacterMagics(character: CharacterAsset): Map<MagicAsset, List<MagicRequirementAsset>> {
        return getMagicsAndRequirements().filter { (_, requirements) ->
            requirements.any { it.characterIds.contains(character.id) }
        }
    }

    private fun ClassAsset.isClassAvailable(character: CharacterAsset): Boolean {
        return availableGenders.contains(character.gender) &&
                (characterExclusive.isEmpty() || characterExclusive.contains(character.id))
    }

}