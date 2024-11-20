<div style="text-align: center;"> <img src=ChangelogPhoto.png width="1500"> </div>

# <div style="text-align: center;">- Back Math - October 22nd Update -</div>
### <div style="text-align: center;">A Back Math Update Changelog made on *03/11/2024*</div>

## Additions
### Items
- Added archer lucia boots.
  - Included in the `equipment/archer_lucia` loot table.

### Entities
- Added **3** new wanderer sophie variants: *Round 6*, *swimsuit* and *green hoodie*.
  - These variants don't spawn naturally, thus the addition of the new `spawns_naturally` tag.
  > <img src=Screenshots/round_six_ws.png width="50"> <img src=Screenshots/swimsuit_ws.png width="50"> <img src=Screenshots/green_hoodie_ws.png width="50">
  >
  > *"Round 6"*, *"Swimsuit / Bikini"*, and *"Green Hoodie"* variants, respectively

### Miscellaneous
- The shift key used in tooltips can now be changed though the controls screen.
  - It defaults to "Left Shift", and is under the "Melony Studios" category (the same used by Variants).
  - The vanilla shift key is used for changing tito/toti, and resetting the mold in crystallizers.

## Changes
### Blocks
- Smooth aljanstone slabs now use the proper double slab model.
- The bottom model of queen lucy relics now has particles.

### Items
- Cut aljame now gives poison for 2.5 seconds and blindness for 15 seconds.
- Renamed the "fire rate delay" field of Back Math bows to "use duration".
- Updated the textures of the following items:
  > - Archer lucia vest -- to add the new gloves;
  > - Wanderer and warrior sophie, queen lucy, insomnia zombie spawn eggs;
  > - "Current" design queen lucy shirt (no model update);
  > - Mob persona cards for: angry, insomnia, wanderer and warrior sophies, queen lucy.

### Entities
- Fixed the UV mapping of zombie fabricios, so the arms and legs use the proper texture.
- Custom wanderer sophie variants are now able to spawn naturally.
- Warrior sophies now have slim arms.
- Removed the debugging `efe` wanderer sophie variant.
- Added an empty loot table for collector fabricios.
- Updated the textures of the following entities:
  > - All wanderer sophies;
  >   - Made eye color and hair consistent between most variants. Only exceptions are `ender` and `worker`.
  >   - Variant `ender` now has purple hair.
  >   - Variants `savannah` and `witcher` now have their robes extended to match the original entities.
  >   - Variants `brazil_shirt` and `ender` now have visible panties.
  > - Angry sophies -- added neck texture;
  > - (Archer) insomnia sophies -- added neck texture;
  > - Warrior sophies;
  > - Queen lucy and queen lucy relic;
  > - Insomnia zombies and zombie fabricios;
  > - Jantic bolt -- now it has a tip.

### Translation
- ***[English]*** Changed the advancement name *"More Like Crystallizer MK2!"* to *"More Like "Crystallizer MK2"!"*.
- ***[Bra. Portuguese]*** Added translations for all of Back Math's advancements.
- ***[Bra. Portuguese]*** Renamed *"Back campos [originais/modificados]"* to *"Campos backen [originais/modificados]"*.
- ***[Bra. Portuguese]*** Renamed *"Tulipa aljámico"* to *"Tulipa aljámica"*.
- ***[Bra. Portuguese]*** Renamed aljanwood-related content to *"[...] de madeira aljân"*.
- ***[Bra. Portuguese]*** Renamed *"rainha Lucy"* and *"Lucy rainha"* to *"Rainha Lucy"*.
- Removed the translation key for Aljan portals.
- Added translations for Back Math's colors, used by Variants.
- Changed the invalid variant error message from *"[...] This registry does not exist!"* to *"[...] This variant does not exist!"*.
  - *"[...] Esse registro não existe!"* to *"[...] Essa variante não existe!"* in Brazilian Portuguese.
- Changed the *"Hold \<Shift> for description/Bow Attributes"* tooltip.

### Miscellaneous
- The Aljan sky color no longer shows up during the day. Now, it properly fades out at sunrise.
  - Currently, it still only applies during the first day -- all other days it doesn't apply.
- Changed the Aljan teleporter logic.
  - Separated the position calculation and portal stand placement into separate methods.
    - As a result of this, the stand no longer gets moved up when inside a block. This is fixed next version.
  - The log messages from `logAljanTeleporterDebugging` are now outputted into chat and above the hotbar.

## *"Aljan Texture Update"* Pack
### Additions
- Added texture for insomnia arrows (item only), sleepish bones and sleepish fertilizer.

### Changes
- Updated textures for avondalic nylium. Now the side textures align and the colors are now correct.

## Technical
### Additions
- Added a `spawns_naturally` string field to **wanderer sophie variants** definitions.
  - This controls whether this variant can spawn from any natural spawning context. Spawning with a set variant through commands is an exception, for example.
- Saving wanderer sophie and queen lucy pet variants through data generation now throws an error if the texture doesn't exist.
- Back Math boats can now have their variants changed with a `wood_type` string tag.
  - The valid values are `aljanwood`, `aljancap`, `insomnian` and `avondalic_willow`.
  - Avondalic willow will default to aljanwood as it doesn't exist yet.

### Changes
- *BMPlayerModel* now applies Y-offsets.
- Fixed the left leg on *BMPlayerModel* so it uses the correct texture.
- *ToolBehaviors* no longer uses `assert` as it doesn't seem to work with tag null-checking.
- The `milked_sword_item` tag now uses Variants' stack handling.
- Sparey effects now read using "any numeric" instead of only "byte" and "any".
- Moved *VSUtils* to the Back Math package as it was causing issues with variants.
  - Now it can properly save an empty stack.
```
NoSuchMethodError: melonystudios.variants.util.VSUtils.minecraft(Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;
    at melonystudios.variants.item.custom.armor.color.WoolArmorColor.<clinit>(WoolArmorColor.java:21) ~[variants:1.16.5-1.8.0.3-14-09-2024] {re:classloading}
    at melonystudios.variants.item.custom.armor.WoolArmorItem.fillItemCategory(WoolArmorItem.java:101) ~[variants:1.16.5-1.8.0.3-14-09-2024] {re:classloading}
```

## Tags
### Changes
- Added snow layers to `#backmath:aljan_teleporter_replaceables` block tag.

## Gallery
> <div style="text-align: center;"> <img src=Screenshots/all_ws_variants.png width="1000"> </div>
> <div style="text-align: center;">
>
> All wanderer sophie variants, except *"green hoodie"*. </div>

> <div style="text-align: center;"> <img src=Screenshots/queen_lucy.png width="100"> <img src=Screenshots/queen_lucy_relic.png width="100"> <img src=Screenshots/warrior_sophie.png width="100"> </div>
> <div style="text-align: center;">
>
> The updated textures for queen lucy, queen lucy relics, and warrior sophies. </div>