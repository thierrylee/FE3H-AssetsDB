# Fire Emblem Three Houses Assets Database

This project is a library to query data programmatically about Fire Emblem Three Houses. 
It gathers data about characters, classes, abilities, combat arts... and more !

For those only interested on data itself, you can find it on [this spreadsheet: HERE](https://docs.google.com/spreadsheets/d/1O_iL8lO8oq3Jo3UeVGI2XlV3QHroVNi0fqZ8M2dY0Mo/edit?usp=sharing) 

# How to use

First, compile this project as a JAR, AAR, or use it directly as a Gradle Module. Then import it in your projet.
To retrieve the whole database, simply call `AssetDatabaseBuilder.buildAssetDatabase()`
Il will return an `AssetDatabase` containing :
- Genders
- Skills (Sword, Lance, Axe, Bow, Brawling,...)
- Ranks (S+, S, A+,...)
- Characters
- Crests
- Classes
- Abilities
- Combat arts
- Magics
- Combat art requirements (can be universal, personal, class related... requirements)
- Ability requirements (can be universal, personal, class related... requirements)
- Magic requirements

You can then call preconfigured queries on the `AssetDatabase` object, i.e. :
- getAbilitiesAndRequirements()
- getCharacterClasses(character)
- getCharacterCombatArts(character)

# Mistakes ?

If you find out mistakes, please let me know: send me a mail or even make a Pull Request !
To do so, edit `*.TSV` in the `resources` directory.

## Data source & Special thanks

Data compiled mainly from [Serenes Forest](http://serenesforest.net) and [Fire Emblem Wikia](http://fireemblem.wikia.com).
Thanks a lot to the [Fire Emblem subreddit](https://www.reddit.com/r/fireemblem/) and the entire Fire Emblem community !