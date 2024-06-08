# <center>- Exponential Bowls -</center>
### <center>*A Guide & Documentation of the Stews - Made on 08/06/2024*</center>

## NBT Structure
- `bowl_type`: The root tag for exponential stews.
  - *(String)* `bowl_name`: A resource location for the bowl item. Can be any valid item id.
    - **Example**: "minecraft:bowl" or "variants:spruce_bowl".
  - *(Integer)* `bowl_id`: A integer used to determine what texture will be loaded.
    - *0 = Oak | 1 = Spruce | 2 = Birch | 3 = Jungle | 4 = Acacia | 5 = Dark Oak | 6 = Painting | 7 = Crimson | 8 = Warped | 9 = Enderwood (ender)*
- `behavior`: The root tag for stew behaviors.
  - *(String)* `id`: A resource location for the stew behavior (from registry).
    - **Default Values**: "variants:default", "variants:milk", "variants:lava" and "variants:effect" *(will be renamed)*.
  - *(Compound)* `properties`: Individual properties for each behavior. See **Expo. Stew: Default Behaviors** below.

## Expo. Stew: Default Behaviors

### Default Behavior (`DefaultStewBehavior`):
This is the default behavior for stews -- it doesn't do anything and has no properties.

- **Registry Name**: `variants:default`
- **Name**: Default (None) (`stew_behavior.variants.default`)
- **Properties**: None

### Apply Mob Effects Behavior (`ApplyMobEffectsBehavior`):
This is the behavior used by Exponential Water Bowls. It saves and applies effects to whoever drinks/eats it. <sup>[*effects tag can be used separately from the behavior*]</sup>

Only the `id` and `duration` effect properties are saved to the existing stews, but only `id` is truly necessary to make the effect work.

- **Registry Name**: `variants:effect`
- **Name**: Effect (`stew_behavior.variants.effect`)
- **Properties**:
  - *(List)* `effects`: The root tag for effects for this behavior.
    - A single effect compound tag.
      - *(String)* `id`: A resource location for the effect name.
      - *(Integer)* `duration`: An optional integer for the effect duration in ticks. Defaults to `160` ticks (8 seconds).
      - *(Integer)* `amplifier`: An optional integer for the effect amplifier. Defaults to `0`.
      - *(Boolean)* `ambient`: An optional boolean for whether the effect is ambient or not (like beacons do). Defaults to `false`.
      - *(Boolean)* `show_particles`: An optional boolean for whether to show particles or not. Defaults to `true`.
      - *(Boolean)* `show_icon`: An optional boolean for whether to show the effect icon or not. Defaults to `true`.
      - *(Boolean)* `no_counter`: An optional boolean for whether to display or not the clientside counter (?). Defaults to `false`.
      - *(List)* `curative_items`: An optional *ItemStack* list for the items this effect uses an a curative. Defaults to `[{id:"minecraft:milk_bucket",Count:1b}]`.

### Clear Mob Effects (`ClearMobEffectsBehavior`):

This is the behavior used by Exponential Milk Bowls. It uses a curative item to clear effects on the mob that drinks/eats it.

- **Registry Name**: `variants:milk`
- **Name**: Milk (`stew_behavior.variants.milk`)
- **Properties**:
  - `curative_item`: An *ItemStack* root tag that stores information about the curative item.
    - *(String)* `id`: A resource location for the item name. Defaults to `minecraft:milk_bucket`.
    - *(Byte)* `Count`: A byte that stored the stack size of this item. Defaults to `1`.
    - *(Compound)* `tag`: An optional compound that stores all the item's tags. Doesn't show up by default.

### Set On Fire (`SetOnFireBehavior`):

This is the behavior used by Exponential Lava and Soul Lava Bowls. It uses an integer to use as a duration in ticks to set the mob on fire for.

- **Registry Name**: `variants:lava`
- **Name**: Lava (`stew_behavior.variants.lava`)
- **Properties**:
  - *(Integer)* `ticks_on_fire`: An integer that defines how long the mob will be set on fire for. Defaults to `100` for Lava and to `200` for Soul Lava.

## Expo. Stew: Creating Your Own
To make your own exponential stew, you will need to call this method on **FMLClientSetupEvent**. `name` is the id of the exponential stew in question, *"exponential_mushroom_stew"* for example, and `stewType` is what type of stew this is, such as *"mushroom"* for mushroom stew[^2].

