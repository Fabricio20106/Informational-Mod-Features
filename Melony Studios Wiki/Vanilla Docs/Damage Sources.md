# Damage Source

**Damage sources** are the way Minecraft defines different kinds of damage that entities can take. They control which attributes the damage has as well as which death message is used when an entity dies due to that damage source.

On the vanilla game, the aspects of how damage is applied are dealt by various methods.

Damage sources added by the vanilla game and my own mods can be applied using the `/damage` command, backported by Variants, as long as it is included as a data-driven source.

## NBT Format (Exponential Stews)
> This feature is exclusive to the 1.16 version of *Variants*.

Damage sources are stored either as a compound or a string inside the `properties` tag, which itself is inside the `behavior` tag of exponential stews.

- The root `properties` tag.
  - *(String)* `source`: Used as part of the death message translation.
  - *(Compound)* `source`: The root tag for this source.
    - *(String)* `message_id`: Used as part of the death message translation.
    - *(Float)* `food_exhaustion`: The amount of hunger exhaustion caused by this damage source.
    - *(Enum)* `scaling`: How this damage source scales with difficulty.
    - *(Enum)* `death_message_type`: What kind of death message is produced when you die from this damage source.
    - *(Boolean)* `is_explosion`: Whether the damage is from an explosion or not.
    - *(Boolean)* `is_projectile`: Whether the damage is from a projectile or not.
    - *(Boolean)* `is_magic`: Whether the damage comes from something magic related or not.
    - *(Boolean)* `is_fire`: Whether the damage is from fire or or not lava.
    - *(Boolean)* `bypasses_armor`: Whether the damage goes through armor.
    - *(Boolean)* `bypasses_invulnerability`: Whether the damage goes through the `Invulnerability` tag.
    - *(Boolean)* `bypasses_magic`: Whether the damage goes through the Resistance effect.

For example, here is an example implementation for the `out_of_world` damage source in a stew behavior's NBT:

```json
  {
    source: {
      message_id: "outOfWorld", // Using the vanilla name for this damage source.
      scaling: "never",
      food_exhaustion: 0F,
      bypasses_armor: 1b,
      bypasses_invulnerability: 1b
    }
  }
```

And this is an example implementation of the same damage source, but as a JSON file:

```json
  {
    "message_id": "outOfWorld",
    "death_message_type": "default",
    "scaling": "never",
    "food_exhaustion": 0.0,
    "bypasses_armor": true,
    "bypasses_invulnerability": true
  }
```

## List of damage sources
### Vanilla:

<details>
<summary>All vanilla damage sources</summary>

