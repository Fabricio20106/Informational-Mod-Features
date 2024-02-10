# <center>- Exponential Bowls -</center>
### <center>*A Guide & Documentation of the Stews - Made on 09/02/2024*</center>

## NBT Structure
- ```bowl_type```: The root tag for exponential stews.
  - *(String)* ```bowl_name```: A resource location for the bowl item. Can be any valid item id.
    - **Example**: "minecraft:bowl" or "variants:spruce_bowl".
  - *(Integer)* ```bowl_id```: A integer used to determine what texture will be loaded.
    - *0 = Oak | 1 = Spruce | 2 = Birch | 3 = Jungle | 4 = Acacia | 5 = Dark Oak | 6 = Painting | 7 = Crimson | 8 = Warped | 9 = Enderwood (ender)*
- ```effects```: An array where the effect and duration of a Suspicious Stew effect is stored.
  - *(Short)* ```id```: A short value that stores what effect the stew gives.
  - *(Integer)* ```duration```: An integer value that stores, in ticks, how long this effect lasts for.

## Expo. Stew: Creating Your Own
To make your own exponential stew, you will need to call [```VSItemModelModels.expoStew(String, String)```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/data/models/VSItemModelModels.java#L66), passing in the item name in registry, and what type of stew this is (for example, "mushroom" for mushroom stew).

This method will automatically generate all files for you, **but in Variants' namespace**. This will be fixed in a later release, however. <sup>*(maybe fixed in 1.6.20.1)*</sup>

Alternatively, you can use a pre-existing stew, and use resource packs to modify the models or add new ones.

When creating a custom exponential stew, you will also need to call [```VSClientHelpers.makeCustomBowls(Item)```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/util/VSClientHelpers.java#L130) on the common load, passing in your stew to make sure the model overrides will load correctly.

## Expo. Stew Behavior Classes
When registering an exponential stew, an instance of an [```IStewBehavior```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/IStewBehavior.java) will be required. This interface has a method called ```executeBehavior(ItemStack, World, LivingEntity)```, which will be automatically implemented when you extend it.

```executeBehavior()``` is called upon fishing to eat this stew, and with its parameters, it can basically do anything from setting you on fire to making you explode.

There is also a ```getEffects()``` method that returns an *EffectInstance* for any effects that you may want to apply. This is used by ```EffectStewBehavior``` to apply its effects.

When making a stew provide an effect, that effect and its duration will be stored in the item's NBT data.

Variants includes some default behaviors for its stews, these being:
- [```DefaultStewBehavior()```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/DefaultStewBehavior.java): Does Nothing;
- [```EffectStewBehavior(EffectInstance)```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/EffectStewBehavior.java): Has an *EffectInstance* for any effects you may wish to give the player;
- [```MilkStewBehavior()```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/MilkStewBehavior.java): Clears the player of any effects they may have;
- [```LavaStewBehavior(boolean)```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/LavaStewBehavior.java): Sets the player on fire for 10 or 5 seconds depending on the ```containsSoulLava``` boolean.

## Expo. Stew: ```ExponentialStewItem```:
[```ExponentialStewItem```](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/food/ExponentialSoupItem.java) is the base class for all exponential stews. It contains the logic that runs ```executeBehavior()``` method from [*IStewBehavior*](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/IStewBehavior.java), that applies effects from ```getEffects()``` and from Suspicious Stew NBT data.

There aren't many methods to use in this class, here are these anyway:
- ```writeEffectToStew(ItemStack, Effect, int)```: A method that gives this stew NBT data related to Suspicious Stew, applied by this very class.
  - ```(ItemStack stack)```: The stack the NBT data will be applied to.
  - ```(Effect effect)```: What effect will be saved to NBT.
  - ```(int duration)```: How long the effect will last. The duration is in ticks.
  - This method is also available on ```BucketFoodItem``` so its special recipe can set the effect.
- ```getBowlType(ItemStack)```: Returns the bowl item for this stew. Will return a vanilla Bowl if the NBT isn't present.
  - ```(ItemStack stack)```: The stack the ```bowl_type``` NBT will be checked for the bowl item.