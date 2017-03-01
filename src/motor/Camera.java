package motor;

/**
 *
 * @author leonardo
 */
public class Camera {

    private Ponto posicao = new Ponto(25, -300, 25);
    private Ponto alvo = new Ponto(25, 500, 25);

    private int width = 800;
    private int height = 600;
    
    public Ponto getPosicao() {
        return posicao;
    }

    public void setPosicao(Ponto posicao) {
        this.posicao = posicao;
    }

    public Ponto getAlvo() {
        return alvo;
    }

    public void setAlvo(Ponto alvo) {
        this.alvo = alvo;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
