package mainPackage;

public class PritnUserMenu {
    public static void mainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню: \n");
        stringBuilder.append("1 - Получить информацию из базы\n");
        stringBuilder.append("2 - Добавить информацию \n");
        stringBuilder.append("3 - Удалить информацию \n");
        stringBuilder.append("4 - Изменить информацию \n");
        stringBuilder.append("5 - Экспортировать данные в XML\n");
        stringBuilder.append("6 - Выход\n");
        System.out.println(stringBuilder);
    }

    public static void menu_1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("По какой базе получить инфо: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    public static void menu_2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию добавить: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    public static void menu_3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию удалить: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    public static void menu_4() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию модифицировать: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    public static void standartFormatDate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дата и время проведения осмотра в формате \n");
        stringBuilder.append("1 - Год (Пример ГГГГ)\n");
        stringBuilder.append("2 - Месяц (Пример Январь)\n");
        stringBuilder.append("3 - День (Пример ДД)\n");
        stringBuilder.append("4 - Час посещения (Пример 21)\n");
        stringBuilder.append("5 - Минуты (Пример 45)\n");
        System.out.println(stringBuilder);
    }

    public static void menu_5() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию экспортировать в файл XML: \n");
        stringBuilder.append("1 - Пациентов в XML\n");
        stringBuilder.append("2 - Врачей в XML\n");
        stringBuilder.append("3 - Визитов в XML\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }
}
