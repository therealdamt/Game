package xyz.damt.game.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import xyz.damt.game.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

@Getter
@Setter
public class GameStartThread extends Thread {

    private boolean running;
    private int frames;

    private final Game game;

    public GameStartThread(Game game) {
        this.game = game;
    }

    public void create() {
        this.setDaemon(false);
        this.start();

        this.running = true;
    }

    @SneakyThrows
    public void end() {
        this.join();
        this.running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.00;

        double ns = 1000000000 / amountOfTicks;
        double delta = 0.00;

        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running)
                render();

            frames++;


            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
               // System.out.printf("FPS: " + frames + "\n");
                frames = 0;
            }

        }
        end();
    }

    public void tick() {
        game.getObjectHandler().tickAll();
    }

    public void render() {
        BufferStrategy bufferStrategy = game.getBufferStrategy();

        if (bufferStrategy == null) {
            game.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, game.getWidth(), game.getHeight());

        game.getObjectHandler().renderAll(graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

}
