package com.example.mercury.gui;

import net.minecraft.client.gui.DrawContext;

public class ModuleButton {

    private final String name;
    private boolean enabled;

    public ModuleButton(String name) {
        this.name = name;
    }

    public void render(DrawContext ctx, int x, int y, int mouseX, int mouseY) {

        int color = enabled ? 0xFF00FF00 : 0xFFFF5555;

        ctx.drawTextWithShadow(
                net.minecraft.client.MinecraftClient.getInstance().textRenderer,
                (enabled ? "[ON] " : "[OFF] ") + name,
                x,
                y,
                color
        );
    }

    public void mouseClicked(double mouseX, double mouseY) {
        // very simple hitbox (you can improve later)
        if (mouseX >= 0 && mouseX <= 120) {
            enabled = !enabled;
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
}
