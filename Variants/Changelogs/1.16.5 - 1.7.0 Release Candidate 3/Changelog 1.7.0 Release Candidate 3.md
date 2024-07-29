<center> <img src=ChangelogPhoto.png width="1500"> </center>

# <center>- Variants - 1.7.0 Release Candidate 3 -</center>
### <center>A Variants Release Changelog made on *22/07/2024*</center>

## Additions
- Backported the `/damage` command.
  - Its syntax in my version is `/damage <target> <amount> <source> [by] [killer]` (`<>` means required, `[]` means optional).
    - Example: `/damage @s 20 minecraft:thorns by @e[type=pig,limit=1]`.
  - The damage sources that are available are:
    - All vanilla sources, including "even more magic" and "message too long";
    - All Variants' sources;
    - All data-driven sources added by my other mods (like `freeze` by The Mato).
- Added a `/stewbehavior` command.
  - As a result, the `setbehavior` command has been removed, and readded as `/stewbehavior set`.
  - Added a subcommand called `fix`, to fix various tags from exponential/vanilla suspicious stews.
    - This command has a target, and a type of tag to fix, those being:
      - **`exponential_stew`**: Executes the *"Exponential Stew Effects"* and *"bowl_name Tag"* fixes.
      - **`exponential_stew_effects`**: Moves the *"effects"* tag on the root tag to *behavior.properties*.
      - **`bowl_name_tag`**: Renames the *"bowl_type"* tag of Exponential Stews and its *"bowl_name"* and *"bowl_id"* subtags to *"bowl"*, *"name"* and *"texture_id"* respectively.
      - **`suspicious_stew_effects`**: Renames the *"Effects"* tag of Suspicious Stews and its *"EffectId"* and *"EffectDuration"* subtags to *"effects"*, *"id"* and *"duration"* respectively.
  - The `set` subcommand now fails silently when not run by a player in creative mode.
- Warping Vines are now registered as a feature.
  - They are currently still unused as *Feature* is weird.

### Translation Additions
- Added translations for *"Dry Out"* and *"death.fell.accident.water"* damage sources.

### Technical Additions
- Added two new damage sources: *"Even More Magic"* and *"Message Too Long"*.
- Added a Damage Sources Report data generator.

## Changes
- The *"Portable Mob Spawning™"* advancement is now a goal, and rewards 50 experience.
- Wool Armor dyeing now accepts all of my modded dyes.
- Glass (Pane)'s "Color" tooltip now only appear if advanced tooltips is on, and now shows after the other tooltips.
- Written Books now show their tags when Alt is held down.
- Spyglasses can now be crafted using amethyst shards added by *Caves & Cliffs Backport*.
- Powder Snow Bottles can now be crafted using powder snow buckets added by *The Mato*.
- Many crashes and errors relating to exponential stews with no NBT have been fixed. Stews...
  - Now check if their *"effects"* tag is null before applying effects.
  - No longer crash the Statistics menu when rendering the item.
  - With behaviors (not including *apply effects* or *default*) no longer crash when the `properties` tag is null.
    - The parameters of the behaviors now check if the properties tag is null, and if so it return the default.
- Stews now get properties from their constructor when they don't have NBT, such as:
  - The behavior tooltip, now it no longer shows *"404 Behavior Not Found"*.
  - The effects for an *Apply Effects* behavior.
- Some errors or other things relating to stylised pots have been fixed:
  - Pots now null-check when getting the poisoning type from NBT.
  - Pots now get their type tooltip from their constructor when the *"poisoning_type"* tag is null.
  - Pots now read and apply the `no_counter` effect tag. <sup>*[I still don't know what this really does]*</sup>

### Translation Changes (English)
- The stew behavior tooltip has been changed from "Stew Behavior: %s" to "Behavior: %s".

### Translations Changes (Brazilian Portuguese)
- The stew behavior tooltip has been changed from "Funcionamento de ensopado: %s" to "Funcionamento: %s".
- Renamed the exponential beetroot soup to "Ensopado de de beterraba", from "Ensoado de beterraba".
- Renamed the exponential water bowl to "Tigela de água", from "Tigela d'água".
- Renamed the *"Spawners Picked Up"* stat to "Geradores coletados em carrinhos".

### Technical Changes
- New damage sources can now be registered through datapacks.
  - Currently, the only places where these are used are in the `damage` command and in *damage entity* behaviors.
  - The folder where these are stored is in `data/<namespace>/damage_source`.
  - The format of the JSON file is essentially the same as the *damage entity* behavior.
- The biome reports data generator's errors are now translated.
- The error message when converting a stew behavior to JSON is now properly translated.
- Renamed the Enderwood Forest surface builder to `enderwood_forest`, from `enderwood_forest_old`.

#### Stew Behaviors
- `source` compounds inside the *Damage Entity* and *Explode* behaviors now have two new fields:
  - **`death_message_type`**: Controls what damage source is displayed on death. Its possible values are `default`, `direct_entity`, `indirect_entity` and `intentional_game_design`.
  - **`scaling`**: Replaces the `scales_with_difficulty` boolean tag. Its possible values are `always`, `when_caused_by_living_non_player`, and `never`.
    - This still controls whether this damage source scales with difficulty.
  - When making a new source with this field, the source is now added to the data-driven sources map with the `damage_behavior` namespace (by default).
- *Damage Entity* behavior now checks if the `message_id` tag is null before making it the message id.
- *Damage Entity* behavior's default damage is now 0.
- `source` string inside the *Damage Entity* behavior is now a resource location.
- The *DamageBehaviorSource* now returns super if the food exhaustion tag is null/not present.
- When writing damage sources to JSON, it now defaults to `minecraft:generic`.
- When writing damage sources to NBT, vanilla sources are now a resource location instead of a string.

## Tags
- Added `#melony:bows` item tag.
  - Items in this tag are only used by my other mods.
  - Contains Debug Bows.