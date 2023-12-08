# <center>- Variants - 1.6.5 -</center>
### <center>A Variants Release Changelog made on *08/12/2023*</center>

For this release, there were various commits. So, to know in which commit each feature got added, here's a small list for what was added in each commit:
- **(C1)**: "Elder Prismarine & New Tags"
- **(C2)**: "Texture Changes & Small Changes & Fixes"
- **(C3)**: "New Shears, Glass & Quartz Ore & Various Fixes"
- **(C4)**: "More Features from 1.4.8 & Miscellaneous Items"

## Additions
- **(C1)** Added Elder Prismarine
    - Includes normal, brick, dark and lantern variants.
- **(C1)** Warped Wart can now be made into blocks.
- **(C2)** Diamond and Iron Spyglasses can now be crafted.
    - Netherite Spyglasses can now be made at the crafting table.
- **(C3)** Added Deepslate Quartz Ore.
- **(C3)** Added Glow Black Stained Glass (+ pane).
    - These stained glass, when put on of of a Beacon, will give out a glow black color.
- **(C3)** Added Exposed, Weathered and Oxidized Copper Shears and Amethyst Shears.
- **(C3)** Added Glow Black Beds, but they're hidden from the creative tab since they're not finished yet.
- **(C4)** Added Chiseled End Stone Bricks and Purpur Blocks.
- **(C4)** Added Quartz Glass and Glass Pane.
- **(C4)** Added Quartz Shards (nuggets).
- **(C4)** Warped Wart can now be crafted from Warped Wart Blocks.

## Changes
- **(C1)** Golden Beacons can now only be crafted from colorless glass.
- **(C2)** Renamed block model ```variants:block_item_crop``` to ```variants:inventory_crop```.
- **(C2)** Renamed block model ```variants:flower_pot_cross_alt``` to ```variants:inventory_potted_plant```.
- **(C2)** End Quartz Ore can no longer be broken by Ender Dragons.
- **(C2)** Potted Sugar Cane and Painting Leaves now use the biome's foliage color/tint instead of the grass color.
- **(C2)** Cauldrons are now renderer 3D in the inventory.
- **(C2)** All quartz ores have a new texture.
- **(C2)** Removed a pixel in the golden carrots' 3rd stage of growth.
- **(C3)** Coal Shears now have 32 durability, and Copper Shears now have 131.
- **(C3)** Potted Sugar Cane now uses the grass color/tint.
- **(C3)** Renamed Splash Sophie Potions to "Splash Soph Potion".
- **(C4)** Deepslate Quartz Ore now drops experience.
- **(C4)** Purpur Pillars are now crafted using two purpur blocks instead of two slabs.
    - The result will now give two pillars instead of one.

### Translation Changes (Brazilian Portuguese)
- **(C3)** Renamed purple iron nugget from "Pepita de ferro roxa" to "Pepita de ferro roxo".

## Tags
- **(C1)** Added ```#variants:conduit_frame_blocks``` block tag.
    - Contains all full block variants of prismarine and elder prismarine (normal, brick, dark and lantern).
- **(C1)** Added ```#variants:golden_carrots_plantable_on``` block tag.
    - Contains ```minecraft:farmland```.
- **(C1)** Added ```#variants:warped_wart_plantable_on``` block tag.
    - Contains ```minecraft:soul_sand``` and ```minecraft:soul_soil```.
- **(C3)** Added ```#forge:deepslate_replaceables``` block tag.
    - Contains ```minecraft:deepslate```, ```cavesandcliffs:deepslate``` and ```quark:deepslate```.
- **(C3)** Added ```#forge:glass/glow_black``` and ```#forge:glass_panes/glow_black``` block and item tags.
    - Contains ```variants:glow_black_stained_glass``` and ```variants:glow_black_stained_glass_pane``` respectively.
- **(C3)** Added Glow Black Stained Glass and GBSG Pane to ```#forge:stained_glass``` and ```#forge:stained_glass_panes``` block and item tags respectively.
- **(C3)** Added GBSG to ```#minecraft:impermeable``` block tag.
- **(C3)** Added Glow Black Beds to ```#minecraft:beds``` block and item tags.
- **(C4)** Added Quartz Glass to ```#forge:glass/colorless``` block and item tags and to ```#minecraft:impermeable``` block tag.
- **(C4)** Added Quartz Glass Pane to ```#forge:glass_panes/colorless``` block and item tags.
- **(C4)** Added Quartz Shards to ```#forge:nuggets/quartz``` item tag.