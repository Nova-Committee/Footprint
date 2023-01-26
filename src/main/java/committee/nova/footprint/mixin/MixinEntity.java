package committee.nova.footprint.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {
    @Shadow
    public World worldObj;

    @Shadow
    public double posX;

    @Shadow
    public double posY;

    @Shadow
    public double posZ;

    @Shadow
    public float rotationYaw;

    @Inject(method = "moveEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;func_145780_a(IIILnet/minecraft/block/Block;)V"))
    private void inject$moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_, CallbackInfo ci) {
        worldObj.spawnParticle("footstep", posX, posY - 1.605, posZ, rotationYaw, 0.0, 0.0);
    }
}
