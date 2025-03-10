<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.8.0.4 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *19/10/2024* and *04/11/2024*</div>

**1.8.0.4** is the fourth version for [*Revaried 1.8.0*](/Revaried/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on September 19, 2024.[^1][^2]

## Additions
### Items
- Added glass bottles for all stained glass types (and quartz glass).
  - There is a separate tab for these glass bottles: *"Variants' Brewery"* (stylized as "▷ ᴠᴀʀɪᴀɴᴛꜱ' ʙʀᴇᴡᴇʀʏ ◁").
  - These bottles can have a `glass_color` integer tag that defines the color of stained bottles o'experience particles.
- Added **9** stained bottles: experience, honey, dragon's breath, potion, lava, soul lava, milk, powder snow and sophie.
  - Recipes that can be made from regular bottles can be made using these.
  - Bottles o'experience have their particle color taken from the bottle's glass color.
  - Cooldowns and custom sounds don't work on bottles o'experience.
  - Dragon's breath is only used by brewing recipes added by Variants.
  - Only powder snow and Sophie bottles cannot be crafted (because data gen).
  - Stained potions cannot be brewed, but are all available in the creative menu.
  - Stained potions' tint is applied differently to regular potions, thus Melony Lib's potion color backport doesn't work with this.

### Miscellaneous
- Added **1** new config: **"populateStainedGlassBottlesInTabs"**.
  - Controls whether to populate all types of stained glass bottles in the Variants' Brewery tab.
  - If disabled, only the white stained glass bottles are added.
- Sugar pots now appear as giving speed on JEED.
- Exponential water bowls now appear as giving water breathing on JEED.
- Added translation for quartz color.
- Added two unused textures: `item/bottle_contents/ominous` and `item/bottle_contents/ominous_what`.

## Changes
### Items
- Debug bows, debug arrows and stained bottles o'experience now read from the `enchantment_glint_override` boolean tag for its glint.
- Effect tooltips in *apply effects* behaviors now properly show the effect duration and amplifier.
  - It now shows "No effects..." when it was no effects.
- Eating tag-configurable foods now properly grants stats and gives you the use remainder.
- Tag-configurable foods with use remainders are now properly seen by `hasContainerItem(ItemStack)`.
- Added lava and soul lava bottle recipes to "lava_bottle" and "soul_lava_bottle" groups respectively.

### Entities
- Thrown dragon's breath and stained experience bottles and small soul fireballs now use the vanilla *SpriteRenderer*.

### Advancements
- The *"Pocket Milk"* advancement can now be granted using stained milk bottles.

### Consume Behaviors
- The *teleport entity* behavior no longer applies cooldown separately from the `cooldown` tag.
- The *teleport entity* behavior now properly saves.
  - `random_teleport`'s default is `true` but the method assumed otherwise.
- Instant effects now get properly applied when consuming items.

### Translations
- Renamed the *"Stew shapeless recipe [...]"* / *"[..] sem formato de ensopado [...]"* to *"Shapeless recipe [...]"* / *"[...] sem formato [...]"*.

## Technical
### Changes
- Renamed method `makeExpoStew()` in *VSUtils* to `addTextureIdentifier()`.
- Renamed *StewBehaviorTags* to *ConsumeBehaviorTags*.
- Renamed *VSStewBehaviorTagsProvider* to *VSConsumeBehaviorTagsProvider*.
- Renamed *NBTSavingRecipeBuilder* (formerly *ExponentialStewRecipeBuilder*) to work with stained bottles:
  - Having a consume behavior is no longer needed -- the tag will just be empty on the recipe.
  - Moved behavior serialization to *JSONUtils*.
- The following classes are now considered having an use remainder by default:
  - *[Placeable]BucketFoodItem*;
  - *DrinkableContainerItem*;
  - *ExponentialStewItem*;
  - *SophiePotionItem*.

## Removals
### Translations
- Removed translations for the sugar pot speed alias effect.

### Technical
- Removed *VSUtils*`.woolArmorColor(String, int)`.

### References
[^1]: ["1.8.0.4: Way Too Many Stained Glass Bottles"](https://github.com/isabellawoods/Revaried/commit/a2cb145db5e8a2b12be9cee02973fef60822f4de) (Commit `a2cb145`) – GitHub, September 15, 2024.
[^2]: ["1.8.0.4 (Part II): Few Too Many Stained Bottles (+ Recipes)"](https://github.com/isabellawoods/Revaried/commit/255640e5407156272c2d920c0ce70700ef84bceb) (Commit `255640e`) – GitHub, September 19, 2024.