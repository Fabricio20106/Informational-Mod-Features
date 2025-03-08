# <div style="text-align: center;">- Back Math - December 27th, 2022 Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *01/03/2025*</div>

The **December 27th** update is a version for *Back Math* 1.8.0, released on December 27, 2022.[^1]

## Removals
- Removed the compatibility with *Mystical Agriculture*.
  - This includes the new crops, new items, related recipes and tags.

### Sounds
- Removed `entity.friend_sophie.shoot` and `entity.queen_sophie.summon_spell`.

## Changes
### Items
- Aljamic grass blocks are now tinted in the inventory.

## Technical
### Changes
- The `archerInsomniaSophieSpawn` config now defaults to `true`.
- The *"BackMath"* in the data generator names is now *"Back Math"*.
- The *"BM1.7.0"* in the insomnian tulip error messages is now *"Back Math"*.
- The modifier names of rainbow pencils is now *"Rainbow Pencil modifier"* instead of *"Weapon modifier"*.
- Removed the `SOPHIE_TOWER_LOOT` field from *BMResourceLocations*.
- Renamed the class *ShyFabricio.AvoidEntityGoal* to *ShyFabricio.ShyFabricioAvoidEntityGoal*.
- Renamed various fields across the code:
  - (*BMBlocks*) `deepslate_angelic_ore` --> `DEEPSLATE_ANGELIC_ORE`;
  - (*BMResourceLocations*) `HILARY_<STILL/FLOWING/OVERLAY>_RL` --> `HILLARY_<STILL/FLOWING/OVERLAY>_RL`;
  - (*BMResourceLocations*) `MILKLARY_<STILL/FLOWING/OVERLAY>_RL` --> `MILKLLARY_<STILL/FLOWING/OVERLAY>_RL`;
  - (*BMStaticFields*) `CANDY_YELLOW_TURTLE` --> `CANDY_YELLOW_TURTLE_ARMOR`;
  - (*BMStaticFields*) `CANDY_PINK_TURTLE` --> `CANDY_PINK_TURTLE_ARMOR`;
  - (*BMStaticFields*) `ALJAMIC_BONE` --> `ALJAMIC_BONE_ARMOR`;
  - (*BMStaticFields*) `INSOMNIA_SOPHIE_SLEEPWEAR` --> `INSOMNIA_SOPHIE_SLEEPWEAR_ARMOR`;
  - (*BMFeatures*) `IMMUTABLE_LIST_BACKMATH_FLOWERS` --> `BACK_FIELD_FLOWERS_IL`;
  - (*BMFeatures*) `BACKMATH_FLOWER_PATCH` --> `BACK_FIELD_FLOWER_PATCH`;
  - (*BMFeatures*) `KINDA_OF_LIST_TURTLE_FRIED_EGG_FLOWER` --> `TURTLE_FRIED_EGG_FLOWER_PATCH_IL`;
  - (*BMFeatures*) `BACKMATH_BEACH_FLOWER_PATCH` --> `TURTLE_FRIED_EGG_FLOWER_PATCH`;
  - (*BMFeatures*) `IMMUTABLE_LIST_ALJAN_FLOWERS` --> `ALJAN_WOODS_FLOWER_PATCH_IL`;
  - (*BMFeatures*) `IMMUTABLE_LIST_CAPPED_HILLS_FLOWERS` --> `CAPPED_HILLS_FLOWER_PATCH_IL`;
  - (*BMFeatures*) `IMMUTABLE_LIST_INSOMNIAN_FLOWERS` --> `INSOMNIAN_WOODS_FLOWER_PATCH_IL`;
  - (*BMFeatures*) `INSOMNIAN_FLOWER_PATCH` --> `INSOMNIAN_WOODS_FLOWER_PATCH`;
  - (*BMFeatures*) `IMMUTABLE_LIST_AMARACAMEL_STICKS_WCW` --> `AMARACAMEL_STICKS_WCW_PATCH_IL`;
  - (*BMFeatures*) `WILD_CARAMELED_WHEAT_PATCH` --> `AMARACAMEL_STICKS_WCW_PATCH`;
  - (*BMFeatures*) `PATCH_ALJANSHROOM` --> `ALJANSHROOM_PATCH`;
  - (*BMFeatures*) `PATCH_SLEEPSHROOM` --> `SLEEPSHROOM_PATCH`;
  - (*BMFeatures*) `PATCH_SLEEPYSHROOM` --> `SLEEPYSHROOM_PATCH`;
  - (*BMFeatures*) `DISK_INSOGRAVEL` --> `INSOGRAVEL_DISK`;
  - (*BMFeatures*) `DISK_ALJAMIC_SAND` --> `ALJAMIC_SAND_DISK`;
  - (*BMFeatures*) `IMMUTABLE_LIST_ALJAN_WOODS_WCW` --> `ALJAN_WOODS_WAO_PATCH_IL`;
  - (*BMFeatures*) `WILD_ALJAMIC_ONIONS_PATCH` --> `ALJAN_WOODS_WAO_PATCH`;

## References
[^1]: ["some big code cleanup"](https://github.com/Fabricio20106/Back-Math/commit/86ddad51997086f4bc9e448c3ba66a758502d770) (Commit `86ddad5`) – GitHub, December 27, 2022.