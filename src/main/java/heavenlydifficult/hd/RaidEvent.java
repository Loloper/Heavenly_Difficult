package heavenlydifficult.hd;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;

import java.util.List;

/*This is the raid event class*/
public class RaidEvent {
    private static int pillagerAnger = 7;
    private static int raidAgression;

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(RaidEvent::checkWorldEvents);
    }

    private static void checkWorldEvents(ServerWorld world) {

        if (world.getTimeOfDay() % 24000 == 12000) {
            pillagerAnger = raidChanceIncrease();

            if (pillagerAnger < 10) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    List<VillagerEntity> villagers = world.getEntitiesByClass(VillagerEntity.class, new Box(player.getBlockPos()).expand(100), villager -> true);
                    int villageSize = villagers.size();
                    System.out.println(villageSize);
                    if (villageSize > 100) {
                        raidAgression = 5;
                        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.AMBIENT, 1.0F, .2F);
                        List<PillagerEntity> pillager = world.getEntitiesByClass(PillagerEntity.class, new Box(player.getBlockPos()).expand(100), pillagerEntity -> true);
                    } else if (villageSize > 50) {
                        raidAgression = 3;
                    } else if (villageSize > 30) {
                        raidAgression = 1;
                    } else {
                        System.out.println("Raid has been cancelled because its as big as your biggest man. Nigga");
                        return;
                    }
                }

                world.getPlayers().forEach(player -> {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 5, raidAgression));
                });
                pillagerAnger = 0;
            }
            System.out.println(pillagerAnger);

        }
    }

    private static int raidChanceIncrease() {
        if ((int) (Math.random() * 101) < 10) {
            pillagerAnger++;
        }
        return pillagerAnger;
    }
}
