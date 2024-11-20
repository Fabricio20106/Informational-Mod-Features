<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.16 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *13/12/2023*</div>

## Additions
- Added Stew/Soup Buckets.
- Added Iron/Powered/Corner Iron Ties, Wooden/Powered Railbeds and Detector Plates.
    - Can be used to make all rail types (vanilla rails, that is).
- Added a new **Infinity Sweaters** item tab.
    - Can be enabled through configs.
    - The quantity of sweaters and the spacing can also be configured.
    - Comes with a new item for the tab icon.
- Added Exponential Mushroom Stew (hidden from inventory).
    - "Exponential" stews are stews that have their bowl defined through NBT data. Although this functionality won't be added until 1.6.20.
- Most Stained Glass (and Quartz Glass) now show their beacom beam color on the tooltip.
- Variants' bookshelves now show their enchanting power on the tooltip.
    - My other mods' bookshelves will slowly have their descriptions added.
- Variants' ores now show how much experience they drop on the tooltip.
    - My other mods' bookshelves will slowly have their descriptions added.
- Added a recipe for Variated Instructions book. <sup>*[renamed to "Varied Instructions on 1.6.20.2"]*</sup>

## Changes
- Various models have been moved to data generation.
- Updated the descriptions of enchantments (can be disabled through configs).
    - Enchantments now display the category that this enchantment can be applied to.
- Nether Wart can now be planted on any block tagged as `#variants:nether_wart_plantable_on`.
- Variants' weapons tab icon is now a random color Wool Sweater (picked randomly every world load).
- Wither Skeletons' bone drop has been replaced by Wither Bones.
- Nether Wart can now be pollinated by Bees.

## Tags
- Renamed block tag `#variants:warped_wart_plantable_on` to `#variants:nether_wart_plantable_on`.
- Added `#forge:crops` item tag.
    - Contains `#forge:crops/golden_carrot`, `#forge:crops/warped_wart` and `#forge:crops/ender_wart`. (contents are self-explanatory)
- Added `#variants:bowl_foods` item tag.
    - Contains `#variants:bowl_foods/mushroom`, `#variants:bowl_foods/beetroot`, `#variants:bowl_foods/rabbit`, `#variants:bowl_foods/fungi`, `#variants:bowl_foods/end_fungi` and  `#variants:bowl_foods/aljan_fungi` item tags.
- Added Deepslate from Vanilla, Caves & Cliffs: Backport and Quark to `#forge:deepslate_replaceables` block tag.
- Added Nether and Ender Wart to `#minecraft:crops` block tag.
- Added Aljamic Farmland (Back Math) to `#variants:farmland` block tag.
- Added Book of Regular/Advanced Molds (Back Math), Guide Book (Patchouli) and Quest Book (FTB Quests) to `#variants:books` item tag.
- Added Devil, Angelic, Mid-Term, Aljameed and Moonering Shields (Back Math) to `#variants:shields` item tag.