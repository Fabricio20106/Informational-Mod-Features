<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.7 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *09/12/2024*</div>

## Additions
### Blocks
- Added crimson wheat, soul carrots, warped potatoes and melting beets.
  - All of these can be found throughout the Nether, either in chests or planted.
  - Warped potatoes drop withered warped potatoes.
  - Soul carrots emit soul particles when they're fully grown.
- Added wild crimson wheat, soul carrots, warped potatoes and melting beets.
  - These wild crops can be found around the Nether: crimson wheat in crimson forests, soul carrots in soul sand valleys, warped potatoes in warped forests, and melting beets around lava.
  - These can be found in the creative menu, like golden carrots.
  - Added a model template for these crops: `template_wild_crop`, copied from Back Math.
- Added crimson straw bales.
  - Use the "crimson nylium" map color.
  - Its recipe is shapeless, like in the newer versions, instead of shaped.

### Items
- Added crimson wheat and crimson wheat seeds.
- Added crimson loaves.
  - These loaves act like regular bread, but it also gives you fire resistance for 15 seconds.s
- Added quartz carrots.
- Added debug sticks for all wood stick types.
  - These can only be obtained through commands, or through the "Operator Items" tab, backported by Melony Lib.

## Changes
### Blocks
- Renamed the world "powered" in models `painting_pressure_plate_powered` and `enderwood_pressure_plate_powered` to "down".
- Dispensers and droppers are now placed in the correct orientation.

### Items
- White wool sweaters can now be colored without merging the new color with white.
- Lingering potions no longer have its tooltips duplicated.
- The recipe of plasteel shears now uses the item tag `#rimcraft:plasteel_materials`, instead of `#melony:plasteel_materials`.

### GUIs
- The Variants config menu now has the main menu's panorama as a background.
  - It also no longer has the "substitute 'The End' biome with" text box.
    - However, if it has an invalid entry, the "Done" button is now grayed out.

### Consume Behaviors
- *Apply effects* behavior can now pull effects from the built-in behavior.
  - This, however, is *very* broken due to effect instances being mutable (see [MC-276426](https://bugs.mojang.com/browse/MC-276426)), causing them to be synced between the item and the player.
- *Damage entity* and *play sound* behaviors now properly null-checks their properties tag.
- *Explode* behavior's `spawn_effect_cloud` tag is now properly saved.
- *Teleport entity* behavior's exact teleport now only runs on the server side.

### Translations
- Fish and Variants' boats now have proper translations once again.
- Updated the translations of Variants' config menu.
  - > *"Variants - Configure Settings"* -> *"Variants - Settings"*
  - > *"Saved Settings!"* -> *"Changes Saved!"*
  - > *"Successfully saved settings to 'variants.json'."* -> *"Successfully saved all changes to 'variants.json'."*
- Added Brazilian Portuguese translations for the config screen and options.

## Technical
### Additions
- Backported the *"equippable"* and *"glider"* item components.
  - > *Documentation: [**Equippables**](https://github.com/Fabricio20106/Informational-Mod-Features/blob/main/Variants/Docs/Equippables.md)*
  - This is still in early development, so some features (like "allowed_entities") aren't available yet.
  - This can be *applied* to any item, but it's not guaranteed to *work* on all items.
  - Currently, the fields that exist for "equippable" are these: `slot`, `equip_sound`, `asset_id`, `dispensable`, `swappable`, `damages_on_hurt` and `camera_overlay`.
  - The "glider" tag currently doesn't seem to work.

### Changes
- Renamed the field `NETHER_WART_PLACEABLE_ON` in *VSBlockTags* to `NETHER_WART_PLANTABLE_ON`.
- Renamed the "killer" field in *"/damage"* to "attacker".
- The fail message of *"/damage"* no longer shows the death message in question.
- Renamed the class *Equippable* to *Swappable*.
- The eating and drinking sounds of consumables are now pulled from the stack instead of the default sound.
- *Consumable* is now implemented by the vanilla *Item* class. This means **all items are now consumables**. However, some items don't work with this.
- Items can now have their rarity and enchantment glint changed through the tags `rarity` and `enchantment_glint_override`.

### Removals
- Removed the *"/consumable \<target> open_config_screen"* debug subcommand.
- Removed the files *"intermod_content.txt"* and *"nbt_command_tree.json5"*.

## Tags
### Additions
- Added `#forge:elytra` item tag.
  - Contains elytra.
  - Items in this tag 
- Added `#variants:wild_nether_crops_plantable_on` block tag.
  - Contains `#melony:farmland`, `#variants:nether_wart_plantable_on`, `#minecraft:nylium`, soul sand and soul soil.
  - Blocks in this tag can be used as base for wild Nether crops.

### Changes
- Added all new debug sticks to `#forge:rods/debug_wooden` item tag.
- Added all new (wild) crops to `#minecraft:crops` item tag.