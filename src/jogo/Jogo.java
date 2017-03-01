package jogo;

import java.util.List;
import motor.Cor;
import motor.Espaco;
import motor.Objeto3D;
import motor.Tempo;
import jogo.impl.MotorImpl;

/**
 *
 * @author leonardo
 */
public class Jogo extends Objeto3D {
     
    public static Jogo jogo = new Jogo();
    public static Nave nave = new Nave();
    public static Espaco espaco;

    public static void main(String[] args) {
        MotorImpl motor = new MotorImpl();
        espaco = motor.getEspaco();
        preparar(espaco);
        motor.iniciar();
    }
    
    public static void preparar(Espaco espaco) {
        espaco.addObjeto3D(jogo);
        
        for (int i=0; i<100; i++) {
            Estrela estrela = new Estrela();
            estrela.getTranslacao().setX((float) (Math.random() * 700 - 350));
            estrela.getTranslacao().setY((float) (Math.random() * 5750 - 750));
            estrela.getTranslacao().setZ((float) (Math.random() * 600 - 300));
            espaco.addObjeto3D(estrela);
        }

        for (int i=0; i<20; i++) {
            Inimigo inimigo = new Inimigo();
            inimigo.getTranslacao().setX((float) (Math.random() * 500 - 250));
            inimigo.getTranslacao().setY((float) (Math.random() * 5000) - 2000);
            inimigo.getTranslacao().setZ((float) (Math.random() * 500 - 250));
            inimigo.setCor(new Cor(255,0,0));
            espaco.addObjeto3D(inimigo);
            Mira mira = new Mira(nave, inimigo);
            inimigo.setMira(mira);
            espaco.addObjeto3D(mira);
        }
        
        espaco.addObjeto3D(nave);
    }

    @Override
    public void atualizar() {
        if (Tempo.obterCronometro("nave atingida") > 5000) {
            Tempo.paraCronometro("nave atingida");
            //nave.getTranslacao().setX(0);
            //nave.getTranslacao().setZ(0);
            nave = new Nave();
            Mira.nave = nave;
            espaco.addObjeto3D(nave);
            espaco.getCamera().getPosicao().setX(0);
            espaco.getCamera().getPosicao().setZ(0);
        }
    }

    @Override
    public String getEtiqueta() {
        return "jogo";
    }

    @Override
    public void construir() {
    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
    }
    
}
