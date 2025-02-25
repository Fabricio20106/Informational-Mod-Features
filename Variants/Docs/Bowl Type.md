# Bowl Type
> [!NOTE]
> This feature is exclusive to *Revaried*.
>
> ***Last Updated**: 1.8.0.9 (24-2-25)*

A **bowl type** is group of properties for an exponential stew bowl, which includes item and model data number. Bowl types can be defined using JSON files in a data pack at the path `data/<namespace>/bowl_type/`.

## JSON format
Bowl types are defined using the following format:

- <img src=Tags/compound_tag.png> The root object.
  - <img src=Tags/string_tag.png> **asset_id**: The resource location of this bowl type. Should match the location of this file inside the data pack.
  - <img src=Tags/compound_tag.png> **bowl**: The bowl item stack to use when finishing to eat the stew.
    > **Tags common to all items saved by Revaried:**
    > - <img src=Tags/string_tag.png> **id**: The id of the item.
    > - <img src=Tags/integer_tag.png> **count**: *(optional)* How many items there are in this stack. Effectively capped at 127 due to the default count tag being a <img src=Tags/short_tag.png> short.
    > - <img src=Tags/compound_tag.png> **tags**: *(optional)* The tags this item stack has.
  - <img src=Tags/string_tag.png> **name**: The name of the material of this bowl. Used when creating item models and recipe through the data generators.
  - <img src=Tags/integer_tag.png> **texture_id**: The texture identifier (custom model data value) of this bowl.

## History
| Version | Changes |
|---------|---------|
| [1.8.0.2](/Variants/Changelogs/1.16.5%20-%201.8.0.2%20(Markdown)/Changelog%201.8.0.2.md) | <li> Added bowl types to data packs. </li> <li> Currently, the `bowl` field does not include a `components` field. </li> |
| [1.8.0.3](/Variants/Changelogs/1.16.5%20-%201.8.0.3/Changelog%201.8.0.3.md) | Bowl types can now read the `components` field, but only as a string that is later resolved. |
| [1.8.0.5](/Variants/Changelogs/1.16.5%20-%201.8.0.5/Changelog%201.8.0.5.md) | <li> The duplicate texture id error now includes the texture id in question. </li> <li> Bowl type instances are no longer made when it already exists in the default bowls list <sup>*[not sure whether this actually makes a diference]*</sup> </li> |
| [1.8.0.7](/Variants/Changelogs/1.16.5%20-%201.8.0.7/Changelog%201.8.0.7.md) | Bowl types using vanilla wood types are now in the `minecraft` namespace instead of `variants`'s.
| [1.8.0.9](/Variants/Changelogs/1.16.5%20-%201.8.0.9/Changelog%201.8.0.9.md) | <li> Bowl type bowls no longer include the `count` field by default. </li> <li> Renamed the field `components` to `tags`. </li> <li> Bowl types can now read the `tags` field as a full object instead of only a string. </li> |

## Issues
Issues relating to "Bowl type" are maintained on [Revaried's bug tracker](https://github.com/Fabricio20106/Variants/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) [Outfit Definition](/Back%20Math/Docs/Outfit%20Definition.md) ▪ ![](/Textures/navbox/queen_lucy_variant.png) [Queen Lucy Variant](/Back%20Math/Docs/Queen%20Lucy%20Variant.md) ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) [Wanderer Sophie Variant](/Back%20Math/Docs/Wanderer%20Sophie%20Variant.md) |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) **Bowl Type** ▪ ![](/Textures/navbox/damage_source.png) [Damage Source](/Variants/Docs/Damage%20Source.md) ▪ ![](/Textures/navbox/wool_armor_color.png) [Wool Armor Color](/Variants/Docs/Wool%20Armor%20Color.md) |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |