package com.company;

import java.awt.*;
import java.awt.geom.*;

class Kulka extends Ellipse2D.Float {
    Plansza p;
    int dx, dy;

    Kulka(Plansza p, int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;

        this.p = p;
        this.dx = dx;
        this.dy = dy;

    }

    void nextKrok() {

        x += dx;
        //dy = 4 - Math.abs(dx);
        y += dy;
        // odbicia od ścian
        if (getMinX() < 0 || getMaxX() > p.getWidth())
            dx = -dx;
        if (getMinY() < 0 || getMaxY() > p.getHeight())
            dy = -dy;
        if (getMaxY() > p.getHeight()) {
            dy = -dy;
            changeScoreBy(-1);
        }

        // kolizja kulki z belką
        if (this.intersects(p.b)) {
            int ballPosition = p.b.outcode(this.x + this.width / 2, this.y + this.height / 2);

            if ((ballPosition & p.b.OUT_TOP) == p.b.OUT_TOP)
                dy = -dy;
//                if ((ballPosition & p.b.OUT_BOTTOM) == p.b.OUT_BOTTOM)
//                    dy = -dy;
//                if ((ballPosition & p.b.OUT_LEFT) == p.b.OUT_LEFT)
//                    dx = -dx;
//                if ((ballPosition & p.b.OUT_RIGHT) == p.b.OUT_RIGHT)
//                    dx = -dx;
        }

        boolean cegielkaColision = p.cegielki.removeIf(this::intersects);
        if (cegielkaColision) {
            dy = -dy;
            changeScoreBy(1);
        }

        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    private void changeScoreBy(int change) {
        try {
            p.jTextField.setText(String.valueOf(Integer.parseInt(p.jTextField.getText()) + change));
        } catch (NullPointerException e) {

        } catch (NumberFormatException e){

        }
    }
}