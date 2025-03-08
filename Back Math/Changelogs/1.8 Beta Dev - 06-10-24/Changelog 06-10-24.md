<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - October 6th Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *19/10/2024*</div>

The **October 6th** update is a version for *Back Math* 1.8.0, released on October 6, 2024.[^1]

## Known Bugs
- The Aljan nighttime fog also applies during daytime.

## Additions
### Blocks
- Aljanstone-related blocks now have pickaxes as an assigned tool.
- Aljanstone bricks can now be crafted from aljanstone in a stonecutter.

### Entities
- Added *"farmer"* variant for wanderer sophies.

### World Generation
- Added super large caves to the Aljan.
  - These caves can go from the surface to lava-level easily.
  - Are rarer than ravines (1% compared to ravines' 2%).

### Miscellaneous
- The Aljan sky now has two hemispheres, like the Overworld.
  - The lower hemisphere is where the fog color is applied.
- Stars now render in the Aljan sky again.

## Changes
### Blocks
- Insomnia sophie heads now use the head model with the hood layer.

### Items
- Back Math's buckets now place down fluids again.
- Knives can now be used in crafting recipes properly again.
- Updated textures for:
  - Angry sophie spawn eggs;
  - (Archer) insomnia sophie spawn eggs;
  - Insomnia sophie sleepwear blouse, pants and model;
  - Archer lucia armor model.

### Entities
- Archer lucias now drop their inventory when killed.
- Queen lucy pets now null-check when making the entity name.
- Angry and (archer) insomnia sophies now have new textures.
  - They now also have slim arms.
- Collector fabricios' swords are now chosen based on their armor.
  - If they have no armor, an aljanstone knife is chosen.
- Collector fabricios no longer target invulnerable entities or creative/spectator players.
- Insomnia zombies and zombie fabricios no longer target shy fabricios separately (twice).
- Sleepish Skeletons no longer target shy fabricios separately.

## Technical
### Additions
- Added **5** new configs:
  - **"enableAljanLargeCaves"**: Enables/disables generation of large caves in the Aljan. Defaults to `true`;
  - **"aljamicMembersArmorChance"**: the chance of Aljamic Empire members (currently only collector fabricios) spawning with armor. Defaults to `0.75` ou 75%;
  - **"enableAljanFog"**: Enables/disables the fog in the Aljan. Defaults to `true`;
  - **"aljanFogDensity"**: How dense the fog in the Aljan should be. Defaults to `0.02`;
  - **"changeAljanFogColorAtNight"**: Whether to transition the fog in the Aljan to purple during the nighttime. Defaults to `true`.

### Changes
- Added `asset_id` string field for **wanderer sophie** and **queen lucy pet variant** definitions.
  - This is now used to validate new variants, instead of the old Forge registry-based method.
  - This means the temporary *"efe"* variant now works.
  - Data-driven variants currently don't spawn naturally.
- Collector fabricios now separately reads the `CanPickUpLoot` tag.
- Renamed model templates for mob heads:
  - `template_bm_head_ground` to `template_head`;
  - `template_bm_wall_head` to `template_wall_head`;
  - `template_bm_head_ground_no_overlay` to `template_head_no_overlay`;
  - `template_bm_wall_head_no_overlay` to `template_wall_head_no_overlay`.
- Added a temporary test model for insomnian tulips: `insomnian_tulip_test`.

## Tags
### Changes
- Removed non-wild aljamic onions and carameled wheat from `#backmath:fabricios_can_harvest` block tag.

## References
[^1]: ["Sky Updates, Texture Updates & Data-Driven Variants"](https://github.com/Fabricio20106/Back-Math/commit/fb2babd68f6a34ff606e991305357e918fed9a2b) (Commit `fb2babd`) – GitHub, October 6, 2024.