<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.3 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *17/01/2025*</div>

## Additions
### Blocks
- Added aljanwood, aljancap, insomnian and avondalic willow barrels.
  - Works like their vanilla counterparts.
  - Aljanwood and aljancap barrels use the updated wood palette by default.
  - Their inventory tag is written is lowercase (`items`).
    - Item stacks are saved using Variants' stack handling.
    - The `Slot` byte tag is written in lowercase (`slot`) and an integer.

### Particles
- Added hillary flame particles.
  - These are meant to show on hillary torches, but Minecraft is ✨*quirky*✨ is registry order breaks this.

### Miscellaneous
- Tabu, hillaried stone, aljanstone, sleepingstone and obsidian infused mid-term are now usable in Silent Gear.
  - The four stone types mostly just copy the properties of vanilla stone.
  - Obsidian infused mid-term has no translation because I forgot.
- Added recipe advancements for the aljancap and insomnian doors and trapdoors.

## Changes
### Blocks
- The model of insomnian tulips is now data-generated.
- Red yellow concrete powder, aljamic sand and aljamic dirt paths are now mined faster by shovels.
- Insogravel now drops when mined by hand.
- The following blocks now drop when broken:
  - Aljamic farmland (drops aljamic dirt);
  - Aljanstone walls;
  - Charjan (wall) torches;
  - Blocks of milkllary;
  - Mossy angelic brick stairs;
  - Sleepyshrooms;
  - Zombie fabricio (wall) heads;
- Mobs now (should) avoid walking through poison roses.
- Back Math's ores now show how much experience it drops on a tooltip *(Variants only)*.
- Back Math's stained glass (panes) color tooltip is no longer entirely colored *(Variants only)*.
  - This is now hidden when advanced tooltips is off.

### Items
- Dispensing eyes of ender will now make a new stack instead of splitting the current stack (which potentially consumed 2 eyes).
- The outfit layer class is now unified between Back Math mobs and players.
- Golden halos can now be crafted with 4 golden nuggets in a "+" shape.
- The Back Guide now goes into the `backmath.main` tab.
- Mid-term tools are now repaired using any `#backmath:mid_term_materials`.
- Obsidian infused mid-term tools are now repaired using any `#backmath:oimt_materials`.
- The protection of obsidian infused mid-term breastplates and leggings have been swapped.

### Entities
- Queen lucy pets now prefer looking at each other than at players or randomly.
- Archer lucias can now pick up and wear mid-term armor, queen lucy shirts and pastel turtle shells.<sup>*[verify if this was true before this]*</sup>
- Collector and shy fabricios now try to not walk over poison rose.
- Collector fabricios now have to be closer to break crops.
- Termians now have the *Minecraft Experience* and *Mojang Office* capes.

## Structures
- Fabricio hideout dungeons no longer generate in the Aljan (for real this time).
  - Trying to `/locate` it will freeze the server.
- Hideout dungeons now properly check the top block to see if it can generate (conditions being no liquids and not bedrock).
- Sophie towers can now only spawn in biomes it can generate (back field biomes).

## Particles
- Warmterm and coldterm particles are now fully bright.

## Miscellaneous
- `/weather` and sleeping now works in custom dimensions.
- The Aljan sun is now hidden when it starts raining.
- When entering the Aljan with *Traveler's Titles*, the dimension's name is now properly shown.
- Updated Back Math's materials in Silent Gear.
  - Removed empty `silentgear:_highlight` sections (why did I even leave them empty in the first place?).
  - Added and removed traits for some materials, and updated stats.
    - Hardened amaracamel now has **Malleable III** instead of **Brittle II**.
    - Mid-term now has **Light I** instead if **III**.
  - Updated the colors of some materials.
  - Removed newlines from the end of the file.
  - Materials are now properly classified.

## Technical
### Changes
- Back Math's loot modifiers are now data-generated.
- The `chance` field of the "add to table" modifier is now a double.

## Tags
### Additions
- Added `#backmath:outfits` item tag.
  - Contains plateforced mid-term armor, bakugou armor, insomnia sophie sleepwear blouse and pants, the three queen lucy shirts, cat and dog tiaras and yellow karate headbands.
  - Items in this tag, if an instance of *ArmorItem*, are rendered as outfits on players and Back Math's mobs.

### Changes
- Added the new barrels to `#forge:barrels/wooden` block and item tags.
- Added the new barrels to `#melony:barrels` and `#minecraft:guarded_by_piglins` block tags.
- Renamed the `#backmath:aljan_teleporter_replaceables` block tag to `#backmath:aljan_teleporter_passthrough`.
  - Added `#minecraft:leaves` block tag to this tag.
- The item tags `#create:upright_on_belt`, `#create:crushed_ores` and `#tconstruct:anvil_metal` are now data-generated.