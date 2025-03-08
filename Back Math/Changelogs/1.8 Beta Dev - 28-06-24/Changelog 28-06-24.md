<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - June 28th, 2024 Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *01/03/2025*</div>

The **June 28th** update is a version for *Back Math* 1.8.0, released on June 28, 2024.[^1]

## Additions
### Advancements
- Added **3** new advancements:
  - **"Over-Overkill"**: *"Deal 50 hearts of damage in a single hit using Queen Lucy's Summoner Staff."*
    - This is a backport of the [Over-Overkill](https://minecraft.wiki/w/Advancement#Over-Overkill) advancement from Java Edition 1.21.
    - This is a challenge advancement, its parent is *"The Sophie Leader"*, it grants 50 experience points, and its icon is a queen lucy summoner staff.
  - **"Mangaed Mangoes"**: *"Get a Mangaed Mango from Mangaed Mango Oak Leaves."*
    - This is like all other fruit advancements: a task advancement, parent is *"Fruit Trees"*, and icon is the respective fruit.
  - **"The Aljan"**: *"Go to the Aljan through the Aljan Portal Stand."*
    - This advancement essentially replaces the root advancement, with the root advancement having a new look.
    - This is a goal advacement, its parent is *"Hidden from the Empire"* (the new root), and its icon is an aljamic grass block.

## Changes
### Entities
- Warrior sophie now have armor and weapons again.
  - This was because the ids of the warrior helmets were wrong (`<type>_warrior_helmet` instead of `warrior_<type>_helmet`).

### Advancements
- Moved the *"Recordful"* advancement from the *"backmath"* folder to the *"adventure"* folder.
  - This may cause the advancement to reset if you had it already.
- Advancements with the parent set to `the_aljan/root` now have their parent set to `the_aljan/enter_aljan` (*"The Aljan"*, new advancement).
- Updated the requirements and settings of many advancements:
  - The required items for these advancements are now counted individually towards them:
    - **"Back Math"**, **"Devil Armor"**, **"Aether Armor"**, **"Heat Singularity"**, **"Are they Cold or Hot?"**, **"The True Overpower"**, **"With ALL Powers Combined!"**, **"Fruit Trees"**, **"Meal Cooker Master"**, **"Mixing Ingots"** and **"Both Sides, Combined"**.
  - **"More Like 'Crystallizer MK2'!"**: now grants 50 experience points;
  - **"Purple Lanterns"**: can now be granted with mid-term hillary lanterns;
  - **"That Kid with Expensive School Supplies"**: now grants 350 experience points;
  - **"Heat Singularity"**: now grants 500 experience points (the `rewards` field was in the wrong place);
  - **"Arey they Cold or Hot?"**: now grants 1.200 experience;
  - **"With ALL Powers Combined!"**: is now hidden, grants 1.000 experience points, and more singularities are now counted towards it;
  - **"But It Isn't Ready Yet!"**: now requires the player to right-click a meal cooker with a spoon, in addition to having pasta;
  - **"Fabricio Meat?"**: now requires having raw fabricio, in addition to killing a shy fabricio;
  - **"Fine, Gentlemen"**: can now be granted with jabuticaba wine;
  - **"Fruit Trees"**: now grants 40 experience points, and now requires mangaed mango saplings;
  - **"Fruit Trees: Fruits"**: now requires mangaed mangoes and enchanted golden apples;
  - **"Meal Cooker Master"**: now requires bread with turtle and ender dragon fried eggs;
  - **"Not Loot Bags!"**: now requires turtle fried egg bags and boot packs;
  - **"Adventurer of the Seven Voids"**: the diamond boots on its icon now have Protection IV, from level I;
  - **"Mixing Ingots"**: the required items are now their respective item tags;
  - **"Both Sides, Combined"**: now grants 100 experience points;
  - **"The Aljan" *(old)***: its translations are now **"Hidden from the Empire"**: *"Locate a Fabricio Hideout Dungeon."*, its icon is now a spruce log, and it's achieved by entering a hideout dungeon;

### Translations
- Updated capitalization and wording of all *Back Math* advancements to make them "more" gramatically correct and to clarify requirements.
- Removed the `backmath:` and `variants:` prefixes from effect jam translations.

## Technical
### Changes
- The wanderer sophie and queen lucy pet variant registries now have tag folders at `tags/wanderer_sophie_variant` and `tags/queen_lucy_pet_variant`.
- Queen lucy pet variant's `display_name` field is now an actual text component.
  - It is no longer an optional field (if it even was), and now supports all other text component types.
- When adding items from an equipment loot table, mainhand/offhand items are now added in the main `for` loop.
  - Empty item stacks no longer get processed.

### Removals
- Removed the `asset_id` field from the debugging `efe` wanderer sophie variant.

## Tags
### Changes
- Added `melony:bows` and aljameed shovels to the `#melony:allowed_in_mainhand` item tag.

## References
[^1]: ["Updated Most Advancements & Backported 'Over-Overkill'"](https://github.com/Fabricio20106/Back-Math/commit/4116c0b670de82418efc57fc3ae516d651c99ef3) (Commit `4116c0b`) – GitHub, June 28, 2024.