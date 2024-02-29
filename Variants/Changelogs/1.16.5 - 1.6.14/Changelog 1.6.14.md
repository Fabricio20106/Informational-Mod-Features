![Additions and Changes from 1.6.14](ChangelogPhoto.png)

# <center>- Variants - 1.6.14 -</center>
### <center>A Variants Release Changelog made on *06/12/2023*</center>

## Changes
- Fish (old cod) can now be obtained from fishing.
- Bowls and Sticks from loot table ```minecraft:gameplay/fishing/junk``` can now be any wood type from the Overworld.
- Renamed ![A](Assets/creeper_powder_pot_old.png)"Creeperpowder Pot" to ![A](Assets/creeper_powder_pot_new.png)"Explosive Blend Pot", and updated the texture accordingly.
  - This also applies to the poisoning effect icon (![A](Assets/creeper_powder_poisoning_old.png) --> ![A](Assets/creeper_powder_poisoning_new.png)).
- Trying to use Debug Bows in survival, adventure or spectator mode now shows a new tooltip: ```Cannot change block states in Survival/Adventure/Spectator Mode```.

## Tags
- Added ```#variants:catlike_tame_items``` item tag.
    - Contains Raw Cod, Raw Salmon and Raw Fish.
    - Determines what items can be used to tame Cats and "passify" Ocelots.
- Added ```variants:bowls/obtainable_through_fishing``` item tag
  - Contains Bowls and Oak, Spruce, Birch, Jungle, Acacia, Dark Oak and Painting Bowls.
- Added ```#variants:bowls/wooden``` item tag.
  - Contains all bowls above and Crimson, Warped and Enderwood Bowls.
- Added ```#forge:rods/obtainable_through_fishing``` item tag.
  - Contains Sticks and Oak, Spruce, Birch, Jungle, Acacia, Dark Oak and Painting Sticks.

## Bug Fixes
- Crimson and Warped Boats no longer turn into Painting Boats when reloading the world.
- Cauldrons no longer generate waterlogged in village houses and igloos.
  - They still generate waterlogged within some rooms in Woodland Mansions.
- Fixed a mixin-related crash that could occur on servers.