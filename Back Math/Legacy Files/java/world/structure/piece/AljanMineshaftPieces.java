package com.sophicreeper.backmath.world.structure.piece;

import com.google.common.collect.Lists;
import com.sophicreeper.backmath.block.BMBlocks;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.util.BMResourceLocations;
import com.sophicreeper.backmath.world.structure.custom.AljanMineshaftStructure;
import net.minecraft.block.*;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.state.properties.RailShape;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class AljanMineshaftPieces {
    private static AljanMineshaftPieces.Piece createRandomShaftPiece(List<StructurePiece> pieces, Random rand, int x, int y, int z, @Nullable Direction direction, int p_189940_6_, AljanMineshaftStructure.MineshaftType type) {
        int random = rand.nextInt(100);
        if (random >= 80) {
            MutableBoundingBox crossingBB = AljanMineshaftPieces.Cross.findCrossing(pieces, rand, x, y, z, direction);
            if (crossingBB != null) {
                return new AljanMineshaftPieces.Cross(p_189940_6_, crossingBB, direction, type);
            }
        } else if (random >= 70) {
            MutableBoundingBox stairsBB = AljanMineshaftPieces.Stairs.findStairs(pieces, rand, x, y, z, direction);
            if (stairsBB != null) {
                return new AljanMineshaftPieces.Stairs(p_189940_6_, stairsBB, direction, type);
            }
        } else {
            MutableBoundingBox corridorSizeBB = AljanMineshaftPieces.Corridor.findCorridorSize(pieces, rand, x, y, z, direction);
            if (corridorSizeBB != null) {
                return new AljanMineshaftPieces.Corridor(p_189940_6_, rand, corridorSizeBB, direction, type);
            }
        }

        return null;
    }

    private static AljanMineshaftPieces.Piece generateAndAddPiece(StructurePiece piece, List<StructurePiece> pieces, Random rand, int x, int y, int z, Direction direction, int p_189938_7_) {
        if (p_189938_7_ > 8) {
            return null;
        } else if (Math.abs(x - piece.getBoundingBox().minX) <= 80 && Math.abs(z - piece.getBoundingBox().minZ) <= 80) {
            AljanMineshaftStructure.MineshaftType type = ((AljanMineshaftPieces.Piece) piece).mineshaftType;
            AljanMineshaftPieces.Piece aljanPieces = createRandomShaftPiece(pieces, rand, x, y, z, direction, p_189938_7_ + 1, type);
            if (aljanPieces != null) {
                pieces.add(aljanPieces);
                aljanPieces.buildComponent(piece, pieces, rand);
            }

            return aljanPieces;
        } else {
            return null;
        }
    }

    public static class Corridor extends AljanMineshaftPieces.Piece {
        private final boolean hasRails;
        private final boolean hasJanticals;
        private boolean spawnerPlaced;
        private final int sectionCount;

        public Corridor(TemplateManager tempManager, CompoundNBT tag) {
            super(IStructurePieceType.MSCORRIDOR, tag);
            this.hasRails = tag.getBoolean("hr");
            this.hasJanticals = tag.getBoolean("sc");
            this.spawnerPlaced = tag.getBoolean("hps");
            this.sectionCount = tag.getInt("Num");
        }

        protected void readAdditional(CompoundNBT tag) {
            super.readAdditional(tag);
            tag.putBoolean("hr", this.hasRails);
            tag.putBoolean("sc", this.hasJanticals);
            tag.putBoolean("hps", this.spawnerPlaced);
            tag.putInt("Num", this.sectionCount);
        }

        public Corridor(int componentType, Random rand, MutableBoundingBox boundingBox, Direction direction, AljanMineshaftStructure.MineshaftType type) {
            super(IStructurePieceType.MSCORRIDOR, componentType, type);
            this.setCoordBaseMode(direction);
            this.boundingBox = boundingBox;
            this.hasRails = rand.nextInt(3) == 0;
            this.hasJanticals = !this.hasRails && rand.nextInt(23) == 0;
            if (this.getCoordBaseMode().getAxis() == Direction.Axis.Z) {
                this.sectionCount = boundingBox.getZSize() / 5;
            } else {
                this.sectionCount = boundingBox.getXSize() / 5;
            }
        }

        public static MutableBoundingBox findCorridorSize(List<StructurePiece> pieces, Random rand, int x, int y, int z, Direction facing) {
            MutableBoundingBox boundingBox1 = new MutableBoundingBox(x, y, z, x, y + 3 - 1, z);

            int i;
            for(i = rand.nextInt(3) + 2; i > 0; --i) {
                int j = i * 5;
                switch(facing) {
                    case NORTH:
                    default:
                        boundingBox1.maxX = x + 3 - 1;
                        boundingBox1.minZ = z - (j - 1);
                        break;
                    case SOUTH:
                        boundingBox1.maxX = x + 3 - 1;
                        boundingBox1.maxZ = z + j - 1;
                        break;
                    case WEST:
                        boundingBox1.minX = x - (j - 1);
                        boundingBox1.maxZ = z + 3 - 1;
                        break;
                    case EAST:
                        boundingBox1.maxX = x + j - 1;
                        boundingBox1.maxZ = z + 3 - 1;
                }

                if (StructurePiece.findIntersecting(pieces, boundingBox1) == null) {
                    break;
                }
            }

            return i > 0 ? boundingBox1 : null;
        }

        public void buildComponent(StructurePiece component, List<StructurePiece> pieces, Random rand) {
            int componentType1 = this.getComponentType();
            int random = rand.nextInt(4);
            Direction direction = this.getCoordBaseMode();
            if (direction != null) {
                switch(direction) {
                    case NORTH:
                    default:
                        if (random <= 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ - 1, direction, componentType1);
                        } else if (random == 2) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ, Direction.WEST, componentType1);
                        } else {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ, Direction.EAST, componentType1);
                        }
                        break;
                    case SOUTH:
                        if (random <= 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.maxZ + 1, direction, componentType1);
                        } else if (random == 2) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.maxZ - 3, Direction.WEST, componentType1);
                        } else {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.maxZ - 3, Direction.EAST, componentType1);
                        }
                        break;
                    case WEST:
                        if (random <= 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ, direction, componentType1);
                        } else if (random == 2) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                        } else {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                        }
                        break;
                    case EAST:
                        if (random <= 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ, direction, componentType1);
                        } else if (random == 2) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                        } else {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + rand.nextInt(3), this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                        }
                }
            }

            if (componentType1 < 8) {
                if (direction != Direction.NORTH && direction != Direction.SOUTH) {
                    for(int i1 = this.boundingBox.minX + 3; i1 + 3 <= this.boundingBox.maxX; i1 += 5) {
                        int j1 = rand.nextInt(5);
                        if (j1 == 0) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, i1, this.boundingBox.minY, this.boundingBox.minZ - 1, Direction.NORTH, componentType1 + 1);
                        } else if (j1 == 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, i1, this.boundingBox.minY, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1 + 1);
                        }
                    }
                } else {
                    for(int k = this.boundingBox.minZ + 3; k + 3 <= this.boundingBox.maxZ; k += 5) {
                        int l = rand.nextInt(5);
                        if (l == 0) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY, k, Direction.WEST, componentType1 + 1);
                        } else if (l == 1) {
                            AljanMineshaftPieces.generateAndAddPiece(component, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY, k, Direction.EAST, componentType1 + 1);
                        }
                    }
                }
            }
        }

        // Adds chest to the structure and sets its contents.
        protected boolean generateChest(ISeedReader world, MutableBoundingBox boundingBox, Random rand, int x, int y, int z, ResourceLocation lootTable) {
            BlockPos pos = new BlockPos(this.getXWithOffset(x, z), this.getYWithOffset(y), this.getZWithOffset(x, z));
            if (boundingBox.isVecInside(pos) && world.getBlockState(pos).isAir(world, pos) && !world.getBlockState(pos.down()).isAir(world, pos.down())) {
                BlockState railState = Blocks.RAIL.getDefaultState().with(RailBlock.SHAPE, rand.nextBoolean() ? RailShape.NORTH_SOUTH : RailShape.EAST_WEST);
                this.setBlockState(world, railState, x, y, z, boundingBox);
                ChestMinecartEntity chestMinecart = new ChestMinecartEntity(world.getWorld(), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
                chestMinecart.setLootTable(lootTable, rand.nextLong());
                world.addEntity(chestMinecart);
                return true;
            } else {
                return false;
            }
        }

        public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            if (this.isLiquidInStructureBoundingBox(world, boundingBox)) {
                return false;
            } else {
                int i = this.sectionCount * 5 - 1;
                BlockState planks = this.getPlanksBlock();
                this.fillWithBlocks(world, boundingBox, 0, 0, 0, 2, 1, i, CAVE_AIR, CAVE_AIR, false);
                this.generateMaybeBox(world, boundingBox, rand, 0.8F, 0, 2, 0, 2, 2, i, CAVE_AIR, CAVE_AIR, false, false);
                if (this.hasJanticals) {
                    this.generateMaybeBox(world, boundingBox, rand, 0.6F, 0, 0, 0, 2, 1, i, Blocks.COBWEB.getDefaultState(), CAVE_AIR, false, true);
                }

                for(int j1 = 0; j1 < this.sectionCount; ++j1) {
                    int k1 = 2 + j1 * 5;
                    this.placeSupport(world, boundingBox, 0, 0, k1, 2, 2, rand);
                    this.placeCobWeb(world, boundingBox, rand, 0.1F, 0, 2, k1 - 1);
                    this.placeCobWeb(world, boundingBox, rand, 0.1F, 2, 2, k1 - 1);
                    this.placeCobWeb(world, boundingBox, rand, 0.1F, 0, 2, k1 + 1);
                    this.placeCobWeb(world, boundingBox, rand, 0.1F, 2, 2, k1 + 1);
                    this.placeCobWeb(world, boundingBox, rand, 0.05F, 0, 2, k1 - 2);
                    this.placeCobWeb(world, boundingBox, rand, 0.05F, 2, 2, k1 - 2);
                    this.placeCobWeb(world, boundingBox, rand, 0.05F, 0, 2, k1 + 2);
                    this.placeCobWeb(world, boundingBox, rand, 0.05F, 2, 2, k1 + 2);
                    if (rand.nextInt(100) == 0) {
                        this.generateChest(world, boundingBox, rand, 2, 0, k1 - 1, BMResourceLocations.ALJAN_MINESHAFT_LOOT);
                    }

                    if (rand.nextInt(100) == 0) {
                        this.generateChest(world, boundingBox, rand, 0, 0, k1 + 1, BMResourceLocations.ALJAN_MINESHAFT_LOOT);
                    }

                    if (this.hasJanticals && !this.spawnerPlaced) {
                        int l1 = this.getYWithOffset(0);
                        int i2 = k1 - 1 + rand.nextInt(3);
                        int j2 = this.getXWithOffset(1, i2);
                        int k2 = this.getZWithOffset(1, i2);
                        BlockPos pos = new BlockPos(j2, l1, k2);
                        if (boundingBox.isVecInside(pos) && this.getSkyBrightness(world, 1, 0, i2, boundingBox)) {
                            this.spawnerPlaced = true;
                            world.setBlockState(pos, Blocks.SPAWNER.getDefaultState(), 2);
                            TileEntity spawner = world.getTileEntity(pos);
                            if (spawner instanceof MobSpawnerTileEntity) {
                                ((MobSpawnerTileEntity) spawner).getSpawnerBaseLogic().setEntityType(BMEntities.JANTICLE.get());
                            }
                        }
                    }
                }

                for(int l2 = 0; l2 <= 2; ++l2) {
                    for(int i3 = 0; i3 <= i; ++i3) {
                        BlockState stateFromPos = this.getBlockStateFromPos(world, l2, -1, i3, boundingBox);
                        if (stateFromPos.isAir() && this.getSkyBrightness(world, l2, -1, i3, boundingBox)) {
                            this.setBlockState(world, planks, l2, -1, i3, boundingBox);
                        }
                    }
                }

                if (this.hasRails) {
                    BlockState railState = Blocks.RAIL.getDefaultState().with(RailBlock.SHAPE, RailShape.NORTH_SOUTH);

                    for(int j3 = 0; j3 <= i; ++j3) {
                        BlockState stateFromPos = this.getBlockStateFromPos(world, 1, -1, j3, boundingBox);
                        if (!stateFromPos.isAir() && stateFromPos.isOpaqueCube(world, new BlockPos(this.getXWithOffset(1, j3), this.getYWithOffset(-1), this.getZWithOffset(1, j3)))) {
                            float skyBrightness = this.getSkyBrightness(world, 1, 0, j3, boundingBox) ? 0.7F : 0.9F;
                            this.randomlyPlaceBlock(world, boundingBox, rand, skyBrightness, 1, 0, j3, railState);
                        }
                    }
                }

                return true;
            }
        }

        private void placeSupport(ISeedReader world, MutableBoundingBox boundingBox, int xMin, int y, int zMin, int yMin, int yMax, Random rand) {
            if (this.isSupportingBox(world, boundingBox, xMin, yMax, yMin, zMin)) {
                BlockState planks = this.getPlanksBlock();
                BlockState fence = this.getFenceBlock();
                BlockState torch = this.getWallTorchBlock();
                this.fillWithBlocks(world, boundingBox, xMin, y, zMin, xMin, yMin - 1, zMin, fence.with(FenceBlock.WEST, true), CAVE_AIR, false);
                this.fillWithBlocks(world, boundingBox, yMax, y, zMin, yMax, yMin - 1, zMin, fence.with(FenceBlock.EAST, true), CAVE_AIR, false);
                if (rand.nextInt(4) == 0) {
                    this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMin, yMin, zMin, planks, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, yMax, yMin, zMin, yMax, yMin, zMin, planks, CAVE_AIR, false);
                } else {
                    this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, yMax, yMin, zMin, planks, CAVE_AIR, false);
                    this.randomlyPlaceBlock(world, boundingBox, rand, 0.05F, xMin + 1, yMin, zMin - 1, torch.with(WallTorchBlock.HORIZONTAL_FACING, Direction.NORTH));
                    this.randomlyPlaceBlock(world, boundingBox, rand, 0.05F, xMin + 1, yMin, zMin + 1, torch.with(WallTorchBlock.HORIZONTAL_FACING, Direction.SOUTH));
                }
            }
        }

        private void placeCobWeb(ISeedReader world, MutableBoundingBox boundingBox, Random rand, float chance, int x, int y, int z) {
            if (this.getSkyBrightness(world, x, y, z, boundingBox)) {
                this.randomlyPlaceBlock(world, boundingBox, rand, chance, x, y, z, Blocks.COBWEB.getDefaultState());
            }
        }
    }

    public static class Cross extends AljanMineshaftPieces.Piece {
        private final Direction corridorDirection;
        private final boolean isMultipleFloors;

        public Cross(TemplateManager tempManager, CompoundNBT tag) {
            super(IStructurePieceType.MSCROSSING, tag);
            this.isMultipleFloors = tag.getBoolean("tf");
            this.corridorDirection = Direction.byHorizontalIndex(tag.getInt("D"));
        }

        protected void readAdditional(CompoundNBT tag) {
            super.readAdditional(tag);
            tag.putBoolean("tf", this.isMultipleFloors);
            tag.putInt("D", this.corridorDirection.getHorizontalIndex());
        }

        public Cross(int componentType, MutableBoundingBox boundingBox, @Nullable Direction direction, AljanMineshaftStructure.MineshaftType type) {
            super(IStructurePieceType.MSCROSSING, componentType, type);
            this.corridorDirection = direction;
            this.boundingBox = boundingBox;
            this.isMultipleFloors = boundingBox.getYSize() > 3;
        }

        public static MutableBoundingBox findCrossing(List<StructurePiece> pieces, Random rand, int x, int y, int z, Direction facing) {
            MutableBoundingBox boundingBox1 = new MutableBoundingBox(x, y, z, x, y + 3 - 1, z);
            if (rand.nextInt(4) == 0) {
                boundingBox1.maxY += 4;
            }

            switch(facing) {
                case NORTH:
                default:
                    boundingBox1.minX = x - 1;
                    boundingBox1.maxX = x + 3;
                    boundingBox1.minZ = z - 4;
                    break;
                case SOUTH:
                    boundingBox1.minX = x - 1;
                    boundingBox1.maxX = x + 3;
                    boundingBox1.maxZ = z + 3 + 1;
                    break;
                case WEST:
                    boundingBox1.minX = x - 4;
                    boundingBox1.minZ = z - 1;
                    boundingBox1.maxZ = z + 3;
                    break;
                case EAST:
                    boundingBox1.maxX = x + 3 + 1;
                    boundingBox1.minZ = z - 1;
                    boundingBox1.maxZ = z + 3;
            }

            return StructurePiece.findIntersecting(pieces, boundingBox1) != null ? null : boundingBox1;
        }

        // Initiates construction of the Structure Component picked, at the current Location of StructGen.
        public void buildComponent(StructurePiece piece, List<StructurePiece> pieces, Random rand) {
            int componentType1 = this.getComponentType();
            switch(this.corridorDirection) {
                case NORTH:
                default:
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.WEST, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.EAST, componentType1);
                    break;
                case SOUTH:
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.WEST, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.EAST, componentType1);
                    break;
                case WEST:
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.WEST, componentType1);
                    break;
                case EAST:
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, Direction.EAST, componentType1);
            }

            if (this.isMultipleFloors) {
                if (rand.nextBoolean()) {
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                }

                if (rand.nextBoolean()) {
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, Direction.WEST, componentType1);
                }

                if (rand.nextBoolean()) {
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, Direction.EAST, componentType1);
                }

                if (rand.nextBoolean()) {
                    AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                }
            }
        }

        public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            if (this.isLiquidInStructureBoundingBox(world, boundingBox)) {
                return false;
            } else {
                BlockState planks = this.getPlanksBlock();
                if (this.isMultipleFloors) {
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, CAVE_AIR, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, CAVE_AIR, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, CAVE_AIR, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, CAVE_AIR, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, CAVE_AIR, CAVE_AIR, false);
                } else {
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, CAVE_AIR, CAVE_AIR, false);
                    this.fillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, CAVE_AIR, CAVE_AIR, false);
                }

                this.placeSupportPillar(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
                this.placeSupportPillar(world, boundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);
                this.placeSupportPillar(world, boundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
                this.placeSupportPillar(world, boundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);

                for(int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i) {
                    for(int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j) {
                        if (this.getBlockStateFromPos(world, i, this.boundingBox.minY - 1, j, boundingBox).isAir() && this.getSkyBrightness(world, i, this.boundingBox.minY - 1, j, boundingBox)) {
                            this.setBlockState(world, planks, i, this.boundingBox.minY - 1, j, boundingBox);
                        }
                    }
                }

                return true;
            }
        }

        private void placeSupportPillar(ISeedReader world, MutableBoundingBox boundingBox, int xMin, int yMin, int zMin, int yMax) {
            if (!this.getBlockStateFromPos(world, xMin, yMax + 1, zMin, boundingBox).isAir()) {
                this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMin, yMax, zMin, this.getPlanksBlock(), CAVE_AIR, false);
            }
        }
    }

    public abstract static class Piece extends StructurePiece {
        protected AljanMineshaftStructure.MineshaftType mineshaftType;

        public Piece(IStructurePieceType pieceType, int componentType, AljanMineshaftStructure.MineshaftType type) {
            super(pieceType, componentType);
            this.mineshaftType = type;
        }

        public Piece(IStructurePieceType pieceType, CompoundNBT tag) {
            super(pieceType, tag);
            this.mineshaftType = AljanMineshaftStructure.MineshaftType.byId(tag.getInt("MST"));
        }

        // (abstract) Helper method to read subclass data from NBT.
        protected void readAdditional(CompoundNBT tag) {
            tag.putInt("MST", this.mineshaftType.ordinal());
        }

        protected BlockState getPlanksBlock() {
            switch(this.mineshaftType) {
                case ALJANWOOD:
                default:
                    return BMBlocks.ALJANWOOD_PLANKS.get().getDefaultState();
                case ALJANCAP:
                    return BMBlocks.ALJANCAP_PLANKS.get().getDefaultState();
                case INSOMNIAN:
                    return BMBlocks.INSOMNIAN_PLANKS.get().getDefaultState();
                case AVONDALIC_WILLOW:
                    return BMBlocks.AVONDALIC_WILLOW_PLANKS.get().getDefaultState();
            }
        }

        protected BlockState getFenceBlock() {
            switch(this.mineshaftType) {
                case ALJANWOOD:
                default:
                    return BMBlocks.ALJANWOOD_FENCE.get().getDefaultState();
                case ALJANCAP:
                    return BMBlocks.ALJANCAP_FENCE.get().getDefaultState();
                case INSOMNIAN:
                    return BMBlocks.INSOMNIAN_FENCE.get().getDefaultState();
                case AVONDALIC_WILLOW:
                    return BMBlocks.AVONDALIC_WILLOW_FENCE.get().getDefaultState();
            }
        }

        protected BlockState getWallTorchBlock () {
            switch (this.mineshaftType) {
                case ALJANWOOD:
                case AVONDALIC_WILLOW:
                default:
                    return BMBlocks.CHARJAN_ALJANWOOD_WALL_TORCH.get().getDefaultState();
                case ALJANCAP:
                    return BMBlocks.CHARJAN_ALJANCAP_WALL_TORCH.get().getDefaultState();
                case INSOMNIAN:
                    return BMBlocks.CHARJAN_INSOMNIAN_WALL_TORCH.get().getDefaultState();
            }
        }

        protected boolean isSupportingBox(IBlockReader reader, MutableBoundingBox boundingBox, int xStart, int xEnd, int x, int z) {
            for(int i = xStart; i <= xEnd; ++i) {
                if (this.getBlockStateFromPos(reader, i, x + 1, z, boundingBox).isAir()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static class Room extends AljanMineshaftPieces.Piece {
        private final List<MutableBoundingBox> connectedRooms = Lists.newLinkedList();

        public Room(int componentType, Random rand, int p_i47137_3_, int p_i47137_4_, AljanMineshaftStructure.MineshaftType type) {
            super(IStructurePieceType.MSROOM, componentType, type);
            this.mineshaftType = type;
            this.boundingBox = new MutableBoundingBox(p_i47137_3_, 50, p_i47137_4_, p_i47137_3_ + 7 + rand.nextInt(6), 54 + rand.nextInt(6), p_i47137_4_ + 7 + rand.nextInt(6));
        }

        public Room(TemplateManager tempManager, CompoundNBT tag) {
            super(IStructurePieceType.MSROOM, tag);
            ListNBT entrances = tag.getList("Entrances", 11);

            for(int i = 0; i < entrances.size(); ++i) {
                this.connectedRooms.add(new MutableBoundingBox(entrances.getIntArray(i)));
            }
        }

        // Initiates construction of the Structure Component picked, at the current Location of StructGen.
        public void buildComponent(StructurePiece piece, List<StructurePiece> pieces, Random rand) {
            int componentType1 = this.getComponentType();
            int j = this.boundingBox.getYSize() - 3 - 1;
            if (j <= 0) {
                j = 1;
            }

            int k;
            for(k = 0; k < this.boundingBox.getXSize(); k = k + 4) {
                k = k + rand.nextInt(this.boundingBox.getXSize());
                if (k + 3 > this.boundingBox.getXSize()) {
                    break;
                }

                AljanMineshaftPieces.Piece piece1 = AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + k, this.boundingBox.minY + rand.nextInt(j) + 1, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                if (piece1 != null) {
                    MutableBoundingBox boundingBox1 = piece1.getBoundingBox();
                    this.connectedRooms.add(new MutableBoundingBox(boundingBox1.minX, boundingBox1.minY, this.boundingBox.minZ, boundingBox1.maxX, boundingBox1.maxY, this.boundingBox.minZ + 1));
                }
            }

            for(k = 0; k < this.boundingBox.getXSize(); k = k + 4) {
                k = k + rand.nextInt(this.boundingBox.getXSize());
                if (k + 3 > this.boundingBox.getXSize()) {
                    break;
                }

                AljanMineshaftPieces.Piece piece1 = AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX + k, this.boundingBox.minY + rand.nextInt(j) + 1, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                if (piece1 != null) {
                    MutableBoundingBox boundingBox1 = piece1.getBoundingBox();
                    this.connectedRooms.add(new MutableBoundingBox(boundingBox1.minX, boundingBox1.minY, this.boundingBox.maxZ - 1, boundingBox1.maxX, boundingBox1.maxY, this.boundingBox.maxZ));
                }
            }

            for(k = 0; k < this.boundingBox.getZSize(); k = k + 4) {
                k = k + rand.nextInt(this.boundingBox.getZSize());
                if (k + 3 > this.boundingBox.getZSize()) {
                    break;
                }

                AljanMineshaftPieces.Piece piece1 = AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY + rand.nextInt(j) + 1, this.boundingBox.minZ + k, Direction.WEST, componentType1);
                if (piece1 != null) {
                    MutableBoundingBox boundingBox1 = piece1.getBoundingBox();
                    this.connectedRooms.add(new MutableBoundingBox(this.boundingBox.minX, boundingBox1.minY, boundingBox1.minZ, this.boundingBox.minX + 1, boundingBox1.maxY, boundingBox1.maxZ));
                }
            }

            for(k = 0; k < this.boundingBox.getZSize(); k = k + 4) {
                k = k + rand.nextInt(this.boundingBox.getZSize());
                if (k + 3 > this.boundingBox.getZSize()) {
                    break;
                }

                StructurePiece piece1 = AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY + rand.nextInt(j) + 1, this.boundingBox.minZ + k, Direction.EAST, componentType1);
                if (piece1 != null) {
                    MutableBoundingBox boundingBox1 = piece1.getBoundingBox();
                    this.connectedRooms.add(new MutableBoundingBox(this.boundingBox.maxX - 1, boundingBox1.minY, boundingBox1.minZ, this.boundingBox.maxX, boundingBox1.maxY, boundingBox1.maxZ));
                }
            }
        }

        public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            if (this.isLiquidInStructureBoundingBox(world, boundingBox)) {
                return false;
            } else {
                this.fillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.DIRT.getDefaultState(), CAVE_AIR, true);
                this.fillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, CAVE_AIR, CAVE_AIR, false);

                for(MutableBoundingBox mutableboundingbox : this.connectedRooms) {
                    this.fillWithBlocks(world, boundingBox, mutableboundingbox.minX, mutableboundingbox.maxY - 2, mutableboundingbox.minZ, mutableboundingbox.maxX, mutableboundingbox.maxY, mutableboundingbox.maxZ, CAVE_AIR, CAVE_AIR, false);
                }

                this.randomlyRareFillWithBlocks(world, boundingBox, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, CAVE_AIR, false);
                return true;
            }
        }

        public void offset(int x, int y, int z) {
            super.offset(x, y, z);

            for(MutableBoundingBox boundingBox : this.connectedRooms) {
                boundingBox.offset(x, y, z);
            }
        }

        // (abstract) Helper method to read subclass data from NBT.
        protected void readAdditional(CompoundNBT tag) {
            super.readAdditional(tag);
            ListNBT entrances = new ListNBT();

            for(MutableBoundingBox boundingBox : this.connectedRooms) {
                entrances.add(boundingBox.toNBTTagIntArray());
            }

            tag.put("Entrances", entrances);
        }
    }

    public static class Stairs extends AljanMineshaftPieces.Piece {
        public Stairs(int componentType, MutableBoundingBox boundingBox, Direction direction, AljanMineshaftStructure.MineshaftType type) {
            super(IStructurePieceType.MSSTAIRS, componentType, type);
            this.setCoordBaseMode(direction);
            this.boundingBox = boundingBox;
        }

        public Stairs(TemplateManager manager, CompoundNBT tag) {
            super(IStructurePieceType.MSSTAIRS, tag);
        }

        public static MutableBoundingBox findStairs(List<StructurePiece> pieces, Random rand, int x, int y, int z, Direction facing) {
            MutableBoundingBox boundingBox1 = new MutableBoundingBox(x, y - 5, z, x, y + 3 - 1, z);
            switch(facing) {
                case NORTH:
                default:
                    boundingBox1.maxX = x + 3 - 1;
                    boundingBox1.minZ = z - 8;
                    break;
                case SOUTH:
                    boundingBox1.maxX = x + 3 - 1;
                    boundingBox1.maxZ = z + 8;
                    break;
                case WEST:
                    boundingBox1.minX = x - 8;
                    boundingBox1.maxZ = z + 3 - 1;
                    break;
                case EAST:
                    boundingBox1.maxX = x + 8;
                    boundingBox1.maxZ = z + 3 - 1;
            }

            return StructurePiece.findIntersecting(pieces, boundingBox1) != null ? null : boundingBox1;
        }

        // Initiates construction of the Structure Component picked, at the current Location of StructGen.
        public void buildComponent(StructurePiece piece, List<StructurePiece> pieces, Random rand) {
            int componentType1 = this.getComponentType();
            Direction direction = this.getCoordBaseMode();
            if (direction != null) {
                switch(direction) {
                    case NORTH:
                    default:
                        AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, Direction.NORTH, componentType1);
                        break;
                    case SOUTH:
                        AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, Direction.SOUTH, componentType1);
                        break;
                    case WEST:
                        AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, Direction.WEST, componentType1);
                        break;
                    case EAST:
                        AljanMineshaftPieces.generateAndAddPiece(piece, pieces, rand, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, Direction.EAST, componentType1);
                }
            }

        }

        public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            if (this.isLiquidInStructureBoundingBox(world, boundingBox)) {
                return false;
            } else {
                this.fillWithBlocks(world, boundingBox, 0, 5, 0, 2, 7, 1, CAVE_AIR, CAVE_AIR, false);
                this.fillWithBlocks(world, boundingBox, 0, 0, 7, 2, 2, 8, CAVE_AIR, CAVE_AIR, false);

                for(int i = 0; i < 5; ++i) {
                    this.fillWithBlocks(world, boundingBox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, CAVE_AIR, CAVE_AIR, false);
                }

                return true;
            }
        }
    }
}
