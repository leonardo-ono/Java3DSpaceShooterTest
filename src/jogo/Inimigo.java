package jogo;

import java.util.List;
import motor.CaixaColidivel;
import motor.Cor;
import motor.Face;
import motor.Objeto3D;
import motor.Ponto;
import motor.Tempo;

/**
 *
 * @author leonardo
 */
public class Inimigo extends Objeto3D {
    
    private float seedX = (float) Math.random() * 2;
    private float seedZ = (float) Math.random() * 2;
    private float seedR = (float) (Math.random() * 2);
    private Mira mira;

    public void setMira(Mira mira) {
        this.mira = mira;
    }

    @Override
    public void atualizar() {
            float z = (float) Math.sin((double) System.currentTimeMillis() / 1000 * seedZ) * 200;
            getTranslacao().setZ(z);
            float x = (float) Math.sin((double) System.currentTimeMillis() / 2000 * seedX) * 300;
            getTranslacao().setX(x);
            getTranslacao().addY(-Tempo.getDelta() * 0.0000001f);
            if (getTranslacao().getY() < -100) {
                getTranslacao().setY(3000);
            }
            getRotacao().addZ(Tempo.getDelta() * 0.000000005f);
    }
    
    @Override
    public String getEtiqueta() {
        return "inimigo";
    }

    @Override
    public void construir() {
        CaixaColidivel colidivel = new CaixaColidivel();
        colidivel.getA().setX(-15);
        colidivel.getA().setY(-15);
        colidivel.getA().setZ(-15);
        colidivel.getB().setX(15);
        colidivel.getB().setY(15);
        colidivel.getB().setZ(15);
        setColidivel(colidivel);
        
        // Wavefront.carregar(System.getProperty("user.dir").replace("\\","/") + "/res/nave.obj", this, 30);
        Ponto p1 = new Ponto(-0.0f, -30.0f, 0.0f);
        Ponto p2 = new Ponto(-21.213211f, -21.213211f, 0.0f);
        Ponto p3 = new Ponto(-30.0f, 0.0f, -0.0f);
        Ponto p4 = new Ponto(-21.213211f, 21.213211f, -0.0f);
        Ponto p5 = new Ponto(0.0f, 30.0f, -0.0f);
        Ponto p6 = new Ponto(21.213211f, 21.213211f, -0.0f);
        Ponto p7 = new Ponto(30.0f, -0.0f, 0.0f);
        Ponto p8 = new Ponto(21.213211f, -21.213211f, 0.0f);
        Ponto p9 = new Ponto(21.213211f, -21.213211f, -8.59284f);
        Ponto p10 = new Ponto(30.0f, -0.0f, -8.59284f);
        Ponto p11 = new Ponto(21.213211f, 21.213211f, -8.59284f);
        Ponto p12 = new Ponto(0.0f, 30.0f, -8.59284f);
        Ponto p13 = new Ponto(-21.213211f, 21.213211f, -8.59284f);
        Ponto p14 = new Ponto(-30.0f, 0.0f, -8.59284f);
        Ponto p15 = new Ponto(-21.213211f, -21.213211f, -8.59284f);
        Ponto p16 = new Ponto(-0.0f, -30.0f, -8.59284f);
        Ponto p17 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p18 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p19 = new Ponto(-0.0f, -0.0f, -17.59284f);
        Ponto p20 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p21 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p22 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p23 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p24 = new Ponto(0.0f, -0.0f, -17.59284f);
        Ponto p25 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p26 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p27 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p28 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p29 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p30 = new Ponto(-0.0f, 0.0f, 9.0f);
        Ponto p31 = new Ponto(0.0f, 0.0f, 9.0f);
        Ponto p32 = new Ponto(0.0f, 0.0f, 9.0f);
        Face f1 = new Face(p8,p1,p16,p9);
        Face f2 = new Face(p8,p7,p10,p9);
        Face f3 = new Face(p7,p6,p11,p10);
        Face f4 = new Face(p6,p5,p12,p11);
        Face f5 = new Face(p5,p4,p13,p12);
        Face f6 = new Face(p4,p3,p14,p13);
        Face f7 = new Face(p2,p3,p14,p15);
        Face f8 = new Face(p2,p1,p16,p15);
        Face f9 = new Face(p15,p16,p17,p18);
        Face f10 = new Face(p15,p14,p19,p18);
        Face f11 = new Face(p13,p14,p19,p20);
        Face f12 = new Face(p12,p13,p20,p21);
        Face f13 = new Face(p11,p12,p21,p22);
        Face f14 = new Face(p10,p11,p22,p23);
        Face f15 = new Face(p9,p10,p23,p24);
        Face f16 = new Face(p9,p16,p17,p24);
        Face f17 = new Face(p1,p8,p25,p32);
        Face f18 = new Face(p7,p8,p25,p26);
        Face f19 = new Face(p6,p7,p26,p27);
        Face f20 = new Face(p5,p6,p27,p28);
        Face f21 = new Face(p4,p5,p28,p29);
        Face f22 = new Face(p3,p4,p29,p30);
        Face f23 = new Face(p3,p2,p31,p30);
        Face f24 = new Face(p1,p2,p31,p32);
        addFace(f1);
        addFace(f2);
        addFace(f3);
        addFace(f4);
        addFace(f5);
        addFace(f6);
        addFace(f7);
        addFace(f8);
        addFace(f9);
        addFace(f10);
        addFace(f11);
        addFace(f12);
        addFace(f13);
        addFace(f14);
        addFace(f15);
        addFace(f16);
        addFace(f17);
        addFace(f18);
        addFace(f19);
        addFace(f20);
        addFace(f21);
        addFace(f22);
        addFace(f23);
        addFace(f24);

        getRotacao().setZ(seedR);
    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
        // System.out.println("Inimigo acertou " + objetos.get(0).getEtiqueta() + " ...");
        boolean temTiro = false;
        for (Objeto3D objeto : objetos) {
            if (objeto.getEtiqueta().equals("tiro")) {
                temTiro = true;
                break;
            }
        }
        if (!temTiro) {
            return;
        }
        
        // Explosao
        for (Face face : getFaces()) {
            Estilhaco estilhaco = new Estilhaco();
            estilhaco.setCor(new Cor(150,150,150));
            estilhaco.getTranslacao().setX(getTranslacao().getX());
            estilhaco.getTranslacao().setY(getTranslacao().getY());
            estilhaco.getTranslacao().setZ(getTranslacao().getZ());
            estilhaco.getRotacao().setX(getRotacao().getX());
            estilhaco.getRotacao().setY(getRotacao().getY());
            estilhaco.getRotacao().setZ(getRotacao().getZ());
            estilhaco.getEscala().setX(getEscala().getX());
            estilhaco.getEscala().setY(getEscala().getY());
            estilhaco.getEscala().setZ(getEscala().getZ());
            estilhaco.addFace(face);
            getEspaco().addObjeto3D(estilhaco);
        }
        getEspaco().removeObjeto3D(this);
        getEspaco().removeObjeto3D(mira);
    }
    
}
