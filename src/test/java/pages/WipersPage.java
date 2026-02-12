package pages;

import static com.codeborne.selenide.Selenide.open;

public class WipersPage extends PageBase{
    public WipersPage openPage(){
        open("/catalogs/wipers/");
        return this;
    }
}
