<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Back Math - October 4th Update -</center>
### <center>A Back Math Update Changelog made on *05/10/2024*</center>

## Known Bugs
- Archer Lucias have no texture. This is fixed in the next commit.

## Additions
### Entities
- Added Collector Fabricios.
  - Collector Fabricios mostly roam around, killing whatever hostile mobs and collecting any wild crops they may find.
    - They always target the mob that hit them last, including the player. This makes them considered neutral mobs.
    - They have a slightly extended reach when attacking mobs.
    - Currently, they have no filter for who they'll attack, so they even attack player in creative or spectator.
  - They have 36 inventory slots. When they die, their entire inventory is dropped.
    - Their inventory is saved using Variants' stack saving.
  - They have a player-like food system. They only eat whenever their nutrition is below 6 or sometimes when they're in combat.
  - They can form groups of up to 4 collectors.
  - Can automatically open and close doors, like villagers or piglins.
  - They have a 75% chance of spawning with armor, and wear it from helmet to boots (as per [MC-182478](https://bugs.mojang.com/browse/MC-182478)). They also always have an aljameed blade.
    - Their armor can be jantskin, archer fabricio, aljameed, moonering and jantiquified moonering.
  - Most Aljan hostile mobs attack them.
  - They currently don't spawn naturally.

### World Generation
- Added `thick_grass_patch` configured feature, used in avondalic groves.
  - Generates grass and ferns in high quantities.

### Miscellaneous
- Added a work-in-progress Aljan texture update resource pack.
  > <center> <img src=https://raw.githubusercontent.com/Fabricio20106/Back-Math/refs/heads/main/src/main/resources/assets/backmath/resourcepacks/aljan_texture_update/pack.png width="128"> </center>
  >
  > *"Texture update for the Aljan. [Made on 29-9-24]"*
  >
  > <div style="text-align: right">
  >
  > \- `pack.mcmeta` Description</div>
  - This pack updates most textures in the Aljan. It also enables and disables the fog density and color.
  - Adds an eye layer for sleepish skeletons, so their eyes now glow.
    - They use an empty texture when the pack is disabled.

## Changes
### Blocks
- Aljamic grass blocks and avondalic nylium now have proper side textures when snowy.
  - Snowy models now use `block/cube_bottom_top` instead of `backmath:block/template_grass_block`.

### Items
- Effect jams now show the vanilla tooltip instead of an updated tooltip.
  - This is so it matches potion tooltips when Variants is loaded.
- Music discs that have SophiCreeper as author now show it as "SophiCreeper" instead of "Sophicreeper".
- Slightly updated the archer lucia armor texture.

### Entities
- Malaikas no longer spawn in the Aljan by default.
  - Their spawning is disabled when the Aljan texture update pack is enabled.
- Updated the textures of the *empresary 2*, *pajama*, *original* and *modified* variants of wanderer sophies.
  - The first one was fully updated, and the others were only to update the sleeves to slim.
- Most most that targeted shy fabricios now target collector fabricios as well.
- Shy fabricios now also look at collector fabricios.
- Aljamic bones now have their helmet and sword back, although without a loot table.
- Amaracamelers now target collector fabricios, and can also attack them and shy fabricios now.
- Amaracamelers now check for spawning in amaracamel sticks instead of swamps.

### Sounds
- Added `entity.fabricio.burp` sound event.
  - Used by collector fabricios when finishing eating.

### World Generation
- The Aljan dimension type now uses the proper dimension effects.
- Changed the temperature of aljan woods to **-0.5**, and the foliage color to #**E9F9F9**.
  - This means aljan woods is now snow-covered.

### Miscellaneous
- Updated the Aljan skybox.
  - The sun now uses the proper *"Aljan Sun"* texture.
  - Removed the Moon from the night sky.
  - Stars are supposed to generate, but somewhere in development they stopped appearing.
  - Now it "has ground". Don't quite know what it means.

## Technical Changes
### Items
- Items that give container items now read from a `use_remainder` tag.

### Entities
- Moved texture location of most Back Math entities.
  > Moved wanderer sophie textures to *"entity/sophie/wanderer/\*"*;

  > Moved insomnia sophie texture to *"entity/sophie/insomnia/\*"*;
  > - Added a separate texture for archer insomnia sophies.

  > Moved warrior sophie texture to *"entity/sophie/warrior_sophie.png"*;

  > Moved angry sophie texture to *"entity/sophie/angry_sophie.png"*;

  > Moved archer and karate lucia textures to *"entity/lucia/\*"*;

  > Moved shy fabricio texture to *"entity/aljamic_member/shy_fabricio.png"*;

  > Moved insomnia arrow and jantic bolt textures to *"entity/projectiles/\*"*.

## Removals
### Blocks
- Removed textures for aljanwood, aljancap, insomnian and avondalic willow leaves, as those leaves use vanilla textures.

## Tags
### Additions
- Added `#backmath:collector_fabricios_can_pickup` item tag.
  - Contains rotten aljamic flesh, aljameed bones, sleepish bones, sticky amaracamel balls, pine jellies, aljamic onions, carameled wheat, carameled wheat seeds, aljameed ingots and aljamic bone helmets.
  - Items in this tag can be collected and are targeted for pickup by collector fabricios.
- Added `#backmath:fabricios_can_harvest` block tag.
  - Contains aljamic onions, wild aljamic onions, carameled wheat and wild carameled wheat.
  - Blocks in this tag can be harvested by Collector Fabricios.
- Added `#backmath:aljamic_member_targets` entity type tag.
  - Contains insomnia zombies, zombie fabricios, aljamic bones, sleepish skeletons, janticles, amaracamelers, malaikas, angry sophies, warrior sophies, insomnia sophies, archer insomnia sophies, archer lucias and Queen Lucy.
  - Entities in this tag are automatically targeted by Aljamic Empire members (only Collector Fabricios currently).
- Added `#backmath:amaracameler_targets` entity type tags.
  - Contains iron golems, collector and shy fabricios.
  - Entities in this tag can take damage from amaracamelers.

### Changes
- Added collector fabricios to `#backmath:devil_sparey_effectives`, `#backmath:qlp_targets/not_tamed`, `#backmath:shy_fabricios_friendlies` and `#backmath:fabricios` entity type tags.
- Added zoglins to `#backmath:qlp_targets/tamed`.

## Gallery
> <center> <img src=Screenshots/aljan_sky_daytime.png width="300"> </center>
>
> <center> The updated Aljan sky during daytime. </center>
----
> <center> <img src=Screenshots/aljan_sky_nighttime.png width="300"> </center>
>
> <center> The updated Aljan sky during nighttime. </center>
----
> <center> <img src=Screenshots/aljan_pack_in_menu.png width="300"> </center>
> <center>
>
> The *Aljan Texture Update* pack on the resource pack selection screen. </center>