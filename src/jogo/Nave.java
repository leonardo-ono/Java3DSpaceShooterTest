package jogo;

import java.util.List;
import motor.CaixaColidivel;
import motor.Camera;
import motor.Face;
import motor.Objeto3D;
import motor.Ponto;
import motor.Teclado;
import motor.Tempo;

/**
 *
 * @author leonardo
 */
public class Nave extends Objeto3D {
    
    private Float cameraX;
    private Float cameraZ;

    @Override
    public String getEtiqueta() {
        return "nave";
    }

    @Override
    public void construir() {
        CaixaColidivel colidivel = new CaixaColidivel();
        colidivel.getA().setX(-40);
        colidivel.getA().setY(-40);
        colidivel.getA().setZ(-40);
        colidivel.getB().setX(40);
        colidivel.getB().setY(40);
        colidivel.getB().setZ(40);
        setColidivel(colidivel);
        
        // Wavefront.carregar(System.getProperty("user.dir").replace("\\","/") + "/res/heroi.obj", this, 7f);
        
        Ponto p1 = new Ponto(-3.1566288f, 6.999993f, -5.35017f);
        Ponto p2 = new Ponto(-3.1566288f, -7.0000067f, -5.350156f);
        Ponto p3 = new Ponto(3.1566288f, -7.0000067f, -5.350156f);
        Ponto p4 = new Ponto(3.1566288f, 7.0f, -5.35017f);
        Ponto p5 = new Ponto(-3.058923f, 7.0f, 2.191385f);
        Ponto p6 = new Ponto(-3.058916f, -7.0f, 2.191399f);
        Ponto p7 = new Ponto(3.058923f, -6.999993f, 2.191399f);
        Ponto p8 = new Ponto(3.058916f, 7.0f, 2.191385f);
        Ponto p9 = new Ponto(3.1566288f, 21.0f, -5.3501844f);
        Ponto p10 = new Ponto(3.058916f, 21.0f, 0.305445f);
        Ponto p11 = new Ponto(-3.1566288f, 20.999992f, -5.3501844f);
        Ponto p12 = new Ponto(-3.058923f, 21.0f, 0.305445f);
        Ponto p13 = new Ponto(-17.034256f, -1.589602f, -6.53548f);
        Ponto p14 = new Ponto(-17.034256f, -1.589602f, -4.939368f);
        Ponto p15 = new Ponto(-17.034256f, -15.589602f, -6.5354657f);
        Ponto p16 = new Ponto(-17.034256f, -15.589602f, -4.939354f);
        Ponto p17 = new Ponto(17.034256f, -1.589595f, -6.53548f);
        Ponto p18 = new Ponto(17.034256f, -1.589602f, -4.939368f);
        Ponto p19 = new Ponto(17.034256f, -15.589602f, -6.5354657f);
        Ponto p20 = new Ponto(17.034256f, -15.589596f, -4.939354f);
        Ponto p21 = new Ponto(4.133374f, 24.787336f, -5.556789f);
        Ponto p22 = new Ponto(-4.133388f, 24.787336f, -5.556789f);
        Ponto p23 = new Ponto(-4.1333947f, 28.511244f, -4.159183f);
        Ponto p24 = new Ponto(4.133374f, 28.511244f, -4.159183f);
        Ponto p25 = new Ponto(4.133367f, 32.057186f, -5.793991f);
        Ponto p26 = new Ponto(4.133374f, 32.05718f, -5.347195f);
        Ponto p27 = new Ponto(-4.1333947f, 32.05718f, -5.793991f);
        Ponto p28 = new Ponto(-4.1333947f, 32.05718f, -5.347195f);
        Ponto p29 = new Ponto(10.429523f, 2.7052062f, -2.356893f);
        Ponto p30 = new Ponto(7.186886f, 2.7052062f, 0.325283f);
        Ponto p31 = new Ponto(7.1868925f, -11.294794f, 0.325297f);
        Ponto p32 = new Ponto(10.429531f, -11.294802f, -2.356879f);
        Ponto p33 = new Ponto(-7.1868925f, 2.705199f, 0.325283f);
        Ponto p34 = new Ponto(-10.429531f, 2.705199f, -2.356893f);
        Ponto p35 = new Ponto(-10.429531f, -11.294802f, -2.356879f);
        Ponto p36 = new Ponto(-7.186886f, -11.294802f, 0.325297f);
        Ponto p37 = new Ponto(32.892807f, -1.589595f, -0.85843104f);
        Ponto p38 = new Ponto(32.89281f, -15.589596f, -0.858417f);
        Ponto p39 = new Ponto(-32.89281f, -1.589602f, -0.85841f);
        Ponto p40 = new Ponto(-32.892807f, -15.589602f, -0.85839605f);
        Face f1 = new Face(p1,p2,p3,p4);
        Face f2 = new Face(p5,p8,p7,p6);
        Face f3 = new Face(p2,p6,p7,p3);
        Face f4 = new Face(p4,p8,p10,p9);
        Face f5 = new Face(p5,p1,p11,p12);
        Face f6 = new Face(p8,p5,p12,p10);
        Face f7 = new Face(p1,p4,p9,p11);
        Face f8 = new Face(p11,p9,p21,p22);
        Face f9 = new Face(p10,p12,p23,p24);
        Face f10 = new Face(p12,p11,p22,p23);
        Face f11 = new Face(p9,p10,p24,p21);
        Face f12 = new Face(p21,p24,p26,p25);
        Face f13 = new Face(p23,p22,p27,p28);
        Face f14 = new Face(p24,p23,p28,p26);
        Face f15 = new Face(p22,p21,p25,p27);
        Face f16 = new Face(p4,p29,p30,p8);
        Face f17 = new Face(p29,p17,p18,p30);
        Face f18 = new Face(p7,p31,p32,p3);
        Face f19 = new Face(p31,p20,p19,p32);
        Face f20 = new Face(p8,p30,p31,p7);
        Face f21 = new Face(p30,p18,p20,p31);
        Face f22 = new Face(p3,p32,p29,p4);
        Face f23 = new Face(p32,p19,p17,p29);
        Face f24 = new Face(p34,p1,p5,p33);
        Face f25 = new Face(p33,p14,p13,p34);
        Face f26 = new Face(p2,p35,p36,p6);
        Face f27 = new Face(p35,p15,p16,p36);
        Face f28 = new Face(p6,p36,p33,p5);
        Face f29 = new Face(p36,p16,p14,p33);
        Face f30 = new Face(p1,p34,p35,p2);
        Face f31 = new Face(p34,p13,p15,p35);
        Face f32 = new Face(p17,p19,p38,p37);
        Face f33 = new Face(p20,p18,p37,p38);
        Face f34 = new Face(p19,p20,p38);
        Face f35 = new Face(p18,p17,p37);
        Face f36 = new Face(p15,p13,p39,p40);
        Face f37 = new Face(p14,p16,p40,p39);
        Face f38 = new Face(p16,p15,p40);
        Face f39 = new Face(p13,p14,p39);
        Face f40 = new Face(p25,p26,p28,p27);
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
        addFace(f25);
        addFace(f26);
        addFace(f27);
        addFace(f28);
        addFace(f29);
        addFace(f30);
        addFace(f31);
        addFace(f32);
        addFace(f33);
        addFace(f34);
        addFace(f35);
        addFace(f36);
        addFace(f37);
        addFace(f38);
        addFace(f39);
        addFace(f40);

    }
    
