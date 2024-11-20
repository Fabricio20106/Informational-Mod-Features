<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Variants - 1.6.15.1 -</div>
### <div style="text-align: center;">A Variants Release Changelog made on *13/12/2023*</div>

## Changes
- Splash and Lingering Glass Bottles now appear before all other bottles in the creative menu.
- Splash and Lingering Dragon's Breath no longer have their container items set to splash and lingering potions (respectively).
- The word "copper" on the Variants' mod menu descriptions is now lower case.
- Fungi Stew recipe now accepts any bowl in the recipe.

### Translation Changes (Brazilian Portuguese)
- Renamed "Girassol Pequeno" to "Girassol pequeno".
- All poisoning effect names now have the "poisoning" part abbreviated ("Envenenamento" to "Env.").

## Internal Changes
- Minimum and maximum experience drops for ores are now defined in their constructor.
- Renamed `HexBeamStainedGlass(Pane)Block` to `CustomBeamGlass(Pane)Block`.
- Renamed all instances of "creeper powder" to "explosive blend".
    - This includes the damage source `poisoning.creeper_powder`, which has been renamed to `poisoning.explosive_blend`.
- Renamed tab `variants_blocks` (Variants: Blocks) to `variants.blocks`.
- Renamed tab `variants` (Variants) to `variants.main`.
- Renamed tab `weaponryTab` (Variants: Weapons) to `variants.weapons`.