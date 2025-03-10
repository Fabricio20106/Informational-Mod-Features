# Outfit Definition
> [!NOTE]
> This feature is exclusive to *Back Math*.
>
> ***Last Updated**: 1.9.0.6 (10-3-25)*

An **outfit definition** is a set of textures to use for an outfit item or `outfit` tag. Outfit definitions can be defined using JSON files in a data pack at the path `data/<namespace>/outfit_definition/`.

## JSON Format
Outfit definitions are defined using the following format.

- ![](/Variants/Docs/Tags/compound_tag.png) The root object.
  - ![](/Variants/Docs/Tags/string_tag.png) **asset_id**: The resource location of this outfit definition. Should match the filename and namespace of this outfit.
  - ![](/Variants/Docs/Tags/compound_tag.png) **head**: *(optional)* The head outfit slot. Used when getting a texture for the entity's head.
    - ![](/Variants/Docs/Tags/string_tag.png) **texture**: A resource location for the texture used by this outfit slot. Omits the `textures/` prefix and `.png` suffix.
    - ![](/Variants/Docs/Tags/string_tag.png) **emissive_texture**: *(optional)* A resource location for the emissive texture used by this outfit slot. Omits the `textures/` prefix and `.png` suffix.
    - ![](/Variants/Docs/Tags/integer_tag.png) **color**: *(optional)* An integer defining a set color for this outfit slot. When defined, this field overrides the item's default color and the `display.color` tag.
  - ![](/Variants/Docs/Tags/compound_tag.png) **chest**, **legs** and **feet**: *(all optional)* Same format as ![](/Variants/Docs/Tags/compound_tag.png) **head**.

## History
| Version | Changes |
|---------|---------|
| [1.9.0.5](/Back%20Math/Changelogs/1.9.0.5%20Beta%20-%2028-01-25/Changelog%201.9.0.5.md) | <li> Added outfit definitions to data packs. </li> <li> Currently, the `emissive_texture` field doesn't work because I didn't implement it. |
| [1.9.0.6](/Back%20Math/Changelogs/1.9.0.6%20Beta%20-%2004-03-25) | <li> Added the `color` field. </li> <li> The `emissive_texture` field now works. </li> |

## Issues
Issues relating to "Outfit definition" are maintained on [Back Math's bug tracker](https://github.com/isabellawoods/Back-Math/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) **Outfit Definition** ▪ ![](/Textures/navbox/queen_lucy_variant.png) [Queen Lucy Variant](/Back%20Math/Docs/Queen%20Lucy%20Variant.md) ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) [Wanderer Sophie Variant](/Back%20Math/Docs/Wanderer%20Sophie%20Variant.md) |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) [Bowl Type](/Revaried/Docs/Bowl%20Type.md) ▪ ![](/Textures/navbox/damage_source.png) [Damage Source](/Revaried/Docs/Damage%20Source.md) ▪ ![](/Textures/navbox/wool_armor_color.png) [Wool Armor Color](/Revaried/Docs/Wool%20Armor%20Color.md) |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |