<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.2 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *09 and 10/11/2024*</div>

**1.9.0.2** is the second version for *Back Math* 1.9.0, released on December 5, 2024.[^1][^2][^3] 

## Additions
### Items
- Added outfits.
  - Outfits are essentially armor that renders on top of the entity's skin, just like a skin layer.
  - Only termians, aljans (?) and players can render outfits currently.
    - Mannequins will be added later as a substitute for armor stands.
  - Outfits can be either an item (which renders only one texture) or a tag (which renders all textures if they exist).
    - Currently, the only outfit that isn't an item is the termian guard outfit.
  - Vanilla's armor layer is not rendered when the armor piece is an outfit.
  - On Back Math's entities, the cape doesn't render offset, and their second skin layer is hidden depending on the armor piece (except for the hat layer).
    - If wearing a built-in outfit, all second skin layers (except the hat layer) are hidden.
  - Currently, the outfits are a bit unoptimized and, as such, may lag a lot when many entities have ouffits.
  - All of these items work as outfits:
    - Insomnia sophie sleepwear, bakugou armor, cat and dog tiaras, yellow karate headbands, and queen lucy's shirts.
    - The old textures of these armor pieces are now transparent.
  - Outfits also render on your first-person arm.
  - Updated the texture of the "alternate" queen lucy shirt.
  - Updated the texture of "current" queen lucy shirts to fix a gap in the arm.
- Added plateforced mid-term armor.
  - This new armor set is the mid-term armor set that's intended to use (pure mid-term armor would be unstable).
  - The armor has epic rarity and is fire resistant.
  - The armor is crafted using obsidian ingots and mid-term shards or nuggets. In total, 7 shards and 17 ingots are used in the recipe. It's also the first new item to have a recipe advancement attached to it (unlocked by obsidian ingots).
  - The breastplate allows you to mine blocks faster (0.25x, to be exact). May have forgotten to make it mine at the correct harvest level.

| Armor stats         | Helmet | Breastplate | Leggings | Boots |
|---------------------|--------|-------------|----------|-------|
| **Durability**      | 550    | 800         | 750      | 650   |
| **Armor**           | 6      | 9           | 8        | 6     |
| **Armor Toughness** | 4      | 4           | 4        | 4     |
| **Knockback Res.**  | 4.5    | 4.5         | 4.5      | 4.5   |

### Effects
- Added supercharged.
  - Supercharged is applied when activating a mid-term, lasting for 10 minutes.
  - It increases various attributes of entity:
    - **+10** Max Health, **+1.5** Attack Knockback, **+4** Attack Damage and **+50%** Movement Speed.
    - It's supposed to increase step height by 1 and produce warmterm and coldterm particles, but neither of these work.

### Particles
- Added warmterm and coldterm particles.
  - These particles are a copy of end rod particles, but with different textures.
  - The fade colors for these are **#FFAE00** for warmterm and **#0097B4** for coldterm.

### Sounds
- Added 2 mid-term activation and deactivation sounds: `backmath:item.mid_term.activate.ender_eye|beacon`, and `backmath:item.mid_term.deactivate.ender_eye|beacon`.
  - Both activation/deactivation sounds use one subtitle: *"Mid-Term activates"* and *"Mid-Term deactivates"*.

## Changes
### Blocks
- Aljan portal stands no longer produce jantical particles.
- Crystallizers:
  - No longer play the "gear equips" sound when giving items.
  - Now properly craft again.
  - Their crafting sound volume decrease is now in the `sounds.json` file instead of being hardcoded.
- Removed the duplicate 2/3 hillary ingot recipe from crystalline crystallizers.
- The eye of ender dispense behavior now splits the stack from the dispenser.
  - Now, the default eyes of ender now also have this behavior.
  - Accidentaly uses twice the amount of eyes to dispense one.
- Angry sophie, insomnia sophie, zombie fabricio and queen lucy heads now use block entity renderers instead of block models.
  - Queen lucy heads no longer have a crown, and zombie fabricio heads now render the hat layer.
  - The breaking particles is now soul sand, like all vanilla heads.
  - Heads don't render on the inventory for whatever reason.
  - Mobs can no longer pathfind through wall heads.
  - Wall heads are no longer waterlogged by default, and are now waterlogged when placed underwater.
  - All head block states and models are now empty and data generated.

### Items
- Mid-term can now be used to supercharge nearby players.
  - When used, the mid-term will play an activation sound, a 2 second cooldown is applied, and a 10 minute timer starts.
    - The durability bar is used to indicate how much time is left of the supercharge.
    - The (de)activation sound is an eye of ender popping and a high-pitched beacon (de)activating.
  - Nearby players will be saved to the item's NBT, and will be given the supercharged effect for 10 minutes (currently all players on the server).
  - When the timer ends, the mid-term will pop and play a deactivation sound.
  - The timer and connected players are shown on the tooltip.
  - The timer is saved to `supercharge_settings.duration`, and the connected players to `supercharge_settings.connected_players`.
    - The cooldown duration is saved to `consumable.cooldown` (save as Variants).
    - The duration is set to -1 when the supercharge timer finishes.
