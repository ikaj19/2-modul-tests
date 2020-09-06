import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    //Задание 2 модуль 2

    @Test
    public void testHelloVasya() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    //Задание 3 модуль 2

    @Test
    public void testwithouttext() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    //Задание 4 модуль 2

    @Test
    public void Should_BeHello_When_placesIsFilled() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Кирилл");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("phone")).sendKeys("89161234567");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Кирилл.\n" +
                "На вашу почту (test@test.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89161234567.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void Should_BeHello_When_placeEmailIsNull() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Кирилл");
        driver.findElement(By.name("phone")).sendKeys("89161234567");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Кирилл.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89161234567.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void Should_BeHello_When_placeNameIsNull() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("phone")).sendKeys("89161234567");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (test@test.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89161234567.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void Should_BeHello_When_AllPlacesIsNull() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void Should_BeHello_When_AllPlacesWithIncorrectData() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("12345");
        driver.findElement(By.name("email")).sendKeys("test");
        driver.findElement(By.name("phone")).sendKeys("wrong_phone");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, 12345.\n" +
                "На вашу почту (test) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: wrong_phone.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }


}
