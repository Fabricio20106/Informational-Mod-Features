<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.5 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *28/02/2025*</div>

## Additions
### Entities
- Added a "piglin brute" wanderer sophie variant.
  - Its texture is a termian in a piglin brute's clothes.

### Advancements
- Added a new advancement: **"Hey, Catch!"**: *Shoot a jantic railgun.*
  - This is a goal advancement, its parent is "Aaahh!", it grants 50 experience, and its icon is a jantic railgun.

## Removals
- Removed the *"Item Tree"* advacement category.
  - Personally, I think it was pretty useless, plus it wasn't up-to-date and needed to have proper translations for everything, so I figured it was better to remove it altogether.
- Temporarily removed jantical, warmterm, coldterm and hillary flame particles.
  - They were causing way too frequent and inconsistent crashes, so I'll remove them until I can get them working reliably.
- Removed effect jam translations for *Revaried*'s poisoning effects.
- Removed the textures of golden pots, guarana bush seeds, grape vine seeds and liquid guarana, mango, grape and lemon buckets.

## Changes
### Blocks
- Queen lucy heads can now have variants.
  - These are rendered the same way as wanderer sophie heads, including the emissiveness.
  - The gold-colored tooltip of relic variant heads is hardcoded.
  - Each queen lucy variant has its own head in the creative menu, with its appearance being controlled by the `populateQueenLucyHeadVariants` config (defaulting to `true`).
- Fixed the incorrect mirroring on queen lucy pet relics.
  - All model elements are now named and in groups when loaded in *Blockbench*.
- Updated the guarana oak, mango oak, mangaed mango oak, lemon oak, orange oak, banana jungle and aljame birch leaves.
  - These leaves now have fruits growing on them on each side of the block (except up).
  - Each side can be right-clicked to harvest the fruit, pulling the items from a `picking` loot table.
  - The base model is now the respective leaf block, with another model being applied on top.
  - Updated the textures of most fruits to fill the whole block.
    - The texture is based on the resin clump.
  - The loot tables of these leaves now drop 1 fruit per side with fruit, with the maximum being 5.
- Updated the textures of all guava wood blocks.
  - Only exception are the guava tools, knives and mortar and pestle.
  - The border between the top and bottom textures of guava doors now match.

### Items
- Golden halos are now fully lit like mid-term.
- Carewni's inventory icon now cycles through the colors of the rainbow like its handheld counterpart.

### Entities
- Collector fabricios now have an interval of 10 ticks before they can attack entities again.
- Back Math's swords now apply their effects on you when a Termian hits you with them.
- Updated the following textures:
  - *Shy fabricio*: fixed the shoes and blouse to be in the correct rotation;
  - *"Blue Axolotl" wanderer sophie*: fixed the incorrectly colored sole on the right leg;
  - *"Witcher" wanderer sophie*: removed a singular pixel on the left arm overlay.
  - *"Alternate" queen lucy*: made their fringe a bit longer;
  - *"Entrepreneur" wanderer sophie*: a curve on the back of the blouse is now a straight line;
  - *"Worker" wanderer sophie*: added some detailing to the shoes on the second skin layer;
  - *"Ender" queen lucy pet*: the wings are now emissive as well;

#### Queen Lucy
- Added queen lucy variants.
  - Currently, there are 3 variants: Current, Alternate and Relic. Any of these can spawn randomly.
  - The relic variant's entire texture is fully bright.
- The current and alternate variants (now) have glowing eyes.
  - Queen lucy's eyes are (kind of) meant to match the mid-term, as they carry the summoner staff. So now their eyes glow like mid-term.
- Queen lucy's shirt drop is now controlled by which variant it has.
  - If it's a new variant, a shirt won't drop by default.
- Queen lucy's spell tag no longer prints an error if it's empty.
  - An empty tag now defaults to no spell.

#### Queen Lucy Pet
- Data-driven queen lucy pet variants can now naturally spawn.
- Data-driven variants are now properly loaded.
- Queen lucy pets now reset their anger towards a target after some time.
- Updated the textures of all queen lucy pet variants to match the new wanderer sophie textures.
  - Renamed all the texture files to match the variant asset ids.
- The "Relic", "Empresary2", "Entrepreneur" and "Savannah" variants now have emissive textures.
  - The "Ender" variant now uses the data-driven system for its emissive texture.

