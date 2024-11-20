<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 3.0.15 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *08/12/2023*</div>

This release of Variants is almost identical to release 1.6.15, but updated to 1.20.2 and to NeoForge 20.2.

## Additions
- Added Chest Boats, but they currently do not have textures or items to spawn them.

## Changes
- All Variants' armor can now be trimmed.
    - Though Wool Sweaters don't render the overlay (because complexity).

## Tags
- Moved Glow Black Carpets from ```#minecraft:carpets``` block/item tags to ```#minecraft:wool_carpets```.
- Added ```#minecraft:cauldrons``` block tag to ```#variants:cauldrons```.
- Added all Variants' swords to ```#minecraft:swords``` item tag.
- Added all Variants' pickaxes to ```#minecraft:pickaxes``` item tag.
- Added all Variants' shovels to ```#minecraft:shovels``` item tag.
- Added all Variants' axes to ```#minecraft:axes``` item tag.
- Added all Variants' hoes to ```#minecraft:hoes``` item tag.
- Added all Variants' helmets to ```#forge:armors/helmet``` item tag.
- Added all Variants' chestplates to ```#forge:armors/chestplate``` item tag.
- Added all Variants' leggings to ```#forge:armors/leggings``` item tag.
- Added all Variants' boots to ```#forge:armors/boots``` item tag.
- Added all Variants' armors to ```#minecraft:trimmable_armor``` item tag.
- Added Enchanted Knowledge Books to ```#minecraft:bookshelf_books``` item tag.
- Added Soul o' Charges to ```#minecraft:creeper_igniters``` item tag.
- Added Wool Sweaters to ```#minecraft:freeze_immune_wearables``` item tag.
- Added Raw Fish and Cooked Fish to ```#minecraft:fishes``` item tag.
- Added Golden Cauldrons to ```#minecraft:cauldrons``` block tag.
- Added Debug Bows to ```#forge:tools/bows``` item tag.
- Added Empty Armor Slot Shields to ```#forge:tools/shields``` item tag.
- Added Quartz Ore to ```#forge:ores_in_ground/stone``` item tag and to ```#forge:ores_rates/singular```.
- Added Deepslate Quartz Ore to ```#forge:ores_in_ground/deepslate``` item tag and to ```#forge:ores_rates/singular```.
- Added End Quartz Ore to ```#forge:ores_in_ground/end_stone``` item tag (new tag) and to ```#forge:ores_rates/singular```.

## Temporary Removals
- Soul Lava (includes buckets);
- All world generation;
- Natural Fish spawning;
- Variations of Enchanted Knowledge Books in the creative tab;
- Mixins;
- Access Transformers (stripping, tilling, flammability, etc.).

## Known Issues
- Golden Cauldrons transmute into regular Cauldrons when any fluid is put inside.
- Glow Black Beds and Diamond Bells render as a Light Blue Bed and a regular Bell respectively.
- Glow Black Stained Glass Panes appear opaque in the inventory.