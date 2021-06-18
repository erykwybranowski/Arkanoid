package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
class Plansza extends JPanel implements MouseMotionListener {
    Belka b;
    Kulka a;
    SilnikKulki s;
    List<Cegielka> cegielki = new ArrayList<>();
    JTextField jTextField;

    Plansza() {
        super();
        addMouseMotionListener(this);

        b = new Belka(100);
        a = new Kulka(this, 100, 100, 1, 1);
        s = new SilnikKulki(a);
        for (int i = 0; i < 5; i++){
//            (getWidth() / 5) * i
            cegielki.add(new Cegielka((Cegielka.szerokosc + 5) * i, 0));
        }
        for (int i = 0; i < 5; i++){
//            (getWidth() / 5) * i
            cegielki.add(new Cegielka((Cegielka.szerokosc + 5) * i, Cegielka.wysokosc + 5));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.fill(a);
        g2d.fill(b);
        for (Cegielka cegielka : cegielki)
            g2d.fill(cegielka);
    }

    public void mouseMoved(MouseEvent e) {
        b.setX(e.getX() - 50);
        repaint();
    }

    public void mouseDragged(MouseEvent e) {

    }
}