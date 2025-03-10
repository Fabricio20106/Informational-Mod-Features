<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - June 9th Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *23/06/2024*</div>

The **June 9th** update is a version for *Back Math* 1.8.0, released on June 9, 2024.[^1]

## Additions
- Added `equipment` loot parameter set.
  - This taken in *"origin"* as a required parameter and *"this entity"* as an optional one.

## Changes
- Wanderer Sophie and Queen Lucy Pet variants now truly work (except for new data-driven variants).
  - Wanderer Sophie's `Variant` and `variant_reg` tags and QLP's `Variant` tag are now a single tag called `variant`.
  - Old integer-based variants are updated to the new registry-based variants, with the old tag being removed upon loading.
  - QLP variant manager now checks on the folder `queen_lucy_pet_variant`.
- Fixed some Wanderer Sophie variants having a 64x65 texture instead of 64x64.
  - This affected the Entrepreneur, Pajama and Savannah variants.
- Archer Insomnia Sophies can now shoot arrows, and now check for any `#melony:bows` to use instead of only Angelic Bows.
  - They now also more accurately look towards the entity they're shooting at.
- Archer Lucia's crossbows are now enchanted during Sophie Raids, instead of Queen Lucy's.
- Archer Lucia's technical arm pose now changes based on whether they're charging their crossbow or whether it's loaded.
- Queen Lucy Pets can now heal without being in peaceful difficulty.
- *"QLP Daycare"* advancement now works again.
- Zombie Fabricios are now cured using Jantiquified Aljame instead of Golden Apples.
- Capes are no longer render if Termian patrollers have an empty `cape` tag.
- Devil and Angelic tools now show up with their repair materials in JEI's anvil repair category.

### Technical Changes
- *BMRangedBowAttackGoal* now checks for any `#melony:bows` instead of only Angelic Bows.
- *BMRangedCrossbowAttackGoal* now checks for any `#melony:crossbows` instead of only Angelic Crossbows.
- Wanderer Sophie variants now only have a `texture_location` and `slim_arms`.
- Queen Lucy Pet variants now only have a `texture_location` and a `display_name` compound.

#### Wanderer Sophie Variants Format:
```json
{
  "texture_location": "backmath:entity/wanderer_sophie/yellow_axolotl",
  // Still does nothing as of 23/06/24.
  "slim_arms": true
}
```

#### Queen Lucy Pet Variants Format:
```json
{
  "texture_location": "backmath:entity/queen_lucy_pet/qsp_current",
  "display_name": {
    // Can be either "translate" (translated text) or "text" (literal string).
    "translate": "entity.backmath.queen_lucy_pet.current"
  }
}
```

## Tags
- Added `#backmath:immune_to_summoner_staff_smashes` entity type tag.
  - Contains nothing.
  - Entities in this tag are not knocked back by Queen Lucy Summoner Staff smash attacks.

## References
[^1]: ["Added Registry QLP Variants & Variant Conversion"](https://github.com/isabellawoods/Back-Math/commit/3c4c36d8e4151a93a885d32943f330c359de8161) (Commit `3c4c36d`) – GitHub, June 9, 2024.