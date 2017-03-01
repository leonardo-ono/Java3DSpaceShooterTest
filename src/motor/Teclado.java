/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

/**
 *
 * @author leonardo
 */
public class Teclado {

    private static boolean[] teclas = new boolean[255];

    public static void keyDown(int keyCode) {
        teclas[keyCode] = true;
    }

    public static void keyUp(int keyCode) {
        teclas[keyCode] = false;
    }
    
    public static boolean isKeyPressed(int keyCode) {
        return teclas[keyCode];
    }
    
}
