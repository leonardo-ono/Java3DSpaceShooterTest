package motor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author leonardo
 */
public abstract class Objeto3D {

    private Espaco espaco;
    
    private Ponto translacao = new Ponto(0, 0, 0);
    private Ponto rotacao = new Ponto(0.01f, 0.01f, 0.01f);
    private Ponto escala = new Ponto(0, 0, 0);
    
    private List<Face> faces = new ArrayList<Face>();
    
    private Colidivel colidivel;
    
    private Cor cor = new Cor(255, 255, 255); // branco
    
    public Objeto3D(Face ... fs) {
        faces.addAll(Arrays.asList(fs));
        construir();
    }

    public List<Face> getFaces() {
        return faces;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Ponto getTranslacao() {
        return translacao;
    }

    public void setTranslacao(Ponto translacao) {
        this.translacao = translacao;
    }

    public Ponto getRotacao() {
        return rotacao;
    }

    public void setRotacao(Ponto rotacao) {
        this.rotacao = rotacao;
    }

    public Ponto getEscala() {
        return escala;
    }

    public void setEscala(Ponto escala) {
        this.escala = escala;
    }
    
    public Colidivel getColidivel() {
        return colidivel;
    }

    public void setColidivel(Colidivel colidivel) {
        colidivel.setTranslacao(translacao);
        this.colidivel = colidivel;
    }
    
    public void addFace(Face face) {
        face.setObjeto3D(this);
        faces.add(face);
    }

    public void removeFace(Face face) {
        face.setObjeto3D(null);
        faces.remove(face);
    }
    
    public void desenhar(Tela g, Camera camera) {
        for (Face face : faces) {
            face.desenhar(g, camera, translacao, rotacao, escala);
        }
    }
    
    // para cada atualizacao
    public abstract void atualizar();
    
    // serve como id para o objeto 3D
    public abstract String getEtiqueta();

    // invocado para construir
    public abstract void construir();

    // invocado quando um objeto 3D colide com outro
    public abstract void colidiu(List<Objeto3D> objetos);
    
}
