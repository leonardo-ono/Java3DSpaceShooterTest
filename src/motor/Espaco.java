package motor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Espaco {

    private Camera camera = new Camera();
    private List<Objeto3D> objetos = Collections.synchronizedList(new ArrayList<Objeto3D>());
    private List<Objeto3D> objetosAdicionar = Collections.synchronizedList(new ArrayList<Objeto3D>());
    private List<Objeto3D> objetosRemover = Collections.synchronizedList(new ArrayList<Objeto3D>());
    
    public void addObjeto3D(Objeto3D objeto) {
        objeto.setEspaco(this);
        objetosAdicionar.add(objeto);
    }

    public void removeObjeto3D(Objeto3D objeto) {
        objetosRemover.add(objeto);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void desenhar(Tela g) {
        Iterator<Objeto3D> i = objetos.iterator();
        while (i.hasNext()) {
            Objeto3D objeto = i.next();
            objeto.atualizar();
            objeto.desenhar(g, camera);
        }
        
        objetos.addAll(objetosAdicionar);
        objetosAdicionar.clear();
        
        objetos.removeAll(objetosRemover);
        objetosAdicionar.clear();
    }

    public void verificarColisoes() {
        Iterator<Objeto3D> i = objetos.iterator();
        while (i.hasNext()) {
            List<Objeto3D> objetosColididos = new ArrayList<Objeto3D>();
            Objeto3D objeto = i.next();
            
            if (objeto.getColidivel() == null) {
                continue;
            }
            
            Iterator<Objeto3D> i2 = objetos.iterator();
            while (i2.hasNext()) {
                Objeto3D objeto2 = i2.next();
                
                if (objeto2.getColidivel() == null || objeto == objeto2) {
                    continue;
                }
                
                if (objeto.getColidivel().colide(objeto2.getColidivel())) {
                    objetosColididos.add(objeto2);
                }
            }
            
            if (!objetosColididos.isEmpty()) {
                objeto.colidiu(objetosColididos);
            }
        }
    }

}
