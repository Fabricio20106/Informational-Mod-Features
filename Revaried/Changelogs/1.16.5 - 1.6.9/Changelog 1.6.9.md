<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.9 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *19/11/2023*</div>

## Additions
### Items
- Spyglasses are now "usable", although they still don't zoom in or show the correct holding pose.

### Entities
- Many items from Variants are now sold by villagers, some of which weren't obtainable before:

#### <div style="text-align: center;"> Villager trade tables for Variants' items </div>
| Villager Level   | Profession       | Buys                    | Sells                                    |
|------------------|------------------|-------------------------|------------------------------------------|
| Apprentice (2)   | Armorer          | 36 Emeralds             | 1 Diamond Bell                           |
| Apprentice (2)   | Armorer          | 1 Emerald               | 1 Empty Armor Slot Boots                 |
| Apprentice (2)   | Armorer          | 1 Emerald               | 1 Empty Armor Slot Leggings              |
| Journeyman (3)   | Armorer          | 1 Emerald               | 1 Empty Armor Slot Helmet                |
| Journeyman (3)   | Armorer          | 4 Emeralds              | 1 Empty Armor Slot Chestplate            |
| Journeyman (3)   | Armorer          | 5 Emerald               | 1 Empty Armor Slot Shield                |
| Apprentice (2)   | Cartographer     | 11 Quartz Glass Pane    | 1 Emerald                                |
| Master (5)       | Cleric           | 22 Warped Wart          | 1 Emerald                                |
| Novice (1)       | Fletcher         | 32 Variants wood sticks | 1 Emerald                                |
| Master (5)       | Fletcher         | 48 Emeralds             | 1 Enchanted Debug Bow                    |
| Novice (1)       | Librarian        | 9 Emeralds              | 1 Plain Birch Bookshelf                  |
| Journeyman (3)   | Librarian        | 1 Emerald               | 4 Quartz Glass                           |
| Apprentice (2)   | Shepherd         | 12 Glow Black Dye       | 1 Emerald                                |
| Apprentice (2)   | Shepherd         | 1 Emerald               | 1 Glow Black Wool                        |
| Apprentice (2)   | Shepherd         | 1 Emerald               | 4 Glow Black Wool                        |
| Journeyman (3)   | Shepherd         | 3 Emeralds              | 1 Glow Black Bed                         |
| Journeyman (3)   | Shepherd         | 2 Emeralds              | 1 Random color Wool Sweater              |
| Journeyman (3)   | Shepherd         | 4 Emeralds              | 1 Rabbit Hide Tunic                      |
| Journeyman (3)   | Shepherd         | 4 Emeralds              | 1 Phantom Membrane Tunic                 |
| Master (5)       | Shepherd         | 2 Emeralds              | 2 Painting Doors (Wanderer/Graham/First) |
| Novice (1)       | Toolsmith        | 1 Emerald               | 1 Diorite/Granite/Andesite Axe           |
| Novice (1)       | Toolsmith        | 1 Emerald               | 1 Diorite/Granite/Andesite Shovel        |
| Novice (1)       | Toolsmith        | 1 Emerald               | 1 Diorite/Granite/Andesite Pickaxe       |
| Novice (1)       | Toolsmith        | 1 Emerald               | 1 Diorite/Granite/Andesite Hoe           |
| Apprentice (2)   | Toolsmith        | 36 Emeralds             | 1 Diamond Bell                           |
| Apprentice (2)   | Toolsmith        | 3 Emeralds              | 1 Magma Sword                            |
| Apprentice (2)   | Weaponsmith      | 36 Emeralds             | 1 Diamond Bell                           |
| Journeyman (3)   | Weaponsmith      | 12 Emeralds             | 1 Iron Spyglass                          |
| Wandering Trader | Wandering Trader | 5 Emeralds              | 1 Painting Sapling                       |
| Wandering Trader | Wandering Trader | 1 Emerald               | 1 Glow Black Tulip                       |
| Wandering Trader | Wandering Trader | 1 Emerald               | 3 Glow Black Dyes                        |
| Wandering Trader | Wandering Trader | 5 Emeralds              | 1 Glow Berry Bush                        |

## Changes
- Updated textures of:
  - Painting logs and wood, stripped painting logs and wood and glow black wool.
  - All sticks and raw debris.
- "dog" music disc file is now smaller.

## Tags
### Additions
- Added `#variants:beacons` item tag.
  - Contains beacons and golden beacons.
- Added `#variants:cauldrons` block and item tags.
  - Contains cauldrons and golden cauldrons.
- Added `#forge:armors/boots` item tag.
  - Contains empty armor slot boots.
  - Items in this tag can be used to craft Back Math' boot pack, and can be dropped when breaking boot packs.

## Technical
### Additions
- Added a translation for `null`: "Null".
- Added *WoolArmorItem*`.pickRandomColor(Item)` method, used by the shepherd's wool sweater trade.