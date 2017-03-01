package jogo;

import java.util.List;
import motor.Objeto3D;
import motor.Tempo;

/**
 *
 * @author leo
 */
public class Estilhaco extends Objeto3D {

    float x = (float) (Math.random() * 0.000000005f);
    float y = (float) (Math.random() * 0.000000005f);
    float z = (float) (Math.random() * 0.000000005f);

    float xt = (float) (Math.random() * 0.0000002f - 0.0000001f);
    float zt = (float) (Math.random() * 0.0000002f - 0.0000001f);
    
    @Override
    public void atualizar() {
        getRotacao().addX(Tempo.getDelta() * x);
        getRotacao().addY(Tempo.getDelta() * y);
        getRotacao().addZ(Tempo.getDelta() * z);
        getTranslacao().addY(Tempo.getDelta() * -0.0000001f);
        getTranslacao().addX(Tempo.getDelta() * xt);
        getTranslacao().addZ(Tempo.getDelta() * zt);
        
        if (getTranslacao().getY() < -200) {
            getEspaco().removeObjeto3D(this);
        }
    }

    @Override
    public String getEtiqueta() {
        return "estilhaco";
    }

    @Override
    public void construir() {
    }

    @Override
    public void colidiu(List<Objeto3D> objetos) {
    }
    
}
