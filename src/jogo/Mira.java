package jogo;

import java.util.List;
import motor.Cor;
import motor.Face;
import motor.Objeto3D;
import motor.Ponto;

/**
 *
 * @author leonardo
 */
public class Mira extends Objeto3D {
    
    public static Nave nave;
    private Inimigo inimigo;
    
    public Mira(Nave nave, Inimigo inimigo) {
        this.nave = nave;
        this.inimigo = inimigo;
    }

    @Override
    public String getEtiqueta() {
        return "mira";
    }

    @Override
    public void construir() {
        setCor(new Cor(0, 255, 0));
        //Wavefront.carregar(System.getProperty("user.dir").replace("\\","/") + "/res/mira.obj", this, 10);

        Ponto p1 = new Ponto( -10, -10, -10);
        Ponto p2 = new Ponto( 10, -10, -10);
        Ponto p3 = new Ponto( 10, 10, -10);
        Ponto p4 = new Ponto( -10, 10, -10);
        Ponto p5 = new Ponto( -10, -10, 10);
        Ponto p6 = new Ponto( 10, -10, 10);
        Ponto p7 = new Ponto( 10, 10, 10);
        Ponto p8 = new Ponto( -10, 10, 10);
        
        Face f1 = new Face(p1, p2, p3, p4);
        Face f2 = new Face(p5, p6, p7, p8);
        Face f3 = new Face(p1, p2, p6, p5);
        Face f4 = new Face(p2, p3, p7, p6);
        Face f5 = new Face(p3, p4, p8, p7);
        Face f6 = new Face(p4, p1, p5, p8);
        
        //addFace(f1);
        //addFace(f2);
        addFace(f3);
        //addFace(f4);
        //addFace(f5);
        //addFace(f6);
    }

    @Override
    public void atualizar() {
        getTranslacao().setY(inimigo.getTranslacao().getY() - 10);
        getTranslacao().setX(nave.getTranslacao().getX());
        getTranslacao().setZ(nave.getTranslacao().getZ());
    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
    }
    
}
