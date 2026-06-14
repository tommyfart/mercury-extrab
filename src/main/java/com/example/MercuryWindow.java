package com.example.mercury.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class MercuryWindow {

    public String title;

    public double x, y;
    private double dragX, dragY;
    private boolean dragging;

    private boolean expanded = true;

    private final List<ModuleButton> modules = new ArrayList<>();

    public MercuryWindow(String title, double x, double y) {
        this.title = title;
        this.x = x;
        this.y = y;

        // demo modules
        modules.add(new ModuleButton("Example Module 1"));
        modules.add(new ModuleButton("Example Module 2"));
        modules.add(new ModuleButton("Example Module 3"));
    }

    public void render(DrawContext ctx, int mouseX, int mouseY) {

        int width = 120;
        int headerHeight = 14;

        // Background
        ctx.fill((int)x, (int)y, (int)x + width, (int)y + 100, 0xFF1A1A1A);

        // Header
        ctx.fill((int)x, (int)y, (int)x + width, (int)y + headerHeight, 0xFF2B2B2B);
        ctx.drawTextWithShadow(
                net.minecraft.client.MinecraftClient.getInstance().textRenderer,
                title,
                (int)x + 4,
                (int)y + 3,
                0xFFFFFF
        );

        if (expanded) {
            int offsetY = 18;

            for (ModuleButton module : modules) {
                module.render(ctx, (int)x + 4, (int)y + offsetY, mouseX, mouseY);
                offsetY += 12;
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

        int width = 120;
        int headerHeight = 14;

        // click header = drag or toggle expand
        if (mouseX >= x && mouseX <= x + width &&
            mouseY >= y && mouseY <= y + headerHeight) {

            if (button == 0) {
                dragging = true;
                dragX = mouseX - x;
                dragY = mouseY - y;
            } else if (button == 1) {
                expanded = !expanded;
            }
        }

        if (expanded) {
            for (ModuleButton module : modules) {
                module.mouseClicked(mouseX, mouseY);
            }
        }
    }

    public void mouseDragged(double mouseX, double mouseY, int button) {
        if (dragging) {
            x = mouseX - dragX;
            y = mouseY - dragY;
        }
    }
}
