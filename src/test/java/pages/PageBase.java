package pages;

import pages.components.TopMenuComponent;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PageBase {
    protected TopMenuComponent topMenu = new TopMenuComponent();
    protected ElementsCollection carCatalog = $$(".brands-catalog__letter");

    public PageBase openPage()
    {
        return this;
    }
    public PageBase checkCarBrands (List<String> carBrands){
        carCatalog.filter(visible).shouldHave(textsInAnyOrder(carBrands));
        return this;
    }
}
