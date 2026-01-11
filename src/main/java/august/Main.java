package august;


public class Main {
    public static void main(String[] args) {
        System.out.println("|||||||| STARTING ||||||||");
        Sim sim = new Sim();
        Thread simThread = new Thread(sim);
        simThread.start();
    }
}