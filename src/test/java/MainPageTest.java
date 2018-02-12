import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
<<<<<<< HEAD
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
=======
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
>>>>>>> origin/master
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
<<<<<<< HEAD
    public void SignInTest() {
=======
    public void signInTest() {
>>>>>>> origin/master
        LoginPage loginPage = mainPage.clickSignInButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
<<<<<<< HEAD
        SignUpPage signUpPage = mainPage.register("wefrwef", "CEIJF", "wefnwiefn");
=======
        SignUpPage signUpPage = mainPage.register("testuser", "testmail", "testpass");
>>>>>>> origin/master
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest() {
<<<<<<< HEAD
        SignUpPage signUpPage = mainPage.register("", "mail@mail.com", "olebasfcdk14881927");
=======
        SignUpPage signUpPage = mainPage.register("", "testmail", "testpass");
>>>>>>> origin/master
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest() {
<<<<<<< HEAD
        SignUpPage signUpPage = mainPage.register("Olebas13", "cnskd,c,", "olebasfcdk123322");
=======
        SignUpPage signUpPage = mainPage.register("test", "wefyyw121", "testpass");
>>>>>>> origin/master
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
