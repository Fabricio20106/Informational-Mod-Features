# <div style="text-align: center;">- Consumables -</div>
### <div style="text-align: center;">*A Guide and Documentation of all things consumable - Made on 20/11/2024*</div>

## NBT Format
- <img src=Tags/compound_tag.png> Root tag for this item.
  - <img src=Tags/compound_tag.png> **consumable**: The main tag for consumable items. This tag only applies changes to Variants' consumables.<sup>*[until 1.8.0.7]*</sup>
    - <img src=Tags/string_tag.png> **animation**: The animation played when eating this item. Can be one of `none`, `eat`, `drink`, `block`, `bow`, `crossbow` and `trident`. Defaults to `eat`.
    - <img src=Tags/compound_tag.png> **behavior**: The consume behavior to execute when this item is eaten.
      - <img src=Tags/string_tag.png> **id**: The id of the consume behavior to run.
      - > **Any other behavior-specific tags**
    - <img src=Tags/integer_tag.png> **consume_ticks**: A non-negative integer that controls how many ticks it takes to eat this item. Defaults to `32` on foods and `16` on "fast foods".
    - <img src=Tags/integer_tag.png> **cooldown**: A non-negative integer of how many ticks cooldown will be applied for after finishing to eat this item. Defaults to `0`.
    - <img src=Tags/string_tag.png> **shatter_sound**: A sound event id to play when a thrown bottle shatters. Defaults to `variants:entity.thrown_bottle.shatter`.
    - <img src=Tags/string_tag.png> **sound**: A sound event id to play when using this item. The burp sound is not affected by this. Defaults to `minecraft:entity.generic.eat`.
    - <img src=Tags/compound_tag.png> **use_remainder**: The item left after eating this item.
      > **Tags common to all items saved by Variants:**
      > - <img src=Tags/string_tag.png> **id**: The id of the item.
      > - <img src=Tags/integer_tag.png> **count**: How many items there are in this stack. Effectively capped at 127 due to the default count tag being a <img src=Tags/short_tag.png> short.
      > - <img src=Tags/compound_tag.png> **components**: The tags this item stack has.
  - <img src=Tags/float_tag.png> **texture_id**: *(Unused)* The texture identifier for item model overrides.
  - <img src=Tags/integer_tag.png> **texture_id**: The texture identifier for item model overrides. Used by exponential stews and stained bottles.

## Behavior Format
The behavior tag is where a consume behavior gets its properties from. It usually defaults to `consumable.behavior`, but it can be in `consumable.behavior.behaviors[]` if ran from a multi-behavior.

