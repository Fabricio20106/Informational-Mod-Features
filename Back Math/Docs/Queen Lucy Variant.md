# Queen Lucy Variant
> [!NOTE]
> This feature is exclusive to *Back Math*.
>
> ***Last Updated**: 1.9.0.5 (10-3-25)*

A **queen lucy variant** is an individual variant used for queen lucy's textures. Queen lucy variants can be defined using JSON files in a data pack at the path `data/<namespace>/queen_lucy_variant/`.

Queen lucy variants can have tags defined at the path `data/<namespace>/tags/queen_lucy_variant/`.

## JSON Format
Queen lucy variants are defined using the following format:

- ![](/Revaried/Docs/Tags/compound_tag.png) The root object.
  - ![](/Revaried/Docs/Tags/string_tag.png) **asset_id**: The resource location of this queen lucy variant. Should match the location of this file inside the data pack.
  - ![](/Revaried/Docs/Tags/string_tag.png) **texture_location**: A resource location of where the texture for this variant is located. Omits the `textures/` prefix and `.png` suffix.
  - ![](/Revaried/Docs/Tags/string_tag.png) **emissive_texture**: *(optional)* A resource location of where the emissive texture for this variant is located. Omits the `textures/` prefix and `.png` suffix.
  - ![](/Revaried/Docs/Tags/compound_tag.png) **bossbar_information**: *(optional)* Properties to apply to queen lucy's bossbar when spawned. All properties inside this object are optional.
    - ![](/Revaried/Docs/Tags/boolean_tag.png) **visible**: Whether the bossbar is visible or not. Defaults to `true`.
    - ![](/Revaried/Docs/Tags/string_tag.png) **color**: The color to use for the bossbar. Can be one of `pink`, `blue`, `red`, `green`, `yellow`, `purple` or `white`. Defaults to `blue`.
    - ![](/Revaried/Docs/Tags/string_tag.png) **overlay**: What kind of overlay to use for the bossbar. Can be one of `progress`, `notched_6`, `notched_10`, `notched_12` or `notched_20`. Defaults to `notched_6`.
    - ![](/Revaried/Docs/Tags/boolean_tag.png) **darkens_screen**: Whether to apply a vignette to the player viewing the bossbar. Defaults to `false`.
    - ![](/Revaried/Docs/Tags/boolean_tag.png) **plays_boss_music**: Whether to play *"Boss"* during the time the bossbar is visible. Defaults to `false`.
    - ![](/Revaried/Docs/Tags/boolean_tag.png) **creates_fog**: Whether to apply fog to the player viewing the bossbar. Defaults to `false`.
    - ![](/Revaried/Docs/Tags/compound_tag.png) **name**: A text component for a custom name to apply to the bossbar. Defaults to a translatable component (`entity.backmath.queen_sophie` / "Queen Lucy").

## History
| Version | Changes |
|---------|---------|
| [1.9.0.5](/Back%20Math/Changelogs/1.9.0.5%20Beta%20-%2028-01-25/Changelog%201.9.0.5.md) | Added queen lucy variants to data packs. |

## Issues
Issues relating to "Queen lucy variant" are maintained on [Back Math's bug tracker](https://github.com/isabellawoods/Back-Math/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) [Outfit Definition](/Back%20Math/Docs/Outfit%20Definition.md) ▪ ![](/Textures/navbox/queen_lucy_variant.png) **Queen Lucy Variant** ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) [Wanderer Sophie Variant](/Back%20Math/Docs/Wanderer%20Sophie%20Variant.md) |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) [Bowl Type](/Revaried/Docs/Bowl%20Type.md) ▪ ![](/Textures/navbox/damage_source.png) [Damage Source](/Revaried/Docs/Damage%20Source.md) ▪ ![](/Textures/navbox/wool_armor_color.png) [Wool Armor Color](/Revaried/Docs/Wool%20Armor%20Color.md) |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |