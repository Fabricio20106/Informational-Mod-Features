<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;"><p style="font-family:'Minecraft Five'">- Variants - 1.8.0.2 -</p></div>
### <div style="text-align: center;">A Variants Release Changelog made on *August 14th and 17th, 2024*</div>

**1.8.0.2** is the second version for [*Revaried 1.8.0*](/Variants/Changelogs/1.16.5%20-%201.8.0/Changelog%201.8.0.md), released on August 16, 2024.[^1][^2]

## <p style="font-family:'Minecraft Five'">Additions</p>
- Added an `explosionRadiusUpperLimit` config.
  - This controls what the maximum explosion radius for an *Explode* stew behavior is.
  - Defaults to `128`.
- Added a `soundPitchUpperLimit` config.
  - This controls what the maximum pitch for a *Play Sound* behavior is.
  - Defaults to `2`.
- Both of these configs are inside a `stewBehaviors` block, and their maximum value is `Float.MAX_VALUE`.
- Added an *Add Experience* stew behavior.
  - This behavior takes in an `amount` integer field, and an optional `level` boolean field.
  - The `level` field controls whether it will give you experience points or levels.
  - This behavior is properly saved to JSON in the exponential stew recipes.
- Added 2 new fixing subcommands: *"correct_ender_bowl"*, and *"old_stew_behavior_names"*.
  - **Correct Ender Bowl**: Swaps the Ender Bowl item in stews to Enderwood Bowl.
  - **Old Stew Behavior Names**: Swaps the old behavior names (`milk`, `lava` and `effect`) for the new names (`clear_mob_effects`, `ignite` and `apply_mob_effects`).

### <p style="font-family:'Minecraft Five'">Technical Additions</p>
- Bowl types are now data-driven.<sup>*[not yet, but working on it]*</sup>
  - This is an example for the JSON format for the bowl types:
```json
{
  "asset_id": "melonyexamples:example",
  // This is the item you're going to get when eating this stew.
  "bowl": {
    "id": "melonyexamples:example_bowl",
    "count": 1
    // Eventually I'll add the "tag" and "forge_capabilies" fields.
  },
  // Used by the data generator to make the models.
  "name": "example",
  // Used by the exponential stew model overrides.
  "texture_id": 11
} 
```
  - Bowl types are stored inside `data/<namespace>/bowl_type`.
  - Will log a warning if the texture id being used is already being used by another bowl type.
  - Currently, the only thing that works is the data generator and the JSON loading system.

### <p style="font-family:'Minecraft Five'">Translation Additions</p>
- Flammable items can now draw their burn time from a `burn_time` tag.
- The error message of the `convertToString()` method inside the *SetStewBehavior* class is now translated.

## <p style="font-family:'Minecraft Five'">Changes</p>
- The rarity of the "dog" music disc is now *uncommon*.
- Stew behaviors can now add their own tooltips to the exponential stew item.
  - Currently, the only behavior that uses this is the *Apply Effects*, which adds the effects (and their attributes) to the tooltip, like the food effects.
  - These tooltips can be hidden using the `hide_behavior_tooltips` hiding tag.
- The `no_counter` tag in exponential stews and in the `getEffectsFromNBT()` method now defaults to `false`.
- Tags shown when holding Alt will now have line breaks between each tag.
  - Sometimes it may not work and will just display a line break character.
- Lava Bottles and Soul Lava Bottles can now draw their burn time from a `seconds_on_fire` integer tag.
- Milk Bottles can now draw their curative item from a `curative_item` compound tag.
- Curative items can now be saved and read from the effects tag.

### <p style="font-family:'Minecraft Five'">Technical Changes</p>
- Updated the IDs for many blocks, items, entities and biomes for Variants. These changes are documented in the table on the bottom of the page.
  - All textures were also renamed.
- Both `sounds.json` files are now data-generated.
  - This means the empty sound events `variants:entity.fish.ambient` and `variants:stew_behavior.play_sound.default` are no longer included.
- Renamed the `resourceLoc` method inside the main *Variants* class to `variants`.
- The *"name"* tag inside the *"bowl"* tag of exponential stews has now been renamed to *"item"*, and is now a compound.
  - The format used to save the item is different to a regular item stack.
  - The item id is still stored as `id`, but the count is now a `count` (lowercase) integer tag, and the tags are now called `components`.
  - The item count is no longer saved when it is the default (1).
  - This format, however, does not allow for Forge capabilities to be saved and read from NBT.
    - This is also used to store the item stack inside the *Clear Effects* behavior, debug arrow entity's item, milk bottle, and bowl type serialization.
- The effect amplifier's default value is no longer stored on the recipe files for exponential stews.
- The exponential stew recipe data generator now uses bowl types for its recipes.
- Exponential stew's effect tags now accept any numbers, not only bytes.
- Block flags used in Variants' classes are now defined in the *Constants.BlockFlags* class.
- World events used in Variants' classes are now referenced from *Constants.WorldEvents* class (the Forge constants class).
- The duplicate texture id warning message is now properly displayed.
- Removed the `backmath:mid_term_armor_instability` damage source as an example for the `/damage` command.

