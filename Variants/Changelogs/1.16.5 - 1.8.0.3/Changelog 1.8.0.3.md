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
- Added the `/consumable` command.
  - Too lazy to add the syntax now.

## Removals
- Removed poisoning types, as stylised pots now use consume behaviors to apply effects.

## Changes
- Renamed Phantom Membrane and Rabbit Hide Sweaters to Tunics
  - The item ids were changed accordingly.
- Variants' boats now have proper names.
  - They now show *"\<wood type> Boat"* instead of *"Boat (Variants)"*
  - Boats with wood type `ender` are now renamed to `enderwood`.
- Bucket foods and stylised/poisoning pots no longer have the `no_counter` tag set to true.
- The effect-related tags from bucket foods, stylised pots and exponential stews now check for *"any numerical"* tags instead of only integer and bytes.
- Curative items are now saved using Variants' stack saving. This applies to the *"Cure Effects"* behavior and the effects tag.
- The `/consumebehavior set` command now works for all tag-configurable foods.

### Technical Changes
- Wool armor colors are now data-driven.
  - Wool Sweaters in the weaponry tab are now populated using wool armor colors (both colors and designs).
  - These are stored inside `data/<namespace>/wool_armor_color`.
- The `texture_id` integer tag of exponential stews is now on the top-level tag.
- Renamed item field `SOUL_O_CHARGE` in *VSItems* to `SOUL_CHARGE`.

### Translation Changes (Brazilian Portuguese)
- The *"old_behavior_names"* fix's "no tag" success message is now translated.

## Tags
- Added `#forge:gems/amethyst` item tag.
  - Contains nothing.
  - Items in this tag can be used to repair amethyst swords.
- Added `#forge:ingots/copper` item tag.
  - Contains nothing.
  - Items in this tag can be used to repair copper swords and chestplates.
- Renamed the stew behavior tag folder to `consume_behavior`.

## Consumables Update
All items in Variants that are consumable (honey balls, milk bottles, exponential stews) now support changing their use remainder, cooldown, eating duration, eating sound, animation, and consume behavior.

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

### Behavior Changes
- Behavior properties are no longer encased in a `properties` subtag. They're now at the `behavior` tag.
- Effects are now applied by the *Apply Effects* behavior, instead of the item.
- Renamed the sound event id in the *Play Sound* behavior to `sound`, to remove a conflict with the new system.
- The *Play Sound* behavior can now play sounds added by resource packs.
- The stew recipe provider now adds the "show particles", "show icon", "is visible" and "no counter" of effects instances.