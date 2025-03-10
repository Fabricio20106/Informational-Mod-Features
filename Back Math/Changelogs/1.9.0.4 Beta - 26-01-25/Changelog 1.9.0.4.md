<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.4 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *27/01/2025*</div>

**1.9.0.4** is the fourth version for *Back Math* 1.9.0, released on January 26, 2025.[^1][^2][^3]

This changelog doesn't have the full list of changes made to items because I'm too lazy to do that.

## Hotfix
- Removed the duplicate tooltip on Back Math's shields when Variants is loaded.

## Additions
### Blocks
- Added aljamic bones and sleepish skeleton skulls.
  - Sleepish skeleton skulls have emissive eyes like their mob counterpart.
- Added wanderer sophie heads.
  - All variants are available, including data-driven ones.
    - All of these show up on the creative menu, being controlled by a new config called `populateWandererSophieHeadVariants`.
    - The variant is shown on the item's tooltip. Variants that cannot spawn naturally are shown in a gold color.
  - Mining and "pick-blocking" these give the correct head variant.
  - This is saved to a tag called `variant` both on the item and block entity.
  - Currently, all Back Math mobs blown up by a charged creeper drop a head.

### Translations
- Added translation for the obsidian infused mid-term material on Silent Gear.
- Added translations for all wanderer sophie variants.
- Added translation for potion amplifier 64: LXIV.

## Changes
### Blocks
#### Heads
- Now render when on your hands and head.
- No longer pop off with flowing water.
- Are now placed properly on walls when targeting the side of a block.
- Now lower the visibility of the specific mob when wearing it.
  - Does not apply for the 3 new heads (added these before the new heads).
