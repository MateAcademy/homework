package homework.home04012019;

public enum Type {
    STRAWBERRY("клубника"), APPLE("яблоко"), PEAR("груша"), CHERRY("вишня"), GRAPES("виноград"),
    CURRANT("смородина"), PEACH("персик");

    private String translations;

    Type() {
    }

    Type(String translations) {
        this.translations = translations;
    }

    public String getTranslations() {
        return  "Перевод на русский язык: " + translations;
    }


}
