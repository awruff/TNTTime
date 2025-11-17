package club.sk1er.mods.tnttimer.mixins;

import club.sk1er.mods.tnttimer.TNTTime;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.entity.item.EntityTNTPrimed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderTNTPrimed.class)
public class RenderTNTPrimedMixin {
    @Inject(
            method = "doRender(Lnet/minecraft/entity/item/EntityTNTPrimed;DDDFF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/Render;doRender(Lnet/minecraft/entity/Entity;DDDFF)V")
    )
    private void drawNametag(EntityTNTPrimed entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        TNTTime.INSTANCE.renderTag(((RenderTNTPrimed)(Object)this), entity, x, y, z, partialTicks);
    }
}
