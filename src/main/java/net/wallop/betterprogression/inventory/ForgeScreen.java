package net.wallop.betterprogression.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;

public class ForgeScreen extends HandledScreen<ForgeScreenHandler> {

    private static final Identifier LIT_PROGRESS_TEXTURE = Identifier.of(BetterProgression.MOD_ID,"container/forge/lit_progress");
    private static final Identifier BURN_PROGRESS_TEXTURE = Identifier.of(BetterProgression.MOD_ID,"container/forge/burn_progress");
    private static final Identifier TEXTURE = Identifier.of(BetterProgression.MOD_ID,"textures/gui/container/forge.png");

    public ForgeScreen(ForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if (this.handler.isBurning()) {
            int h = MathHelper.ceil(this.handler.getFuelProgress() * 40.0F) + 1;
            context.drawGuiTexture(LIT_PROGRESS_TEXTURE, 7,41,0,41-h,x + 55,y + 23 + 41 - h,7,h);
        }

        int l = MathHelper.ceil(this.handler.getCookProgress() * 31.0f);
        context.drawGuiTexture(BURN_PROGRESS_TEXTURE, 31, 28, 0, 0, x + 88,y + 28,l, 28);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
