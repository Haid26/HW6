package tests;

import pages.MainPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://avtoto.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

}
