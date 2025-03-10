<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.20 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *09/02/2024*</div>

## Additions
- Added Exponential Stews for: Beetroot, Rabbit, Suspicious, Fungi, End Fungi, Aljan Fungi *(Back Math)*, Water, Milk, Lava, Soul Lava and Powder Snow.
  - Water, Milk, Lava and Soul Lava give 4 nutrition and 5 saturation.
  - Powder Snow has its nutrition values taken from Apples.
  - The NBT structure for storing the effects is different from Suspicious Stew.
  - Comes with a config `populateExponentialBowlsInTabs` to disable all bowls from appearing in the creative menu.
- Added "recipe advancements" for all exponential stews *(side effect of data generating recipes)*.
- Added Suspicious Stew Buckets.
  - Includes a custom recipe type for its recipe (`variants:suspicious_stew_bucket_special_recipe`).
- End Quartz Ore now acts like Netherrack besides nylium -- the Ender Nylium can now spread to the ore.
  - This was also implemented for End Stone, but due to unintended side effects and bugs, it was removed. <sup>*(basically, all End Stone was removed, even leaving a hole in the creative menu)*</sup>

## Changes
- Ender Nylium Quartz Ore's map color is now **"COLOR_PURPLE"**.
- Ender Nylium and Farmland's map color is now **"COLOR_PURPLE"**.
- Registered Variants' modified End biome source (`variants:enderwood_end`).
- Milk Bottles can now cure you from effects.
- Splash Sophie Potions now give you 3 saturation, instead of the old 18.
  - This is because the true saturation value is *nutrition x saturationMod = saturation*.
- Updated the texture of Chiseled Purpur Blocks so the color pallete matches Purpur Blocks.

### Translation Changes (Brazilian Portuguese)
- The word "Spawner" in the description of `Not Really Implemented` is now "Gerador".
- Changed the names of Shulker Spectrum Icon and Infinity Sweaters Tab Icon to their equivalent English names.
- Renamed "Balde de sopa de beterraba" to "Balde de ensopado de beterraba".

## Tags
- Added `#variants:has_ender_nylium` block tag.
  - Contains Ender Nylium and Ender Nylium Quartz Ore.
- Added each exponential stew into its respective `#variants:bowl_foods/*` item tag.
- Removed Ender Nylium and Ender Nylium Quartz Ore from `#variants:chorus_flower_plantable_on` block tag, and added `#variants:has_ender_nylium` instead.
- Removed Ender Nylium and Ender Nylium Quartz Ore from `#variants:ender_wart_plantable_on` block tag, and added `#variants:has_ender_nylium` instead.