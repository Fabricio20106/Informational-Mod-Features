![Additions and Changes from 1.7.0 Pre-Release 5](ChangelogPhoto.png)

# <center>- Variants - 1.7.0 Pre-Release 5 -</center>
### <center>A Variants Release Changelog made on *08/06/2024*</center>

## Additions
- Added a Sugar Pot Speed alias effect.
  - Only purpose is to give you speed for 10 seconds, and gets imediately removed after.
  - Used by Sugar Pots.
- Added *"Sugar"* and *"None"* poisoning types.
- Stew Behaviors are now shown in the item tooltip, and can be hidden using the hiding tag `hide_stew_behavior`.

## Changes
- Sugar Pots, Sweet Berry Pots and Glow Berry Pots are now stylised pots. This means they can have effects now.
- Updated most of the stew behavior system. All changes are documented [here](https://github.com/Fabricio20106/Variants/wiki/Exponential-Stews-(After-1.7.0%E2%80%90pre5)), in Variants' GitHub wiki.
- Poisoning pots (`StylisedPotItem`s) now can have their effects come from NBT.
  - If not available, it will fall back to the built-in type.
  - Pots that have effects on NBT will show it in their tooltips as *"Poisoning/Effect: \<effect with accurate color>"*, and the poisoning type will, for some reason, show up as *"404 Poisoning Not Found"*, instead of the built-in type.
  - The effect's `id` and `duration` are set by default on the creative tab.
- Poisoning pots now have translations.
  - If the poisoning type is null (which is sometimes is), it shows up as *"404 Poisoning Not Found"* (`poisoning_type.unregistered_sadface`).

### Technical Changes
- Debug Arrow dispense behavior is now a separate class (`DebugArrowDispenseBehavior`).

## Tags
- Added Bells to `#minecraft:guarded_by_piglins` block tag.
  - Added in the second commit (not yet out).