    public void construirVelho() {
        Ponto p1 = new Ponto( 0,  0,  0);
        Ponto p2 = new Ponto(50,  0,  0);
        Ponto p3 = new Ponto(50, 50,  0);
        Ponto p4 = new Ponto(0,  50,  0);
        Ponto p5 = new Ponto( 0,  0, 50);
        Ponto p6 = new Ponto(50,  0, 50);
        Ponto p7 = new Ponto(50, 50, 50);
        Ponto p8 = new Ponto(0,  50, 50);
        
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
    
    private float rotacaoY = 0;
    private float rotacaoVoltaY = 0; 

    private float rotacaoX = 0;
    private float rotacaoVoltaX = 0;
    
    @Override
    public void atualizar() {
        //getRotacao().addZ(Tempo.getDelta() * 0.000000001f);
        
        if (Teclado.isKeyPressed(39)) {
            getTranslacao().addX(-Tempo.getDelta() * 0.0000003f);
            rotacaoY -= Tempo.getDelta() * 0.0000000005;
            getRotacao().setY(rotacaoY);
            rotacaoVoltaY = 0.000000001f;
        }
        else if (Teclado.isKeyPressed(37)) {
            getTranslacao().addX(Tempo.getDelta() * 0.0000003f);
            rotacaoY += Tempo.getDelta() * 0.0000000005;
            getRotacao().setY(rotacaoY);
            rotacaoVoltaY = -0.000000001f;
        }
        else {
            rotacaoY += Tempo.getDelta() * rotacaoVoltaY;
            if ((rotacaoY > 0 && rotacaoVoltaY > 0) || (rotacaoY < 0 && rotacaoVoltaY < 0)) {
                rotacaoY = 0;
            }
            else {
                getTranslacao().addX(Tempo.getDelta() * rotacaoVoltaY * -200);
            }
            getRotacao().setY(rotacaoY);
        }
        
        
        if (Teclado.isKeyPressed(38)) {
            getTranslacao().addZ(Tempo.getDelta() * 0.0000003f);
            rotacaoX += Tempo.getDelta() * 0.0000000005;
            getRotacao().setX(rotacaoX);
            rotacaoVoltaX = -0.000000001f;
        }
        else if (Teclado.isKeyPressed(40)) {
            getTranslacao().addZ(-Tempo.getDelta() * 0.0000003f);
            rotacaoX -= Tempo.getDelta() * 0.0000000005;
            getRotacao().setX(rotacaoX);
            rotacaoVoltaX = 0.000000001f;
        }
        else {
            rotacaoX += Tempo.getDelta() * rotacaoVoltaX;
            if ((rotacaoX > 0 && rotacaoVoltaX > 0) || (rotacaoX < 0 && rotacaoVoltaX < 0)) {
                rotacaoX = 0;
            } 
            else {
                getTranslacao().addZ(Tempo.getDelta() * rotacaoVoltaX * -300);
            }
            getRotacao().setX(rotacaoX);
        }

        if (Teclado.isKeyPressed(107)) {
            getTranslacao().addY(Tempo.getDelta() * 0.0000003f);
        }
        if (Teclado.isKeyPressed(109)) {
            getTranslacao().addY(-Tempo.getDelta() * 0.0000003f);
        }
        if (Teclado.isKeyPressed(32)) {
            Teclado.keyUp(32);
            Tiro tiro = new Tiro();
            tiro.getTranslacao().setX(getTranslacao().getX() + 0);
            tiro.getTranslacao().setY(getTranslacao().getY() + 0);
            tiro.getTranslacao().setZ(getTranslacao().getZ() + 0);
            getEspaco().addObjeto3D(tiro);
        }
        
        // Atualiza posicao da camera
        Camera camera = getEspaco().getCamera();
        if (cameraX == null) {
            cameraX = camera.getPosicao().getX();
            cameraZ = camera.getPosicao().getZ();
        }
        camera.getPosicao().setX(cameraX + (int) (getTranslacao().getX()/1.5));
        camera.getPosicao().setZ(cameraZ + (int) (getTranslacao().getZ()/1.5));

    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
        System.out.println("Nave acertou " + objetos.get(0).getEtiqueta() + " ...");
        
        boolean temInimigo = false;
        for (Objeto3D objeto : objetos) {
            if (objeto.getEtiqueta().equals("inimigo")) {
                temInimigo = true;
                break;
            }
        }
        if (!temInimigo) {
            return;
        }        
        
        // Explosao
        for (Face face : getFaces()) {
            Estilhaco estilhaco = new Estilhaco();
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
        Tempo.iniciarCronometro("nave atingida");
    }
    
}
