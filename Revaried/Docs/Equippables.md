# <div style="text-align: center;">- Equippables -</div>
### <div style="text-align: center;">*A Guide and Documentation of the NBT-driven armory - Made on 09/12/2024*</div>

***Last Updated**: 09/12/2024 - 1.8.0.7 (I)*

## NBT Format
- <img src=Tags/compound_tag.png> Root tag for this item.
  - <img src=Tags/compound_tag.png> **equippable**: The main tag for equippable items. This tag applies to all items, but only works on some of them.
    - <img src=Tags/string_tag.png> **slot**: The slot this item can be worn in. Can be one of `head`, `chest`, `legs`, `feet`, `mainhand` or `offhand`. Defaults to `mainhand`.
    - <img src=Tags/string_tag.png> **equip_sound**: A sound event id to play when wearing this item. Defaults to `minecraft:item.armor.equip_generic`.
    - <img src=Tags/string_tag.png> **asset_id**: A resource location of the identifier for this armor, like "iron" or "netherite". Does not default to anything, and isn't used anywhere yet.
    - <img src=Tags/boolean_tag.png> **dispensable**: Whether this item can be equipped onto the player via a dispenser. Defaults to `true`.
    - <img src=Tags/boolean_tag.png> **swappable**: Whether you can replace the current item you're wearing with this one via right-clicking. Defaults to `true`.
    - <img src=Tags/boolean_tag.png> **damages_on_hurt**: Whether this item is damaged when taking damage while wearing it. Defaults to `true`.
    - <img src=Tags/string_tag.png> **camera_overlay**: A resource location of a texture to use as an overlay, like the pumpkin blur. The path omits the `textures/` prefix and the `.png` suffix.
      - For example, to use purple stained glass as an overlay, the tag should be *"minecraft:block/purple_stained_glass"*, with the *"minecraft:"* prefix being optional.
      - Pointing to an invalid texture will use the missing texture as the overlay.
  - <img src=Tags/compound_tag.png> **glider**: An empty compound that makes this item act as elytra. Seems to be a little broken currently.