### <p style="font-family:'Minecraft Five'">Translation Changes</p>
- Renamed the phantom membrane and rabbit hide tunics to sweaters.

### <p style="font-family:'Minecraft Five'">Translation Changes (Brazilian Portuguese)</p>
- The enderwood forest name in the *"It's Never Coming\*"* advancement has been corrected to "Floresta Enderwood".
- All enderwood items have been renamed from *"\<item> de madeira to End"* to *"<item> do End"*.
- Removed an extra comma on the *"Apply Effects"* description.

## <p style="font-family:'Minecraft Five'">Tags</p>
- Removed Prismarine, Prismarine Bricks, Dark Prismarine and Sea Lanterns from `#variants:conduit_frame_blocks` block tag.
- Added `#variants:cannot_run_without_nbt` stew behavior tag.
  - Does not contain anything.
  - Stew behaviors in this tag cannot run when either the `behavior` or `properties` tags are null.

## <p style="font-family:'Minecraft Five'">ID Updates</p>

| Type           | Old Name                      | New Name                    |
|----------------|-------------------------------|-----------------------------|
| Block and Item | `ender_stem`                  | `enderwood_stem`            |
| Block and Item | `ender_hyphae`                | `enderwood_hyphae`          |
| Block and Item | `stripped_ender_stem`         | `stripped_enderwood_stem`   |
| Block and Item | `stripped_ender_hyphae`       | `stripped_enderwood_hyphae` |
| Block and Item | `ender_planks`                | `enderwood_planks`          |
| Block and Item | `ender_bookshelf`             | `enderwood_bookshelf`       |
| Block and Item | `ender_stairs`                | `enderwood_stairs`          |
| Block and Item | `ender_slab`                  | `enderwood_slab`            |
| Block and Item | `ender_fence`                 | `enderwood_fence`           |
| Block and Item | `ender_fence_gate`            | `enderwood_fence_gate`      |
| Block and Item | `ender_pressure_plate`        | `enderwood_pressure_plate`  |
| Block and Item | `ender_button`                | `enderwood_button`          |
| Block and Item | `ender_trapdoor`              | `enderwood_trapdoor`        |
| Block and Item | `ender_door`                  | `enderwood_door`            |
| Block and Item | `ender_sign`                  | `enderwood_sign`            |
| Block          | `ender_wall_sign`             | `enderwood_wall_sign`       |
| Block and Item | `mossy_purpur_block_stairs`   | `mossy_purpur_stairs`       |
| Block and Item | `mossy_purpur_block_slab`     | `mossy_purpur_slab`         |
| Block and Item | `mossy_purpur_block_wall`     | `mossy_purpur_wall`         |
| Block and Item | `gold_cauldron`               | `golden_cauldron`           |
| Block and Item | `gold_beacon`                 | `golden_beacon`             |
| Block and Item | `ender_sprouts`               | `end_sprouts`               |
| Item           | `old_cod_spawn_egg`           | `fish_spawn_egg`            |
| Item           | `old_cod_bucket`              | `fish_bucket`               |
| Item           | `ender_boat`                  | `enderwood_boat`            |
| Item           | `lava_glass_bottle`           | `lava_bottle`               |
| Item           | `milk_glass_bottle`           | `milk_bottle`               |
| Item           | `creeper_powder_pot`          | `explosive_blend_pot`       |
| Item           | `old_cod`                     | `fish`                      |
| Item           | `old_cooked_cod`              | `cooked_fish`               |
| Item           | `ender_stick`                 | `enderwood_stick`           |
| Item           | `ender_bowl`                  | `enderwood_bowl`            |
| Item           | `soul_rod`                    | `soul_blaze_rod`            |
| Item           | `soul_powder`                 | `soul_blaze_powder`         |
| Item           | `diamond_nugget`              | `diamond_shard`             |
| Item           | `emerald_nugget`              | `emerald_shard`             |
| Item           | `quartz_nugget`               | `quartz_shard`              |
| Item           | `purple_nugget`               | `purple_iron_nugget`        |
| Item           | `phantom_membrane_sweatchest` | `phantom_membrane_sweater`  |
| Item           | `rabbit_hide_sweatchest`      | `rabbit_hide_sweater`       |
| Item           | `wool_sweatchest`             | `wool_sweater`              |
| Item           | `crystal_shears`              | `magentic_crystal_shears`   |
| Item           | `light_magenta_shears`        | `magentic_shears`           |
| Entity Type    | `old_cod`                     | `fish`                      |
| Biome          | `ender_forest`                | `enderwood_forest`          |

### <p style="font-family:'Minecraft Five'">References</p>
[^1]: ["1.8.0.2 (Part I): Data-Driven Bowl Types & Data-Generated sounds.json"](https://github.com/Fabricio20106/Variants/commit/779aa6327a28c81c13ecf7ebaafd0dc2192e007f) (Commit `779aa63`) – GitHub, August 9, 2024.
[^2]: ["1.8.0.2 (Part 2): Semi-Working Data-Driven Bowls & Renames"](https://github.com/Fabricio20106/Variants/commit/82e99f7961e709e636dc95ffcb5fb23c89794058) (Commit `82e99f7`) – GitHub, August 16, 2024.