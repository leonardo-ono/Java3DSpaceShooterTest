package motor;

/**
 *
 * @author leonardo
 */
public abstract class Motor implements Runnable {

    private Tela tela;
    private Espaco espaco = new Espaco();

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }
    
    public void iniciar() {
        if (tela == null) {
            throw new RuntimeException("Tela não foi setado !");
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        int count = 0;
        int fps = 0;
        long time = System.currentTimeMillis();
        
        /*
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(System.getProperty("user.dir").replace("\\","/") + "/res/fundo.jpg"));
        } catch (IOException e) {
        }
         */
        
        while (true) {
            Tempo.setInicio(System.nanoTime());
            
            //Graphics b = getBufferStrategy().getDrawGraphics();
            
            //setBackground(Color.BLACK);
            //b.clearRect(0, 0, getWidth(), getHeight());
            //b.drawImage(img, 0, 0, null);
            tela.limpar();
            
            espaco.verificarColisoes();
            espaco.desenhar(tela);

            /*
            // Simula atraso de tempo aleatorio 
            try {
                long pausa = (long) (Math.random() * 10);
                Thread.sleep(pausa);
            } catch (InterruptedException ex) {
            }
            */ 

            count++;
            long tempoPassado = System.currentTimeMillis() - time;
            if (tempoPassado>=1000) {
               fps = count;
               time = System.currentTimeMillis();
               count = 0;
            }
            tela.setCor(new Cor(255, 255, 255));
            tela.desenhaString("FPS: " + fps, 50, 50);
            
            tela.exibir();
            
            Tempo.setFim(System.nanoTime());
        }
    }
    
}
