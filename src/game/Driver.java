package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Driver implements Runnable {

    int w = 420;
    int offset = 0;

    static Bird b;
    static boolean running = true;

    JFrame frame;
    static Canvas canvas;
    static BasicTimer timer = new BasicTimer(30);

    BufferedImage bk = ImageIO.read(new File("src/asset/bk.png"));
    BufferedImage bird = ImageIO.read(new File("src/asset/bird.png"));
    BufferedImage tube = ImageIO.read(new File("src/asset/tube.png"));
    BufferedImage go = ImageIO.read(new File("src/asset/go.png"));



    public Driver() throws IOException {
        frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas = new Canvas());
        canvas.addKeyListener(new Keys());
        frame.setSize(814, w);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(this).start();

    }

    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(bk, offset, 0, null);
        g.drawImage(bk, 814 + offset, 0, null);
        if (!running){
            g.drawImage(go, -45, 0, null);
            g.dispose();
            bs.show();
        } else {
            g.drawImage(bird, 150, b.y, null);
            g.dispose();
            bs.show();
        }
        g.dispose();
        bs.show();

    }

    public void update() {
        if (offset == 814) {
            offset = 0;
        } else {
            offset -= 2;
        }
        Bird.changeY(b);
        Bird.changeVel(b);
        Bird.checkStatus(b);
    }

    public static void init() {
        b = new Bird(210, 0);
    }

    @Override
    public void run() {
        init();
        while (true) {
            timer.sync();
            update();
            render();
        }

    }

    public static void main(String[] args) throws IOException {
        new Driver();

    }
}