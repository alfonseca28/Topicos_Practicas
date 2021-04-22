package Hilos;

/**
 *
 * @author Aarón Alfonseca
 */
public class SimpleThreads {

    // Se muestra un mensaje, precediendo por el nombre del hilo actual 
    static void threadMessage(String message) {
        String threadName
                = Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoop
            implements Runnable {

        public void run() {
            String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                        i < importantInfo.length;
                        i++) {
                    // Descanso por 4 seg
                    Thread.sleep(4000);
                    // Impresion en consola
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        //Aqui se hace un retraso, en milisegundos antes de que se interrumpa el hilo MessageLoop (predeterminado una hora). 
        long patience = 1000 * 60 * 60;

        // Si el argumento de la línea de comando está presente, queda esperar los segundos. 
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
