<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.8 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *22/02/2025*</div>

## Hotfix
- Fixed fish spawning in the "water creature" category instead of "water ambient".
  - This caused thousands upon thousands of fish to spawn in oceans, eventually making the game unplayable.

## Additions
### Blocks
- Added oak, birch, acacia, dark oak, crimson and enderwood trapdoor doors.
  - These are crafted using 2 of their respective trapdoors.
- Added crystallized magma cream ore.
  - Found from Y-0 to Y-32, with a vein size *(max blocks per vein)* of 3 and a size *(veins per chunk)* of 6.
  - Has uncommon rarity.
  - Drops crystallized magma cream and 3-6 experience when mined.

### Items
- Added crystallized magma cream.
  - Has uncommon rarity.
  - Is used to craft magma swords.
- Minecarts with spawners now have an unique texture for pigs, like the other mobs.

### World Generation
- Added the **azure fields** biome.
  - This is a slightly cold plains biome densely populated with short & tall grass, (large) ferns and azure bluets.
  - Has various azure bluet bushes spread across the biome.
  - Only sheep and chickens can spawn here.
  - When **The Mato's Music Pack** is present, *"Left to Bloom"* and *"One More Day"* can play in this biome, with *"Subwoofer Lullaby"*, *"Living Mice"*, *"Haggstrom"* and *"Danny"* always having a chance to play:
  - Has a weight of 5, and its categories are **overworld**, **plains** and **lush**.
- Added the **paintingwood forest** biome.
  - This is like a forest biome, but it only has painting trees, and double the amount of *Revaried*'s flowers.
  - Plains villages and ruined portals can generate here.
  - When **The Mato's Music Pack** is present, the following songs can play in this biome:
    - *"Bromeliad"*, *"Aerie"*, *"Firebugs"* and *"Labyrinthine"*.
    - Vanilla music always has a chance to play.
  - Has a weight of 7, and its categories are **overworld**, **forest** and **lush**.
- Added the following configured features:
  - `variants:azure_bluet_feature`;
  - `variants:azure_bluet_patch`: azure bluet flower patch;
  - `variants:tall_plant_patch`: patch of tall grass and large ferns;
  - `variants:azure_bush`: a jungle bush with azure bluet leaves and a stripped spruce log trunk.

### Sounds
- Added **2** new sounds for biome music:
  - `variants:music.overworld.paintingwood_forest`;
  - `variants:music.overworld.azure_fields`.

### Miscellaneous
- Added the "Nether Coal Ore" config to the world generation config menu.

## Changes
### Blocks
- Dirt, coarse dirt, podzol and mycelium can now be flattened into dirt paths.
  - This was added a while back in-code, but only now is it properly registered.
- Updated the texture of azure bluet leaves to match the grass color of the azure fields.
- Lodestones are now crafted using iron ingots instead of netherite ingots.
- The recipe for shulker boxes is now in the `shulker_boxes_from_shells` group.

### Items
- Magma swords are now crafted and repaired using crystallized magma cream.
  - Updated the texture to match their new recipe.
  - Now have uncommon rarity.
- Updated the stats of magma swords:
  - **Tier**: 1 -> 2;
  - **Durability**: 250 -> 500;
  - **Attack Damage**: 1 -> 2 (effectively 5 -> 6);
  - **Enchantability**: 5 -> 7.
- Stained potions (should) now have the updated potions colors when *Melony Lib* is loaded.

### World Generation
- Updated the `variants:paintingwood_forest_trees` configured feature:
  - Now has a 20% chance of picking a fancy tree.
  - Now places 6 trees per chunk, with a now 20% chance of adding 2 more.

### Translations
- Changed the wording of the stack loading error (bold = new, strikethrough = old):
  - **[English]** "Variants: Could not parse **an** item ~~tags~~**stack** from ~~string \<item NBT>~~**NBT (\<item NBT>)**"
  - **[Bra. Portuguese]** "Variants: Não conseguiu ler ~~as tags~~**a stack** de item da ~~string \<item NBT>>~~**NBT (<\<item NBT>>)**"
- **[Bra. Portuguese]** Changed the word "tags" in the tag keybind and hold alt translations to "marcações".
- **[Bra. Portuguese]** Changed the word "Design" in the wool armor design translation to "Desenho".
- **[Bra. Portuguese]** Added the word "pontos" before "de experiência" in the ore experience drops translation.

## Technical
### Additions
- Added `paintingwood_forest`, `azure_fields` and `crystallized_magma_cream_ore` to the world generation section of the JSON config file.
- Added biome JSON files for the azure fields and paintingwood forest to the `reports/worldgen/biome` folder.

### Changes
- Updated the JSON config version to `1808`.<sup>*[does it actually change?]*</sup>
- The `sounds.json` files are no longer data-generated.
- Renamed the method `teleportToRandomPosition()` to `teleportWithinDiameter()`.
- Changed the "When equipped:" translation key to `tooltip.variants.horse_armor.when_equipped`.
- The tag of *Revaried*'s item stacks are now always verified, even if the `components` or `tag` field isn't present.

### Remappings
- `soul_lava_block` and `mushroom_stew_block` are now converted to soul lava and mushroom stew respectively.
- `hilary_bottle` is now converted to *Back Math*'s hillary bottle.
- `gelatinous_magma_cream`, from old versions of *Revaried*, is now converted to magma cream.
- `pornhey` is now converted to pigs (obviously never readding this thing).
- `painting_wooded_forest` is now converted to paintingwood forests.

## Tags
### Additions
- Added `#forge:ores/crystallized_magma_cream` block and item tags.
  - Contains crystallized magma cream ore.
- Added `#forge:raw_materials/crystallized_magma_cream` item tag.
  - Contains crystallized magma cream.

### Changes
- Added `#forge:ores/crystallized_magma_cream` to `#forge:ores` block and item tags.
- Added `#forge:raw_materials/crystallized_magma_cream` to `#forge:raw_materials` item tag.
- Added new trapdoor doors to `#minecraft:wooden_doors` block and item tags.