- All heads (except queen lucy's) now have uncommon rarity.

### Items
- Mid-term items now apply slowness for 5 seconds instead of 1.
- Mid-term armor setting mobs on fire is now controlled by item behaviors.
- Obsidian infused mid-term armor now has mid-term's durability bar color.
- Arrows shot by mid-term bows now apply the slowness effect.
- Jantic railguns now load when keeping holding down right-click (retroactive fix for [MC-165461](https://bugs.mojang.com/browse/MC-165461)).
- Jantic railguns now show tooltips from `super` (more specifically, from stone).
- Jantic railguns now render properly in first person.
- Skull banner patterns can now be crafted using aljamic bones and sleepish skeleton skulls.
- Milked butter swords dropped by Queen Lucy now have between **150** and **250** experience.
- Chestplates now render on your arm in first person.
  - This doesn't seem to work on dyeable armor like leather or wool for some reason.
- Bakugou armor and insomnia sophie sleepwear no longer gives any protection.
- Peace teas now give supercharged for 5 minutes.
- Bags no longer output a message in chat when the specified loot table is empty.
  - I removed the translation but forgot it's still used on the logs.
- The upgrade tooltip color of upgrade tokens is now gold instead of blue.
- The design tooltip color of queen lucy shirts is now light purple instead of blue.
- Aljame (and related foods) now give **3.5** saturation instead of 17.5.
- Descriptions where my old name (JuneTheWoods) is mentioned have been changed to "**isabellawoods**".

#### Outfits
- File locations can now look at all available mod ids (don't know if resource packs work yet).
- Are now invisible when the entity is invisible (translucent when the player is in spectator).
- The fully lit items tag now works with armor outfits.
  - These no longer break on players.
- No longer get a red tint when the entity takes damage.

### Entities
- The "ender" variant of wanderer sophies now has emissive eyes, for both the face and hoodie.
  - This layer currently renders on top of outfits.
- Archer lucias' inventories are now saved and read using Variants' stack handling.
- Player's capes are no longer offset when wearing outfits.
- Player's skin layers are now hidden when wearing outfits.
- Zombies, husks, drowned, piglins, piglin brutes and zombified piglins now render outfits.
- Aljan mobs' armor chance is now affected by regional difficulty again.
- Insomnia zombies and zombie fabricios' baby spawn chance is now controlled by Forge's `zombieBabyChance` config.

#### Queen Lucy Pets
- The "ender" variant now has emissive eyes on their hoodies.
  - Updated their texture so their hair is now purple, and some wing pixels are now black.
- Can now attack other queen lucy pets that are not your own.
  - They can no longer attack any entity that is owned by the player, like wolves or parrots.
  - The `#backmath:qlp_targets/disallowed` tag still works.
- Can now have their effects cleared by their owner.
  - Only milk buckets can be used as the method checks for the curative items. This check will be removed in the future.
  - When using it, a high-pitched version of the drinking sound is played, and the container item is given back to you.

### Translations
- **[Brazilian Portuguese]** Changed the word "viajantes" on wanderer sophie spawn eggs to "andarilhas".
- Moved the translation for the pink gum frying pan description to `tooltip.backmath.pink_gum_frying_pan`.

## Technical
### Additions
- Added **item behaviors**.
  - Item behaviors are a way to unify functionality between Back Math's items by making their behavior centralized.
  - This works by having a list of **item behavior effect types** (individual effects that this item has) which run when either hitting a mob (by default) or consuming the item.
  - Behaviors can also define more properties than just functionality:
    - If an item has an enchantment glint (which can be controlled by the `enchantment_glint_override` tag);
    - The item's durability bar color.
  - Most effect types have a tooltip to show what it does, like apply effects, ignite the entity, give an item, etc.
    - This is shown like Variants' effect tooltip, except that attributes are grouped together with the effects themselves.
- Added 2 new loot functions (these don't have any extra fields):
  - **Copy wanderer sophie variant**: Copies the wanderer sophie variant from a wanderer sophie (head) to the item;
  - **Increase dropped skulls**: Increases the amount of dropped heads for the charged creeper that exploded. This does not seem to work.
- Added Variants' tag tooltip for the development environment.

## Changes
- Renamed the class *Equippable* to *Swappable* and the method `swapWithEquipmentSlot` to `equipOrSwapItem`, to match Variants.
- When defining the tags `milked_sword_item` and `use_remainder` in the shortened form, the extended form is now written using Variants' stack handling.
- Renamed the tags `sparey_<strength|weakness|prohibition_weakness>_effect` to `<strength|weakness|prohibition_weakness>_effect`.
- The `patrol_target` tag of all termian patrollers is now an integer array instead of a compound with `X`, `Y` and `Z` tags.
- The `SophieType` tag from friend sophies (alpha wanderer sophies) is now converted to the new `variant` tag.
- Changed the order of the ids when converting entity variants:
  - The "worker" variant for queen lucy pets is now id 4;
  - Shifted the ids for wanderer sophies back to fill the gap between 10 and 12.

## Tags
### Additions
- Added `#backmath:can_cure_zombie_fabricios` item tag.
  - Contains jantiquified aljame and holy jantiquified aljame.
  - Items in this tag can be used to cure zombie fabricios.
- Added `#backmath:chestplate_mining_items` item tag.
  - Contains plateforced mid-term breastplates.
  - Items in this tag that can be worn on your chest increase your mining speed by 1.25 and harvest level to 3.
- Added `#melony:clears_mob_effects` item tag.
  - Contains `#forge:milk` item tag.
  - Items in this tag can be used to clear effects from queen lucy pets.
- Added `#backmath:railguns` item tag.
  - Contains jantic railguns.
  - Items in this tag are rendered like a crossbow when held in third and first person.

### Changes
- Added the 3 new heads to the `#forge:heads` item tag.
- Added milk buckets to the `#forge:milk` item tag.
- Added aljamic aljame juice and aljamic aljamic berry juice to the `#backmath:juices` item tag.
- Added jabuticaba jams to the `#backmath:jams` item tag.
- Added Cebolinhas's hair strand to the `#backmath:sophie_idea/aljamic_wars` item tag.

### Removals
- Removed jabuticabadas from the `#backmath:jams` item tag.
- Removed queen lucy pets from the `#backmath:qlp_targets/disallowed` entity type tag.

## References
[^1]: ["1.9.0.4 (I): Updated Heads & Bugfixing"](https://github.com/isabellawoods/Back-Math/commit/b926a9d5496dfc68bc3d8833c971f559f0389fea) (Commit `b926a9d`) – GitHub, January 23, 2025.
[^2]: ["1.9.0.4 (II): Item Behaviors & New Tags"](https://github.com/isabellawoods/Back-Math/commit/8e7f740f9f96616d8e06c7dc7fb35cafeca62058) (Commit `8e7f740`) – GitHub, January 26, 2025.
[^3]: ["Fix shield having duplicate tooltips with Variants"](https://github.com/isabellawoods/Back-Math/commit/b50091db31ee43827c77d9399e4aac4a5846a96a) (Commit: `b50091d`) – GitHub, January 26, 2025.