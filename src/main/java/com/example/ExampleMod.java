package com.example;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class MercuryScreen extends Screen {
    private int panelX = 100;
    private int panelY = 60;
    private int panelW = 400;
    private int panelH = 250;

    public MercuryScreen() {
        super(Component.literal("Mercury"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics, mouseX, mouseY, delta);

        // Main panel
        graphics.fill(panelX, panelY, panelX + panelW, panelY + panelH, 0xDD1A1A1A);

        // Header
        graphics.fill(panelX, panelY, panelX + panelW, panelY + 20, 0xFF2A2A2A);

        graphics.drawString(
            font,
            "Mercury",
            panelX + 6,
            panelY + 6,
            0xFFFFFF,
            false
        );

        // Categories
        graphics.fill(panelX + 5, panelY + 25, panelX + 100, panelY + 245, 0xFF202020);

        graphics.drawString(font, "Combat", panelX + 10, panelY + 35, 0xFFFFFF, false);
        graphics.drawString(font, "Movement", panelX + 10, panelY + 50, 0x00FF00, false);
        graphics.drawString(font, "Render", panelX + 10, panelY + 65, 0xFFFFFF, false);
        graphics.drawString(font, "World", panelX + 10, panelY + 80, 0xFFFFFF, false);

        // Modules
        graphics.fill(panelX + 110, panelY + 25, panelX + 395, panelY + 245, 0xFF202020);

        graphics.drawString(font, "[ON] Sprint", panelX + 120, panelY + 40, 0x00FF00, false);
        graphics.drawString(font, "[ON] Speed", panelX + 120, panelY + 55, 0x00FF00, false);
        graphics.drawString(font, "[OFF] Fly", panelX + 120, panelY + 70, 0xFF5555, false);

        // Settings panel
        graphics.fill(panelX + 260, panelY + 35, panelX + 390, panelY + 180, 0xFF252525);

        graphics.drawString(font, "Fly Settings", panelX + 270, panelY + 45, 0xFFFFFF, false);
        graphics.drawString(font, "Mode: Vanilla", panelX + 270, panelY + 65, 0xAAAAAA, false);
        graphics.drawString(font, "Speed: 2.5", panelX + 270, panelY + 80, 0xAAAAAA, false);
        graphics.drawString(font, "Anti-Kick: ON", panelX + 270, panelY + 95, 0xAAAAAA, false);

        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
