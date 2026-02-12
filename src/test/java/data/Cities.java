package data;

public enum Cities {
    ROSTOV("Ростовская обл., Ростов-на-Дону"), KRASNODAR("Краснодарский край, Краснодар"),
    VOLGOGRAD("Волгоградская обл., Волгоград"), STAVROPOL("Ставропольский край, Ставрополь");

    public final String fullName;
    Cities (String fullName) {
        this.fullName = fullName;
    }
}
