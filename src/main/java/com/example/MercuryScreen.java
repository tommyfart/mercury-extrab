package com.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MercuryScreen extends Screen {

    private final List<MercuryWindow> windows = new ArrayList<>();

    public MercuryScreen() {
        super(Text.literal("Mercury"));

        // Create default category windows (like Meteor)
        windows.add(new MercuryWindow("Movement", 50, 50));
        windows.add(new MercuryWindow("Render", 220, 50));
        windows.add(new MercuryWindow("World", 390, 50));
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        this.renderBackground(ctx);

        for (MercuryWindow window : windows) {
            window.render(ctx, mouseX, mouseY);
        }

        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (MercuryWindow window : windows) {
            window.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button,
                                double deltaX, double deltaY) {
        for (MercuryWindow window : windows) {
            window.mouseDragged(mouseX, mouseY, button);
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    public static void open() {
        MinecraftClient.getInstance().setScreen(new MercuryScreen());
    }
}
