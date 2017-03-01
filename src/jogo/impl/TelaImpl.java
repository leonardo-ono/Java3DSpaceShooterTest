package jogo.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import motor.Cor;
import motor.Tela;

/**
 *
 * @author leonardo
 */
public class TelaImpl implements Tela {
    
    private JFrame frame;
    private BufferStrategy bs;
    private Graphics g;
    private Cor cor;
    
    public TelaImpl(JFrame frame) {
        frame.setBackground(Color.BLACK);
        frame.createBufferStrategy(2);
        this.frame = frame;
        this.bs = frame.getBufferStrategy();
        this.g = bs.getDrawGraphics();
    }
    
    @Override
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    @Override
    public void desenharLinha(int x1, int y1, int x2, int y2) {
        g.setColor(new Color(cor.getR(), cor.getG(), cor.getB()));
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void desenhaString(String string, int x, int y) {
        g.setColor(new Color(cor.getR(), cor.getG(), cor.getB()));
        g.drawString(string, x, y);
    }

    @Override
    public void limpar() {
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    @Override
    public void exibir() {
        bs.show();
    }
    
}
