public class LetterPrinter {
    private boolean isPrintedA=false;
    private boolean isPrintedB=false;
    private boolean isPrintedC=true;

    public synchronized void printA(){
        for (int i = 0; i < 5; i++) {
            while (!isPrintedC) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            isPrintedA = true;
            isPrintedB = false;
            isPrintedC = false;
            notifyAll();
        }
    }
    public synchronized void printB(){
        for (int i = 0; i < 5; i++) {
            while (!isPrintedA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            isPrintedB = true;
            isPrintedA = false;
            isPrintedC = false;
            notifyAll();
        }

    }
    public synchronized void printC(){
        for (int i = 0; i < 5; i++) {
            while (!isPrintedB) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            isPrintedC = true;
            isPrintedA = false;
            isPrintedB = false;
            notifyAll();
        }
    }

}
