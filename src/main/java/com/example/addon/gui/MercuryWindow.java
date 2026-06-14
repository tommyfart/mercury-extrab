package com.example.addon.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class MercuryWindow {

    private final String title;

    private double x, y;
    private double dragX, dragY;
    private boolean dragging;

    public MercuryWindow(String title, double x, double y) {
        this.title = title;
        this.x = x;
        this.y = y;
    }

    public void render(DrawContext ctx, int mouseX, int mouseY) {

        ctx.fill((int)x, (int)y, (int)x + 120, (int)y + 14, 0xFF222222);

        ctx.drawTextWithShadow(
            MinecraftClient.getInstance().textRenderer,
            title,
            (int)x + 4,
            (int)y + 4,
            0xFFFFFF
        );
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= x && mouseX <= x + 120 &&
            mouseY >= y && mouseY <= y + 14) {

            if (button == 0) {
                dragging = true;
                dragX = mouseX - x;
                dragY = mouseY - y;
            }
        }
    }

    public void mouseDragged(double mouseX, double mouseY) {
        if (dragging) {
            x = mouseX - dragX;
            y = mouseY - dragY;
        }
    }
}
