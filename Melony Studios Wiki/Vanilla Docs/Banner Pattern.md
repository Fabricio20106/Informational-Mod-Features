# Banner Pattern

<sup>**Access Transformer Target**: `public net.minecraft.tileentity.BannerPattern`</sup>

------

**Banner patterns** are the different drawings that a banner can have. These are registered in an extensible enum called *BannerPattern*. Patterns can have any dye color in the game.

New banner patterns will be able to be registered in the `data/<namespace>/banner_pattern/` folder when using *Melony Lib*. However, this functionality is currently not yet working and/or out yet.

## Making a new pattern
To make a new pattern, what you need to do is to make a new field for your pattern, using the `BannerPattern.create()` method:

- **1: Enum Name**: The name of the field if it existed in the *BannerPattern* class.
- **2: Filename**: The name of this banner pattern's file, stored in `minecraft:textures/entity/banner/<filename>` and in `minecraft:textures/entity/shield/<filename>`.
- **3: Hash Name**: The short name for this banner pattern, used for storing this to the banner block (entity).
- **4: Has Pattern Item**: If this banner pattern has a pattern item. Normally, if this is not data-driven, this is usually not true.
  - This field can be omitted, defaulting to `false`.

```java
public static final BannerPattern EXAMPLE = BannerPattern.create("EXAMPLE", "example", "exa", true);
```

## Methods inside `BannerPattern`
There are some getter methods inside this class, including a subclass called *Builder*.

- **[Only In: Client]** `location(boolean shield)`:
  - Returns the resource location of this pattern using this pattern's `filename`.
  - The output is `minecraft:textures/entity/banner/<filename>` or `minecraft:textures/entity/shield/<filename>`, depending on the value of the input boolean.
- **[Only In: Client]** `getFilename()`: Returns the filename of this banner pattern.
- `getHashname()`: Return the hash name of this banner pattern.
- **[Nullable]**, **[Only In: Client]** `byHash(String hashName)`: Returns a banner pattern based on the `hashName`, and return null if the     ''' `hashName` 

## List of banner patterns
These are all banner that are registered in the base game as of 1.16.5:

| Name                        | Filename / Asset ID      | Hash Name  | Has Pattern Item |
|-----------------------------|--------------------------|------------|------------------|
| Base                        | `base`                   | `b`        | No               |
| Base Dexter Canton          | `square_bottom_left`     | `bl`       | No               |
| Base Sinister Canton        | `square_bottom_right`    | `br`       | No               |
| Chief Dexter Canton         | `square_top_left`        | `tl`       | No               |
| Chief Sinister Canton       | `square_top_right`       | `tr`       | No               |
| Base                        | `stripe_bottom`          | `bs`       | No               |
| Chief                       | `stripe_top`             | `ts`       | No               |
| Pale Dexter                 | `stripe_left`            | `ls`       | No               |
| Pale Sinister               | `stripe_right`           | `rs`       | No               |
| Pale                        | `stripe_center`          | `cs`       | No               |
| Fess                        | `stripe_middle`          | `ms`       | No               |
| Bend                        | `stripe_downright`       | `drs`      | No               |
| Bend Sinister               | `stripe_downleft`        | `dls`      | No               |
| Paly                        | `small_stripes`          | `ss`       | No               |
| Saltire                     | `cross`                  | `cr`       | No               |
| Cross                       | `straight_cross`         | `sc`       | No               |
| Chevron                     | `triangle_bottom`        | `bt`       | No               |
| Inverted Chevron            | `triangle_top`           | `tt`       | No               |
| Base Indented               | `triangles_bottom`       | `bts`      | No               |
| Chief Indented              | `triangles_top`          | `tts`      | No               |
| Per Bend Sinister           | `diagonal_left`          | `ld`       | No               |
| Per Bend Sinister Invented  | `diagonal_up_right`      | `rd`       | No               |
| Per Bend                    | `diagonal_right`         | `rud`      | No               |
| Roundel                     | `circle`                 | `mc`       | No               |
| Lozenge                     | `rhombus`                | `mr`       | No               |
| Per Pale                    | `half_vertical`          | `vh`       | No               |
| Per Fess                    | `half_horizontal`        | `hh`       | No               |
| Per Pale Inverted           | `half_vertical_right`    | `vhr`      | No               |
| Per Fess Inverted           | `half_horizontal_bottom` | `hhb`      | No               |
| Bordure                     | `border`                 | `bo`       | No               |
| Bordure Indented            | `curly_border`           | `cbo`      | No[^1] |
| Gradient                    | `gradient`               | `gra`      | No               |
| Base Gradient               | `gradient_up`            | `gru`      | No               |
| Field Masoned               | `bricks`                 | `bri`      | No[^1] |
| Globe                       | `globe`                  | `glb`      | Yes              |
| Creeper Charge              | `creeper`                | `cre`      | Yes              |
| Skull Charge                | `skull`                  | `sku`      | Yes              |
| Flower Charge               | `flower`                 | `flo`      | Yes              |
| Thing                       | `mojang`                 | `moj`      | Yes              |
| Snout                       | `piglin`                 | `pig`      | Yes              |

[^1]: ↑ Included as a banner pattern in snapshot [24w33a](https://minecraft.wiki/w/Java_Edition_24w33a).