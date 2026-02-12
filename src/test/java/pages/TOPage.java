package pages;

import static com.codeborne.selenide.Selenide.open;

public class TOPage extends PageBase{

    public TOPage openPage(){
        open("/catalogs_to.html");
        return this;
    }
}
