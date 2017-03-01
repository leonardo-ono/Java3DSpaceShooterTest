package motor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leo
 */
public class Wavefront {

    public static void carregar(String arquivo, Objeto3D objeto, float escala) {
        List<Ponto> pontos = new ArrayList<Ponto>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                if (linha.toLowerCase().startsWith("v")) {
                    String[] ps = linha.split("\\ ");
                    float x = -Float.valueOf(ps[1]) * escala;
                    float z = Float.valueOf(ps[2]) * escala;
                    float y = -Float.valueOf(ps[3]) * escala;
                    Ponto p = new Ponto(x, y, z);
                    pontos.add(p);
                }
                else if (linha.toLowerCase().startsWith("f")) {
                    String[] fs = linha.split("\\ ");
                    Face face = new Face();
                    for (int i=1; i<fs.length; i++) {
                        int index = Integer.valueOf(fs[i]) - 1;
                        Ponto ponto = pontos.get(index);
                        face.getPontos().add(ponto);
                    }
                    objeto.addFace(face);
                }
            }
            br.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void converterEmCodigo(String arquivo, float escala) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            int pi = 0;
            int fi = 0;
            while ((linha = br.readLine()) != null) {
                //System.out.println(linha);
                if (linha.toLowerCase().startsWith("v")) {
                    String[] ps = linha.split("\\ ");
                    float x = -Float.valueOf(ps[1]) * escala;
                    float z = Float.valueOf(ps[2]) * escala;
                    float y = -Float.valueOf(ps[3]) * escala;
                    System.out.println("Ponto p" + (++pi) + " = new Ponto(" + x + "f, " + y + "f, " + z + "f);");
                }
                else if (linha.toLowerCase().startsWith("f")) {
                    String[] fs = linha.split("\\ ");
                    System.out.print("Face f" + (++fi) + " = new Face(");
                    for (int i=1; i<fs.length; i++) {
                        int index = Integer.valueOf(fs[i]);
                        System.out.print("p" + index + "" + (i == (fs.length-1) ? "" : ","));
                    }
                    System.out.println(");");
                }
            }
            br.close();
            for (int i=1; i<=fi; i++) {
                System.out.println("addFace(f" + i + ");");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
