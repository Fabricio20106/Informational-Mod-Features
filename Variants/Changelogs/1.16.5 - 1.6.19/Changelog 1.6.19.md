![Additions and Changes from 1.6.19](ChangelogPhoto.png)

# <center>- Variants - 1.6.19 -</center>
### <center>A Variants Release Changelog made on *09/02/2024*</center>

## Additions
- Added the Enderwood Forest.
    - An outer End biome that has huge enderwood fungi, ender roots, fungus, and sprouts.
    - Replaces all "End Midlands" biomes.
    - The water color here matches the Bedrock End water color (#62529E).
    - Currently, it cannot be stopped from generating, but may not generate in existing worlds due to Variants overriding the default End biome source.
- Added a new ```enchantmentTypesOnTooltip``` config, which controls whether the "(Breakable Items)" or "(Weapons)" suffix on enchantments appears or not.
- Added descriptions for Variants' effects. This is for Just Enough Effect Descriptions (JEED).
- Added effect providers for Variants' effects for JEED, but these don't work because they use the Mob Taker's mod id instead of Variants'.
- Added **31** new advancements.
    - ```Antecipated Updates```: Get some Glow Black Dyes from its tulips.
    - ```It's Never* Coming```: Find an Enderwood Forest in the End.
    - ```An Unpleasant Way Out```: Meet your demise by drinking any poisoning pots.
    - ```You've Gone Insane!```: Get Glowing from a Glowstone Pot, so everyone can see you've gone insane.
    - ```An Explosive Way Out```: Drink an Explosive Blend Pot an go out like a Creeper.
    - ```Hidden Rooms 2.0```: Craft any non-compat Painting Doors or Trapdoors to hide a room.
    - ```Better Shelves```: Craft an Enderwood Bookshelf. These give 2 enchanting power, so you'll need only around 8.
    - ```Plain Shelves``` *(hidden)*: Craft a Plain Birch Bookshelf, a compatibility between Fabricio2010's Pack.
    - ```What are You Gonna Grow Here?```: Till an Ender Nylium and reflect on what you're going to plant there. <sup>*(unachievable since the ```#forge:tools/hoes``` item tag wasn't added in this release)*</sup>
    - ```Prismarine for the Rich``` *(goal)*: Get your hands on some Elder Prismarine, the fanciest and most exotic blocks out there.
    - ```Fortunate Debris```: Mine for some Raw Debris (it's better to mine it with Fortune now).
    - ```Villager-Proof```: Make a Glow Black Bed. Villagers can't sleep in it because Minecraft is weird.
    - ```No Glow Berries!```: Buy a Glow Berry Bush from Wandering Traders (it gives Sweet Berries).
    - ```Smol Flower```: Find a few Sunny Flowers (you can bonemeal it to grow them).
    - ```The Shulker Spectrum``` *(goal)*: Get all 18 possible Shulker Shell colors.
    - ```A Lost Legacy``` *(goal)*: Find the legacy "dog" disc within Creepers.
    - ```Not *Really* Implemented``` *(challenge)*: Pickup a Spawner in a Minecart.
    - ```A Lost Species```: Find and kill Fish in the Ocean (or just fish for it).
    - ```Ways Deadlier``` *(goal)*: Grab a bucket of Soul Lava (it should've melted your bucket).
    - ```A Handy Meal``` *(goal)*: Prepare a Fungi Stew from the fungi of the Nether.
    - ```A Slight Better Meal``` *(goal)*: Prepare an End Fungi Stew from End Fungi.
    - ```Pocket Milk``` *(goal)*: Bottle up some Milk for later.
    - ```A Special Brew``` *(hidden)*: Splash up a Sophie Potion with Gunpowder.
    - ```A Sticky Sweet``` *(hidden)*: Craft and eat Honey Balls.
    - ```Who Asked for This!?```: Kill a Soul Blaze (at least the eyes won't shatter) [NYI].
    - ```A New Way to Make Rails``` *(goal)*: Craft a Rail using the new method/recipe.
    - ```Bone Variants```: Grab some Wither Bones while you're farming Wither Skeleton Skulls.
    - ```Functionality Not Included!```: Craft any spyglasses added by Variants.
    - ```Villager's New Favorite```: Craft or buy a full set or Emerald armor.
    - ```You're Hacking!``` *(hidden)*: Buy a Debug Bow from master Fletchers.
    - ```It's Now a Machine Gun...``` *(challenge & hidden)*: Get your hands on a Quick Charge V book. <sup>*(gives 100 experience)*</sup>
- Variants also adds 2 advancements to mediate other advancements:
    - ```The Nether```: Not much has changed here, but there are a few new things.
    - ```The End```: As you can see, nothing significant was changed here... yet.

## Changes
- Chorus Flowers and Chorus Plants can now be placed on Ender Nylium.
- When an enchantment isn't applied to a vanilla category, it will now show up as ```(Other)``` instead of ```(How Did We Get Here?)```.
- Changed *"When on Horse"* tooltip to *"When equipped"*, to be consistent with [24w04a](https://minecraft.wiki/w/Java_Edition_24w04a)'s addition of the horse armor (and wolf armor) armor tooltips.

### Translation Changes (Brazilian Portuguese)
- Renamed *"No cavalo"* tooltip to *"No corpo"*, to be consistent with 24w04a.

## Tags
- Added ```#variants:warping_vines_feature_can_place_on``` block tag.
    - Contains End Stone, Ender Nylium and Ender Wart Block.
- Added ```#variants:chorus_flower_plantable_on``` block tag.
    - Contains End Stone and Ender Nylium.
- Added Ender Nylium to ```#variants:ender_wart_plantable_on``` and ```#minecraft:dragon_immune``` block tags.
- Removed Ender Nylium, Roots and Fungus from the ```#minecraft:enderman_holdable``` block tag.