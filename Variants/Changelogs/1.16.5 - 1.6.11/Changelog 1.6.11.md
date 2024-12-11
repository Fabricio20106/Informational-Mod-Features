<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.11 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *22/11/2023*</div>

## Additions
### Blocks
- Added enderwood.
  - Currently, it does not spawn naturally.
  - Has most wood-related blocks, including bookshelves.
  - Ender wart blocks have an **85%** chance to fill a composter.
- Added ender roots, End sprouts, ender fungus, ender wart and warping vines.
  - End sprouts and warping vines have a **50%** chance to fill a composter.
  - Ender roots and ender fungi have a **65%** chance to fill a composter.
- Added ender nylium and ender farmland.
  - Ender farmland currently turns into dirt if placed below a block.
- Red nether bricks can now be crafted from red nether brick items.

### Items
- Added soul lava bottles.
- Added enderwood sticks.

### World Generation
- Added the following configured features:
  - `variants:closed_soul_lava_spring`;
  - `variants:double_closed_soul_lava_spring` (unused);
  - `variants:open_soul_lava_spring`;
  - `variants:enderwood_fungi`;
  - `variants:planted_enderwood_fungi`;
  - `variants:enderwood_forest_vegetation`;
  - `variants:end_sprouts`.

### Miscellaneous
- Added a new `pack.png` for Variants.
- Added **1** new config: `generateSoulLavaSprings`.
  - This controls whether soul lava springs generate throughout the Nether.

## Changes
### Blocks
- Updated textures of quartz, gold and diamond chains.

### Fluids
- Soul Lava now generates naturally in the Nether (configurable).
- Soul Lava now flows as far and as fast as normal lava.

### Items
- Attempted to fix drinkable containers not giving the empty container item.
- Lava bottles now kill the entity directly instead of giving instant damage 100.
  - The death message is now: "*\<player>* went up in flames" instead of "*\<player>* was killed by magic"

### Entities
- Fletchers now buy 32 enderwood sticks for 1 emerald.

### Miscellaneous
- Updated Variants' wide logo to match the new `pack.png` logo.

## Tags
### Additions
- Added `#variants:farmland` block tag.
  - Contains farmland and ender farmland.
  - Blocks in this tag can be used as base for golden carrots.
- Added `#variants:end_plants_plantable_on` block tag.
  - Contains `#minecraft:nylium`, End stone and obsidian.
  - Blocks in this tag can be used as base for ender roots, ender fungi and End sprouts.
- Added `#variants:ender_wart_plantable_on` block tag.
  - Contains ender farmland, End stone and obsidian.
  - blocks in this tag can be used as base for ender wart.

### Changes
- Added warping vines and warping vine plants to `#minecraft:climbable` block tag.
- Added ender nylium, roots and fungi to `#minecraft:enderman_holdable` block tag.
- Added potted ender roots and fungi to `#minecraft:flower_pots` block tag.
- Added ender nylium to `#minecraft:nylium` block tag.
- Added enderwood bookshelves to `#variants:bookshelves` block and item tags.
- Added enderwood sticks to `#forge:rods/wooden` item tag.
- The `#variants:golden_carrots_plantable_on` block tag now contains `#variants:farmland` instead of only vanilla farmland.