<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.6 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *04/03/2025*</div>

**1.9.0.6** is the sixth version for *Back Math* 1.9.0, released on March 4, 2025.[^1]

## Additions
### Blocks
- Added crates.
  - Crates serve as an early-game version of shulker boxes, being able to be carried around with all its items.
  - These can be crafted using two string and a composter in a "V" shape.
  - These have essentially the same properties as planks.
  - Placed crates can be picked up using shift-right-click, using this will automatically put it in your chestplate slot, or your hand it it's occupied.
  - Crates on your inventory inflict Slowness III for 1 second, unless there's a crate in your chestplate slot.
  - Crates render on your back, and come with a simple chest strap to make it look like you're carrying it.
  - Filled crates show a tooltip like the shulker box, but updated.
    - The crate's tooltip has the ability to show all items by holding shift.
  - Crates cannot be put inside other crates or shulker boxes.
    - Shulker boxes cannot be put into crates either.
  - These use *Revaried*'s stack handling to save and load items.

### Entities
- All termians, collector alcalytes, and angry sophies can now have breasts.
  - The size of their bust is controlled by a new tag called `bust_size`.
  - Their bust size is randomized when they spawn.
  - Breasts can have outfits rendered on top of them, but there's a lot of Z-fighting that occurs.
  - Their breasts are only rendered if the `renderBreasts` config is set to `true` and the *Female Gender Mod* is loaded.

### Statistics
- Added the **"Crates Opened"** statistics.

## Changes
### Items
- Plateforced mid-term armor now has an emissive layer.
  - This is defined by its outfit definition.
  - The items, however, don't have it.
- Fixed a single floating pixel on the plateforced mid-term leggings outfit model.
- Dyed outfit items will now show its colors when worn.
  - This doesn't apply to outfits being rendered on your first-person arm.
- Karate headbands can now be dyed.
  - Updated the item and outfit textures to be white.
  - Karate lucia's karate headbands are still yellow.
  - Renamed to "Karate Headband".
  - Their default color is **#FED83D**.
  - Are now repaired and crafted using any `#minecraft:wool`.
    - The recipe advancement now requires both wool and string.
  - Renamed the texture file to `karate_headband_head.png`.
- Most items related to "fabricio" or "aljamic member" is now called "alcalyte".

### Entities
- Angry sophies now have a 60% chance of spawning wearing a crate.
  - Crates used by them will use the `gameplay/angry_sophie_crate` loot table.
  - The items the crate can have are: aljame, aljame birch saplings and amaracamel batter/(turtle) fried egg bags.
- Karate lucias can now spawn as termian patrollers and with different capes.
- The `fabricio_conversion_ticks` integer tag of zombie fabricios is now called `shy_alcalyte_conversion_ticks`.
  - This tag is automatically renamed upon loading the entity.

#### Termians
- Termians can now be in different poses, with their hitbox updating accordingly.
  - The conditions to be in these different poses are the same as the player's.
  - They, however, don't get any movement debuffs from crawling or crouching, moving at the same speed as regular walking.
  - Shoving them against a block with air under causes them to enter the crawling position.
  - They can now swim towards their target (still kind of broken as of this update).
- Their capes are now hidden when they're wearing crates.

#### Alcalytes
- All fabricios/aljamic members are now called "alcalytes".
  - This includes all translations, classes, and sound registries.
- Moved the textures of all alcalytes to the `alcalyte` folder, and renamed the textures.

#### Wanderer Sophies
- Wanderer sophies now have a 50% chance of spawning wearing a crate instead of their chestplate.
  - Crates used by them will use the `gameplay/wanderer_sophie_crate` loot table.
  - The items the crate can have are: apples, guaranas, mangoes, oranges, guavas, jabuticabas, any `#backmath:crate_fruit_saplings`, sticks and amaracamel batter/(turtle) fried egg bags.
- Wanderer sophies can now look at each other.