| Damage source      | Sources                               |
|--------------------|---------------------------------------|
|`anvil`             |- A falling anvil hits something       |
|`bad_respawn_point` |- Explosion caused by using a bed or respawn anchor in the wrong dimension |
|`cactus`            |- Touching a cactus |
|`cramming`          |- When too many mobs are in one place (24 by default) |
| `dragon_breath`    |- Unused<sup>[[1]](https://bugs.mojang.com/browse/MC-84595)</sup> |
|`drown`             |- Ticking damage while drowning |
|`drown`             |- Snow golems, blazes, endermen, and striders in water/rain |
|`drown`             |- Bees underwater |
|`drown`             |- Dolphins and squid when not underwater for too long |
|`dry_out`           |- When dolphins are out of water for too long |
|`explosion`         |- When an end crystal takes damage and blows up |
|`explosion`         |- Damage to the ender dragon when the healing end crystal is destroyed |
|`explosion`         |- A wither fight starting |
|`explosion`         |- A minecart with TNT exploding, either from a flaming arrow or another reason |
|`explosion`         |- TNT exploding when its fuse runs out
|`explosion`         |- A creeper exploding when its fuse runs out |
|`explosion`         |- An explosion caused by a ghast fireball or wither skull |
|`explosion`         |- Explosions from the dragon respawn animation |
|`fall`              |- Falling too far |
|`fall`              |- A boat taking fall damage |
|`fall`              |- Teleporting with an ender pearl |
|`falling_block`     |- A non-anvil falling block hitting an entity |
|`fly_into_wall`     |- Colliding with terrain using an elytra |
|`generic`           |- Bees dying after stinging |
|`generic`           |- When reporting an end crystal killed by /kill to the dragon fight |
|`hot_floor`         |- Standing on a magma block |
|`in_fire`           |- Ticking damage while standing in a fire, soul fire or enderbreath fire block |
|`in_fire`           |- Ticking damage while standing on a lit campfire, soul campfire or enderbreath campfire
|`in_wall`           |- Ticking damage while suffocating
|`in_wall`           |- Ticking damage while outside the world border |
|`indirect_magic`    |- Instant damage from a harming/healing potion (drink, splash, or lingering) or jam |
|`indirect_magic`    |- Extra damage from a guardian's beam attack |
|`indirect_magic`    |- Evoker fangs with an owner dealing damage |
|`indirect_magic`    |- Damage dealt to snow golems, blazes, endermen, and striders from splash water bottles |
|`indirect_mob_attack` |- Llama spit and shulker bullets hitting an entity |
|`lava`              |- Ticking damage while in lava |
|`lightning_bolt`    |- When struck by lightning |
|`magic`             |- Simulating a kill with /loot kill |
|`magic`             |- Ticking damage from a Harming/Healing effect (i.e. not initial contact)
|`magic`             |- Ticking damage from a Poison effect |
|`magic`             |- Evoker fangs with no owner dealing damage |
|`magic`             |- A wither skull with no owner hitting something |
|`magic`             |- A conduit attack |

</details>

### Variants:
| Damage source      | Sources                               |
|--------------------|---------------------------------------|
|`bluestone_poisoning` |- Ticking damage from a Bluestone Poisoning effect |
|`explosive_blend_poisoning` |- Ticking damage from an Explosive Blend Poisoning effect |
|`glowstone_poisoning` |- Ticking damage from a Glowstone Poisoning effect |
|`gunpowder_poisoning` |- Ticking damage from a Gunpowder Poisoning effect |
|`redstone_poisoning` |- Ticking damage from a Redstone Poisoning effect |

### Back Math:
| Damage source      | Sources                               |
|--------------------|---------------------------------------|
|`chocoglued`        |- A chocoglue projectile hitting something |
|`hot_and_cold_meal` |- Finishing to eat a Hot Sophie and Cold Fabricio Meal |
|`mid_term_armor_instability` |- Any mid-term armor piece reaching 0 or 1 durability |
|`patience_tea`      |- Ticking damage from a Patience Tea effect |
|`poison_rose`       |- A poison rose checking if it can poison its bystander, but technically unused |
|`water_talc_powder` |- Finishing to eat a Water Talc Powder |

### The Mato:
| Damage source | Sources                                  |
|---------------|------------------------------------------|
|`freeze`       |- Ticking damage from the Freezing effect | 

## Scaling
Damage sources control how damage scales with difficulty.<sup>[*more information needed*]</sup>

On exponential stews, this is defined in `behavior.properties.source.scaling`.

- When `always`, the damage always scales with difficulty;
- When `when_caused_by_living_non_player`, the damage will scale if the entity causing it is a living entity but not a player;
- When `never`, the damage is always the same.

## Death Message Types
Damage sources mostly control what their death message will be. The only exception is `fall` damage, which is hardcoded.

On exponential stews, this is defined in `behavior.properties.source.death_message_type`.

- When `default`, the default method of making death messages is used;
- When `direct_entity`, the message will include the entity which killed the player;
- When `direct_entity`, the message will also include the entity which killed the player;
- When `intentional_game_design`, the message will be *"Player was killed by [[Intentional Game Design](https://bugs.mojang.com/browse/MCPE-28723)]"*.

## History
### Variants
| Version | Changes |
|---------|---------|
|1.6.2    |Added `poisoning.redstone`, `poisoning.bluestone`, `poisoning.glowstone`, `poisoning.gunpowder` and `poisoning.creeper_powder` |
|1.6.15.1 |Renamed `poisoning.creeper_powder` to `poisoning.explosive_blend` |
|1.7.0 Pre-Release 5 |Renamed all damage sources from `poisoning.<x>` to `<x>_poisoning`|
|1.7.0 Release Candidate 3 |Damage can now be dealt from the newly added `/damage` command |

### Back Math
| Release Date       | Changes |
|--------------------|---------|
|December 20th, 2022 |Added `hotAndColdMeal`, `waterTalcPowder`, `midTermArmorInstability` and `poisonRose` |
|April 4th, 2023     |Added `patienceTea` and `chocoglued` |
|August 5th, 2024    |Renamed all sources to snakecase, and added `went_americanas` and `went_food_and_drinks` |

### The Mato
| Version | Changes       |
|---------|---------------|
|0.3.3    |Added `freeze` |