# Block Entity Tags

## Back Math
### Barrel (`bm_barrel`)
- Items (`items`): Stored *ItemStack*s (27 total). This is saved using *Revaried*'s (Variants) stack handling.

### Crate (`crate`)
- Items (`items`): Stored *ItemStack*s (18 total). This is saved using *Revaried*'s (Variants) stack handling.

### Queen Lucy Head (`queen_lucy_head`)
- Variant (`variant`): The entity variant used to render this head. This is validated by both the item and the block entity.

### Wanderer Sophie Head (`wanderer_sophie_head`)
- Variant (`variant`): The entity variant used to render this head. This is validated by both the item and the block entity.

## Others Removed
### Nether Reactor Core (`nether_reactor`)
- Reactor Progress (`reactor_progress`): How long this reactor has been running for. This normally ends at 900 ticks (45 seconds).
- Loot Spacing (`reactor_loot_spacing`): A spacing in ticks for when the reactor should pop out loot. Defaults to 200 ticks, ejecting loot 4 times.