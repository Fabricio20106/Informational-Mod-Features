<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - August 31st Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *07/09/2024*</div>

The **August 31st** update is a version for *Back Math* 1.8.0, released on August 31, 2024.[^1]

## Changes
### Blocks
- Cobbled Aljanstone (& related) no longer takes 5 years to mine (now have an assigned tool).
- Updated the model of the Crystalline Crystallizer.

#### Chocolate Naked Cakes
- Now have a comparator output of 15.
- Now have their bottom faces culled.

#### Aljan Portal Stands
- Now have a comparator output of 15 when filled.
- Now have their bottom face, top faces and top parts culled.

### Items
#### Jantic Railguns
- Now show the *super* tooltips. This means tooltips added by Variants now show up.
- Now take 2.5 seconds to load instead of 1.25.
- Firing speed is now always 3.15 when used by Archer Lucias.

### Mobs
- Aljan mobs no longer have armor or equipment.
  - This is part of a fix for the Aljan dimension softlocking the game whenever chunks are loaded.
- Baby Aljan zombie spawn changes are now hardcoded to 5% (will be reverted later).

### Technical Changes
- Tag fixes now check for the specific tag types.
- Removed the `aljan` configured surface builder from Back Math's data folder.

### Translation Changes (English)
- Removed translation keys for Aljan Portal Frames and Aljanwood Barrels.
- Renamed "Spy Sophie" to "Spy Enderphie", to match Brazilian Portuguese translation.
- The *"Empresary 2"* Queen Lucy Pet variant name no longer has an extra space at the end.
- Updated explosive blend poisoning effect jam name.

### Translation Changes (Brazilian Portuguese)
- Updated *a lot* of things. [Here](https://github.com/isabellawoods/Back-Math/blob/90799b0428fa513444e276d4cd38587b38bcebf7/src/main/resources/assets/backmath/lang/pt_br.json)'s the diff.

## References
[^1]: ["Fixed Aljan Crashes & Updated Crystalline Crystallizer Model"](https://github.com/isabellawoods/Back-Math/commit/90799b0428fa513444e276d4cd38587b38bcebf7) (Commit `90799b0`) – GitHub, August 31, 2024.