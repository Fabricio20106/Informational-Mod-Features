<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.5 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *04/11/2024*</div>

**1.8.0.5** is the fifth version for [*Revaried 1.8.0*](/Revaried/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on October 22, 2024.[^1]

## Additions
### Items
- Added splash and lingering bottles for honey, dragon's breath, lava, soul lava, milk, powder snow.
- Added lingering sophie potions.
  - All of these have both crafting and brewing recipes.
  - Correctly apply cooldown and sound tags from *TagConfigurableFood*.

### Entities
- Added thrown behavior bottles.
  - These bottles run the behaviors of the respective item like a splash potion.
  - It also have particles which match the bottle contents.
  - Currently, it run the behaviors on both the client and server, so it plays sound and particles twice.

### Potions
- Added levitation potions.
  - These come in default (30 seconds), long (1:30 minutes) and strong (30 seconds, level II).
  - Are brewed using a shulker shell on awkward potions.

### Consume Behaviors
- Added an *"eat item"* behavior.
  - Its argument is an item stack to consume.

### Miscellaneous
- Added a translation for potion level 100: **C**.
- Added textures for splash and lingering bottle contents.

## Changes
### Blocks
- The enchanting power tooltip of Variants' bookshelves now only appears with advanced tooltips.
- The XP drops tooltip of Variants' ores now only appears with advanced tooltips.
  - These two now appear after tooltips added by `super` (like tags).
- Enderwood pressure plates now drop again.

### Items
- Added Brazilian Portuguese translations for stained potions.
- Slightly changed the texture of glow black stained bottles.
- Updated textures for splash and lingering dragon's breath, bottles o'experience and empty bottles.
- End fungi stew and quartz shards can now be crafted again.
- Master level clerics now sell stained bottles o'experience.
- Renamed unused texture `item/bottle_contents/ominous_what` to `item/bottle_contents/how_in_the_actual_f_did_this_happen`.

### Entities
- Debug arrows now cycle properties instead of changing them when the shooter is shifting.

### Consume Behaviors
- The *ignite* behavior now applies fire for the correct amount of time now (divide by 20 ticks instead of multiplying by 20).
- The *multi-behavior* now properly null-checks the item tag, and now runs even if there's no tag.

### Miscellaneous
- Changed the "show tags" key translation namespace from "variants" to "melony_studios".
- Changed the duplicate texture id message from:
  > Variants: Bowl type '`bowl_type`' is using an already used texture ID.
  - to:
  > Variants: Bowl type '`bowl_type`' is using texture ID `texture_id`, which is already being used.
- Updated loot table for pillager outposts to add stained bottles o'experience.

## Technical
### Additions
- Added a JSON config file for Variants.
  - Currently, it only contains the world generation related configs.
  - The *"substitute "The End" biome with"* config is now a resource location for the biome name. This means any biome can now be chosen.
  - The current version of the file is `1805`, or 1.8.0.5.
- Added a "set texture identifier" loot function.
  - Sets the texture identifier for any item. The `texture_id` field is a random range.
- Added some random codecs for bowl type and *teleport entity* behavior.
- Added a new item stack codec on *NBTUtils*.
  - Added a method to parse explosion modes as well.

### Changes
- Changed the "stained glass" in `populateStainedGlassBottlesInTabs` description to "stained-glass".
- Renamed the config category `stewBehaviors` to `consumeBehaviors`.
- Renamed the sound event `stew_behavior.play_sound.default` to `consume_behavior.play_sound.default`.
- Most items in Variants now extend *VSItem*, and now have the following tags:
  - <sup>*[note]*: *"max_stack_size"*, *"max_damage"* and *"enchantable"* seem to not work properly.</sup>
  - **`enchantment_glint_override`**: Controls the enchantment glint of the item;
  - **`max_stack_size`**: Maximum stack size of this item. Capped at 127;
  - **`max_damage`**: Maximum damage this item can take;
  - **`enchantable`**: The enchantment value of this item. Not encased within a `value` field like in 1.21.2;
  - **`item_entity_lifespan`**: How long, in ticks, the dropped item will last for.
- Stained bottles o'experience now apply the cooldown and sound tags from *TagConfigurableFood*.
- Stained full bottles and exponential stew now have default NBT data when their tag population configs are off.
- *VSUtils* stack handling now properly saves empty item stacks.

### Removals
- Removed `red_yellow`, `aljan_light_blue`, `poison_brown` and `insomnian` wool armor colors, as they're now added by Back Math.
- Removed `tooltip.variants.hold_alt.held` tooltip, as the colors are now hardcoded.
- Removed the tooltip translations for poisoning types.

## Tags
### Additions
- Added `#melony:natural_farmland` block tag.
  - Contains farmland, ender farmland and aljamic farmland (Back Math).
  - Blocks in this tag can be used to place natural crops, such as wheat or golden carrots.
- Added `#minecraft:worldgen/plants_placeable_on` block tag.
  - Contains `#melony:natural_farmland`, grass blocks, podzol, dirt and coarse dirt.
  - Replaces the hardcoded blocks in *"mayPlaceOn()"* on *BushBlock*.
- Added `#variants:dragon_breath_bottles` item tag.
  - Contains dragon's breath, splash dragon's breath, lingering dragon's breath and stained dragon's breath.
  - Items in this tag are used by some crafting recipes.

### Changes
- Removed normal, ender and aljamic farmland from `#melony:farmland` block tag.
  - It now contains `#melony:natural_farmland` and crimson and warped farmland.
  - Blocks in this tag can be used to place unnatural crops, such as crimson wheat<sup>*[upcoming]*</sup>.
- Added all new splash and lingering bottles to `#variants:throwable_bottles` item tag.

### References
[^1]: ["1.8.0.5: Bottle Updates & JSON Configs"](https://github.com/isabellawoods/Revaried/commit/e7231934a4b0159d44952f3063259d3266b00eaa) (Commit `e723193`) – GitHub, October 22, 2024.