- Carewni now have extended block reach.
- Updated the recipe of carewni.
  - These are now crafted using hillary rods instead of mid-term rods.
  - The textures have been updated accordingly.
- Bags with custom loot tables now have the correct loot table when dispensed.
- Teas now apply the correct effects when they have custom NBT.
- Buckets now have their dispense behaviors again.
- Juices no longer consume two items when drinking.
- Milkllary, mid-term, obsidian infused mid-term and jantical crowns are now properly attached to the entity's head.
- Lowered the attack damage of mid-term tools from 43 (base damage) to 16.
- Lowered the enchantment value of mid-term tools from 36 to 17.
- Mid-term longswords now slow the entity holding it by 20%.
- Jantic railguns can now be repaired using moonering ingots.
- Jantic railguns' projectile tooltip is now gray.
- Updated the textures of queen lucy relics and "alternate" and "relic" queen lucy shirts.

### Entities
- Malaikas have been updated again:
  - Their hitboxes are now 0.7 x 2.4 (width x height);
  - They're now properly classified as monsters;
  - Are now 0.2x larger;
  - Their eye height is now 2.1.
- Added a string field called "**outfit**" that defines what outfit a termian or aljan should wear.
  - This is a resource location of the base name of the armor. Won't render anything if the tag is empty or null.
  - This string defaults to "".
  - For example, if *outfit* is `backmath:termian_guard`, the game will try to load `backmath:textures/models/outfit/termian_guard_<head|chest_classic/slim|legs|feet>`. If any of these don't exist, the game won't load it.
- Back Math's armor layer now supports fully lit armor items.
- Aljan monsters now use Back Math's armor layer.
- Slightly updated the textures of queen lucy and "empresary 2" wanderer sophie variant.
- Updated the texture of queen lucy's "alternate" variant.
- Back Math's boat names are now just "Boat".

### Translations
- The message for wanderer sophie/queen lucy pet variants being registered is no longer always pluralized.
- The message for a queen lucy speel being set is no longer written like an error.

### Miscellaneous
- Renamed the config `midTermGreatswordReachIncrease` to `midTermLongswordReachIncrease`.
- Added a new config for carewni reach increase: `carewniReachIncrease`.
  - Both of these configs above (now) default to 2.5.
- The configs for reach increase/decrease are now doubles instead of integers.
- The upper hemisphere of the Aljan sky has been lowered back to normal (16).

## Removals
- Removed the changelog files from `assets/backmath/changelogs`.
- Removed the files from `assets/backmath/texts`.
- Removed the *"recipe_groups.txt"* file.

## *"Aljan Texture Update"* Pack
### Additions
- Added an updated texture for the insomnia arrow model.

### Changes
- Updated the texture for the insomnia arrow item.

## Technical
### Changes
- Changed the development version to `melony-studios-dev/back-math`.

## Tags
### Additions
- Added `#backmath:queen_lucy_pet_preferred_blocks` block tag.
  - Contains nothing.
  - Blocks in this tag are preferred by queen lucy pets to land on. Contained *LeavesBlock* and `#minecraft:logs` prior to this change.
- Added `#backmath:extended_entity_reach` item tag.
  - Contains mid-term longsword and carewni.
  - Items in this tag don't do anything, as its functionality was removed during development.
- Added `#backmath:jantic_railgun_projectiles` item tag.
  - Contains janticals.
  - Items in this tag can be used as ammo for jantic railguns in survival mode.
- Added `#backmath:jantic_railgun_not_applicable` enchantment tag.
  - Contains quick charge, piercing and multishot.
  - Enchantments in this tag cannot be applied to jantic railguns (not like any of these worked anyways).

### Changes
- Added all (obsidian infused) mid-term blocks to `#backmath:fully_lit_items` item tag.
- Added plateforced mid-term boots to `#forge:armors/boots`.
- Renamed the item tag `#backmath:pickup_disallowed_predicate/chicken_jockey` to `#backmath:chicken_jockey_cannot_pickup`.

## References
[^1]: ["Outfit Models & Mid-Term Supercharging"](https://github.com/isabellawoods/Back-Math/commit/e6425ac799b1c9bb6fedb2630723ce835067e6a7) (Commit `e6425ac`) – GitHub, November 17, 2024.
[^2]: ["1.9.0.2 (II): Built-In Outfits"](https://github.com/isabellawoods/Back-Math/commit/d8a3c7f38bb4fce6195a421f9887cb45a2c84889) (Commit `d8a3c7f`) – GitHub, November 30, 2024.
[^3]: ["1.9.0.2 (II): Head Rendering & Plateforced Armor"](https://github.com/isabellawoods/Back-Math/commit/bf96adb8279ea9fcd3a89b45142d7eb2f71cc876) (Commit `bf96adb`) – GitHub, December 5, 2024.