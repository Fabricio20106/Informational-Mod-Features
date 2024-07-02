<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Variants - 1.7.0 Release Candidate 1 -</center>
### <center>A Variants Release Changelog made on *01/07/2024*</center>

## Additions
- All armors and Elytra can now be swapped by right-clicking (same as in recent versions).
- Shift-right-clicking a Spawner with an empty Minecart now places the spawner into it.
  - This plays the block breaking sound and particles.
  - Only blocks in the `#variants:spawners` block tag can be picked up.
  - Only data related to the spawner is stored into the minecart's `spawn_data` tag.
  - Adds to the new *"Spawners Picked Up in Minecarts"* stat.
- Breaking Spawner Minecarts now places its spawner when broken (see config below).
- Added 3 new configs.
  - `populateSpawnerMinecartsInTabs` controls whether or not the creative tabs should add a Spawner Minecart for every mob in the game (excluding the player and fishing bobbers). Defaults to `false`.
  - `placeSpawnerWhenBreakingMinecart` controls whether or not breaking Spawner Minecarts will place the spawner (if possible) or just drop it as an item. Defaults to `true`.
  - `defaultSpyglassZoomLevel` controls how much a Spyglass should zoom in. Defaults to `5`.
- Sugar Pots now show up as being able to provide *"Sugar Pot Speed"* in JEED.

## Fixes
- Items in the player's hands now render again.
- The word *"Unknown"* in Firework Rockets is now dark gray again.
- Dispensers now look proper again.
  - Droppers now also rotate and face like Dispensers.
- Explosive Blend Poisoning name is now translated again.
- Explosive Blend Pots now show up applying its poisoning effect in JEED again.

## Changes
- Spyglasses now render 2D in the inventory and ground, and 3D on the player's hands.
- Spyglasses' zoom level is now controlled by a config.
- Spawner Minecarts' name is now *"Minecart with \<Mob> Spawner"* when it has a mob.
  - More specifically, if its `spawn_data.SpawnData.id` tag isn't null.
- Spawner Minecarts now render the mob inside (only pigs right now).
- Spawner Minecarts, when placed, now load the spawner data from from the `spawn_data` tag.
- Colors in Firework Rocket tooltips is now the beacon beam color instead of the text color.
- Compatiblity items, Wool Sweaters, Exponential Stews and Poisoning Pots now render their tooltip after the *"Hold \<Alt> for NBT"* tooltip.
- Filled Maps now render the *"Hold \<Alt> for NBT"* tooltip.
- Renamed advancement "Not *Really* Implemented" to "Portable Mob Spawning™", due to Spawner pickup now being a feature.
- Renamed advancement "Functionality Not Included!" to "Functionality Included!", due to Spyglasses now working.

### Technical Changes
- Renamed template item model `template_spyglass` to `template_spyglass_in_hand`.

## Tags
- Added `#variants:spawners` block tag.
  - Contains Spawners.
  - Blocks in this tag can be picked up by shift-right-clicking it with a Minecart.
- Added `#variants:spawner_minecart_cannot_replace` block tag.
  - Contains Bedrock, all Command Blocks, Structure Blocks, Jigsaws, Barriers, Moving Pistons, End Portal (Frames), Gateways, Nether Portals and Spawners.
  - Blocks in this tag cannot be destroyed by Spawner Minecarts when they are broken. Instead, they drop as an item.