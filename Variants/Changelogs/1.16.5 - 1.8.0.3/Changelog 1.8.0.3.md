<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Variants - 1.8.0.3 -</center>
### <center>A Variants Release Changelog made on *01/09/2024*</center>

## Additions
- Added a new Magic Protection enchantment.
  - Works the same as other protection enchantments, but protects against magic damage sources.
  - This means that it protects against damage from these sources: `magic`, `indirect_magic`, `even_more_magic`, `thorns` and `poisonous_potato_update:potato_magic`.
- Added a new "Show Tags" keybind which defaults to Left Alt.
  - This is under a Melony Studios category.
- Added **5** new damage sources:
  - *"Nightmare"*, from 3D Shareware v1.34;
  - *"On Moon"*, from 23w13a_or_b;
  - *"Midas Touch"*, from 23w13a_or_b;
  - *"Potato Heat"*, from 24w14potato;
  - *"Potato Magic"*, from 24w14potato.
- Added **4** new configs:
  - `populateTagConfigurableFoodTags` controls whether to add the config NBT data to the item on the creative menu. Defaults to `false`.
  - `lineBreaksOnAltTags` controls whether tags shown with alt have line breaks or not. Defaults to `true`.
  - `customPotionDescriptions` controls whether to use or not the updated potion tooltip added by Variants. Defaults to `true`.
  - `durationFactorTooltip` controls whether the "Something% Duration Factor" tooltip should show up. Only shows up if *"customPotionDescriptions"* is on. Defaults to `false`.
- Added the `/consumable` command.
  - Too lazy to add the syntax now.
