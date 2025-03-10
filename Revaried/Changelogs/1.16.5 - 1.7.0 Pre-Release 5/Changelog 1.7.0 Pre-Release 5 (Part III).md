<div style="text-align: center;"> <img src=ChangelogPhotoPartIII.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.7.0 Pre-Release 5 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *02/07/2024*</div>

**1.7.0 Pre-Release 5** (known as **1.7.0pre5** in the jar file) is the fifth pre-release for [*Revaried 1.7.0*](/Revaried/Changelogs/1.16.5%20-%201.7.0/Changelog%201.7.0.md), with part III being released on June 28, 2024.[^1]

This changelog only covers the changes made in part III of this update. For the parts I and II, see [Changelog 1.7.0 Pre-Release 5 (Part I and II)](/Revaried/Changelogs/1.16.5%20-%201.7.0%20Pre-Release%205/Changelog%201.7.0%20Pre-Release%205%20(Part%20I%20and%20II).md).

### Known Issues
- Items in the player's hand don't render. This was fixed in [1.7.0 Release Candidate 1](/Revaried/Changelogs/1.16.5%20-%201.7.0%20Release%20Candidate%201/Changelog%201.7.0%20Release%20Candidate%201.md).

## Additions
- Exponential Water, Lava, Soul Lava, Milk and Powder Snow Bowls are now craftable using 4 bottles of the respective fluid.
- Exponential Stews now have their behavior set when crafting.
- Exponential Suspicious Stews can now be crafted.
  - Can use any bowl inside `#melony:bowls/wooden`.
    - If an item inside the tag is not a valid bowl, the default will be an Oak Bowl.
  - Includes a new custonm recipe type for it (`variants:exponential_suspicious_stew_special_recipe`).
- Mushroom Stew Buckets can now place Mushroom Stew again.[^2]
- Added a new empty sound event (`variants:stew_behavior.play_sound.default`) for the *Play Sound* behavior.
- The Sugar Pot Speed effect now has the effect icon of the Speed effect.

### Technical Additions
- Added a new *Texture ID* random range.
  - This takes in an integer `value` field, which is later clamped between 0-9 (the amount of available stews).
- Added a *"Set Stew Bowl"* loot function.
  - This function takes in a item id field `bowl` and a random range field `texture_id`.
  - Sets the `bowl` tag of exponential stews, and fails if the item isn't one.
- Added a *"Set Stew Behavior"* loot function.
  - This function takes in a behavior id field `behavior` and a string field `properties` (compound NBT in a string).
  - Sets the `behavior` tag of exponential stews, and fails if the item isn't one.
- Added 3 example loot tables for how to use the 3 stew loot functions.

#### New `ExponentialStewItem` Methods:
- `writeBowl(ItemStack, Item)` adds the `bowl` tag to the *stack* based on the *bowlItem*.
- `writeBowlWithTextureID(ItemStack, Item, IRandomRamge)` adds the `bowl` tag to the *stack* using the *bowlItem* and the *textureID*.
- `writeBehaviorToStew(ItemStack, StewBehavior, CompoundNBT)` adds a stew behavior to the *stack* using the id of the *behavior* and the properties of the *CompoundNBT*.

## Changes
- Spyglasses now zoom in and have their overlay.
- Actually fixed the hiding tags.
- The item in the "not an exponential stew" error message of the *"setbehavior"* command is now red.
- Renamed the id of the Explosive Blend Poisoning to `explosive_blend_poisoning` (from `creeper_powder_poisoning`).
- The `debug_arrow_state` tag of Debug Arrows is now saved to the arrow entity instead of the arrow item.
- Poisoning Pots now have their type poisoning (and duration) set when crafting.
- Shields, Banners, Crossbows, Potions, Splash Potions, Lingering Potions and Tipped Arrows now have the *"Hold \<Alt> for NBT"* tooltip.
- Firework Rockets and Stars:
  - Now have the *"Hold \<Alt> for NBT"* tooltip.
  - No longer "Variants" set as their "creator mod id".
  - Have an "and" at the end the explosion colors list instead of a comma.
- The *"Set Stew Effect"* loot function now also applies to exponential stews.
  - Sets the behavior to *Apply Mob Effects*, and the properties to the chosen effect.

### Stew Behaviors
- Exponential Suspicious Stews' default behavior is now *Apply Mob Effects* (with no effects).
- Exponential Stews with a different behavior in their NBT now execute the correct behavior.
- *Damage Entity* behavior now accepts its `source` tag as a compound.
  - This means that creates a new damage source, requiring only a `message_id` and a `food_exhaustion` amount (all other parameters are optional).
  - Added **8** new usable damage sources: `indirect_magic`, `sting`, `mob_attack`, `indirect_mob_attack`, `trident`, `thrown`, `thorns` and `explosion`.
  - This change also applies to the `source` tag of *Explode* behaviors.
- *Explode* behavior now spawns an area effect cloud if it has the `effects` tag.
- *Explode* behavior no longer crashes the game if its `mode` tag is null (now uses `none`).
- *Play Sound* behavior no longer crashes the game if its `id` or `category` tags are null (now uses `variants:stew_behavior.play_sound.default` and `master`).
- The `pos` tag in *Play Sound* and *Explode* behaviors is now an array of 3 integers instead of a compound with X, Y, Z integers.

### Technical Changes
- The `bowl_id` predicate of Exponential Stews is now called `variants:texture_id`.
- The `design` predicate of Wool Sweaters is now called `variants:design`.
- The `bowl_type`, `bowl_name` and `bowl_id` tags of exponential stews are now called `bowl`, `name` and `texture_id`.
- Data-generated stews are now saved in `stews/<name>` instead of `bowls/<name>`.
- *BucketFoodItem*s now save the effect id a string instead of an integer.
- *BucketFoodItem*s, *PlaceableBucketFoodItem*s and vanilla Suspicious Stew now read and apply all effect instance parameters (duration, amplifier, ambient, show particles, show icon and no counter).
- Renamed the `Recipes` tag of Enchanted Knowlegde Books to `recipes`.
- Removed various §'s from the translation files. As a result of this:
  - The enchanting power of bookshelves now shows up in experience-like lime.
  - the *"Unknown"* flight duration of Firework Rockets now shows up as light gray (accidental).
- The *writeEffectToStew(ItemStack, Effect, int)* method inside *ExponentialStewItem* now adds the `properties` tag to the stew.
  - Now it also makes the `id` of the stew *Apply Mob Effects*.
- The `no_counter` parameter of effect instances is now used by Exponential Stews and *BucketFoodItem*s.
- *StewBehavior* and *PoisoningType* can now have tags, and now have the *is(ITag\<StewBehavior/PoisoningType>)* method.

## References
[^1]: ["1.7.0 Pre-Release 5 (Part III): Craftable Stews & Working Spyglasses (#5)"](https://github.com/isabellawoods/Revaried/commit/d1735d5ceb24d37ef7ee9824563f75b9e6d1542f) (Commit `d1735d5`) – GitHub, June 28, 2024.
[^2]: [VS-5](https://github.com/isabellawoods/Revaried/issues/5): Mushroom Stew can be duplicated with the stew bucket.