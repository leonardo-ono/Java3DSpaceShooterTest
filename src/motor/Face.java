package motor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Face {
    
    private Objeto3D objeto3D;
    private List<Ponto> pontos = new ArrayList<Ponto>();

    public Face(Ponto ... p) {
        pontos.addAll(Arrays.asList(p));
    }

    public Objeto3D getObjeto3D() {
        return objeto3D;
    }

    public void setObjeto3D(Objeto3D objeto3D) {
        this.objeto3D = objeto3D;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public void desenhar(Tela g, Camera camera, Ponto translacao, Ponto rotacao, Ponto escala) {
        float xc = camera.getPosicao().getX();
        float yc = camera.getPosicao().getY();
        float zc = camera.getPosicao().getZ();
        
        float ys = camera.getAlvo().getY();
        
        Polygon polygon = new Polygon();
        
        for (Ponto p : pontos) {
            double xp = p.getX() + 0.000000001;
            double yp = p.getY() + 0.000000001;
            double zp = p.getZ() + 0.000000001;
            
            double hipotenusa = 0;
            double a = 0;

            // rotacao em Z
            hipotenusa = Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2));
            a = Math.atan(xp / yp);
            a -= rotacao.getZ();
            yp = (float) (hipotenusa * Math.cos(a));
            xp = (float) (hipotenusa * Math.sin(a));
            if (p.getY()<0) {
                yp = -yp;
                xp = -xp;
            }
            
            // rotacao em x
            hipotenusa = Math.sqrt(Math.pow(yp, 2) + Math.pow(zp, 2));
            a = Math.atan(yp / zp);
            a -= rotacao.getX();
            zp = (float) (hipotenusa * Math.cos(a));
            yp = (float) (hipotenusa * Math.sin(a));
            if (p.getZ()<0) {
                zp = -zp;
                yp = -yp;
            }
            
            // rotacao em y
            double zpg = zp;
            hipotenusa = Math.sqrt(Math.pow(xp, 2) + Math.pow(zp, 2));
            a = Math.atan(xp / zp);
            a -= rotacao.getY();
            zp = (float) (hipotenusa * Math.cos(a));
            xp = (float) (hipotenusa * Math.sin(a));
            if (zpg<0) {
                zp = -zp;
                xp = -xp;
            }

            // Translacao
            xp += translacao.getX();
            yp += translacao.getY();
            zp += translacao.getZ();
            
            float xv = (float) ((yc - ys) * (xc - xp) / (yc - yp));
            float zv = (float) ((yc - ys) * (zc - zp) / (yc - yp));
            
            xv += (camera.getWidth() / 2);
            zv += (camera.getHeight() / 2);

            polygon.addPoint((int) xv, (int) zv);
        }
        g.setCor(new Cor(255, 255, 255)); // branco
        if (objeto3D != null) {
            g.setCor(objeto3D.getCor());
        }
        drawPolygon(g, polygon);
        
    }

    private class PolygonPoint {
        int x;
        int y;
        public PolygonPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private class Polygon {
        int x;
        int y;
        List<PolygonPoint> pontos = new ArrayList<PolygonPoint>();
        public void addPoint(int x, int y) {
            pontos.add(new PolygonPoint(x, y));
        }
    }
    
    private void drawPolygon(Tela tela, Polygon polygon) {
        PolygonPoint pontoInicial = polygon.pontos.get(0);
        PolygonPoint pontoFinal = null;
        for (int i=1; i<polygon.pontos.size(); i++) {
            pontoFinal = polygon.pontos.get(i);
            if (objeto3D != null) {
                tela.setCor(objeto3D.getCor());
            }
            tela.desenharLinha(pontoInicial.x, pontoInicial.y, pontoFinal.x, pontoFinal.y);
            pontoInicial = pontoFinal;
        }
        pontoFinal = polygon.pontos.get(0);
        tela.desenharLinha(pontoInicial.x, pontoInicial.y, pontoFinal.x, pontoFinal.y);
    }
    
}
