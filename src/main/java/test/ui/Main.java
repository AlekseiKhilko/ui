package test.ui;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Ui ui = new Ui();

        ui.startDriver()
                .openRegForm()
                .testRegFormWrong();

        Thread.sleep(5000);

        ui.openRegForm()
                .testRegFormGood();

        Thread.sleep(5000);
        ui.closeDriver();


        //--------

        ui.startDriver()
                .openRegForm()
                .testLoginFormWrong();

        Thread.sleep(5000);

        ui.testLoginFormGood()
                .closeDriver();


    }
}