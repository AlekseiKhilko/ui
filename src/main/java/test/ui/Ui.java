package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Ui {
        public WebDriver driver;

        public Ui startDriver(){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            return this;
        }

        public void closeDriver(){
            driver.close();
        }

        public Ui openRegForm(){
            final String URL = "http://users.bugred.ru/user/login/index.html";
            this.driver.get(URL);

            return this;
        }

        public Ui testRegFormGood(){

            typeRegForm("Иван", "my@email.com", "MyPass123");
            submitRegForm();

            return this;
        }

        public Ui testRegFormWrong(){

            typeRegForm("Iv", "1", "234");
            submitRegForm();

            return this;
        }

        public Ui typeRegForm(String name, String email, String password){
            String xPathForm = "//form[@action='/user/register/index.html']";
            String xPathRegText = "//h2[text()='Регистрация']";
            String xPathInputName = "//input[@name='name']";
            String xPathInputEmail = "//input[@name='email']";
            String xPathInputPassword = "//form[@action='/user/register/index.html']//input[@type='password']";
            //String xPathErrorText = "//form/p[1]";

            WebElement elementForm = driver.findElement(By.xpath(xPathForm));
            WebElement elementInputName = elementForm.findElement(By.xpath(xPathInputName));
            WebElement elementInputEmail = elementForm.findElement(By.xpath(xPathInputEmail));
            WebElement elementInputPassword = driver.findElement(By.xpath(xPathInputPassword));
            //WebElement elementErrorText = driver.findElement(By.xpath(xPathErrorText));

            elementInputName.sendKeys(name);
            elementInputEmail.sendKeys(email);
            elementInputPassword.sendKeys(password);

            //System.out.println(elementErrorText.getText());

            return this;
        }

        public Ui typeLoginForm(String login, String password){
            String xPathForm = "//form[@action='/user/login/index.html']";
            String xPathRegText = "//h2[text()='Вход']";
            String xPathInputLogin = "//input[@name='login']";
            String xPathInputPassword = "//input[@type='password']";

            WebElement elementForm = driver.findElement(By.xpath(xPathForm));
            WebElement elementInputLogin = elementForm.findElement(By.xpath(xPathInputLogin));
            WebElement elementInputPassword = elementForm.findElement(By.xpath(xPathInputPassword));

            elementInputLogin.sendKeys(login);
            elementInputPassword.sendKeys(password);

            return this;
        }

        public Ui testLoginFormGood(){

            typeLoginForm("my@email.com", "MyPass123");
            submitLoginForm();

            return this;
        }

        public Ui testLoginFormWrong(){

            typeLoginForm("myail.com", "MyPass123");
            submitLoginForm();

            return this;
        }

        public Ui submitLoginForm(){
            String xPathInputSubmit = "//input[@value='Авторизоваться']";
            WebElement element = driver.findElement(By.xpath(xPathInputSubmit));
            element.click();

            return this;
        }

        public Ui submitRegForm(){
            String xPathInputSubmit = "//input[@name='act_register_now']";
            WebElement element = driver.findElement(By.xpath(xPathInputSubmit));
            element.click();

            return this;
        }
    }
