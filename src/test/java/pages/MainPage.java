package pages;

import com.codeborne.selenide.SelenideElement;
import data.Cities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends PageBase {


    private SelenideElement acceptCookieButton = $(".CookieNotify_button__axYux");
    public MainPage hideLocationConfirmationPopup(){
        topMenu.confirmPopupLocation();
        return this;
    }

    public MainPage acceptCookie(){
        acceptCookieButton.click();
        return this;
    }
    public MainPage hideAllBanners(){
        hideLocationConfirmationPopup().acceptCookie();
        return this;
    }
    public MainPage openPage(){
        open("/");
        return this;
    }

    public MainPage changeCity(Cities city){
        topMenu.changeCity(city);
        return this;
    }
    public MainPage checkCityChanged(Cities city){
        topMenu.checkCityChanged(city);
        return this;
    }
}
