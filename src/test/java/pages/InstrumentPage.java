package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class InstrumentPage extends PageBase{
    //select_genesis
   //         .catalog-instruments__item-brand
    private static SelenideElement typeFilter = $("#select_genesis"),
        firstElementBrand = $(".catalog-instruments__item-brand");

    public InstrumentPage openPage()
    {
        open("/catalogs/instrument/");
        return this;
    }

    public InstrumentPage setInstrumentType(String type){
        typeFilter.selectOption(type);
        return this;
    }

    public InstrumentPage checkBrandIsThere(String brand){
        firstElementBrand.shouldHave(text(brand));
        return this;
    }
}
