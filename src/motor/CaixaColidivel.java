package motor;

/**
 *
 * @author leonardo
 */
public class CaixaColidivel implements Colidivel {

    private Ponto a = new Ponto(0, 0, 0);
    private Ponto b = new Ponto(0, 0, 0);
    private Ponto translacao = new Ponto(0, 0, 0);
    
    public Ponto getA() {
        return a;
    }

    public void setA(Ponto a) {
        this.a = a;
    }

    public Ponto getB() {
        return b;
    }

    public void setB(Ponto b) {
        this.b = b;
    }

    public Ponto getTranslacao() {
        return translacao;
    }

    @Override
    public void setTranslacao(Ponto translacao) {
        this.translacao = translacao;
    }
    
    @Override
    public boolean colide(Colidivel colidivel) {
        CaixaColidivel colisor = (CaixaColidivel) colidivel;
        
        float ax = a.getX() + translacao.getX();
        float ay = a.getY() + translacao.getY();
        float az = a.getZ() + translacao.getZ();

        float bx = b.getX() + translacao.getX();
        float by = b.getY() + translacao.getY();
        float bz = b.getZ() + translacao.getZ();

        float cax = colisor.a.getX() + colisor.translacao.getX();
        float cay = colisor.a.getY() + colisor.translacao.getY();
        float caz = colisor.a.getZ() + colisor.translacao.getZ();

        float cbx = colisor.b.getX() + colisor.translacao.getX();
        float cby = colisor.b.getY() + colisor.translacao.getY();
        float cbz = colisor.b.getZ() + colisor.translacao.getZ();
    
        Retangulo r1 = new Retangulo((int) ax, (int) ay, (int)(bx-ax), (int) (by-ay));
        Retangulo r2 = new Retangulo((int) ay, (int) az, (int)(by-ay), (int) (bz-az));
        
        boolean v1 = r1.contem(cax, cay) && r2.contem(cay, caz);
        boolean v2 = r1.contem(cax, cay) && r2.contem(cay, cbz);

        boolean v3 = r1.contem(cax, cby) && r2.contem(cby, caz);
        boolean v4 = r1.contem(cax, cby) && r2.contem(cby, cbz);

        boolean v5 = r1.contem(cbx, cby) && r2.contem(cby, caz);
        boolean v6 = r1.contem(cbx, cby) && r2.contem(cby, cbz);

        boolean v7 = r1.contem(cbx, cay) && r2.contem(cay, caz);
        boolean v8 = r1.contem(cbx, cay) && r2.contem(cay, cbz);
        
        boolean colidiu = v1 || v2 || v3 || v4 || v5 || v6 || v7 || v8;
        return colidiu;
    }
    
    // Implementado para Android
    private class Retangulo {
        int ax;
        int ay;
        int wx;
        int wy;

        public Retangulo(int ax, int ay, int wx, int wy) {
            this.ax = ax;
            this.ay = ay;
            this.wx = wx;
            this.wy = wy;
        }
        
        boolean contem(double x, double y) {
            return (x>=ax && x<=(ax + wx) && y>=ay && y<=(ay + wy));
        }
    }
    
}
