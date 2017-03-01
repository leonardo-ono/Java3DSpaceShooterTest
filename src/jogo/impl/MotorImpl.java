package jogo.impl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import motor.Motor;
import motor.Teclado;
import motor.Tela;

/**
 *
 * @author leonardo
 */
public class MotorImpl extends Motor implements KeyListener {

    private JFrame janela = new JFrame() {
        @Override
        public void update(Graphics g) {
            super.update(g);
        }
    };

    public MotorImpl() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 600);
        janela.setLocationRelativeTo(null);
        janela.addKeyListener(this);
        janela.setVisible(true);
        Tela tela = new TelaImpl(janela);
        setTela(tela);
    }

    @Override
    public void iniciar() {
        super.iniciar();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed " + e.getKeyCode() + " ...");
        Teclado.keyDown(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Teclado.keyUp(e.getKeyCode());
    }
 
}
