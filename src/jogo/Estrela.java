package jogo;

import java.util.List;
import motor.Face;
import motor.Objeto3D;
import motor.Ponto;
import motor.Tempo;

/**
 *
 * @author leonardo
 */
public class Estrela extends Objeto3D {

    @Override
    public String getEtiqueta() {
        return "tiro";
    }

    @Override
    public void construir() {
        Ponto p1 = new Ponto( 0, 0, 0);
        Ponto p2 = new Ponto( 2, 0, 0);
        Ponto p3 = new Ponto( 2, 2, 0);
        Ponto p4 = new Ponto( 0, 2, 0);
        Ponto p5 = new Ponto( 0, 0, 2);
        Ponto p6 = new Ponto( 2, 0, 2);
        Ponto p7 = new Ponto( 2, 2, 2);
        Ponto p8 = new Ponto( 0, 2, 2);
        
        Face f1 = new Face(p1, p2, p3, p4);
        Face f2 = new Face(p5, p6, p7, p8);
        Face f3 = new Face(p1, p2, p6, p5);
        Face f4 = new Face(p2, p3, p7, p6);
        Face f5 = new Face(p3, p4, p8, p7);
        Face f6 = new Face(p4, p1, p5, p8);
        
        addFace(f1);
        addFace(f2);
        addFace(f3);
        addFace(f4);
        addFace(f5);
        addFace(f6);
    }

    @Override
    public void atualizar() {
        getTranslacao().addY(-Tempo.getDelta() * 0.000001f);
        if (getTranslacao().getY() < -150) {
            getTranslacao().setY(5000);
        }
    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
    }
    
}