- Added **3** new consume behaviors: **Multi-Behavior**, **Remove Effects** and **Teleport Entity**
  - Multi-behavior executes various behaviors at once. Some backend updates were made for this to work.
  - Remove effects removes specific effects from the entity. This is backported from [snapshot 24w34a](https://minecraft.wiki/w/Java_Edition_24w34a) for use by honey balls.
  - Teleport entity can either teleport the entity randomly (like a chorus fruit) or to a specific position (like the */tp* command, but unlimited).
    - Currently, this behavior applies a cooldown separately from the food item, but it ends up acting the same.
- Added some code for a new tag fixes registry.
- Added a new fixing subcommand: *"update_to_1803"*:
  - **Update to 1.8.0.3**: Updates the `bowl` and `behavior` tags into their post-1.8.0.3 formats.
    - This also applies the *"old_stew_behavior_names"* fix.

### Technical Additions
- Added 2 new loot functions: *"set wool armor color"* and *"set wool armor design"*.

## Removals
- Removed poisoning types, as stylised pots now use consume behaviors to apply effects.
  - Removed the "Sugar Pot Speed" alias effect.
- Removed the `maxInTabWoolArmorDesigns` config, as wool armor designs are now data-driven.
- Lava Bottles no longer read from the `seconds_on_fire` tag for their functionality.
- Milk Bottles no longer read from the `curative_item` tag for their functionality.

## Changes
- Renamed Phantom Membrane and Rabbit Hide Sweaters to Tunics
  - The item ids were changed accordingly.
- Variants' boats now have proper names.
  - They now show *"\<wood type> Boat"* instead of *"Boat (Variants)"*
  - Boats with wood type `ender` are now renamed to `enderwood`.
- Bucket foods and stylised/poisoning pots no longer have the `no_counter` tag set to true.
- The effect-related tags from bucket foods, stylised pots and exponential stews now check for *"any numerical"* tags instead of only integer and bytes.
- Curative items are now saved using Variants' stack saving. This applies to the *"Cure Effects"* behavior and the effects tag.
- The glowstone poisoning effect no longer applies Glowing for 2 seconds.
- The `/consumebehavior set` command now works for all tag-configurable foods.
- Crafting exponential suspicious stew no longer results in the bowl getting bugged and only crafting at max 3* bowls.
- Exponential suspicious stew and suspicious stew buckets now have their behavior tooltips hidden.
- The `design` model override for Wool Sweaters now reads from an any numeric `armor_material` tag.
- The `texture_id` model override for exponential stews now reads from an any numeric `texture_id` tag.
- The `/consumebehavior set` command no longer adds the behavior id if the behavior is null.
- Phantom membrane and rabbit hide tunics can now be crafted again.
- Updated the recipes of some food items to match the new consumable system.

### Behavior Changes
- Behavior properties are no longer encased in a `properties` subtag. They're now at the `behavior` tag.
- The *"executeBehavior()"* method now has the behavior's properties provided.
- The command display of behaviors now shows the registry name in gray on the bottom.
- The *VSUtils.loadStack()* method can now parse tags from a string.
- Effects are now applied by the *apply effects* behavior, instead of the item.
- Slightly updated the tooltip of the *apply effects* behavior.
  - The effect names and duration now have their colors.
  - The "When Applied:" tooltip has been changed to "When drank/eaten:", depending on the use animation.
- The *apply effects* behavior can now read from a `chance` float tag, which controls the chance of applying this effect.
- The *apply effects* behavior now uses a list instead of an array.
- Renamed the sound event id in the *play sound* behavior to `sound`, to remove a conflict with the new system.
- The *Play Sound* behavior can now play sounds added by resource packs.
- Updated the stew recipe provider.
  - Now adds the "show particles", "show icon", "visible" and "no counter" of effects instances from *apply effects* behaviors.
  - Now saves the tags of the curative item of *clear effects* behaviors as a string.
- The *clear effects* behavior now runs even if the behavior properties are null.
- The *damage entity* and *explode* behaviors now null-check properly.
- The *explode* and *play sound* behaviors `pos` tag is now properly read and used.

### Technical Changes
- Wool armor colors are now data-driven.
  - Wool Sweaters in the weaponry tab are now populated using wool armor colors (both colors and designs).
  - Picking random colors using *pickRandomColor()* still does not pick armor designs.
  - These are stored inside `data/<namespace>/wool_armor_color`.
  - The provider for this is called *WoolArmorColorProvider*.
- The `texture_id` integer tag of exponential stews is now on the top-level tag.
- Renamed the *"set stew behavior"* loot function to *"set consume behavior"*.
  - It can now apply behaviors to all tag-configurable foods, instead of only exponential stews.
- The *"set stew bowl"* loot function now reads, writes and needs an item stack instead of an item.
- The bowl id random range is now capped dynamically.
  - This means the maximum is now how many texture identifiers there are instead of 9.
- Bowl types can now read tags again.
- Renamed item field `SOUL_O_CHARGE` in *VSItems* to `SOUL_CHARGE`.
- Renamed the *IEquippable* class to *Equippable*.
- Suspicious Stew effects can now read from a `chance` float tag, which controls the chance of applying this effect.
- Variants' boats can now have a `wood_type` string tag that controls what wood type the boat will have.
- Soul Lava Buckets' and Coal Shears' burn time can now be configured using a `burn_time` integer tag.
- Magma Swords can now control their burn time with a `seconds_on_fire` integer tag. Defaults to 10.
- Spyglasses' use duration can now be controlled with a `use_duration` integer tag. Defaults 1.200.

### Translation Changes
- The "Hold \<Alt> for Tags" tooltip colors are now hardcoded.

### Translation Changes (English)
- The *"remove save() argument"* error is now consistently lowercase and now has a () after "save".

### Translation Changes (Brazilian Portuguese)
- The *"remove save() argument"* error now has a () after "save".
- Changed "sopa" to "ensopado" on the ignite behavior description.
- The *"old_behavior_names"* fix's "no tag" success message is now translated.

## Tags
- Renamed the stew behavior tag folder to `consume_behavior`.
- Added `#variants:exponential_stews` item tag.
  - Contains mushroom, beetroot, rabbit, suspicious, fungi, end fungi and aljan fungi stews/soups, and water, lava, soul lava and powder snow bowls.
- Added `#variants:throwable_potions` item tag.
  - Contains splash and lingering potions.
  - Items in this tag that show the default potion tooltip will show "When thrown:" instead of "When drank:".
- Added `#forge:gems/amethyst` item tag.
  - Contains nothing.
  - Items in this tag can be used to repair amethyst swords.
- Added `#forge:ingots/copper` item tag.
  - Contains nothing.
  - Items in this tag can be used to repair copper swords and chestplates.
- Added `#variants:applicable_to/shears` enchantment tag.
  - Contains efficiency, fortune, unbreaking and mending.
  - Enchantments in this can can be applied to any shears.
- Added `#variants:applicable_to/flint_and_sheel` enchantment tag.
  - Contains unbreaking and mending.
  - Enchantments in this can can be applied to any flint and steel.
- Added `#variants:applicable_to/shields` enchantment tag.
  - Contains unbreaking and mending.
  - Enchantments in this can can be applied to any shields.
- Added `#variants:applies_on_tag_reload` tag fix tag.
  - Contains nothing.
  - Currently does nothing, because tag fixes are not yet fully implemented.
  - Tag fixes in this tag are applied immediately when the item stack `tag` is loaded.

## Consumables Update
All items in Variants that are consumable (honey balls, milk bottles, exponential stews) now support changing their use remainder, cooldown, eating duration, eating sound, animation, and consume behavior.

Because of the addition of the consumable tag, the behavior tag has been moved and, as such, the exponential stew NBT has been updated once again (which means I'm gonna have to write another doc).

<details>
<summary>Click to show all foods that are configurable</summary>

- Mushroom, Beetroot, Rabbit, Suspicious, Fungi and End Fungi Stew/Soup Buckets;
- Fungi and End Fungi Stews (now basically expo. stews);
- Lava, Soul Lava, Milk and Powder Snow Bottles;
- Splash Sophie Potions;
- Redstone, Bluestone, Glowstone, Gunpowder, Explosive Blend, Sugar, Sweet Berry and Glow Berry Pots;
- Honey Balls;
- Raw and Cooked Fish;
- All exponential stews/soups.
</details>

All consume tags can be configured using the `/consumable` and `/consumebehavior`<sup>*[renamed from `/stewbehavior`]*</sup> commands.

### NBT Structure
- `consumable`: The root tag of tag-configurable food items.
  - *(Integer)* `cooldown`: The cooldown duration in ticks to apply after eating the item. Must be above and defaults to `0`.
  - *(Integer)* `consume_ticks`: How long it takes in ticks to consume this item. Must be above `0` and defaults to `40` for honey balls and `32` otherwise.
  - *(String)* `animation`: What animation is played when consuming this item. Possible values are:
    - *"none"*: No animation plays;
    - *"eat"*: The default eating animation. Has eating particles;
    - *"drink"*: The default drinking animation. Doesn't have eating particles;
    - *"block"*: The shield blocking animation;
    - *"bow"*: The bow holding animation;
    - *"spear/trident"*: The trident throwing animation;
    - *"crossbow"*: The crossbow drawing animation. The animation always has the same duration, even if the consume duration is longer.<sup>*[fact check please]*</sup>
  - *(String)* `sound`: The sound played while consuming this item. This currently doesn't support resource packs sounds. Can default to `entity.generic.eat`, `entity.generic.drink`, or `item.honey_bottle.drink`.
  - *(Compound)* `behavior`: The consume behavior to run when this item is consumed.
    - *(String)*: `id`: The id of the consume behavior to run.
    - *[All behavior properties.]*
  - *(Compound)* `use_remainder`: What item is left over when this item is consumed.
    - *(String)* `id`: The id of the remainder item. Can be set to air.
    - *(Integer)* `count`: The count of remainder items. Can be set to above 127, but it may not work correctly.<sup>*[needs testing]*</sup>
    - *(Compound/String)*: `components`: The item tags to apply to the remainder item. If defined as a string, it will be parsed and converted to a compound. This is used by JSON parsers in Variants (like bowl types).
- *(Integer)* `texture_id`: The id used by the model overrides. Only used by exponential stews.