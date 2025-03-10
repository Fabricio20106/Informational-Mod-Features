# <center>- Wool Armor -</center>
### <center>A Guide & Documentation for Wool Armor</center>

Last updated: *19/03/2024*, for update *1.7.0 Pre-Release 2*.

## NBT Structure
- *(String)* `color_name`: A translation for what color it should display.
  - For example, `color.minecraft.green` would display as *"Green Wool Sweater"*.
- *(Integer)* `armor_design`: An integer determining what design this armor should have. Must be **non-negative**.
  - Design **1** is *"Glitch*".
- *(Compound)* `display`: A vanilla tag that contains information on how this item should be displayed.
  - *(Integer)* `color`: An integer that determines what color this item should have. Stored as a decimal value for a HEX value.
    - The default color for a wool armor, which isn't stored on the item, is `#ffffff`, or **16777215**.

## Wool Armor: Creating Your Own
Unlike exponential stews, wool armor isn't as easy to add a new item, due to some things, like the armor material name when using custom armor designs, being hardcoded. But there are a few things that can be done.

First, the item model: There isn't a specific method to generate these models, so you'll have to rely on `getBuilder(String)` to make these models. If you're making your own, you don't necessarily need to add the `design` predicate to have custom armor designs, but you can add it anyway.

Here's an example to how to add a wool armor piece model. This is assuming your item models generator class extends `VSItemModelModels`.
```java
    getBuilder("example_wool_sweater") // The id of your item.
        .parent(generated) // Parent for this item, "item/generated" is the default one.
        .texture("layer0", "item/example_wool_sweater") // What layers to use, and where to find the texture for this item.
        .override().predicate(armorDesign(), 1).model(getExistingFile(modLoc("item/example_wool_sweater_glitch_design"))).end();
        // ^ Adding the "design" predicate and the glitch armor design. The "1" represents what design this is.
        // ^ The "item/example_wool_sweater_glitch_design" part is referring to another item model you'll need to create separately.
```

Then, after generating/creating all necessary item models, you'll go where you register things with the **FMLClientSetupEvent**, which is most likely on a method on your main class or on a client proxy class.

Inside such method, you'll want to do the following:
```java
    // Adds the "design" property to your item, so the model overrides for the armor designs actually work.
    VSClientHelpers.addArmorDesigns(ExampleItems.EXAMPLE_WOOL_SWEATER.get());
```

After all of this is done, you will need to color the item. This can be done by making a class which has `@Mod.EventBusSubscriber` annotation, which has the *"modid"* set to your mod id and the bus to *"MOD"*.

Then, create a static void method that has a `ColorHandlerEvent.Block` parameter, and a `@SubscribeEvent` annotation. On this method, you'll want to add the following:

```java
    // Over here is how you add the design, and the color (if the design isn't present).
    event.getItemColors().register((stack, color) -> {
      if (stack.getTag() != null && stack.getTag().contains("armor_design")) {
          return -1;
      } else {
          return color > 0 ? -1 : ((IDyeableWoolArmorItem) stack.getItem()).getColor(stack);
      }
    }, ExampleItems.EXAMPLE_WOOL_SWEATER.get());
    // If you don't want to have the armor designs, you can use this one instead:
    event.getItemColors().register((stack, color) -> color > 0 ? -1 : ((IDyeableWoolArmorItem) stack.getItem()).getColor(stack), ExampleItems.EXAMPLE_WOOL_SWEATER.get());
```

After you're done will all of this, the only things remaining are the recipe files, the translations (there are 2), and optionally the villager trades and JEI repair items.

## Wool Armor: Useful Methods
While most of the code for wool armor is for internal use, there are some methods that could be useful of mods that aren't Variants itself.

Here's a list of these methods, their utility and possible applications.

<details>
<summary>WoolArmorItem --> Pick Random Color</summary>

### *pickRandomColor(ItemStack)* returns the input item stack, but with NBT data relating to wool armor.

More specifically, it adds a random `display.color` and `color_name` to the item, so when applied to a Wool Sweater, it shows up as a random color. This can be applied to any item capable of reading `display.color` and/or `color_name` (such as leather armor).

This method is used by:
  - **VSWeaponryTab** on `makeIcon()`, to pick a random wool sweater for the tab icon. Updated every world (re)load.
  - **VSEvents** on `addVillagerTrades(VillagerTradesEvent)`, to pick a random wool sweator for a Shepherd villager trade.

### How to Use
This method can be used by calling `WoolArmorItem.pickRandomColor()`, and passing an *ItemStack* as a parameter.

</details>

<details>
<summary>VSClientHelpers --> Add Wool Armor Color</summary>

### *woolArmorColor(String, int)* adds a new color to the `COLOR_NAME_TO_CODE` map on *WoolArmorItem*.

The problem of adding a color to the map using this method, it that **it will mess up the original order of the colors in the creative menu**. A better method will be considered in the future, potentially using Pairs or Lists.

### How to Use
This method can be called on the **FMLClientSetupEvent**, and it takes in a translation string for this color (eg. `"color.example.indigo"`), and an integer for the color (eg. `#551c79` / `0x551c79`).

</details>