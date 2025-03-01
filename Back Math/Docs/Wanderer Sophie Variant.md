# Wanderer Sophie Variant
> [!NOTE]
> This feature is exclusive to *Back Math*.
>
> ***Last Updated**: 1.9.0.5 (22-2-25)*

A **wanderer sophie variant** is an individual variant used for wanderer sophie's textures. Wanderer sophie variants can be defined using JSON files in a data pack at the path `data/<namespace>/wanderer_sophie_variant/`.

Wanderer sophie variants can have tags defined at the path `data/<namespace>/tags/wanderer_sophie_variant/`.

## JSON Format
Wanderer sophie variants are defined using the following format:

- ![](/Variants/Docs/Tags/compound_tag.png) The root object.
  - ![](/Variants/Docs/Tags/string_tag.png) **asset_id**: The resource location of this wanderer sophie variant. Should match the location of this file inside the data pack.
  - ![](/Variants/Docs/Tags/string_tag.png) **texture_location**: A resource location of where the texture for this variant is located. Omits the `textures/` prefix and `.png` suffix.
  - ![](/Variants/Docs/Tags/string_tag.png) **emissive_texture**: *(optional)* A resource location of where the emissive texture for this variant is located. Omits the `textures/` prefix and `.png` suffix.
  - ![](/Variants/Docs/Tags/boolean_tag.png) **slim_arms**: *(optional)* Unused. Meant to define whether this variant will have wide (classic) or slim arms. Defaults to `true`.
  - ![](/Variants/Docs/Tags/boolean_tag.png) **spawns_naturally**: *(optional)* Whether this variant can spawn naturally (either by natural spawning or spawn eggs). Defaults to `true`.

## History
| Version | Changes |
|---------|---------|
| [*May 25th, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2025-05-24/Changelog%2025-05-24.md) (1.8.0) | Added wanderer sophie variants as a *Forge* registry. Only includes the `asset_id` (technical texture location) and `slim_arms` fields. |
| [*June 9th, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2009-06-24/Changelog%2009-06-24.md) (1.8.0) | Removed the `asset_id` field, replacing it with `texture_location`. |
| [*October 6th, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2006-10-24/Changelog%2006-10-24.md) (1.8.0) | <li> Wanderer sophie variants are now loaded from data packs. <li> Readded the `asset_id` field. <li> Added the `farmer` variant. </li> |
| [*October 22nd, 2024*](/Back%20Math/Changelogs/1.8%20Beta%20Dev%20-%2022-10-24/Changelog%2022-10-24.md) (1.8.0) | <li> Added the `green_hoodie`, `swimsuit` and `round_six` variants. <li> Added the `spawns_naturally` field, controlling whether this variant can naturally spawn from natural spawns and spawn eggs. </li> |
| [1.9.0.4](/Back%20Math/Changelogs/1.9.0.4%20Beta%20-%2026-01-25/Changelog%201.9.0.4.md) | <li> Added wanderer sophie heads, which use wanderer sophie variants for their textures. <li> The "ender" variant now has a hardcoded emissive texture.</li> |
| [1.9.0.5](/Back%20Math/Changelogs/1.9.0.5%20Beta%20-%2028-01-25/Changelog%201.9.0.5.md) | <li> Added the `piglin_brute` variant. <li>Added the `emissive_texture` field, which replaced the hardcoded emissive texture for the "ender" variant. <li> The `slim_arms` and `spawns_naturally` fields are now optional. They default to `true` when not defined.</li> |

## Issues
Issues relating to "Wanderer sophie variant" are maintained on [Back Math's bug tracker](https://github.com/Fabricio20106/Back-Math/issues). Issues should be reported and viewed there.

## Navigation
### Data pack definitions
| | |
|-|-|
| **Back Math** | ![](/Textures/navbox/outfit_definition.png) [Outfit Definition](/Back%20Math/Docs/Outfit%20Definition.md) ▪ ![](/Textures/navbox/queen_lucy_variant.png) [Queen Lucy Variant](/Back%20Math/Docs/Queen%20Lucy%20Variant.md) ▪ ![](/Textures/navbox/queen_lucy_pet_variant.png) [Queen Lucy Pet Variant](/Back%20Math/Docs/Queen%20Lucy%20Pet%20Variant.md) ▪ ![](/Textures/navbox/wanderer_sophie_variant.png) **Wanderer Sophie Variant** |
| **Revaried** | ![](/Textures/navbox/bowl_type.png) [Bowl Type](/Variants/Docs/Bowl%20Type.md) ▪ ![](/Textures/navbox/damage_source.png) [Damage Source](/Variants/Docs/Damage%20Source.md) ▪ ![](/Textures/navbox/wool_armor_color.png) [Wool Armor Color](/Variants/Docs/Wool%20Armor%20Color.md) |
| **Stacked Goods** | ![](/Textures/navbox/mineral_extraction.png) [Mineral Extraction](/Stacked%20Goods/Docs/Mineral%20Extraction.md) |