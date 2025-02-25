# Damage Source
> [!NOTE]
> This feature is exclusive to *Revaried*.
>
> ***Last Updated**: 1.8.0.9 (24-2-25)*

**Damage sources** are the way Minecraft defines different kinds of damage that entities can take. Damage sources can be defined using JSON files in a data pack at the path `data/<namespace>/damage_source/`.

## JSON Format
Damage sources are defined using the following format:

- <img src=Tags/compound_tag.png> The root object.
  - <img src=Tags/string_tag.png> **message_id**: The message identifier for this damage source. Used for the death message translation.
  - <img src=Tags/float_tag.png> **food_exhaustion**: How much exhaustion this damage source should cause when applied.
  - <img src=Tags/string_tag.png> **scaling**: How this damage source should scale when in different difficulties. Can be one of:
    - `none`: Never scale damage depending on difficulty.
    - `when_caused_by_living_non_player` (*default*): Scale damage when it's caused by any living entity which isn't a player.
    - `always`: Always scale damage depending on difficulty.
  - <img src=Tags/string_tag.png> **death_message_type**: Which type of death message builder this damage source should use. Can be one of:
    - `default`: Use the default message builder. Only has the "*.player*" suffix.
    - `direct_entity`: <sup>*[please add information here]*</sup>
    - `indirect_entity`: <sup>*[please add information here]*</sup>
    - `intentional_game_design`: Use the "*\<player>* was killed by [[Intentional Game Design](https://bugs.mojang.com/browse/MCPE-28723)]" death message.
  - <img src=Tags/boolean_tag.png> **is_explosion**: *(optional)* Marks this damage source as coming from an explosion. Makes blast protection protect against this.
  - <img src=Tags/boolean_tag.png> **is_projectile**: *(optional)* Marks this damage source as being from a projectile. Makes projectile protection protect against this.
  - <img src=Tags/boolean_tag.png> **is_magic**: *(optional)* Marks this damage source as being from a magic source. Makes magic protection protect against this.
  - <img src=Tags/boolean_tag.png> **is_fire**: *(optional)* Marks this damage source as being from fire or lava. Makes fire protection protect against this.
  - <img src=Tags/boolean_tag.png> **is_thorns**: *(optional)* Marks this damage source as being from thorns. Produces the thorns hit sound when an entity takes damage from this source.
    - **This is only available when `death_message_type` is `direct_entity` or `indirect_entity`.** 
  - <img src=Tags/boolean_tag.png> **bypasses_armor**: Makes this damage source bypass any armor the target may be wearing.
  - <img src=Tags/boolean_tag.png> **bypasses_invulnerability**: Makes this damage source bypass any kind of invulnerability, like the `Invulnerable` tag or a creative mode player.
  - <img src=Tags/boolean_tag.png> **bypasses_magic**: Makes this damage source bypass any enchantments (like protection) the target may have.

## History
### Revaried
| Version | Changes |
|---------|---------|
| [1.7.0 Pre-Release 3](/Variants/Changelogs/1.16.5%20-%201.7.0%20Pre-Release%203/Changelog%201.7.0%20Pre-Release%203.md) | <li> Added damage sources to data packs. </li> <li> Backported the `/damage` command, which utilizes data-driven damage sources. </li> |
| [1.8.0.3](/Variants/Changelogs/1.16.5%20-%201.8.0.3/Changelog%201.8.0.3.md) | Added the `3dshareware:nightmare`, `vote_update:on_moon`, `vote_update:midas_touch`, `poisonous_potato_update:potato_heat` and `poisonous_potato_update:potato_magic` damage sources. |

### Back Math
| Version | Changes |
|---------|---------|
| [*August 5th, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2005-08-24/Changelog%2005-08-24.md) (1.8.0) | Added the `chocoglued`, `mid_term_armor_instability`, `patience_tea`, `poison_rose`, `temperature_meal`, `water_talc_powder`, `went_americanas` and `went_food_and_drinks` damage sources. |

### The Mato
| Version | Changes |
|---------|---------|
| 0.3.4   | Added the `freeze` damage source |

### Mob Taker
| Version | Changes |
|---------|---------|
| 1.5.0   | Added the `enderbreath`, `voided` and `watery` damage sources. |

## Issues
Issues relating to "Damage source" are maintained on [Revaried's bug tracker](https://github.com/Fabricio20106/Variants/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) [Outfit Definition](/Back%20Math/Docs/Outfit%20Definition.md) ▪ ![](/Textures/navbox/queen_lucy_variant.png) [Queen Lucy Variant](/Back%20Math/Docs/Queen%20Lucy%20Variant.md) ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) [Wanderer Sophie Variant](/Back%20Math/Docs/Wanderer%20Sophie%20Variant.md) |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) [Bowl Type](/Variants/Docs/Bowl%20Type.md) ▪ ![](/Textures/navbox/damage_source.png) **Damage Source** ▪ ![](/Textures/navbox/wool_armor_color.png) [Wool Armor Color](/Variants/Docs/Wool%20Armor%20Color.md) |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |