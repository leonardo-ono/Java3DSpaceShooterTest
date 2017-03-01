package motor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leonardo
 */
public class Tempo {

    private static long inicio;
    private static long fim;
    private static long delta;
    private static Map<String, Long> cronometros = new HashMap<String, Long>();

    public static long getInicio() {
        return inicio;
    }

    public static void setInicio(long inicio) {
        Tempo.inicio = inicio;
    }

    public static long getFim() {
        return fim;
    }

    public static void setFim(long fim) {
        Tempo.fim = fim;
        delta = fim - inicio;
    }

    public static long getDelta() {
        return delta;
    }
    
    public static void iniciarCronometro(String chave) {
        cronometros.put(chave, System.currentTimeMillis());
    }

    public static void paraCronometro(String chave) {
        cronometros.remove(chave);
    }
    
    public static long obterCronometro(String chave) {
        Long tempo = cronometros.get(chave);
        if (tempo == null) {
            return -1;
        }
        tempo = System.currentTimeMillis() - tempo;
        return tempo;
    }
    
}
