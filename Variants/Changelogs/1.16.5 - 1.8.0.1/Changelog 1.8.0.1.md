<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Variants - 1.8.0.1 -</center>
### <center>A Variants Release Changelog made on *14/08/2024*</center>

## Additions
- Added a new `showFoodEffects` config.
  - Controls whether foods that apply effects show it in their tooltip.
  - Defaults to `true`.

### Technical Changes
- Moved all of Variants' classes from `com.junethewoods.variants` to `melonystudios.variants`.
  - Moved the stew behavior package from `item.custom.stew` to `stew` (on the top-most package).
  - Moved all damage source-related classes to packages inside `util.damage`.
    - Moved the *DamageSourceSerializer* class inside the *DamageSourceUtils* class, and renamed it to just *Serializer*.
- Separated all tag classes inside *VSTags* into ***VSItemTags***, ***VSBlockTags***, ***VSFluidTags*** and ***VSEntityTypeTags***.
- Moved the tag type fields from *NBTUtils* to *Constants.TagTypes*.
  - Renamed `WILDCARD` field (99) to `ANY_NUMERIC`.
- Removed the *Orientation* block state property class, as it already exists in vanilla as *JigsawOrientation*.
  - This does not change anything in-game (as far as I'm aware).
- The *"Set Stew Effect"* loot function no longer prints a debug line.