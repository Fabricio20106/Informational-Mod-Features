<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - June 12th, 2024 Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *01/03/2025*</div>

The **June 12th** update is a version for *Back Math* 1.8.0, released on June 12, 2024.[^1]

## Additions
### Entities
- The equipment of all mobs in *Back Math* that have it are now controlled by loot tables.
  - These loot tables are located at `data/backmath/loot_tables/equipment/`, which includes some subfolders for a few mobs, such as wanderer and warrior sophies, and Aljan zombies.
  - Because of some quirks of this system, there are some softlocks that can occur:
    - When teleporting into the Aljan, Aljan mobs spawning cause the game to softlock. This is an issue that won't be fixed for some time.
    - When using some loot tables, like *"bastion remnant treasure"*, the game may softlock because of the amount of items it gives.

## Removals
- Removed the item model for `grape_vines`.
- Removed the block textures for the grape vines.

## Changes
### Blocks
- The "no need to place another stand" log message is now only shown when the `logAljanTeleporterDebugging` config is enabled.
- Updated the base texture of insomnian tulips.
- The `insomnian_tulip_glow` texture is now called `insomnian_tulip_overlay`.
- Updated the model of queen lucy relics.
  - The gold plate texture is now the block of gold texture.
  - The crown texture is now the golden crown item texture.
  - Moved the texture to inside the `queen_lucy` folder.
  - Updated the UV and rotation of most model elements.
  - The particle texture of the bottom half is now the missing texture as it points to the wrong texture.

### Items
- Updated the texture of wanderer sophie spawn eggs.

### Entities
- Malaikas can no longer spawn with gold or chainmail armor. Instead, they spawn wearing archer fabricio gear.
- Sleepish skeletons now fire insomnia arrows instead of tipped arrows of blindness and poison.
- Warrior sophies no longer have armor or weapons due to a typo on their equipment loot tables.
- Termian patrollers no longer despawn if they're beyond 16.384 blocks away from the nearest player.
- Moved the textures for queen lucy into a subfolder called `queen_lucy`.
  - The default texture file is now called *"current.png"*.
  - Added a new *"alternate"* texture for queen lucy, which goes unused until *Back Math* [1.9.0.5](/Back%20Math/Changelogs/1.9.0.5%20Beta%20-%2028-01-25/Changelog%201.9.0.5.md).
- Updated the textures of most queen lucy pets.
  - Their hair now has shading.
  - The "brazil shirt" variant no longer has a hood.
  - Added a `qsp_sv_worker_b` texture.

#### Angry Sophies
- Now have the correct riding offset.
- Now use the correct sound events for splashing and swimming in water: `entity.termian.swim`, `entity.termian.splash` and `entity.termian.splash.high_speed`.

## Technical
### Changes
- When wanderer sophie variants are loaded from data packs, there's now an attempt to register them in the *Forge* registry.
  - This fails 100% of the time, as by the time the world is loading the registries have already been locked.
- The save folder for queen lucy pet variants is now `queen_lucy_pet_variant`, from `queen_sophie_pet_variant`.
- The texture location and display name fields of queen lucy pet variants are now read properly.
  - If the display name field isn't present, it will default to a string text component reading "No translation".
- Fixed some queen lucy pet variants pointing to the wrong texture files.
  - This affected the following variants: `alternate`, `sv_cyan_axolotl`, `sv_cyan_axolotl_2`, `sv_ender` and `sv_yellow_axolotl`.
- The loot tables for carving blocks are now located at `loot_tables/cutting/<block>` instead of `loot_tables/gameplay/blocks/cutting_<block>`.

### Removals
- Removed the `isChargingCrossbow()` and `setItemStackToSlot()` methods from the *ArcherLucia* class.

## Tags
### Additions
- Added `#melony:allowed_in_mainhand` item tag.
  - Contains `#melony:crossbows` and queen lucy summoner staves.
  - Items in this tag automatically go to the entity's mainhand when populating items from an equipment loot table.
- Added `#melony:allowed_in_offhand` item tag.
  - Contains `#backmath:squids`.
  - Items in this tag automatically go to the entity's offhand when populating items from an equipment loot table.

## References
[^1]: ["Data-Driven Mob Equipment & Variant Fixes"](https://github.com/Fabricio20106/Back-Math/commit/aba4ed0d01d06b1e182171ec7725aaadb834dbf9) (Commit `aba4ed0`) – GitHub, June 12, 2024.