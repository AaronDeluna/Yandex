import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8]; // Объявите массив shoppingList через длину
        int productCount = 0; // переменная для подсчёта добавленных товаров

        Scanner scanner = new Scanner(System.in);

        String a = "1. Добавить товар в список",
                b = "2. Показать список",
                c = "3. Очистить список",
                d = "4. Завершить работу";

        boolean run = true;
        while (run) {
            System.out.printf("Выберите одну из команд:\n%s\n%s\n%s\n%s\n", a, b, c, d);

            int actionNumber = scanner.nextInt();
            if (actionNumber >= 1 && actionNumber <= 4){
                switch (actionNumber){
                    case 1 -> addProductsToShoppingList(productCount, shoppingList, scanner);
                    case 2 -> showList(shoppingList);
                    case 3 -> clearProductFromList(shoppingList, scanner);
                    case 4 ->
                        run = false;
                }
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }

    public static void addProductsToShoppingList(int productCount, String[] shoppingList, Scanner scanner){
        for (int i = productCount; i < shoppingList.length; i++) {
            System.out.println("Добавьте товар: ");
            String product = scanner.next();
            shoppingList[i] = product;
            productCount++;
            if (productCount % 3 == 0){
                break;
            }
        }
    }

    public static void showList(String[] shoppingList) {
        boolean isEmpty = true;

        for (int i = 0; i < shoppingList.length; i++) {
            if (shoppingList[i] != null) {
                System.out.println((i + 1) + " Товар: " + shoppingList[i]);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("Список пуст!");
        }
    }


    public static void clearProductFromList(String[] array, Scanner scanner){
        String a = "1. Удалить по индексу";
        String b = "2. Удалить по названию товара";
        String c = "3. Удалить все";
        String d = "4. Отменить удаление";

        System.out.printf("Выберите, как вы хотите удалить: \n%s \n%s \n%s \n%s\n", a, b, c, d);

        int deleteCommand = scanner.nextInt();
        boolean run = true;
        while (run){
            if (deleteCommand >= 1 && deleteCommand <= 4){
                switch (deleteCommand){
                    case 1 -> deleteProductByIndex(array, scanner);
                    case 2 -> deleteProductByName(array, scanner);
                    case 3 -> deleteAllProduct(array, scanner);
                    case 4 ->
                        run = false;
                }
            }else {
                System.out.println("Неизвестная команда!");
            }
        }
    }

    public static void deleteProductByIndex(String[] array, Scanner scanner){
        showList(array);
        System.out.println("Введите номер номер товара для удаления: ");
        int productIndex = scanner.nextInt();
        array[productIndex] = null;
        System.out.println("Вы удалили товар под номером: " + productIndex);
        System.out.println("В списке остались: ");
        showList(array);
    }

    public static void deleteProductByName(String[] array, Scanner scanner){
        showList(array);
        System.out.println("Введите название товара для удаления: ");
        String productName = scanner.next();

        boolean itemDeleted = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equalsIgnoreCase(productName)) {
                array[i] = null;
                System.out.println("Вы удалили товар под именем: " + productName);
                itemDeleted = true;
                break;
            }
        }

        if (!itemDeleted) {
            System.out.println("Товар с именем '" + productName + "' не найден.");
        }

        System.out.println("В списке остались: ");
        showList(array);
    }

    public static void deleteAllProduct(String[] array, Scanner scanner){
        showList(array);
        System.out.println("Введите название товара для удаления: ");
        String productName = scanner.next();

        boolean itemDeleted = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equalsIgnoreCase(productName)) {
                array[i] = null;
                System.out.println("Вы удалили товар под именем: " + productName);
                itemDeleted = true;
                break;
            }
        }

        if (!itemDeleted) {
            System.out.println("Товар с именем '" + productName + "' не найден.");
        }

        System.out.println("В списке остались: ");
        showList(array);
    }
}