#### Wanderer Sophie
- The "Empresary2", "Entrepreneur" and "Savannah" variants now have emissive textures.
  - The "Ender" variant now uses the data-driven system for its emissive texture.

### World Generation
- Most fruit trees are now a mix between their regular leaves and fruit leaves.
  - More specifically, it's 70% fruit leaves and 30% normal leaves.
- Guarana oak trees now use the "bush" leaf decorator.
  - The length of the trunk has now shrunk to 1-3 blocks.

### Translations
- The "file not found" error message when data-generating termian variants is now translatable: `error.backmath.<mob_type>_variant.no_texture`.
- The "failed to load variant from NBT" error message is now translatable: `error.backmath.<mob_type>_variant.load_error`.
- Changed the word "*LightBakedModel*" in the "replacement attempt" error to "*FullbrightModel*", to match the class name.
- The words "wanderer sophie" and "queen lucy pet" are now in lowercase across all related error messages.
  - There is, however, an inconsistent "queen lucy" capitalization that slipped (the "load from NBT" error).
- **[Bra. Portuguese]** The words "sophie andarilha" and "rainha lucy pet" are now properly capitalized and pluralized across all related error messages.
- The translation of the "Round 6" variant of wanderer sophies is now "Squid Game" in English.
- **[Bra. Portuguese]** The word "Fabrícios" in the hideout dungeon location message is now lowercase.
- **[Bra. Portuguese]** Fixed a typo in the "Aaahh!" advancement description.

### Advancements
- The background textures for the advancement roots are now separate textures:
  - `backmath:textures/gui/advancement_backgrounds/main.png`;
  - `backmath:textures/gui/advancement_backgrounds/backmath_foods.png`;
  - `backmath:textures/gui/advancement_backgrounds/the_aljan.png`.

## Technical
### Additions
- Readded the "empty loot table" translation for bag items.
- Added **outfit definitions** to data packs.
  > *Documentation: [**Outfit Definition**](/Back%20Math/Docs/Outfit%20Definition.md)*
  - Outfit definitions replace the hardcoded and (maybe) inconsistent method of finding the proper textures for outfits. This fixes it by providing each texture separately.
  - Each files can have a `head`, `chest`, `legs` and `feet` objects to define each texture. These fields are called **outfit slots**.
  - An `emissive_texture` field exists for making a part of the outfit fully lit, but it wasn't implemented.
  - This is part of data packs because I couldn't figure out how to make it work on resource packs.
- Added **queen lucy variant defintions**.
  > *Documentation: [**Queen Lucy Variant**](/Back%20Math/Docs/Queen%20Lucy%20Variant.md)*
  - Queen lucy variants work exactly like other variant definitions, having an `asset_id`, `texture_location` and `emissive_texture` fields.
  - The diference is that these variants have a `bossbar_information` field that defines the bossbar that is shown.
    - This is an optional field, but when defined a `name` field (a text component) is required due to the way it works currently.
  - Queen lucy variants also come with a *Forge* registry, and a tag folder at `tags/queen_lucy_variant`.
- Added a new loot function: **Copy Queen Lucy Variant** (`copy_queen_lucy_variant`)
  - Copies a queen lucy variant from a queen lucy or queen lucy head to the item stack.
- Added loot tables for picking fruits at `loot_tables/picking/`.
  - This includes grapes, even though it doesn't seem to work properly.

### Changes
- Added an `emissive_texture` field to wanderer sophie and queen lucy pet variants.
  - This optional field defines a texture to use for fully lit areas in the texture.
  - This is a resource location without the `textures/` prefix and `.png` suffix.
- The `slim_arms` and `spawns_naturally` fields of wanderer sophie variants are now optional.
  - Now they're only written when they're set to `false`.
- Updated *Revaried*'s stack handling methods to 1.8.0.9.
  - The `components` tag has been renamed to `tags`, and is properly converted to the new tag.
  - The stack tag is now always verified even if the `components` or `tags` field isn't present.

## Tags
### Changes
- Added golden halos to `#backmath:fully_lit_items` item tag.
- Added orange oak and banana jungle leaves to `#minecraft:leaves` block and item tags.
- Replaced jantic railguns in the `#melony:crossbows` item tag with `#backmath:railguns`.

### Removals
- Removed the `#backmath:extended_entity_reach` item tag.