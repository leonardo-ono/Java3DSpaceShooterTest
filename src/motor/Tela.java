package motor;

import motor.Cor;

/**
 *
 * @author leonardo
 */
public interface Tela {
    
    public abstract void setCor(Cor cor);
    public abstract void desenharLinha(int x1, int y1, int x2, int y2);
    public abstract void desenhaString(String string, int x, int y);

    public void limpar();

    public void exibir();
    
}
