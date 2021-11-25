public class Main {
    public static void main(String[] args) {
        LetterPrinter letterPrinter = new LetterPrinter();
        new Thread(()->letterPrinter.printA()).start();
        new Thread(()->letterPrinter.printB()).start();
        new Thread(()->letterPrinter.printC()).start();
    }
}
