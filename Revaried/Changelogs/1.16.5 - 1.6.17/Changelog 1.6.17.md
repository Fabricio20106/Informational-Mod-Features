<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.17 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *28/12/2023*</div>

Some of the bugs in this version (and the crash as well) are due to IntelliJ breaking when I was going to test the features. These errors are fixed in the next version, 1.6.17.1.

## Additions
- Added Enderwood Boats.

## Changes
- Updated Painting Boat texture.
- Wither Bone Blocks now give you Wither for 2 seconds when stepped on.
- All flammable sticks and bowls, soul blaze rods, soul blaze powder and wooden railbeds are now flammable (can be used as furnace fuel).
    - Flammable sticks and bowls burn for **100 ticks** (5 seconds - **0.5 items**);
    - Wooden Railbeds burn for **350 ticks** (17,5 seconds - **1,75 items**), the equivalent of a slab and two sticks;
    - Soul Blaze Rods burn for **4800 ticks** (240 seconds - **24 items**);
    - Soul Blaze Powder burns for **2400 ticks** (120 seconds - **12 items**).
- Removed "Enchantments:" description on enchanted items. 

## Bug Fixes
- Fixed instances of `DrinkableContainerItem` not returning the bottle/consuming the item properly.
- Fixed Lava Bottles setting the mob on fire for 100 seconds
    - Lava Bottles now set fire for 5 seconds, and Soul Lava Bottles now set fire for 10 seconds.

### Known Bugs
- Enderwood Boat item model is missing.
- Enderwood Boats are not craftable.
- Enderwood Boats are not in the `#minecraft:boats` item tag.