package test.ui;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Ui ui = new Ui();

        //test reg form wrong
        ui.startDriver()
                .openRegForm()
                .testRegFormWrong();

        //sleep
        Thread.sleep(5000);

        //test reg form good
        ui.openRegForm()
                .testRegFormGood();

        //sleep
        Thread.sleep(5000);

        ui.closeDriver();

        //--------

        //test login form wrong
        ui.startDriver()
                .openRegForm()
                .testLoginFormWrong();

        //sleep
        Thread.sleep(5000);

        //test login form good
        ui.testLoginFormGood()
                .closeDriver();

    }
}