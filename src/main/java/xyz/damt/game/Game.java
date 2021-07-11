package xyz.damt.game;

import lombok.Getter;
import lombok.SneakyThrows;
import xyz.damt.game.key.KeyInput;
import xyz.damt.game.objects.ObjectHandler;
import xyz.damt.game.objects.ObjectId;
import xyz.damt.game.objects.impl.Enemy;
import xyz.damt.game.objects.impl.Player;
import xyz.damt.game.threads.GameStartThread;
import xyz.damt.game.threads.ShutdownThread;
import xyz.damt.game.util.WindowBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class Game extends Canvas {

    @Getter
    private static Game instance;
    @Getter
    private static Logger logger;

    private final int width = 640;
    private final int height = width / 12 * 9;

    private final GameStartThread gameStartThread;
    private final ObjectHandler objectHandler;

    @SneakyThrows
    public Game() {
        this.objectHandler = new ObjectHandler();
        this.gameStartThread = new GameStartThread(this);
        this.addKeyListener(new KeyInput(this));

        BufferedImage image = ImageIO.read(getClass().getResource("/images/main.jpg"));
        new WindowBuilder("First Game", width, height).add(this).run(() -> gameStartThread.create()).setImage(image).build();

        objectHandler.addObjects(new Enemy(1, 1, ObjectId.ENEMY));
        objectHandler.addObjects(new Player(width / 2 - 32, height / 2 - 32, ObjectId.PLAYER));
    }

    @SneakyThrows
    public static void main(String[] args) {
        logger = Logger.getLogger("Game");

        logger.log(Level.INFO, "Setting Game Startup Logic...");
        instance = new Game();
        logger.log(Level.INFO, "Setting Game Shutdown Logic...");
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
    }
}

