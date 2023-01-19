import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*Automatizovati navodjenje na sajtu https://automationexercise.com.
Otici na pocetnu stranu, kliknuti na "Signup / Login", unesite u polja za "New User Signup!" pomocu faker-a - ime i email.
 Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i "Receive special offers from our partners!".
 Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.
*/public class Zadatak1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\ITBOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");

        WebElement signUpLogin = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLogin.click();

        Faker faker = new Faker();
        WebElement name = driver.findElement(By.name("name"));
        String name1 = faker.name().firstName();
        name.sendKeys(name1);

        //   WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //  webDriverWait.until(ExpectedConditions.elementToBeSelected(By.name("email")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        String email = faker.internet().emailAddress();
        emailAddress.sendKeys(email);

        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();

        WebElement password = driver.findElement(By.id("password"));
        String password1 = faker.internet().password();
        password.sendKeys(password1);

        WebElement firstName = driver.findElement(By.id("first_name"));
        String firstName1 = faker.name().firstName();
        firstName.sendKeys(firstName1);

        WebElement lastName = driver.findElement(By.id("last_name"));
        String lastName1 = faker.name().lastName();
        lastName.sendKeys(lastName1);

        WebElement address = driver.findElement(By.id("address1"));
        String address1 = faker.address().fullAddress();
        address.sendKeys(address1);

        WebElement state = driver.findElement(By.id("state"));
        String state1 = faker.address().state();
        state.sendKeys(state1);

        WebElement city = driver.findElement(By.id("city"));
        String city1 = faker.address().city();
        city.sendKeys(city1);

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        String zipCode1 = faker.address().zipCode();
        zipCode.sendKeys(zipCode1);

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        String mobileNumber1 = faker.phoneNumber().phoneNumber();
        mobileNumber.sendKeys(mobileNumber1);

        WebElement dayOfBirth = driver.findElement(By.id("days"));
        Select category = new Select(dayOfBirth);
        category.selectByValue("10");

        WebElement monthOfBirth = driver.findElement(By.id("months"));
        Select category1 = new Select(monthOfBirth);
        category1.selectByIndex(3);

        WebElement yearOfBirth = driver.findElement(By.id("years"));
        Select category2 = new Select(yearOfBirth);
        category2.selectByIndex(3);

        WebElement title = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[1]/div[2]/label"));
        title.click();

        WebElement field = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[7]/label"));
        field.click();

        WebElement country = driver.findElement(By.id("country"));
        Select category3 = new Select(country);
        category3.selectByVisibleText("Canada");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", " ");

        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));
        createAccount.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteButton.click();

        WebElement cont = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        cont.click();

        driver.quit();
    }
}
