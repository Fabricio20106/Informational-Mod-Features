# Block Entity Tags

## General
- Lock (`Lock`): String

## Furnace (`furnace`), Smoker (`smoker`) & Blast Furnace (`blast_furnace`)
- Cooking Time (`CookTime`): Integer.<sup>[progress to total cooking time]</sup>
- Total Cooking Time (`CookTimeTotal`): Integer.<sup>[defined by recipe]</sup>
- Remaining Fuel Time (`BurnTime`): Integer.
- Items (`Items`): Stored *ItemStack*s (3 total).
  - Input
  - Fuel
  - Output
- Recipes Used (`RecipesUsed`): Recipe to integer map.

## Chest (`chest`), Trapped Chest (`trapped_chest`), Dispenser (`dispenser`) & Dropper (`dropper`)
- Items (`Items`): Stored *ItemStack*s (27 total).

## Jukebox (`jukebox`)
- Record Item (`RecordItem`): Single-slot *ItemStack*.

## Any Sign (`sign`)
- Text Color (`Color`): Any *DyeColor*s.
- Text (`Text1`, `Text2`, `Text3` and `Text4`): Stringified Text Components.

## Monster Spawner (`mob_spawner`)
- Maximum Nearby Entities (`MaxNearbyEntities`): Short (Default: `6`).
- Required Player Range (`RequiredPlayerRange`): Short (Default: `16`).
- Maximum Spawn Count (`SpawnCount`): Short (Default: `4`).
- Spawn Data (`SpawnData`): Compound.
  - Entity (`id`): Entity ID to spawn.
- Maximum Spawn Delay (`MaxSpawnDelay`): Short (Default: `800`).
- Spawn Delay (`Delay`): Short (Default: `0`).
- Spawn Range (`SpawnRange`): Short (Default: `4`).
- Minimum Spawn Delay (`MinSpawnDelay`): Short (Default: `200`).
- Potential Spawns (`SpawnPotentials`): List of compounds.
  - (`Entity`): Compound
    - Entity (`id`): Entity ID to spawn.
    - Weight (`Weight`): Weight to pick this entity.

## Moving Piston (`piston`)
- Block State (`blockState`): Block being pushed.
  - Properties (`Properties`): Block properties (String to property map).
  - Block (`Name`): Block ID.
- Facing Direction (`facing`): Integer.
- Movement Progress (`progress`): Float.
- Is Source (`source`): Boolean.
- Is Extending (`extending`): Boolean.

## Brewing Stand (`brewing_stand`)
- Remaining Blaze Powder (`Fuel`): Integer.
- Items (`Items`): Five *ItemStack*s
  - First three are the potion, fourth is the ingredient, and the fifth is the blaze powder.
- Brewing Time (`BrewTime`): Integer.<sup>[Time remaining util potion is done]</sup>

## Beacon (`beacon`)
- Primary Effect (`Primary`): Main effect, Integer.
- Secondary Effect (`Secondary`): Secondary Effect, Integer.
- Level (`Levels`): Beacon level, Integer.

## Hopper (`hopper`)
- Transfer Cooldown (`TransferCooldown`): Integer.
- Items (`Items`): Five *ItemStack*s.

## Redstone Comparator (`comparator`)
- Output Signal (`OutputSignal`): Integer (`0-15` probably).

## Any Banner (`banner`)
- Banner Patterns (`Patterns`): List of Compounds.
  - Single Compound.
    - Pattern (`Pattern`): Short name of the pattern, String.
    - Color (`Color`): Color, Integer.

## Structure Block (`structure_block`)
- Metadata (`metadata`): String.
- Mirroring (`mirror`): One of `NONE`, `LEFT_RIGHT` or `FRONT_BACK`.
  - *"None"*, *"Left-right"* or *"Front-back"*.
- Ignore Entities (`ignoreEntities`): Boolean.
- Powered (`powered`): Boolean.
- Seed (`seed`): Long.
- Author: (`author`): Minecraft username, String.
- Rotation (`rotation`): One of `NONE`, `CLOCKWISE_90`, `CLOCKWISE_180` or `COUNTERCLOCKWISE_90`.
  - *"No Rotation"*, *"90º Clockwise"*, *"180º Clockwise"* or *"90º Counter-clockwise"*.
- Position (`posX`, `posY` and `posZ`): Bottom-right corner of the structure.
- Size (`sizeX`, `sizeY` and `sizeZ`): Size of the structure.
- Mode (`mode`): One of `SAVE`, `LOAD`, `CORNER` or `DATA`.
  - *"Save"*, *"Load"*, *"Corner"* or *"Data"*.
- Integrity (`integrity`): Integer.
- Show Air: (`showair`): Boolean.
- Show Bounding Box (`showboundingbox`): Boolean.
- Name (`name`): Structure name.

## End Gateway (`end_gateway`)
- Age (`Age`): Long.
- Exact (`ExactTeleport`): Boolean.
- Exit Location (`ExitPortal`): Three block positions.

## Any Command Block (`command_block`)
- Conditions Met (`conditionMet`): Boolean.
- Always Active (`auto`): Boolean.
- Name (`CustomName`): Text Component.
- Powered (`powered`): Boolean.
- Command (`Command`): String.
- Success Count (`SuccessCount`): Integer.
- Track Output (`TrackOutput`): Boolean.
- Update Last Execution (`UpdateLastExecution`): Boolean.

## Any Shulker Box (`shulker_box`)
- Items (`Items`): Twenty seven *ItemStack*s.

## Barrel (`barrel`)
- Items (`Items`): Twenty seven *ItemStack*s.

## Lectern (`lectern`)
- Book (`Book`): Single-slot *ItemStack*.
- Page Open (`Page`): Current open page, Integer.

## Jigsaw (`jigsaw`)
- Joint Type (`joint`): Either `rollable` or `aligned`.
  - *"Rollable"* or *"Aligned"*
- Name (`name`): Resource Location.
- Target Pool (`pool`): Resource Location.
- Target Name (`target`): Resource Location.
- Final State (`final_state`): Block ID.

## Any Campfire (`campfire`)
- Items (`Items`): Four seven *ItemStack*s.
- Cooking Times (`CookingTimes`): Integer Array.
- Total Cooking Times (`CookingTimesTotal`): Integer Array.

## Bee Nest or Beehive (`beehive`)
- Bees (`Bees`): A list of three compounds.
  - Single Compound.
    - Minimum Occupation Ticks (`MinOccupationTicks`): Integer.
    - Ticks in Bee Hive (`TicksInHive`): Integer.
    - Bee Data (`EntityData`): A bee entity.