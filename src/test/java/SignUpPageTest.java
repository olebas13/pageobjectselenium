import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest() {
        SignUpPage sp = signUpPage.typePassword("123");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one lowercase letter", error);
    }

    @Test
    public void signUpReservedUsernameTest() {
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void signUpTakenUsernameTest() {
        SignUpPage sp = signUpPage.typeUserName("user");
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void getHeadingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