```java
VSItemModelModels.expoStew(String name, String stewType)
```

Alternatively, you can use a pre-existing stew, and use resource packs to modify the models or add new ones, and use NBT editing to, for example, change the name of the stew.

When creating a custom exponential stew, you will also need to call this method on the common load (**FMLCommonSetupEvent**), passing in your stew to make sure the model overrides will load correctly[^3].

```java
VSUtils.makeExpoStew(Item expoStew)
```

### Crafting This Stew

When making a new stew, you will probably have to make quite a few recipes by hand. Well, Variants adds an **ExponentialStewRecipeBuilder** that makes it very easy to add new stew recipes.

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

## Expo. Stew Behavior Classes: Forge Registries
Starting with 1.7.0 Pre-Release 5, stew behaviors are now a Forge registry. With this, you will now need to make a class to register your behaviors. Here's an example of a class that can do such thing:

```java
package melonystudios.examples.stew;

import com.junethewoods.variants.item.custom.stew.StewBehavior;

public class ExampleStewBehaviors {
    public static final DeferredRegister<StewBehavior> BEHAVIORS = DeferredRegister.create(VSRegistries.STEW_BEHAVIORS, MelonyExamples.MOD_ID);

    public static final RegistryObject<StewBehavior> EXAMPLE = BEHAVIORS.register("example", () -> ExampleStewBehavior::new);
}
```

## Expo. Stew Behavior Classes: Behavior Classes
When registering a new stew behavior, a class extending [`StewBehavior`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/StewBehavior.java) will be required. This class will automatically add the void method called `executeBehavior(ItemStack, World, LivingEntity)`, together with a method called `writePropertiesToNBT(ItemStack)`, which is where you save your classes' properties to the stew NBT.

Additionally, you will need to override a method called `getBehaviorRegistry()`, in order to get your stew behavior from registry.

Below is an example for a stew behavior class:

```java
package melonystudios.examples.stew;

public class ExampleStewBehavior extends StewBehavior {
    @Override
    public void executeBehavior(ItemStack stack, World world, LivingEntity livEntity) {
        // Your custom stew behavior here.
    }

    @Override
    public CompoundNBT writePropertiesToNBT(ItemStack stewStack) {
        // Anything that may need to be saved to the stew's NBT is written here.
        // If you won't have anything, just return a new CompoundNBT.
        return new CompoundNBT();
    }

    @Override
    public StewBehavior getBehaviorRegistry() {
        // Returns the Forge registry entry for this behavior.
        return ExampleStewBehaviors.EXAMPLE.get();
    }
}
```

- `executeBehavior()` is called upon finishing to eat this stew (before effects are applied). This method can basically do anything from setting you on fire to making you explode.

- `getEffects()` is an optional method that returns an array of effect instances that you may want to apply to the player. This is how `ApplyMobEffectsBehavior` applies its effects.

- `writePropertiesToNBT()` is used to write necessary or arbitrary NBT data to the stew. If nothing is needed to be written, the method can just `return new CompoundNBT()`.

- `getBehaviorRegistry` returns the Forge registry entry for this behavior. It returns `VSStewBehaviors.DEFAULT.get()` by default or when not extended.

## Expo. Stew: `ExponentialStewItem`:
[`ExponentialStewItem`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/food/ExponentialSoupItem.java) is the base class for all exponential stews. It contains the logic that runs `executeBehavior()` and `getEffects()` methods from [`StewBehavior`](https://github.com/Fabricio20106/Variants/blob/forge-1.16.5/src/main/java/com/junethewoods/variants/item/custom/stew/StewBehavior.java), to execute the behaviors and apply effects for Suspicious Stews and exponential stews with the `ApplyMobEffectsBehavior`.

In `ExponentialStewItem`, there aren't many methods to use, but there are some methods available:

- `hasBehaviorInNBT(ItemStack stewStack)` returns a boolean, depending on whether the *"stewStack"* has the `behavior` tag.
- `getBehaviorTranslation(ItemStack stewStack)` returns an *ITextComponent* for the behavior translation from NBT if it's available, or from the display name of the built-in stew behavior.
- `writeEffectToStew(ItemStack stack, Effect effect, int duration)` adds the *effects* tag with an "*effect*" and a "*duration*", adding this tag to *behavior/properties*.
- `getBowlType(ItemStack stack)` returns an *ItemStack* of the bowl from NBT, or a vanilla Bowl if there's none in the NBT.