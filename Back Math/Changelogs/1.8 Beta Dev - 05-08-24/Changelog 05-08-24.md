<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - August 5th Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *17/08/2024*</div>

The **August 5th** update is a version for *Back Math* 1.8.0, released on August 5, 2024.[^1]

## Additions
- Added the MCC cape as a cape for Back Math's mobs.
- Added `went_americanas` and `went_food_and_drinks` damage sources.
- Added 2 new paintings: **EEF**, and **All Powerful Fabricio**, both made by Sophie.
- Wild Update and Trails & Tales music now plays in Back Math's biomes when The Mato's music pack is enabled.

### Technical Additions
- Data generated blocks can now use a *block family provider* to generate their models.
  - This works by providing a block and some textures, adding these blocks to a map, and later builds all the models into their JSON files.

## Changes
- Queen Lucy's Summoner Staff now has a 3D model when held.
  - They still maintain A 2D model when in an item frame or in the inventory.
- QLSS smash particles are now slightly more accurate to the Mace particles.
- Mid-Term Ores now drop 7-13 experience.
- The Mood effects no longer keeps the effects' attributes when removing the effects.
  - The "bug" tooltip on Mood Tea has been removed.
- Queen Lucy can now have beneficial effects.
- Queen Lucy's equip and heal spell now draws the diamond chestplate from a loot table.
- Mid-Term armor now explodes before the item stack has been deleted.
- Most items that set mobs on fire now check if the entity is immune beforehand.
- Queen Lucy Head items now have their texture.
- Moved all music files to a singular *"music_disc"* folder.
- Moved all music files to a separate resource pack.
  - This is because music files are too big, and I decided it would be better to separate them.
- Updated the textures for the stew pots to match Variants.
- Almost all block models are now data generated.
  - This means many model templates were added, renamed, or changed in some way.
    - Grape vine posts now use the `template_grape_vine_post_v2` template.
    - Added `template_ladder` for ladders.
    - Added `template_grass_block` for aljamic grass blocks and avondalic nylium.
    - Added `template_pixel_short_block` for aljamic farmland and dirt paths.
    - Renamed `template_mid_term_hanging_lantern` to `template_hanging_mid_term_lantern`.
  - This is some of the more notable changes due to this:
    - Aljamic Grass Blocks and Avondalic Nylium, now have rotated models when snowy.
    - Smooth Aljanstone Slab's double slab model now uses the correct side texture.
    - Aljamic Farmland now have dedicated side textures.
    - Potted Insomnian Tulips are no longer missing their head. This also applies to the item model.
- Bows, Crossbows and Shields are now data-generated.
  - Added `template_shield`, `template_shield_blocking`, `template_bow` and `template_crossbow` model templates for this.

### Technical Changes
- Renamed the `hotAndColdMeal` damage source to `temperature_meal`.
- Renamed the `queen_lucy_summoner_staff_3d` model to `queen_sophie_summoner_staff_in_hand`.
- The `entity.sophie.celebrate` and `entity.lucia.celebrate` sounds are now properly defined.

## Removals
- Removed all block states and models for Abrobra Rainbow Braba, Abobra Braba Oi and Oi Trapdoors, Aljan Portals, Aljan Portal Frames, Aljanwood Barrels, flowing liquids and Grape Vines.

## Technical Changes
- Renamed all damage sources to snakecase (lowercase, using underscores as spaces).
  - The JSON files for these damage sources have also been added for Variants.

## References
[^1]: ["Reoganized BMBlockStateModels"](https://github.com/isabellawoods/Back-Math/commit/b8abdd5487325a43c7dea1ddc564f128ea42a814) (Commit `b8abdd5`) – GitHub, August 5, 2024.