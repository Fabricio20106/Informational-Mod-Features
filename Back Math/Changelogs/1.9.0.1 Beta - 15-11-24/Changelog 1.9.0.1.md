<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.1 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *09/11/2024*</div>

## Additions
### Blocks
- Added doors and trapdoors for aljancap and insomnian.
  - Aljancap has its textures updated on the Aljan Texture Update pack.

### Particles
- Added janticle particles.
  - These seem to crash the game when first loading resource packs.
  - Its only texture is `minecraft:particles/generic_0`.

## Changes
### Blocks
- Aljan portal stands now produce jantical particles around them.
  - The particles seem to be a bit broken and disappear after 1 tick.

### Items
- Most mid-term items now appear fully bright in most cases, except when placed and on item frames.
- Renamed mid-term greatswords to mid-term longswords.
- Mid-term longswords and carewni now have different models when held.
  - These swords are now held using the crossbow loading animation, which appears as holding the sword with both hands.
  - Carewni (should) have a trans flag texture on June.
    - This uses a `backmath:june_check` property, which returns 1 on June and 0 when not.
  - The model template `handheld_32x` no longer makes the item wider and have a different model on the inventory.
- Updated the textures of mid-term longswords and carewni.
  - Carewni now cycle through its colors individually instead of having a line of all colors.
  - Currently, the inventory texture of mid-term longswords is the same as the mid-term sword.
- Queen Lucy's summoner staves now use their 2D model when on item frames.
- Golden, devil, angelic, christian mid-term, crystalline angelic, aljameed and moonering crowns are now properly attached to the entity's head.

### Entities
- Aljan mobs that wear armor:
  - No longer have their armor chance affected by the regional difficulty.
  - Now have a chance to spawn wearing jantiquified moonering armor.
- Malaikas have had their behavior changed:
  - Are now considered monsters;
  - Now drop 50 experience instead of 2;
  - No longer look at players;
  - Now have 40 health (20 hearts), 5 attack damage, 10 follow range and 5 armor;
  - No longer wear Aljan armor;
  - Can no longer spawn in the Aljan.
- Chocoglue projectiles now hurt entities only on the server side.
- Players now have the proper third-person animations when using jantic railguns.
- Back Math mobs now use the crossbow holding animation when holding charged jantic railguns.

### World Generation
- Renamed the configured feature `backmath:sleepishwater_lake` to `backmath:aljan_water_lake`.
  - Now these have water instead of sleepishwater.
- Aljan underwater caves now use vanilla water instead of sleepishwater.
- The Aljan dimension now uses vanilla water instead of sleepishwater.
- Brightened the color of the water in the Aljan from *#280C40* and *#1D082E* to ***#661163*** and ***#590F57***.

### Miscellaneous
- The Aljan nighttime sky color now applies every day, instead of only the first day.
- The Aljan sky now has 3000 stars instead of 1500.<sup>*[verify]*</sup>
- The upper hemisphere of the Aljan sky has been accidentaly raised (16 to 32).
- Regarding the Aljan teleporter:
  - Updated the debug messages to only say "portal stand".
    - Added a message for when there is an existing stand in the area.
  - The stand is now placed before teleporting the entity.
  - It now properly checks for `#backmath:aljan_teleporter_replaceables` or cave air when moving up.
  - Now places the portal stand at Y-63 with a 3x3 platform of polished sleepingstone when failing to find a suitable location for the stand.
    - This was implemented as a softlock fix for void worlds, and happens if it fails to find a location 5 times.
  - Now places a portal stand properly when coming from the Aljan.
- Renamed aljancap features in Brazilian Portuguese to "caule aljámico".

## Removals
- Removed translations for aljancap and insomnian barrels.

## *"Aljan Texture Update"* Pack
### Additions
- Added updated textures for aljancap blocks and items.

### Changes
- Updated the textures of aljancap mortar & pestle.

### Removals
- Removed the second and third revision textures of aljamic dirt.

## Technical
### Changes
- Changed the development version to `melony-studios-dev`.
- Changed my name in the authors section of *mods.toml* to *"isabellawoods"*.
- Removed the `inside_aljan` boolean field from *"/backmath-aps_testing"* command.
- Added *"/backmath-world_times"* command.
  - This command prints various world times in different formats.
- Renamed the class *MidTermGreatswordItem* to *MidTermLongswordItem*.
- Jantic railguns now save and load their ammo using Variants' stack management.
- Added a recipe for red yellow wool sweaters for Variants.
- All planks recipes are now in the "planks" group.
- All wood recipes are now int the "bark" group.
- All sapling recipes are now in the "sapling" group.
- All chain recipes are now in the "chain" group.
- All duplicate ingot recipes are now in the "\<ingot name>_ingot" group.
- And many other recipes are now in groups.

## Tags
### Additions
- Added `#backmath:natural_farmland` block tag.
  - Contains farmland and aljamic farmland.
  - Blocks in this tag can be used as base for turtle fried egg flowers, and are included in `#melony:farmland`.
- Added `#backmath:dual_wielded` item tag.
  - Contains mid-term longswords and carewni.
  - Items in this tag are held using the crossbow loading animation.
- Added `#backmath:fully_lit` item tag.
  - Contains nearly all items made of mid-term and obsidian infused mid-term.
  - Items in this tag are fully lit/bright when dropped, worn and held, but not when in item frames.

### Changes
#### Blocks
- Changed the contents of the `#backmath:malaika_spawnable_on` block tag to `#forge:end_stones` and `#variants:has_ender_nylium`.
- Changed the `#melony:farmland` block tag inside `#backmath:turtle_fried_egg_flower_plantable_on` to `#melony:natural_farmland`.
- Changed the contents of the `#melony:farmland` block tag to `#melony:natural_farmland`.
- Added aljancap and insomnian doors to `#minecraft:wooden_doors` block and item tags.
- Added aljancap and insomnian trapdoors to `#minecraft:wooden_trapdoors` block and item tags.

#### Items
- Added golden halos to `#minecraft:piglin_loved` item tag.
- Added archer lucia boots to `#forge:armors/boots` item tag.

#### Entities
- Changed the contents of the `#backmath:malaika_targets` entity type tag to `#minecraft:raiders`, `#backmath:player_like`, players, villagers and wandering traders.