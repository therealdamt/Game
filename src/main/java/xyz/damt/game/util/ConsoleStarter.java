package xyz.damt.game.util;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import xyz.damt.game.Game;

import java.awt.*;
import java.io.Console;

@UtilityClass
public class ConsoleStarter {

    @SneakyThrows
    public final void startConsole(Class<?> clazz, Runnable runnable) {
        Console console = System.console();

        if (console == null && !GraphicsEnvironment.isHeadless()) {
            String filename = clazz.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd", "/k", "java -jar \"" + filename + "\""});
        } else {
            runnable.run();
            System.out.println("Program has ended, please type 'exit' to close the console");
        }
    }

}
