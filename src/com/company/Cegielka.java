package com.company;

import java.awt.geom.*;

public class Cegielka extends Rectangle2D.Float{
    static int szerokosc = 100;
    static int wysokosc = 50;
    Cegielka(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = szerokosc;
        this.height = wysokosc;
    }
}
