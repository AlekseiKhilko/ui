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

        public void clouseDriver(){
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
            String xPathErrorText = "//form/p[contains(text(), 'Неправильное значение поля')]";

            WebElement elementForm = driver.findElement(By.xpath(xPathForm));
            WebElement elementInputName = elementForm.findElement(By.xpath(xPathInputName));
            WebElement elementInputEmail = elementForm.findElement(By.xpath(xPathInputEmail));
            WebElement elementInputPassword = driver.findElement(By.xpath(xPathInputPassword));
            WebElement elementErrorText = driver.findElement(By.xpath(xPathErrorText));

            elementInputName.sendKeys(name);
            elementInputEmail.sendKeys(email);
            elementInputPassword.sendKeys(password);

            System.out.println(elementErrorText.getText());

            return this;
        }

        public Ui submitRegForm(){
            String xPathInputSubmit = "//input[@name='act_register_now']";
            WebElement element = driver.findElement(By.xpath(xPathInputSubmit));
            element.click();

            return this;
        }
    }
