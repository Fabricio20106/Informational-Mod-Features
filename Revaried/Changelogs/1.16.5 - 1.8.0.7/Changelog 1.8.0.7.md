<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.7 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *09/12/2024*</div>

**1.8.0.7** is the seventh version for [*Revaried 1.8.0*](/Revaried/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on Januay 6, 2025.[^1][^2][^3]

## Additions
### Blocks
- Added crimson wheat, soul carrots, warped potatoes and melting beets.
  - Warped potatoes can drop withered warped potatoes.
  - Soul carrots emit soul particles when they're fully grown.
- Added wild crimson wheat, soul carrots, warped potatoes and melting beets.
  - All of these can be found in specific places in the Nether:
    - Crimson wheat generates in crimson forests;
    - Soul carrots generate in on top of soul sand;
    - Warped potatoes generate in warped forests;
    - Melting beets generate on top of gravel.
  - These can be found in the creative menu, like golden carrots.
  - Added a new model template for these crops: `template_wild_crop`, copied from Back Math.
- Added crimson straw bales.
  - Use the "crimson nylium" map color.
  - Its recipe is shapeless, like in the newer versions, instead of shaped.
- Added Nether coal ore.
  - Can be found anywhere in the Nether, replacing only netherrack.
  - These have a vein size (ore blocks per vein) of 9, and a count (ore veins per chunk) of 8.
  - Works like its Overworld counterpart: can be mined to get coal, is affected by fortune, can be smelted, and drops 0-2 experience.
- Added quartz ladders.
  - Works like the vanilla ladder, but is crafted with quartz instead of sticks.
  - Uses break and place sounds from stone.

### Items
- Added crimson wheat and crimson wheat seeds.
- Added crimson loaves.
  - These loaves act like regular bread, but it also gives you fire resistance for 15 seconds.
  - Any `crimson_bread` from legacy versions are automatically converted to this one.
- Added quartz carrots.
- Added warped potatoes, baked warped potatoes and withered warped potatoes.
  - Withered warped potatoes have a 60% chance to inflict wither for 5 seconds.
- Added melting beets and melting beet seeds.
- Added melting beet soups.
  - Also comes with the data-driven and bucket variants.
- Added debug sticks for all wood types.
  - These can only be obtained through commands, or through the "Operator Items" tab, backported by Melony Lib.

## Changes
### Blocks
- Renamed the word "powered" in pressure plate models to "down".
- Dispensers and droppers are now placed in the correct orientation.
- End stone levers can now crafted using any `#forge:end_stones`.

### Items
- White wool sweaters can now be colored without merging the new color with white.
- Lingering potions no longer have its tooltips duplicated.
- Spectral arrows now show their effect tooltip like tipped arrows.
  - This is hardcoded as the duration of the effect cannot be changed via the item's NBT.
- Updated the effect tooltips in food items.
- The recipe of plasteel shears now uses the item tag `#rimcraft:plasteel_materials`, instead of `#melony:plasteel_materials`.

### Entities
- Boats can now be leashed.
  - This is a feature backport from 1.21.
  - Everything from 1.21 works in my backport, with the exception of leashes not rendering after reloading the world when attached to fences.
  - Other mods' boats should work if they extend the vanilla boat class. Rendering, however, will not work.
- Variants' boats can now show custom names again.

### GUIs
- Separated the Variants config menu into separate categories.
  - Opening it from the mods menu now shows a simple menu with the config categories as separate buttons (currently only "world generation").
    - This menu has a panorama like the main menu.
  - The old config menu has been moved to the "world generation" submenu, which now has a panorama.
    - Removed the "substitute 'The End' with biome" textbox, but it it's set to an invalid biome, is now grays out the "Done" button.
  - The text position on these menus is lower than before, and now shows the tab you're in.
    - If you're inside the world generation tab, the title will show *"[Variants] Settings > World Generation"*.
- Increased the character limit of anvils to 50 characters.
  - This is a retroactive fix for [MC-203757](https://bugs.mojang.com/browse/MC-203757).

### Consume Behaviors
- *Apply effects* behavior can now pull effects from the built-in behavior.
  - These can now only use Variants' effect instances. As a result, effect instances can now define a `chance` float tag for the chance of applying this effect.
- *Damage entity* and *play sound* behaviors now properly null-checks their properties tag.
- *Damage entity* behaviors now only check their tag for damage sources on `loadFromNBT()`.
- *Explode* behavior's `spawn_effect_cloud` tag is now properly saved.
- *Teleport entity* behavior's exact teleport now only runs on the server side.
- *Ignite* behavior now has a tooltip that shows the fire duration.
  - Currently, it only ever shows as 5 seconds when read from NBT.
  - This is shown like an effect would, with the name being "Ablaze" colored **#E1A61E**.
- Consume behaviors are now properly saved in the recipe data generators.

### Translations
- Fish and Variants' boats now have proper translations once again.
- Updated the translations of Variants' config menu.
  - > *"Variants - Configure Settings"* -> *"Variants - Settings"*
  - > *"Saved Settings!"* -> *"Changes Saved!"*
  - > *"Successfully saved settings to 'variants.json'."* -> *"Successfully saved all changes to 'variants.json'."*
- Added Brazilian Portuguese translations for the config screen and options.
- Changed the Brazilian Portuguese translation for `tooltip.variants.tags` from "Tags:" to "Marcações:".

## Technical
### Additions
- Backported the *"equippable"* and *"glider"* item components.
  - > *Documentation: [**Equippables**](/Revaried/Docs/Equippables.md)*
  - This is still in early development, so some features (like "allowed_entities") aren't available yet.
  - This can be *applied* to any item, but it's not guaranteed to *work* on all items.
  - Currently, the fields that exist for "equippable" are these: `slot`, `equip_sound`, `asset_id`, `dispensable`, `swappable`, `damages_on_hurt` and `camera_overlay`.
  - The "glider" tag currently doesn't seem to work.
- Added a `mod_loaded` advancement criteria trigger.
  - Checks if a specific mod id is loaded. I didn't test if this works.
- Added recipe advancements for most blocks in Variants' blocks tab.

### Changes
- Renamed the field `NETHER_WART_PLACEABLE_ON` in *VSBlockTags* to `NETHER_WART_PLANTABLE_ON`.
- Renamed the "killer" field in *"/damage"* to "attacker".
- The fail message of *"/damage"* no longer shows the death message in question.
- Changed the development version to `melony-studios-dev/revaried` ("Revaried" being the mod's updated name, coming sometime).
- Variants' world generation is now controlled by the JSON config instead of the Forge config.
- Bowl types for vanilla wood types now use the `minecraft` namespace.
- Updated the config file version to `1807`.
- Renamed the class *Equippable* to *Swappable*.
- Renamed the class *VSEndBiomeProvider* to *EnderwoodEndBiomeProvider*.
- The eating and drinking sounds of consumables are now pulled from the stack instead of the default sound.
- *Consumable* is now implemented by the vanilla *Item* class. This means **all items are now consumables**. However, some items don't work with this.
- Items can now have their rarity and enchantment glint changed through the tags `rarity` and `enchantment_glint_override`.
- The `old_behavior_names` fix subcommand can now convert the `melonystudios:multi_behavior` to Variants' multi-behavior.

### Removals
- Removed the *"/consumable \<target> open_config_screen"* debug subcommand.
- Removed the files *"intermod_content.txt"* and *"nbt_command_tree.json5"*.
- Removed all world generation configs from the Forge config.

## Tags
### Additions
- Added `#forge:elytra` item tag.
  - Contains elytra.
  - Items in this tag play the elytra equip sound, and are also used by my other mods.

### Changes
- Added Nether coal ore to `#forge:ores/coal` block and item tags.
- Added quartz ladders to `#minecraft:climbable` block tag.
- Added all new debug sticks to `#forge:rods/debug_wooden` item tag.
- Added all new (wild) crops to `#minecraft:crops` item tag.

### References
[^1]: ["1.8.0.7 (Part I): Universal Consumables & Nether Crops"](https://github.com/isabellawoods/Revaried/commit/a2c3eb32f19d5f605663ef7308754ce7cd3437a1) (Commit `a2c3eb3`) – GitHub, November 30, 2024.
[^2]: ["1.8.0.7 (Part II): Crops & Leashable Boats"](https://github.com/isabellawoods/Revaried/commit/a4ea67d4d0144173f84941f4f9455c4087abf336) (Commit `a4ea67d`) – GitHub, December 21, 2024.
[^3]: ["1.8.0.7 (Part III): Recipe Advancements & Plant Generation"](https://github.com/isabellawoods/Revaried/commit/6969e8897f624d77ac5d0fd83a43026dff18c4d7) (Commit `6969e88`) – GitHub, January 6, 2024.