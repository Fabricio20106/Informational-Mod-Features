<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - July 9th, 2024 Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *01/03/2025*</div>

The **July 9th** update is a version for *Back Math* 1.8.0, released on July 9, 2024.[^1]

## Changes
### Items
- When *Revaried* is loaded, crowns can now be right-clicked to swap them with the item on your head.
  - Since the method that I use to swap seemingly broke when backporting it, swapping crowns may crash the game.
- The tooltips from `super` of titos, totis and queen lucy shirts are now shown first.
- Butter swords now properly check if the `stored_experience` tag exists.
- Devil and mid-term tools no longer set mobs on fire if they're immune to it.
- Devil spareys now set mobs on fire.
- Mid-term sparey now set mobs on fire and gives them Slowness III.

## Technical
### Changes
- Moved most item classes to various different packages.
- Renamed the class *MidTermSpareySwordItem* to *MidTermSpareyItem*.
- Separated the dispense behaviors classes of insoflint and aljansteel and insomnia arrows.
  - These classes are called *IAADispenseBehavior* and *InsomniaArrowDispenseBehavior*.
- The default entry for wanderer sophie variants is now `backmath:yellow_axolotl`.
- The default entry for queen lucy pet variants is now `backmath:current`.

## Tags
### Additions
- Added `#backmath:applicable_to/queen_lucy_summoner_staff` enchantment tag.
  - Contains sharpness, smite, bane of arthropods, looting, fire aspect, sweeping edge and knockback.
  - Enchantments in this tag can be applied to queen lucy summoner staves.

## References
[^1]: ["Item Classes Reorganization & Slight Bugfixes"](https://github.com/Fabricio20106/Back-Math/commit/6e6856cf4beef3a949642120e7492e8daba0562e) (Commit `6e6856c`) – GitHub, July 9, 2024.