package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.*

data class AssetDatabase(
    val genders: List<GenderAsset> = GenderAsset.values().toList(),
    val skills: List<SkillAsset> = SkillAsset.values().toList(),
    val ranks: List<RankAsset> = RankAsset.values().toList(),
    val characters: List<CharacterAsset>,
    val crests: List<CrestAsset>,
    val classes: List<ClassAsset>,
    val abilities: List<AbilityAsset>,
    val combatArts: List<CombatArtAsset>,
    val magics: List<MagicAsset>,
    val combatArtRequirements: List<CombatArtRequirementAsset>,
    val abilityRequirements: List<AbilityRequirementAsset>,
    val magicRequirements: List<MagicRequirementAsset>
) {

    fun getCombatArtsAndRequirements(): Map<CombatArtAsset, List<CombatArtRequirementAsset>> {
        return combatArts.map { combatArt ->
            combatArt to combatArtRequirements.filter { it.combatArtId == combatArt.id }
        }.toMap()
    }

    fun getAbilitiesAndRequirements(): Map<AbilityAsset, List<AbilityRequirementAsset>> {
        return abilities.map { ability ->
            ability to abilityRequirements.filter { it.abilityId == ability.id }
        }.toMap()
    }

    fun getMagicsAndRequirements(): Map<MagicAsset, List<MagicRequirementAsset>> {
        return magics.map { magicAsset ->
            magicAsset to magicRequirements.filter { it.magicId == magicAsset.id }
        }.toMap()
    }

    fun getCharacterClasses(character: CharacterAsset): List<ClassAsset> {
        return classes.filter { it.isClassAvailable(character) }
    }

    fun getCharacterCombatArts(character: CharacterAsset): Map<CombatArtAsset, List<CombatArtRequirementAsset>> {
        return getCombatArtsAndRequirements().mapValues { (_, requirements) ->
            requirements.filter { requirement ->
                when (requirement) {
                    is CombatArtRequirementAsset.UniversalLearn -> true
                    is CombatArtRequirementAsset.PersonalLearn -> requirement.characterIds.contains(
                        character.id
                    )
                    is CombatArtRequirementAsset.BuddingTalent -> requirement.characterIds.contains(
                        character.id
                    )
                    is CombatArtRequirementAsset.ClassMastered -> getCharacterClasses(character).map { it.id }.contains(
                        requirement.classId
                    )
                }
            }
        }.filterValues { it.isNotEmpty() }
    }

    fun getCharacterAbilities(character: CharacterAsset): Map<AbilityAsset, List<AbilityRequirementAsset>> {
        return getAbilitiesAndRequirements().mapValues { (_, requirements) ->
            requirements.filter { requirement ->
                when (requirement) {
                    is AbilityRequirementAsset.UniversalLearn -> true
                    is AbilityRequirementAsset.Personal -> (requirement.characterId == character.id)
                    is AbilityRequirementAsset.PersonalLearn -> requirement.characterIds.contains(
                        character.id
                    )
                    is AbilityRequirementAsset.BuddingTalent -> requirement.characterIds.contains(
                        character.id
                    )
                    is AbilityRequirementAsset.ClassUse -> getCharacterClasses(character).map { it.id }.intersect(
                        requirement.classIds
                    ).isNotEmpty()
                    is AbilityRequirementAsset.ClassMastered -> getCharacterClasses(character).map { it.id }.contains(
                        requirement.classId
                    )
                }
            }
        }.filterValues { it.isNotEmpty() }
    }

    fun getCharacterMagics(character: CharacterAsset): Map<MagicAsset, List<MagicRequirementAsset>> {
        return getMagicsAndRequirements().mapValues { (_, requirements) ->
            requirements.filter { it.characterIds.contains(character.id) }
        }.filterValues { it.isNotEmpty() }
    }

    private fun ClassAsset.isClassAvailable(character: CharacterAsset): Boolean {
        return availableGenders.contains(character.gender) &&
                (characterExclusive.isEmpty() || characterExclusive.contains(character.id))
    }

}