Some behaviors, however, have some of their properties gotten straight from the default location, resulting in some parts of behaviors not working properly when ran from a multi-behavior.<sup>[[1]](https://github.com/Fabricio20106/Variants/issues/7)[[2]](https://github.com/Fabricio20106/Variants/issues/9)</sup>

In code, any compound tag can be a property tag if needed.

### Default (`DefaultConsumeBehavior`)
<sup>**Registry Name**: `variants:default` | **Translation**: Default (None)</sup>

This is the default behavior for items that don't do anything.

- <img src=Tags/compound_tag.png> The behavior tag.
  - *No fields.*

### Add Experience (`AddExperienceBehavior`)
<sup>**Registry Name**: `variants:add_experience` | **Translation**: Add Experience</sup>

Adds a certain amount of experience points or levels.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/integer_tag.png> **amount**: The amount of experience points or levels to give to the player. Defaults to `0`.
  - <img src=Tags/boolean_tag.png> **levels**: Whether to give experience levels (true) or points (false). Defaults to `false`.

### Apply Effects (`ApplyMobEffectsBehavior`)
<sup>**Registry Name**: `variants:apply_mob_effects` | **Translation**: Apply Effects</sup>

Applies various effects to the entity eating.

This behavior shows what effects it will apply on the item's tooltip. However, this only shows up when running in the default location.<sup>[[2]](https://github.com/Fabricio20106/Variants/issues/9)</sup>

- <img src=Tags/compound_tag.png> The root tag for this item.
  - <img src=Tags/float_tag.png> **duration_factor**: Changes *only* the displayed duration of the effects. This value is shown on the item's tooltip.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/list_tag.png> **effects**: A list of effects to apply.
    - <img src=Tags/compound_tag.png> A single effect compound.
      - <img src=Tags/string_tag.png> **id**: A resource location of the effect id to apply. This is the only field that's needed.
      - <img src=Tags/integer_tag.png> **duration**: A non-negative integer of how long this effect will last in ticks.
      - <img src=Tags/integer_tag.png> **amplifier**: How strong this effect is.
      - <img src=Tags/boolean_tag.png> **ambient**: Whether this effect comes from an ambient source, like a beacon or conduit.
      - <img src=Tags/boolean_tag.png> **show_particles**: Whether particles should be produced for this effect.
      - <img src=Tags/boolean_tag.png> **show_icon**: Whether this effect should have its icon displayed on menus and HUDs.
      - <img src=Tags/boolean_tag.png> **no_counter**: Whether this effect should have its duration hidden on tooltips.
      - <img src=Tags/list_tag.png> **curative_items**: A list of items that can be used to cure this effect.
        - <img src=Tags/compound_tag.png> A single compound.
          > **Tags common to all items saved by Variants:**
          > - <img src=Tags/string_tag.png> **id**: The id of the item.
          > - <img src=Tags/integer_tag.png> **count**: How many items there are in this stack. Effectively capped at 127 due to the default count tag being a <img src=Tags/short_tag.png> short.
          > - <img src=Tags/compound_tag.png> **components**: The tags this item stack has.

### Clear Effects (`ClearMobEffectsBehavior`)
<sup>**Registry Name**: `variants:clear_mob_effects` | **Translation**: Clear Effects</sup>

Clears all effects from the entity eating, like a milk bucket.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/compound_tag.png> **curative_item**: The item used to clear all effects. Defaults to a milk bucket.
    > **Tags common to all items saved by Variants:**
    > - <img src=Tags/string_tag.png> **id**: The id of the item.
    > - <img src=Tags/integer_tag.png> **count**: How many items there are in this stack. Effectively capped at 127 due to the default count tag being a <img src=Tags/short_tag.png> short.
    > - <img src=Tags/compound_tag.png> **components**: The tags this item stack has.

### Damage Entity (`DamageEntityBehavior`)
<sup>**Registry Name**: `variants:damage_entity` | **Translation**: Damage Entity</sup>

Damages the entity with a pre-existing or custom damage source. See [**damage source definition**](https://github.com/Fabricio20106/Variants/wiki/Damage-Source-Definition) for how to add new damage sources through data packs.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/float_tag.png> **amount**: How much damage should be applied to the entity. Defaults to `0`.
  - <img src=Tags/string_tag.png><img src=Tags/compound_tag.png> **source**: The damage source to hurt the entity with.
    > **If defined as a string:**
    > - A resource location of a damage source to be used. Damage sources were made data-driven by Variants, and new ones can be defined in `data/<namespace>/damage_source`.
<details>
<summary>Click to show the damage source compound definition</summary>

- **Damage source definition:**
    > **If defined as a compound:**
    > - <img src=Tags/string_tag.png> **message_id**: The message identifier for this damage source. Used for the death message translation.
    > - <img src=Tags/float_tag.png> **food_exhaustion**: How much exhaustion this damage source should cause when applied.
    > - <img src=Tags/string_tag.png> **scaling**: How this damage source should scale when in different difficulties. Can be one of:
    >   - `none`: Never scale damage depending on difficulty.
    >   - `when_caused_by_living_non_player` (*default*): Scale damage when it's caused by any living entity which isn't a player.
    >   - `always`: Always scale damage depending on difficulty.
    > - <img src=Tags/string_tag.png> **death_message_type**: Which type of death message builder this damage source should use. Can be one of:
    >   - `default`: Use the default message builder. Only has the "*.player*" suffix.
    >   - `direct_entity`: <sup>*[please add information here]*</sup>
    >   - `indirect_entity`: <sup>*[please add information here]*</sup>
    >   - `intentional_game_design`: Use the "*\<player>* was killed by [[Intentional Game Design](https://bugs.mojang.com/browse/MCPE-28723)]" death message.
    > - <img src=Tags/boolean_tag.png> **is_explosion**: *(optional)* Marks this damage source as coming from an explosion. Makes blast protection protect against this.
    > - <img src=Tags/boolean_tag.png> **is_projectile**: *(optional)* Marks this damage source as being from a projectile. Makes projectile protection protect against this.
    > - <img src=Tags/boolean_tag.png> **is_magic**: *(optional)* Marks this damage source as being from a magic source. Makes magic protection protect against this.
    > - <img src=Tags/boolean_tag.png> **is_fire**: *(optional)* Marks this damage source as being from fire or lava. Makes fire protection protect against this.
    > - <img src=Tags/boolean_tag.png> **bypasses_armor**: Makes this damage source bypass any armor the target may be wearing.
    > - <img src=Tags/boolean_tag.png> **bypasses_invulnerability**: Makes this damage source bypass any kind of invulnerability, like the `Invulnerable` tag or a creative mode player.
    > - <img src=Tags/boolean_tag.png> **bypasses_magic**: Makes this damage source bypass any enchantments (like protection) the target may have.

</details>

### Eat Item (`EatItemBehavior`)
<sup>**Registry Name**: `variants:eat_item` | **Translation**: Eat Item</sup>

Makes the entity eat an item.

*Item*`.finishUsingItem(ItemStack, World, LivingEntity)` method is called when this method is executed.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/compound_tag.png> **consumable_item**: The item for the entity to eat.
    > **Tags common to all items saved by Variants:**
    > - <img src=Tags/string_tag.png> **id**: The id of the item.
    > - <img src=Tags/integer_tag.png> **count**: How many items there are in this stack. Effectively capped at 127 due to the default count tag being a <img src=Tags/short_tag.png> short.
    > - <img src=Tags/compound_tag.png> **components**: The tags this item stack has.

### Explode (`ExplodeBehavior`)
<sup>**Registry Name**: `variants:explode` | **Translation**: Explode</sup>

Creates an explosion when the entity finishes eating. The explosion has the entity as its owner, causing it to not damage the entity.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/float_tag.png> **radius**: The radius of the explosion. Ranges from `0` to `128`. Maximum is defined by the config `explosionRadiusUpperLimit`.
  - <img src=Tags/boolean_tag.png> **create_fire**: *(optional)* Whether this explosion creates fire. Defaults to `false`.
  - <img src=Tags/boolean_tag.png> **spawn_effect_cloud**: *(optional)* Whether to create an area effect cloud with the explosion. Defaults to `true`.
    - Effects are always read from `consumable.behavior.effects[]`, even when executed from a multi-behavior.<sup>[[1]](https://github.com/Fabricio20106/Variants/issues/7)</sup>
  - <img src=Tags/string_tag.png><img src=Tags/compound_tag.png> **source**: The damage source to use in this explosion. Uses the same format as the *damage entity* behavior.
  - <img src=Tags/string_tag.png> **mode**: How this explosion should behave. Can be one of:
    - `none`: No blocks are broken.
    - `break`: Break and drop all blocks.<sup>*[verify]*</sup>
    - `destroy`: Break all blocks but not drop some.<sup>*[verify]*</sup>
  - <img src=Tags/integer_array_tag.png> **pos**: An array of three integers of where to cause this explosion.

### Ignite (`IgniteBehavior`)
<sup>**Registry Name**: `variants:ignite` | **Translation**: Ignite</sup>

Sets the entity on fire for a specific amount of ticks.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/integer_tag.png> **ticks_on_fire**: How many ticks this entity should be on fire for. Rounded to seconds when applied. Defaults to `100`.

### Multi-Behavior (`MultiBehavior`)
<sup>**Registry Name**: `variants:multi_behavior` | **Translation**: Multi-Behavior</sup>

Runs multiple consume behaviors at once.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/list_tag.png> **behaviors**: A list of consume behaviors.
    - <img src=Tags/compound_tag.png> A single behavior.
      - <img src=Tags/string_tag.png> **id**: The id of the consume behavior to run.
      - > **Any other behavior-specific tags**

### Play Sound (`PlaySoundBehavior`)
<sup>**Registry Name**: `variants:play_sound` | **Translation**: Play Sound</sup>

Plays a sound where the entity is or at a specific position.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/string_tag.png> **sound**: A resource location of the sound event to play. Can be a sound added by resource packs.
  - <img src=Tags/string_tag.png> **category**: What category to use when playing this sound. Can be one of `master`, `music`, `record`, `weather`, `block`, `hostile`, `neutral`, `player`, `ambient` or `voice`.
    - These are **Master Volume**, *Music*, **Jukebox/Note Blocks**, *Weather*, **Blocks**, *Hostile Creatures*, **Friendly Creatures**, *Players*, **Ambient/Environment** and *Voice/Speech*, respectively.
  - <img src=Tags/integer_array_tag.png> **pos**: An array of three integers of where to play this sound.
  - <img src=Tags/boolean_tag.png> **play_at_player**: Whether to assign this sound to the player eating. Defaults to `false`.
  - <img src=Tags/float_tag.png> **volume**: The volume to play this sound at. Clamped from `0` to `(2-2^-23) · 2^127`.
  - <img src=Tags/float_tag.png> **pitch**: The pitch to play this sound with. Ranges from `0` to `2`. Maximum is defined by the config `soundPitchUpperLimit`.
  - <img src=Tags/boolean_tag.png> **use_sound_packet**: Whether this sound should send a *SPlaySoundPacket* to the player instead of playing it normally. **This field is *not* read from or written to NBT**.

### Remove Effects (`RemoveEffectsBehavior`)
<sup>**Registry Name**: `variants:remove_effects` | **Translation**: Remove Effects</sup>

Removes a specified list of effects. Defaults to removing poison.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/list_tag.png> **effects**: A list of effects to remove.
    - <img src=Tags/string_tag.png> A resource location of an effect.

### Teleport Entity (`TeleportEntityBehavior`)
<sup>**Registry Name**: `variants:teleport_entity` | **Translation**: Teleport Entity</sup>

Teleports the entity eating to a specified position or to a random position within a radius.

This behavior shows its teleport diameter or position on the item's tooltip.

- <img src=Tags/compound_tag.png> The behavior tag.
  - <img src=Tags/boolean_tag.png> **random_teleport**: Whether to teleport to a random position within a radius or not.
  - <img src=Tags/float_tag.png> **teleport_diameter**: The diameter of where to take a random position from. Only used if `random_teleport` is true. Defaults to `8`.
  - <img src=Tags/integer_array_tag.png> **teleport_pos**: An array of three integers indicating where to teleport. Only use if `random_teleport` is false. Defaults to the entity's current position.

## References
1. [VS-7](https://github.com/Fabricio20106/Variants/issues/7): Explode behavior effect clouds always get effects from `behavior.effects[]`, even when in multi-behaviors
2. [VS-9](https://github.com/Fabricio20106/Variants/issues/9): Apply Effects behavior tooltip always gets effects from `behavior.effects[]`, even when in multi-behaviors