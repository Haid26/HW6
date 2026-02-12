package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Cities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TopMenuComponent {
    private static ElementsCollection topmenu = $$(".TopMenu_topMenu__link__1dvV8"),
            citiesList = $$(".StepCity_cityBtn__E7sMN");
    private static SelenideElement locationPopupConfirmation = $(".LocationPopup_buttons__rjUZO").$(byText("Да, верно")),
    selectedCityInPopupCityChange = $(".FilledFields_value___4C3j");

    public void confirmPopupLocation(){
        locationPopupConfirmation.click();
    }

    public void changeCity(Cities city){
        topmenu.get(0).click();
        citiesList.findBy(text(city.fullName)).click();
    }

    public void checkCityChanged(Cities city){
        selectedCityInPopupCityChange.shouldHave(text(city.fullName));
    }
}
