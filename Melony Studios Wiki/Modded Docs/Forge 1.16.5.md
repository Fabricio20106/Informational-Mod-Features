# Forge 1.16.5
This is a rough list of all changes and bugfixes that Forge adds on [1.16.5](https://minecraft.wiki/w/Java_Edition_1.16.5).

## Fixes
**32 issues fixed**
#### From released versions before 1.16
- [MC-2518](https://bugs.mojang.com/browse/MC-2518) – No breaking sound or particle effect for some tools and all armor <sup>*["fixed" in 19w14a]*</sup>
- [MC-4647](https://bugs.mojang.com/browse/MC-4647) – World turns completely black when having night vision, and being in the void or having blindness <sup>*["fixed" in 17w06a]*</sup>
- [MC-7569](https://bugs.mojang.com/browse/MC-7569) – RCON output has newlines removed
- [MC-10480](https://bugs.mojang.com/browse/MC-10480) – Blindness + night vision effects create complete blindness <sup>*["fixed" in 1.15.2]*</sup>
- [MC-10657](https://bugs.mojang.com/browse/MC-10657) – Player entering nether portal while sneaking stuck in "partial sneak" <sup>*["fixed" in 1.14.2]*</sup>
- [MC-52974](https://bugs.mojang.com/browse/MC-52974) – Host's skin not visible to other players when in a LAN world <sup>*["fixed" in 18w21a]*</sup>
- [MC-53850](https://bugs.mojang.com/browse/MC-53850) – Invulnerable item entities and experience orbs are removed client-side when they take damage <sup>*[fixed in 22w07a]*</sup>
- [MC-94054](https://bugs.mojang.com/browse/MC-94054) – Cave spiders spin around when walking <sup>*["fixed" in 16w07b]*</sup>
- [MC-98707](https://bugs.mojang.com/browse/MC-98707) – Texture manager is not deleting entry in `mapTextureObjects`<sup>*[`byPath` now]*</sup> when texture is deleted
- [MC-105080](https://bugs.mojang.com/browse/MC-105080) – Ender dragon is respawned if all exit end portal blocks are removed / legacy scanning is done for worlds with new dragon fight <sup>*[fixed in 21w19a]*</sup>
- [MC-112730](https://bugs.mojang.com/browse/MC-112730) – Beacon beam and structure block render twice per frame
- [MC-119811](https://bugs.mojang.com/browse/MC-119811) – Boats rubberband on dismount <sup>*[duplicate of [MC-103672](https://bugs.mojang.com/browse/MC-103672) / "fixed" in 19w39a]*</sup>
- [MC-121048](https://bugs.mojang.com/browse/MC-121048) – When an entity dies, the combat tracker only records the killing blow <sup>*[fixed in 23w03a]*</sup>
- [MC-121772](https://bugs.mojang.com/browse/MC-121772) – Can't scroll while holding SHIFT on macOS <sup>*[fixed in 23w31a]*</sup>
- [MC-129055](https://bugs.mojang.com/browse/MC-129055) – Issues breaking tripwire with shears <sup>*[fixed in 24w33a]*</sup>
- [MC-134110](https://bugs.mojang.com/browse/MC-134110) – Structure mirroring breaking apart double chests
- [MC-145102](https://bugs.mojang.com/browse/MC-145102) – `--server` client launch argument may crash the client on the loading screen <sup>*["fixed" in 20w20b]*</sup>
- [MC-146650](https://bugs.mojang.com/browse/MC-146650) – *GuiContainer*<sup>*[*ContainerScreen* now]*</sup> key and mouse handler methods return `true` even when input is not handled
- [MC-147659](https://bugs.mojang.com/browse/MC-147659) – Some witch huts spawn the incorrect cat
- [MC-158205](https://bugs.mojang.com/browse/MC-158205) – Ender dragon doesn't take damage from melee attacks unless hit a certain way <sup>*[fixed in 24w44a]*</sup>
- [MC-162953](https://bugs.mojang.com/browse/MC-162953) – *NativeImage* bounds checks are incorrect <sup>*[fixed in 21w18a]*</sup>
- [MC-168672](https://bugs.mojang.com/browse/MC-168672) – Strange particles
- [MC-169806](https://bugs.mojang.com/browse/MC-169806) – Incorrect logic in *LightTexture*`.block(int)`

#### From the 1.16 development versions
- [MC-189565](https://bugs.mojang.com/browse/MC-189565) – Some entities do not render inside of spawners and produce error log spam in console, potentially causing lag <sup>*[fixed in 20w45a]*</sup>

#### From 1.16.1
- [MC-194675](https://bugs.mojang.com/browse/MC-194675) – While spectating a creeper, enderman, spider or cave spider, UI elements are rendered completely white <sup>*[fixed in 21w10a]*</sup>
- [MC-194811](https://bugs.mojang.com/browse/MC-194811) – Missing structures will destroy saved worlds
- [MC-196102](https://bugs.mojang.com/browse/MC-196102) – Rails rotation is missing two cases <sup>*[duplicate of [MC-104231](https://bugs.mojang.com/browse/MC-104231)]*</sup>

#### From 1.16.2
- [MC-197860](https://bugs.mojang.com/browse/MC-197860) – Deleting a custom dimension in a datapack deletes Nether and End

#### From 1.16.3
- [MC-201374](https://bugs.mojang.com/browse/MC-201374) – Wrong position passed to `getCollisionShape()` from *CampfireBlock*`.isSmokingBlockAt()`

#### From 1.16.4
- [MC-206338](https://bugs.mojang.com/browse/MC-206338) – Potential *ConcurrentModificationException* in skeleton trap code
- [MC-209819](https://bugs.mojang.com/browse/MC-209819) – Server crash when pathfinding to player that is teleporting away <sup>*[fixed in 1.17 pre-release 1]*</sup>

#### From 1.16.5
- [MC-227255](https://bugs.mojang.com/browse/MC-227255) – Beehives and bee nests do not rotate/mirror correctly in structure blocks <sup>*[fixed in 23w40a]*</sup>