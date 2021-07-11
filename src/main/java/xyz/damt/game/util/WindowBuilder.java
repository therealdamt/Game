package xyz.damt.game.util;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class WindowBuilder extends Canvas {

    private final JFrame jFrame = new JFrame();

    /**
     * Custom Window Builder Created By damt
     * If you would like to use it please give credits.
     */

    public WindowBuilder(String title, int width, int height) {
        jFrame.setTitle(title);

        jFrame.setPreferredSize(new Dimension(width, height));
        jFrame.setMinimumSize(new Dimension(width, height));
        jFrame.setMaximumSize(new Dimension(width, height));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public WindowBuilder setDimensions(int width, int height) {
        jFrame.setPreferredSize(new Dimension(width, height));
        jFrame.setMinimumSize(new Dimension(width, height));
        jFrame.setMaximumSize(new Dimension(width, height));
        return this;
    }

    public WindowBuilder setTitle(String title) {
        jFrame.setTitle(title);
        return this;
    }

    public WindowBuilder add(Canvas canvas) {
        jFrame.add(canvas);
        return this;
    }

    public WindowBuilder setResizable(boolean value) {
        jFrame.setResizable(value);
        return this;
    }

    public WindowBuilder setDefaultCloseOperation(int value) {
        jFrame.setDefaultCloseOperation(value);
        return this;
    }

    public WindowBuilder setShape(Shape shape) {
        jFrame.setShape(shape);
        return this;
    }

    public WindowBuilder setMenuBar(MenuBar menuBar) {
        jFrame.setMenuBar(menuBar);
        return this;
    }

    public WindowBuilder setFontUsed(Font font) {
        jFrame.setFont(font);
        return this;
    }

    public WindowBuilder setLayout(LayoutManager layout) {
        jFrame.setLayout(layout);
        return this;
    }

    public WindowBuilder setIfVisible(boolean value) {
        jFrame.setVisible(value);
        return this;
    }

    public WindowBuilder setImage(Image image) {
        jFrame.setIconImage(image);
        return this;
    }

    public WindowBuilder run(Runnable... runnables) {
        Arrays.asList(runnables).forEach(Runnable::run);
        return this;
    }

    public JFrame build() {
        return jFrame;
    }

}
