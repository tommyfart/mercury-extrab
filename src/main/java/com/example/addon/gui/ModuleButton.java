package com.example.addon.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;

public class ModuleButton {

    private final String name;
    private boolean enabled;

    public ModuleButton(String name) {
        this.name = name;
    }

    public void render(DrawContext ctx, int x, int y, int mouseX, int mouseY) {

        ctx.drawTextWithShadow(
            MinecraftClient.getInstance().textRenderer,
            (enabled ? "ON " : "OFF ") + name,
            x,
            y,
            enabled ? 0x55FF55 : 0xFF5555
        );
    }

    public void click(int mouseX, int mouseY) {
        enabled = !enabled;
    }
}