#### Queen Lucy Pets
- Can now have their effects cleared using any item inside the `#melony:clears_mob_effects` tag, instead of only milk buckets.
- Now tilt their bodies when flying with elytra.
- They now bob their arms when idle.

### Sounds
- Changes the ids of all sounds with "fabricio" in their name to "alcalyte".
  - This includes all subtitles too.

### Miscellaneous
- The "anger dungeon" feature is now registered (not sure if it helps with anything).
- Changed the changelog location from the mod's description to point at the *Informational Mod Features*'s *Back Math* changelogs page, which can be found [here](https://github.com/Fabricio20106/Informational-Mod-Features/tree/main/Back%20Math/Changelogs).

## Technical
### Additions
- Added the `crate` outfit definition.
- Added the `/backmath-spawn_queen_lucies` debug command.
  - Spawns all queen lucy variants in a line, like the other two commands.
- Added the `color` integer field to outfit slots.
  - This controls the color applied to this slot. This overrides any colors provided by the item.
- Added a new loot function: **Set Crate Contents** (`set_crate_contents`)
  - Loads all the provided loot entries into the crate item. This copy of *"set contents"* was made to make it load using *Revaried*'s stack handling.

### Changes
- Renamed the `karate_band` outfit definition to `karate_headband`.
- Outfit textures return an null when the given asset id is `minecraft:`.
- The loot modifiers provider now has a name: *"Back Math - Loot Modifiers"*.
- The *Back Math* config file is now located inside the `melonystudios` subfolder.
  - All my other mods' configs are going to be moved here for consistency.
- Renamed the `shyFabricioSpawn` config to `shyAlcalyteSpawn`.
- Added the `renderBreasts` config.
  - When enabled, and if *Female Gender Mod* is installed, *Back Math* mobs can have breasts.
  - Breasts are also rendered if the game version is set to `melony-studios-dev`.
- The logger used by the *QueenLucyEntity* class is no longer from the *Entity* class.

### Code Refactors
- Most classes, packages, methods and fields that were related to "fabricios" or "aljamic members" are now called "alcalytes".

## Tags
### Additions
- Added `#backmath:crates` item tag.
  - Contains crates.
  - Items in this tag:
    - When being worn by wanderer and angry sophies, have a 50% chance to be dropped;
    - The `backmath:crate` outfit definition is choosen for outfits and breasts if this isn't an armor item;
    - Capes are automatically hidden when these are in your chest slot;
    - Cannot be put inside crates and shulker boxes;
    - Are automatically outfits, as this tag is included inside `#backmath:outfits`.
- Added `#backmath:crate_fruit_saplings` item tag.
  - Contains guarana oak, mango oak, lemon oak, orange oak, guava and jabuticaba saplings.
  - Items in this tag are used by the `gameplay/wanderer_sophie_crate` loot table, used for wanderer sophie's equipment.

### Changes
- Renamed the following tags:
  - `aljamic_member_targets` entity type tag: `alcalyte_targets`;
  - `fabricios` entity type tag: `alcalytes`;
  - `shy_fabricio_friendlies` entity type tag: `shy_alcalyte_friendlies`;
  - `collector_fabricio_can_pickup` item tag: `collector_alcalyte_can_pickup`;
  - `shy_fabricio_tempt_items` item tag: `shy_alcalyte_tempt_items`;
- The `#backmath:fabricios` entity type tag inside `#backmath:player_like` is now `#backmath:alcalytes`.
- Added mid-term dust and obsidian infused mid-term dust to the `#backmath:fully_lit_items` item tag.
- Added the `#backmath:crates` item tag to the `#backmath:outfits` item tag.
- Added crates to the `#minecraft:guarded_by_piglins` block tag.
- Added aljame birch leaves to the `#minecraft:leaves` block and item tags.

## References
[^1]: ["1.9.0.6: Crates & Emissive/Dyeable Outfits"](https://github.com/isabellawoods/Back-Math/commit/0daac53321ff6ad1490e687ed7c62be5230ee5b5) (Commit `0daac53`) – GitHub, March 6, 2024.