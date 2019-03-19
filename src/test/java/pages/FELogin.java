package pages;

import assertion.Asserts;
import bases.BasePage;
import elements.controllerImpl.Button;
import elements.controllerImpl.Element;
import elements.controllerImpl.TextBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


import  static utilities.TestUtils.*;

public class FELogin extends BasePage {

    private Logger log = LogManager.getLogger(FELogin.class);

    private final By txtUername = By.name("username");
    private final By txtPassword = By.name("password");
    private final By btnLogin = By.xpath("//*[@id='loginfrm']/button");
    private String url = "https://www.phptravels.net/";
    private final By ddlMyAccount = By.xpath("//div[contains(@class,'collapse navbar-collapse')]/ul[contains(@class,'nav navbar-nav navbar-right hidden-sm go-left')]//li[@id='li_myaccount']");
    private final By lblLogin = By.xpath("//div[contains(@class,'collapse navbar-collapse')]/ul[contains(@class,'nav navbar-nav navbar-right hidden-sm go-left')]//li[@id='li_myaccount']/ul/li[1]");
    private final By lblUserNameMainPage = By.xpath("//div[@id='body-section']//div[contains(@class,'container')]/div[contains(@class,'row')]/div/h3");
    private final By lblCurrentDate = By.xpath("//div[contains(@class,'col-md-6 go-left RTL')]//span");
    private final String strLblLeftMenuMainPage = "//div[contains(@class,'col-md-1 offset-0')]/ul[contains(@class,'nav profile-tabs')]/li[%]";

    public void enterUserName(String userName) {
        getElement(TextBox.class, txtUername).clearAndSetText(userName);
    }

    public void enterPassWord(String pass) {
        getElement(TextBox.class, txtPassword).clearAndSetText(pass);
    }

    public void clickToMainPage() {
        getElement(Button.class, btnLogin).clickAndWait();
    }

    public void openLoginPage() {

        landingHomePage();
        getElement(Element.class, ddlMyAccount).click();
        getElement(Element.class, lblLogin).click();

    }


    public void landingHomePage()
    {
        openPage(url);
    }
    public void verifyMainPage(){

        String bookings = getElement(Element.class,getXpath(strLblLeftMenuMainPage,"1")).getText().trim();
        String myProfile = getElement(Element.class,getXpath(strLblLeftMenuMainPage,"2")).getText().trim();
        String wishList = getElement(Element.class,getXpath(strLblLeftMenuMainPage,"3")).getText().trim();
        String newsLetter = getElement(Element.class,getXpath(strLblLeftMenuMainPage,"4")).getText().trim();

        Asserts.verifyEquals(getElement(Element.class, lblUserNameMainPage).getText(), "Hi, Johny Smith");
        Asserts.verifyEquals(getElement(Element.class, lblCurrentDate).getText(),getCurrentDate("d MMMMM yyyy"));

        Asserts.verifyEquals(bookings,"Bookings");
        Asserts.verifyEquals(myProfile,"My Profile");
        Asserts.verifyEquals(wishList,"Wishlist");
        Asserts.verifyEquals(newsLetter,"Newsletter");

        Asserts.verifyAll();

    }

    public void verifLoginPage() {

        Asserts.verifyEquals(getTitle(), "Login");
        Asserts.verifyEquals(getCurrentURL(), "https://www.phptravels.net/login");

        Asserts.verifyAll();
    }
}
