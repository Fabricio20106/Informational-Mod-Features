<div style="text-align: center;"> <img src=ChangelogPhotoPartIAndII.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.7.0 Pre-Release 5 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *08/06/2024*</div>

*This changelog only covers the changes made in parts I and II of this update. For the part III, see [Changelog 1.7.0 Pre-Release 5 (Part III)](https://github.com/Fabricio20106/Informational-Mod-Features/blob/main/Variants/Changelogs/1.16.5%20-%201.7.0%20Pre-Release%205/Changelog%201.7.0%20Pre-Release%205%20(Part%20III).md)*

## Additions
- Added a `/setbehavior` command to set the behavior and properties of an exponential stew.
  - Its syntax is `/setbehavior <targets/player> <stew behavior>{<properties>}`.
  - **Example**: `/setbehavior JuneTheWoods variants:clear_mob_effects{curative_item:{id:"minecraft:milk_bucket",Count:1b}}`
  - It can be executed from a permission level of 2.<sup>[[1]](https://minecraft.wiki/w/Permission_level#Java_Edition)</sup>
  - When executed, the behavior name is highlighted in purple, and when hovering it shows the behavior name and description.
- Added a Sugar Pot Speed alias effect.
  - Only purpose is to give you speed for 10 seconds, and gets imediately removed after.
  - Used by Sugar Pots.
- Added *"Sugar"* and *"None"* poisoning types.
- Stew Behaviors are now shown in the item tooltip, and can be hidden using the hiding tag `hide_stew_behavior`.
- Added 3 new stew behaviors: **Damage Entity**, **Explode** and **Play Sound**. More information can be found [here](https://github.com/Fabricio20106/Variants/wiki/Exponential-Stews-(After-1.7.0%E2%80%90pre5)).
  - "Damage Entity" damages the entity with a specified damage source and amount;
  - "Explode" explodes the mob with a specified radius, set fire and damage source;
  - "Play Sound" play any sound in the game with a specified volume, pitch and category, and optionally the position and if it plays from the player.

## Changes
- Renamed poisoning damage sources from `poisoning.<powder>` to `<powder>_poisoning` (same as the effect name).
  - Translations were not yet changed.
- The block and item tags `#melony:completes_find_tree_tutorial` are no longer used by the "Find Tree" tutorial (moved to Melony Lib).
- Sugar Pots, Sweet Berry Pots and Glow Berry Pots are now stylised pots. This means they can have effects now.
- Updated most of the stew behavior system. All changes are documented [here](https://github.com/Fabricio20106/Variants/wiki/Exponential-Stews-(After-1.7.0%E2%80%90pre5)), in Variants' GitHub wiki.
- Exponential Stews now properly execute a custom behavior from NBT, instead of either not executing or executing the default constructor.
- Tooltip hiding tags are no longer inside the `hide_vs_tooltips` tag.
  - Instead, they're now on the top level tag.
- Poisoning pots (`StylisedPotItem`s) now can have their effects come from NBT.
  - If not available, it will fall back to the built-in type.
  - Pots that have effects on NBT will show it in their tooltips as *"Poisoning/Effect: \<effect with accurate color>"*, and the poisoning type will, for some reason, show up as *"404 Poisoning Not Found"*, instead of the built-in type.
  - The effect's `id` and `duration` are set by default on the creative tab.
- Poisoning pots now have translations.
  - If the poisoning type is null (which is sometimes is), it shows up as *"404 Poisoning Not Found"* (`poisoning_type.unregistered_sadface`).

### Technical Changes
- Debug Arrow dispense behavior is now a separate class (`DebugArrowDispenseBehavior`).
- "`hasBehaviorInNBT()`" inside *StewBehavior* has been renamed to "`hasBehaviorIDInNBT()`", and it now properly checks if the behavior id is in the *stewStack* NBT.
- "`getBehaviorFromNBT()`" now properly returns the stew behavior from NBT.

## Tags
- Tags can now be made for stew behaviors. These are stored under the folder `tags/stew_behavior`.
- Added Bells to `#minecraft:guarded_by_piglins` block tag.