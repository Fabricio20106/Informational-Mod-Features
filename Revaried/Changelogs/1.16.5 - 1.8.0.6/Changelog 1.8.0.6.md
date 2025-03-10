<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.6 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *04/11/2024*</div>

**1.8.0.6** is the sixth version for [*Revaried 1.8.0*](/Revaried/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on November 3, 2024.[^1][^2]

## Additions
### Sounds
- Added **3** new sound events:
  - `entity.thrown_bottle.throw`;
  - `entity.thrown_bottle.shatter`;
  - `block.glass.shatter`.

### Menus
- Added a config menu for Variants.
  - This can be used to configure settings in JSON config file (`variants.json`).
  - There is supposed to be a text box for the *"substitute "The End" biome with"* config.

## Changes
### Blocks
- Smooth purpur slabs now have proper side textures.
- Moved chains, cauldrons, and inventory models to data generation.
  - Added new model templates for cauldrons:
    - `template_cauldron_level1`, `template_cauldron_level2` and `template_cauldron_level3`.
    - Added a *"contents"* field for these templates, for the cauldron contents.
    - Particle texture is now pulled from the side texture.
  - Moved the smooth purpur double slab model to data generation.
    - Renamed it to `double_smooth_purpur_slab`.
- Removed 3 stray pixels from the potted ender roots texture.
- Updated the glow black tulip texture to be brighter.

### Items
- Firework rockets, horse armor and lingering potions now show their `super` tooltips.

### Entities
- Particles produced by behavior bottles and stained bottles o'experience are now produced where the bottle broke, instead of at the center of the block.
- Behavior bottles' `.hit()` method now only runs on the server.
- The throw sound of behavior bottles and stained bottles o'experience now have the correct volume and pitch when using different sounds.
  - The default sound is now added by Variants: `entity.thrown_bottle.throw`.

### Miscellaneous
- Added Brazilian Portuguese translation for `commands.consumable.not_a_tcf`: *"[Item] não é uma comida configurável; Mudar suas tags não terá nenhum efeito"*.
- Removed the effect icon for sugar pot speed.

## Technical
### Additions
- Added a `shatter_sound` subcommand to */consumable*.
  - This has the same structure as `sound`, but acts on the tag of same name.
  - This tag can only be applied to stained bottles o'experience and splash and lingering bottles.

----
- <sup>**[DEBUG]**: Added an `open_config_screen` subcommand to */consumable*.</sup>
  - <sup>This command opens the Variants config screen in-game.</sup>

### Changes
- The development version is now `melony-studios-dev`, to match Back Math.
- Changed my name on `mods.toml` and `gradle.properties` to *"isabellawoods"*.
- Checks for *Consumable* now also accept *"com.sophicreeper.backmath.item.custom.food.VSConsumable"*.
- Translations for consume behaviors are now *"consume_behavior"* instead of *"stew_behavior"*.
- Renamed the following classes:

| Old Name | New Name |
|----------|----------|
| *StewBehavior* | *ConsumeBehavior* |
| *VSStewBehaviors* | *VSConsumeBehaviors* |
| *DefaultStewBehavior* | *DefaultConsumeBehavior* |
| *TagConfigurableFood* | *Consumable* |
| *TagConfigurableFoodItem* | *ConsumableItem* |
| *TagConfigurableStewItem* | *SimpleStewItem* |

- Renamed the following methods:

| Old Name | New Name |
|----------|----------|
| *StewBehavior*`.executeBehavior()` | *ConsumeBehavior*`.runBehavior()` |
| *StewBehavior*`.executeFromStewNBT()` | *ConsumeBehavior*`.loadFromNBT()` |
| *StewBehavior*`.writePropertiesToNBT()` | *ConsumeBehavior*`.writeProperties()` |
| *StewBehavior*`.getBehaviorRegistry()` | *ConsumeBehavior*`.registryEntry()` |
| *StewBehavior*`.writeBehaviorToNBT()` | *ConsumeBehavior*`.writeBehavior()` |
| *StewBehavior*`.addToStewTooltip()` | *ConsumeBehavior*`.addToTooltip()` |
| *BucketFoodItem*`.writeEffectToBucket()` | *ConsumableItem*`.writeEffectToNBT()` |
| *ExponentialStewItem*`.getBehavior()` | Uses method from *ConsumableItem* |
| *ExponentialStewItem*`.writeEffectToStew()` | *ConsumableItem*`.writeEffectToNBT()` |
| *ExponentialStewItem*`.hasBehaviorInNBT()` | *ConsumableItem*`.hasBehaviorInNBT()` |
| *ExponentialStewItem*`.canRunBehavior()` | *ConsumableItem*`.canRunBehavior()` |
| *Equippable*`.swapWithEquipmentSlot()` | *Equippable*`.equipOrSwapItem()` |

- ...and many others from consume behavior classes.
- *ConsumeBehavior*`.hasBehaviorIDInNBT()` is now static.
- All instances of the "stewStack" parameter are now named "stack".
- Renamed the "stew" package to "consumable".
- The hiding tag `hide_stew_behavior` has been renamed to `hide_consume_behavior`.
- The `armor_design` tag is now read using *"any numeric"* in *VSColorManager*.
- Added all wool sweater recipes to the *"wool_sweaters"* group.
- Plasteel shears recipe now reads from `#rimcraft:plasteel_materials` instead of `#backmath:materials/plasteel`.

### Removals
- The recipe for red yellow wool sweaters is now added by Back Math.

## Tags
### Additions
- Added `#variants:nether_crops_plantable_on` block tag.
  - Contains `#melony:farmland` and `#variants:nether_wart_plantable_on`.
  - Blocks in this tag can be used as bases for Nether crops.

### Removals
- Removed aljamic farmland from `#melony:natural_farmland`, as it's now added by Back Math.
- Removed devil, angelic, mid-term, aljameed and moonering shields from `#melony:shields`, as it was already adde by Back Math.

### References
[^1]: ["1.8.0.6: uhhhhh"](https://github.com/isabellawoods/Revaried/commit/c0412fa903a33161b612052d75002e1ee6d80549) (Commit `c0412fa`) – GitHub, November 1, 2024.
[^2]: ["1.8.0.6 (Part II): New Config Menu"](https://github.com/isabellawoods/Revaried/commit/7fe11c0c32535964ac95771c7ec7c7e2f1f16b99) (Commit `7fe11c0`) – GitHub, November 3, 2024.