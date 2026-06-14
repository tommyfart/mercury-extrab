package com.example.addon.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MercuryScreen extends Screen {

    private final List<MercuryWindow> windows = new ArrayList<>();

    public MercuryScreen() {
        super(Text.literal("Mercury"));
    }

    @Override
    protected void init() {
        windows.clear();

        windows.add(new MercuryWindow("Movement", 50, 50));
        windows.add(new MercuryWindow("Render", 220, 50));
        windows.add(new MercuryWindow("World", 390, 50));
    }

    @Override
    public void render(net.minecraft.client.gui.DrawContext ctx, int mouseX, int mouseY, float delta) {
        this.renderBackground(ctx);

        for (MercuryWindow w : windows) {
            w.render(ctx, mouseX, mouseY);
        }

        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (MercuryWindow w : windows) {
            w.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button,
                                double deltaX, double deltaY) {
        for (MercuryWindow w : windows) {
            w.mouseDragged(mouseX, mouseY);
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    public static void open() {
        MinecraftClient.getInstance().setScreen(new MercuryScreen());
    }
}
