# Wool Armor Color
> [!NOTE]
> This feature is exclusive to *Revaried*.
>
> ***Last Updated**: 1.8.0.9 (10-3-25)*

A **wool armor color** is a color or design for a wool armor piece (currently is only sweaters). Wool armor colors can be defined using JSON files in a data pack at the path `data/<namespace>/wool_armor_color/`.

## JSON Format
Wool armor colors are defined using the following format:

- <img src=Tags/compound_tag.png> The root object.
  - <img src=Tags/string_tag.png> **asset_id**: The resource location of this wool armor color. Should match the location of this file inside the data pack.
  > **If this wool armor color is a color:**
  - <img src=Tags/integer_tag.png> **color**: The color of this color definition. Uncapped, but recomended to stay within **0** and **16777215**.
  - <img src=Tags/string_tag.png> **color_name**: A translation key for this color definition's name. This is prepended with the wool armor item name.
  > **If this wool armor color is a design:**
  - <img src=Tags/integer_tag.png> **armor_design**: The number of this armor design. This is effectively the number of the custom model data for the item model.

## History
### Revaried
| Version | Changes |
|---------|---------|
| [1.8.0.3](/Revaried/Changelogs/1.16.5%20-%201.8.0.3/Changelog%201.8.0.3.md) | Added wool armor colors to data packs.
| [1.8.0.5](/Revaried/Changelogs/1.16.5%20-%201.8.0.5/Changelog%201.8.0.5.md) | <li> Removed the `red_yellow`, `aljan_light_blue`, `poison_brown` and `insomnian` armor colors. </li> <li> Internally, wool armor colors are now read as nullable integers instead of optional integers. </li> |

### Back Math
| Version | Changes |
|---------|---------|
| [*October 22nd, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2022-10-24/Changelog%2022-10-24.md) (1.8.0) | Added `red_yellow`, `aljan_light_blue`, `poison_brown` and `insomnian` wool armor colors. |

## Issues
Issues relating to "Wool armor color" are maintained on [Revaried's bug tracker](https://github.com/isabellawoods/Revaried/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) [Outfit Definition](/Back%20Math/Docs/Outfit%20Definition.md) ▪ ![](/Textures/navbox/queen_lucy_variant.png) [Queen Lucy Variant](/Back%20Math/Docs/Queen%20Lucy%20Variant.md) ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) [Wanderer Sophie Variant](/Back%20Math/Docs/Wanderer%20Sophie%20Variant.md) |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) [Bowl Type](/Revaried/Docs/Bowl%20Type.md) ▪ ![](/Textures/navbox/damage_source.png) [Damage Source](/Revaried/Docs/Damage%20Source.md) ▪ ![](/Textures/navbox/wool_armor_color.png) **Wool Armor Color** |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |