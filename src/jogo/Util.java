package jogo;

import motor.Wavefront;

/**
 *
 * @author leonardo
 */
public class Util {

    public static void main(String[] args) {
        //Wavefront.converterEmCodigo(System.getProperty("user.dir").replace("\\","/") + "/res/nave.obj", 30);
        Wavefront.converterEmCodigo(System.getProperty("user.dir").replace("\\","/") + "/res/heroi.obj", 3f);
    }
    
}
