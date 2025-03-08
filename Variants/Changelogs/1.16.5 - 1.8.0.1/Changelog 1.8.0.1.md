<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.1 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *14/08/2024*</div>

**1.8.0.1** is the first version for [*Revaried 1.8.0*](/Variants/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on August 5, 2024.[^1]

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

### References
[^1]: ["1.8.0.1: Moved All Classes to "melonystudios.variants" Package"](https://github.com/Fabricio20106/Variants/commit/828fb4472e5b7f710f2bb2f49dc595fc24b8022e) (Commit `828fb44`) – GitHub, August 5, 2024.