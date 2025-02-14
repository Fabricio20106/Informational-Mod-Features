<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - 1.9.0.5 -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *07/02/2025*</div>

## Additions
### Items
- Readded the "empty loot table" translation for bag items.

### Advancements
- Added a new advancement: **"Hey, Catch!"**: *Shoot a jantic railgun.*
  - This is a goal advancement, its parent is "Aaahh!", it grants 50 experience, and its icon is a charged jantic railgun.

## Changes
### Entities
- Collector fabricios now have an interval of 10 ticks before they can attack entities again.
- Queen lucy pets now reset their anger towards a target after some time.
- Back Math's swords now apply their effects on you when a Termian hits you with them.

## Removals
### Particles
- Temporarily removed jantical, warmterm, coldterm and hillary flame particles.
  - They were causing way too frequent and inconsistent crashes, so I'll remove them until I can get them working reliably.

## Technical
### Changes
- Updated Revaried's stack handling methods to 1.8.0.9.
  - The `components` tag has been renamed to `tags`, and is properly converted to the new tag.