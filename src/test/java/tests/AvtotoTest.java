package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import data.Cities;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Параметризированные тесты для Автото")
public class AvtotoTest extends TestBase {

    @EnumSource(Cities.class)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка доступности городов")
    void checkAvailableCities(Cities city) {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .hideAllBanners()
                .changeCity(city);

        mainPage.checkCityChanged(city);

    }

    @CsvSource(value = {
            "Динамометрический инструмент| Berger",
            "Инструмент, разное| Alca",
            "Ключи баллонные | Alca",
            "Ключи гаечные | Ate",
            "Ключи свечные | Jonnesway",
            "Ножницы, щипцы, кусачки | Alca"
    }, delimiter = '|')
    @ParameterizedTest(name="Проверка типа инструмента {0}")
    @DisplayName("Проверка отображения производителя инструментов по фильтру типа инструмента")
    void checkInstrumentFilter(String type, String producer){
        InstrumentPage instrumentPage = new InstrumentPage();
        instrumentPage.openPage()
                .acceptCookie()
                .setInstrumentType(type);

        instrumentPage.checkBrandIsThere(producer);

        //без sleep срабатывает бан запросов по IP против DDoS
        //sleep(2000);
    }

    static Stream<Arguments> carCatalogShouldBeOnEachPage(){
        return Stream.of(
                Arguments.of(
                        new TOPage(),
                        List.of("Acura", "Alfa Romeo", "Audi", "Baic", "Belgee", "Bentley", "BMW", "Brilliance", "Buick", "BYD", "Cadillac", "Changan", "Chery", "Chevrolet", "Chrysler", "Citroen", "Daewoo", "Daihatsu", "Datsun", "Dodge", "Dongfeng", "Evolute", "Exeed", "FAW", "Fiat", "Ford", "Ford USA", "Foton", "Gac", "Geely", "Genesis", "Great Wall", "Hafei", "Haima", "Haval", "Hawtai", "Honda", "Hongqi", "Hummer", "Hyundai", "Infiniti", "Isuzu", "JAC", "Jaecoo", "Jaguar", "Jeep", "Jetour", "Jetta", "Kaiyi", "Kia", "Land Rover", "Lexus", "Li", "Lifan", "Lincoln", "Livan", "Luxgen", "Mazda", "Mercedes", "Mercury", "MINI", "Mitsubishi", "Nissan", "Omoda", "Opel", "Peugeot", "Pontiac", "Porsche", "Ravon", "Renault", "Rover", "Saab", "Saturn", "Scion", "Seat", "Skoda", "Smart", "Sollers", "Ssangyong", "Subaru", "Suzuki", "Tank", "Toyota", "Volkswagen", "Volvo", "Vortex", "Voyah", "Wey", "Xcite", "Zeekr", "Zotye", "ВАЗ", "ГАЗ", "ЗАЗ", "Москвич", "ТагАЗ", "УАЗ")
                ),
                Arguments.of(
                        new WipersPage(),
                        List.of("Acura", "Alfa Romeo", "Audi", "Bentley", "BMW", "Cadillac", "Chevrolet", "Chrysler", "Citroen", "Daewoo", "DAF", "Datsun", "Dodge", "Fiat", "Ford", "Geely", "Great Wall", "Hino", "Honda", "Hummer", "Hyundai", "Infiniti", "ISUZU", "IVECO", "Jaguar", "Jeep", "Kia", "LADA (ВАЗ)", "Land Rover", "Lexus", "MAN", "Mazda", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Saab", "Scania", "SEAT", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Toyota", "Volkswagen", "Volvo", "ГАЗ", "ЗИЛ", "КамАЗ", "УАЗ")
                )
        );
    }
    @MethodSource
    @ParameterizedTest(name="для страницы {0}")
    @DisplayName("Проверка наличия каталога автомобилей")
    void carCatalogShouldBeOnEachPage(PageBase page, List<String> carBrands){
        page.openPage()
                .acceptCookies();

        page.checkCarBrands(carBrands);
        //обход бана по айпи за слишком частые запросы
        //sleep(2000);
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }
}
