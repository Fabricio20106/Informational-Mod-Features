<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Back Math - August 14th Update -</center>
### <center>A Variants Release Changelog made on *17/08/2024*</center>

## Additions
- Added the Jantic Railgun.
  - This new crossbow-like weapon shoots powerful **jantic bolts**, which explode on contact with anything.
  - It's crafted with 2 string, 3 janticals, 1 moonering ingot and 1 tripwire hook, and has 3000 durability.
  - While it can be enchanted with crossbow enchantments, the enchantment's effects are not applied.
- Added Jantic Bolts.
  - These are the projectiles spawned by jantic railguns.
  - They have no gravity, emit (roughly) blue and pink particles and, like tridents, go through water with no problem.
  - Despawn when they go above Y 320 and below Y -64.
  - Can only be picked up on creative mode (if it stays on the ground without exploding somehow.)
  - Their explosion radius is 8.

### Tool Behaviors
Tool behaviors is a class that contains NBT-related methods for Back Math's items. This allows the item's functionality to be changed using only NBT.

- Devil tools, mid-term tools, Mech-Mech and Hot Sophies now read from the `seconds_on_fire` tag to set the entity on fire.
  - Defaults to `5` for devil tools and hot sophies, and `10` to mid-term tools.
- Most drinkable items now read from the `container_item` tag to give the player the container item.
  - This applies to all juices, Monster Energy Drink, Energetic Monster, Wine, Jabuticaba Wine, Sleepishwater Bottle, Choccy Milk Bucket, Choccy Milk Bottle, and others.
- Pink gum frying pans and teas now read from the `applied_effects` tag to give the entity the effects.
  - This tag is an array of effect instances, and uses the same format as Variants.
- Milked sword now read from the `milked_sword_item` to give the player the milk bucket.
- All spareys now read from the `sparey_strength_effect`, `sparey_weakness_effect` and `sparey_prohibition_weakness_effect` tags to apply their effects when you hit a mob.
- All spareys now read from the `effective_entities` and `prohibited_entities` to determine which entities are affected by which effects.

## Changes
- Removed the `bag_loot` tag of bags. Now, the `loot_table` subtag is now on the top-level tag.
- Most drinkable items now consume the item properly.
- The "flame in seconds" tooltip on bows now show up as a potion-like duration.
- Pink Gum Frying Pans now apply their effects from 10 seconds, from the previous 0.5 seconds.
- Updated *BMRangedCrossbowAttackGoal* to work properly with all crossbows (including jantic railguns).
- Revamped most of the item classes to clean up code.
  - Most item tooltips now appear after tooltips from *super*. This means some things from my mods now show up first.
  - Back Math's spawn eggs and Queen Lucy's Summoner Staves now read entity data from `entity_data` tag.

### Technical Changes
- Reverted the Gradle workspace changes.
  - Only reason for this downgrade was to make mixins work (which weren't used in this update).
  - Back Math jar files now include the date on the file name.
- Renamed the `resourceLoc` method inside the main `BackMath` class to `backMath`.
- Separated all tag classes into separate classes: *BMItemTags*, *BMBlockTags*, *BMEntityTypeTags*, *BMFluidTags* and *BMEnchantmentTags*.
- Renamed all entity classes from *"\<entity name>"* to *"\<entity name>Entity"*
- Moved *BMDamageSources* from the *"entity"* package to *"util"*.
- Removed *BottleDrinkAltItem*, as it was too similar to *BottleDrinkItem*.
- Cleaned up *BMArmors*, so now all armor materials are registered in *BMSetFields*.

## Tags
- Added Jantic Crossbows to `#melony:crossbows` item tag.
- Added `#backmath:applicable_to/backmath_bows` enchantment tag.
  - Contains Power, Punch, Flame and Infinity.
  - Enchantments in this tag can be applied to Back Math's bows.