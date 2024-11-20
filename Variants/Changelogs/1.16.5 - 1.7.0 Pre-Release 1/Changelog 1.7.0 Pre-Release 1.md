<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.7.0 Pre-Release 1 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *02/03/2024*</div>

## Additions
- Added Azure Bluet Leaves.
- Added Mossy End Stone Bricks (with Stairs, Slabs, Walls & Infested).
- Added Mossy Purpur Blocks (with Stairs, Slabs, Walls & Infested).
- Added Mossy Nether Bricks (with Stairs, Slabs, Walls & Infested).
  - These mossy variants can also be crafted with Moss Blocks from Others (My Other Stuff).
- Added End Stone Brick & Nether Brick Pillars.
- Added Smooth Purpur (with Slabs).
- Added Soul Brewing Stands.
  - These also count for brewing recipes, and they appear on the sidebar on the brewing recipe category.
- Added Crystallized Honey.
- Repair materials for all of Variants' armors and tools are now shown in JEI.
- All enchantments (levels) for Enchanted Knowledge Books are now shown in JEI.
- Added a new sound event for throwing Dragon Breath bottles (`variants:entity.dragon_breath_bottle.throw`).

## Changes
- Fixed the *"Feature"* crash with Chorus Plants from 1.6.20.3.
- Splash and Lingering Dragon Breath bottles are now throwable (by Dispensers).
  - They do not render, but when they hit the ground they make an Area Effect cloud, like with the Dragon Fireballs.
- Soul o' Charges can now be dispensed by Dispensers.
  - They act the same as Small Fireballs, but they do not render and place Soul Fire instead of regular fire.
  - Although it seem they don't place the soul fire.
- Sunny Flowers can now be bonemealed into Sunflowers.
  - This also works with Dispensers.
- Wither Bone Meal can now be used by Dispensers.
- Soul Lava Buckets, Mushroom Stew Buckets and Buckets with Fish can now be dispensed by Dispensers.
- Variants' Boats can bow be dispensed by Dispensers onto water, like with vanilla boats.
- Splash and Lingering Bottles o' Experience can now be dispensed by Dispensers.
- Mushroom Stew Buckets now have a container item: Buckets.
- Empty Armor Slot Shields can now be repaired with any `#forge:ingots/iron`.
- Shields, Shears and Flint and Steel no longer have their mod id set to *"variants"*.
- The " > " sign on enchantment descriptions is now translatable.
  - This arrow is now colored aqua instead of gold.

### Translation Changes (English)
- Added translation for an Enchanted Knowledge Book error message (unused as of now).
  - `Variants: Invalid recipe for Enchanted Knowledge Book: *error*`
- Renamed *"Splash/Lingering Experience Bottle"* to *"Splash/Lingering Bottle o' Experience"*.
- Changed debug bow tooltip from *"Cannot change block states in <'Gamemode'> Mode"* to *"Cannot change block states while in <'Gamemode'> Mode"*.
- Changed `tooltip.variants.enchant.arrow` from *" > %s"* to *" > "*.

### Translation Changes (Brazilian Portuguese)
- Changed debug bow tooltip from *"Não é permitido mudar estados de bloco no modo <'modo'>"* to *"Não é permitido mudar estados de bloco enquanto no modo <'modo'>"*.

## Tags
- Added `#variants:purpur_smeltables` item tag.
  - Contains Mossy Purpur Block, Purpur Block and Purpur Pillar.
- Added Azure Bluet Leaves to `#minecraft:leaves` and `#minecraft:flowers` block and item tags.
- Added Mossy End Stone Brick Stairs, Mossy Purpur Block Stairs and Mossy Nether Brick Stairs to `#minecraft:stairs` block and item tags.
- Added Mossy End Stone Brick Slab, Mossy Purpur Block Slab, Smooth Purpur Slab and Mossy Nether Brick Slab to `#minecraft:slabs` block and item tags.
- Added Mossy End Stone Brick Wall, Mossy Purpur Block Wall and Mossy Nether Brick Wall to `#minecraft:walls` block and item tags.