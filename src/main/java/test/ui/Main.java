package test.ui;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Ui ui = new Ui();
        ui.startDriver()
                .openRegForm()
                .testRegFormWrong();

        Thread.sleep(5000);

        //ui.testRegFormGood();
        //Thread.sleep(5000);
    }
}