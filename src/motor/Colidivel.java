package motor;

/**
 *
 * @author leonardo
 */
public interface Colidivel {
    
    public abstract void setTranslacao(Ponto ponto);
    public abstract boolean colide(Colidivel colidivel);
    
}
