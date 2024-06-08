# <center>- Exponential Bowls -</center>
### <center>*A Guide & Documentation of the Stews - Made on 09/02/2024*</center>

**Update**: Some of the information in this guide is no longer up-to-date with Variants. Some of the information in this file now only applies to versions before 1.7.0 Pre-Release 5.

## NBT Structure
- `bowl_type`: The root tag for exponential stews.
  - *(String)* `bowl_name`: A resource location for the bowl item. Can be any valid item id.
    - **Example**: "minecraft:bowl" or "variants:spruce_bowl".
  - *(Integer)* `bowl_id`: A integer used to determine what texture will be loaded.
    - *0 = Oak | 1 = Spruce | 2 = Birch | 3 = Jungle | 4 = Acacia | 5 = Dark Oak | 6 = Painting | 7 = Crimson | 8 = Warped | 9 = Enderwood (ender)*
- `effects`: An array where the effect and duration of a Suspicious Stew effect is stored.
  - *(Short)* `id`: A short value that stores what effect the stew gives.
  - *(Integer)* `duration`: An integer value that stores, in ticks, how long this effect lasts for.

## Expo. Stew: Creating Your Own
To make your own exponential stew, you will need to call this method on **FMLClientSetupEvent**. `name` is the id of the exponential stew in question, *"exponential_mushroom_stew"* for example, and `stewType` is what type of stew this is, such as *"mushroom"* for mushroom stew[^2].

```java
VSItemModelModels.expoStew(String name, String stewType)
```

> [!IMPORTANT]
> When generating the stew models using the data generators provided by Variants, **it may generate them on Variants' namespace**.
> 
> This may have been fixed in 1.6.20.1, but without thorough testing I wouldn't be too sure.

Alternatively, you can use a pre-existing stew, and use resource packs to modify the models or add new ones, and use NBT editing to, for example, change the name of the stew.

When creating a custom exponential stew, you will also need to call this method on the common load, passing in your stew to make sure the model overrides will load correctly[^3].

```java
VSClientHelpers.makeExpoStew(Item expoStew)
```

### Crafting This Stew

When making an exponential stew, you will probably have to make quite a few recipes by hand. Well, Variants adds an **ExponentialStewRecipeBuilder** that makes it easy to add new exponential stew recipes.

ExponentialStewRecipeBuilder is a copy of **ShapelessRecipeBuilder** that takes in an *ItemStack* instead of an *Item* for the result. This allows us to add the necessary NBT data to the output of this recipe.

This is an example implementation of this class to make a recipe:
```java
package melonystudios.examples.data.recipe;

public class ExampleRecipeProviders extends RecipeProvider {
  public static Map<Item, String> BOWL_TO_NAME = new ImmutableMap.Builder<Item, String>().put(...).build();

  public ExampleRecipeProviders(DataGenerator generator) {
      super(generator);
  }

  @Override
  protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
      for (Item bowl : BOWL_TO_NAME.keySet()) {
          CompoundNBT bowlTypeTag = new ItemStack(ExampleItems.EXPONENTIAL_EXAMPLE_STEW.get()).getOrCreateTagElement("bowl_type");
          bowlTypeTag.putString("bowl_name", "variants:" + BOWL_TO_NAME.get(bowl) + "_bowl");
          bowlTypeTag.putInt("bowl_id", BOWL_NAME_TO_ID.get(BOWL_TO_NAME.get(bowl)));

          ExponentialStewRecipeBuilder.shapeless(new ItemStack(ExampleItems.EXPONENTIAL_EXAMPLE_STEW.get())).requires(ExampleItems.ITEM_A.get()).requires(ExampleItems.ITEM_B.get()).requires(bowl).group("example_stew").unlockedBy("has_bowl", has(bowl)).save(consumer, "example:bowls/example/" + BOWL_TO_NAME.get(bowl));
      }
  }
}
```

## Expo. Stew Behavior Classes
When registering an exponential stew, an instance of an [`IStewBehavior`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/IStewBehavior.java) will be required. This interface has a method called `executeBehavior(ItemStack, World, LivingEntity)` which will be automatically implemented when you extend it. For example, here's an example implementation of this class:
```java
package melonystudios.examples.stew;

import com.junethewoods.variants.item.custom.stew.IStewBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ExampleStewBehavior implements IStewBehavior {
    @Override
    public void executeBehavior(ItemStack stack, World world, LivingEntity livEntity) {
        // Your custom stew behavior here.
    }
}
```

- `executeBehavior()` is called upon fishing to eat this stew, and with its parameters, it can basically do anything from setting you on fire to making you explode.

- `getEffects()` is an optional method that returns an *EffectInstance* for any effects that you may want to apply. This is how `EffectStewBehavior` applies its effects.

When making a stew provide an effect, that effect and its duration will be stored in the item's NBT data[^1].

Variants includes some default behaviors for its stews, these being:
- [`DefaultStewBehavior()`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/DefaultStewBehavior.java): Does Nothing;
- [`EffectStewBehavior(EffectInstance)`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/EffectStewBehavior.java): Has an *EffectInstance* for any effects you may wish to give the player;
- [`MilkStewBehavior()`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/MilkStewBehavior.java): Clears the player of any effects they may have;
- [`LavaStewBehavior(boolean)`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/custom/LavaStewBehavior.java): Sets the player on fire for 10 or 5 seconds depending on the `containsSoulLava` boolean.

## Expo. Stew: `ExponentialStewItem`:
[`ExponentialStewItem`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/food/ExponentialSoupItem.java) is the base class for all exponential stews. It contains the logic that runs `executeBehavior()` method from [*IStewBehavior*](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/IStewBehavior.java), that applies effects from `getEffects()` and from Suspicious Stew NBT data.

There aren't many methods to use in this class, here are these anyway:
- `writeEffectToStew(ItemStack, Effect, int)`: A method that gives this stew NBT data related to Suspicious Stew, applied by this very class.
  - `(ItemStack stack)`: The stack the NBT data will be applied to.
  - `(Effect effect)`: What effect will be saved to NBT.
  - `(int duration)`: How long the effect will last. The duration is in ticks.
  - This method is also available on `BucketFoodItem` so its special recipe can set the effect.
- `getBowlType(ItemStack)`: Returns the bowl item for this stew. Will return a vanilla Bowl if the NBT isn't present.
  - `(ItemStack stack)`: The stack the `bowl_type` NBT will be checked for the bowl item.

## Footnotes
[^1]: VS-3: [Custom NBT effects on Water Bowls are overridden by the item](https://github.com/Fabricio20106/Variants/issues/3)

[^2]: [VSItemModelModels at method `expoStew`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/data/models/VSItemModelModels.java#L65)

[^3]: [VSClientHelpers at method `makeExpoStew`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/util/VSClientHelpers.java#L130)
