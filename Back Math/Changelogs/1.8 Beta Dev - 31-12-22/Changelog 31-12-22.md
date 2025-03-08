# <div style="text-align: center;">- Back Math - December 31st, 2022 Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *04/03/2025*</div>

The **December 31st** update is a version of *Back Math* 1.8.0, released on December 31, 2022.[^1][^2]

## Additions
### Items
- Added crystallized fruit ingots.
  - There's an ingot for the following fruits: guarana, mango, mangaed mango, grapes, lemon, pineapple, orange, banana, guava, jabuticaba, aljamic berry, aljame, apple, golden apple, enchanted golden apple, melon slice, pumpkin, sweet berry and glow berry (from *Caves & Cliffs: Backport*).
  - Crystallized golden apple and enchanted golden apple ingots have their respective rarity, with the latter having the enchantment glint.
- Added obsidian ingots.
- Obsidian infused mid-term can now be crafted using the same recipe as the ingots.
- Added molten mid-term buckets.
  - These are buckets with rare rarity that don't do anything yet.
- Added pink gum frying pans.
  - This is a new weapon that inflicts Slowness IV and Instant Damage for 10 seconds, instantly killing the entity.
  - These have neither a model nor textures currently.
  - Has a Sophie's idea tooltip: <tooltip>\"This pan is entirely light pink, and when you hit a mob, the mob gets stuck in the pan (gets Slowness IV (4)) and takes constant damage (per tick).\" - Original idea quote by Sophie.</tooltip>
  - This item has 1.024 durability.

## Removals
- Removed *Back Math*'s *Create* cogwheel recipe.

## Changes
### Items
- Mid-term armor and swords now loses 1 durability per tick when on your inventory.
- Jantiquified moonering tools are now crafting in the smithing table, using moonering tools and a jantical.

### Entities
- Shy fabricios now run faster when panicking.
- Shy fabricios now run from every other living entity. This includes everything between themselves and armor stands.

## Technical
### Changes
- Renamed the item model provider to *"Back Math - Item Models"*, removing a space between "Back" and "Math".

## Tags
### Additions
- Added `#forge:ingots/obsidian` item tag.
  - Contains obsidian ingots.

### Changes
- Added `#forge:ingots/obsidian` item tag into `#forge:ingots`.
- Added molten mid-term buckets to the `#backmath:buckets` item tag.

## References
[^1]: ["pushing things"](https://github.com/Fabricio20106/Back-Math/commit/1e9d7a3c645f483209ce7961849772b157b45c9d) (Commit `1e9d7a3`) – GitHub, December 31, 2022.
[^2]: ["pushing things (universioned)"](https://github.com/Fabricio20106/Back-Math/commit/4fa0f4f9122445d39362354775b8185985930182) (Commit `4fa0f4f`) – GitHub, December 31, 2022.