<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.4 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *08/12/2023*</div>

This release of Variants includes two commits. So, to differentiate, they will be named **(C1)** and **(C2)** respectively.

## Additions
- **(C1)** Added Copper Shears.
- **(C1)** Wool Sweaters can now have custom name appended to them.
    - **(C2)** All (vanilla) colors of Wool Sweater now appear in the creative tab.
- **(C1)** Honey Balls can now be crafted from four honey bottles.
- **(C2)** Added Painting Saplings (+ potted).
- **(C2)** Added full Brazilian Portuguese translation.

## Changes
- **(C1)** Many internal class renames.
- **(C1)** Golden Carrots (crop) now appear after Potted Glow Black Tulips in the creative tab.
- **(C1)** Changed compatibility item descriptions from "messages.variants.<tooltip\>" to "tooltip.variants.<tooltip\>".
- **(C1)** Slightly changed the description of Debug Bows.
- **(C1)** Slightly changed the color of Inno Wool Sweaters.
- **(C1)** Updated textures of all shears, including vanilla's.
- **(C1)** Updated textures for all Variants' stone tools.
- **(C1)** Updated textures for all spyglasses.
- **(C1)** Updated texture for Empty Armor Slot armor model.
- **(C1)** Debug Bows now have 3840 durability.
- **(C1)** Redstone Shears now have 250 durability.
- **(C1)** Coal Shears now have 131 durability.
- **(C1)** Golden Shears now have 250 durability.
- **(C1)** Lapis Lazuli Shears now have 1671 durability.
- **(C1)** Emerald Shears now have 1561 durability.
- **(C1)** Quartz Shears now have 500 durability.
- **(C1)** Magentic Crystal Shears now have 861 durability.
- **(C1)** Magentic Shears now have 861 durability.
- **(C1)** Innovator's AI Shears recipe now accepts any `#forge:cores/inno`.
- **(C2)** Golden Cauldrons can now be waterlogged.
- **(C2)** Diamond Shears now appear after Copper Shears in the creative tab.
- **(C2)** Painting Leaves now drop Painting Saplings instead of oak saplings, and Honey Balls instead of apples.

### Translation Changes (English)
- **(C1)** Renamed *Crystal Shears* to *Magentic Crystal Shears*.
- **(C1)** Renamed *Light Magenta Shears* to *Magentic Shears*.
- **(C1)** Renamed all AI shears from *X AI Shears* to *X's AI Shears*.

## Bug Fixes
- **(C1)** [VS-1](https://github.com/Fabricio20106/Variants/issues/1): Bottle Funcionality parameters are passed incorrectly in `DrinkableContainerItem` class.
- **(C2)** Potted plants that inherit `flower_pot_cross_alt` no longer have a hole below the flower pot dirt.

## Tags
- **(C1)** Added copper shears to `#forge:shears` item tag.
- **(C2)** Added `#forge:gems/elder_prismarine` item tag.
    - Contains elder prismarine crystals.
- **(C2)** Added `#forge:rods/soul_blaze` item tag.
    - Contains soul blaze rods.
- **(C2)** Added `#minecraft:saplings` block and item tags.
    - Contains painting saplings.
- **(C2)** Added potted painting saplings to `#minecraft:flower_pots` block tag.