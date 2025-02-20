import java.util.Scanner;

public class HW6_ARR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        //Создаем массив для хранения количества выбранных товаров Пользователем:
        int[] cart = new int[products.length];

        System.out.println("Список возможных продуктов для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт.");
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end")) break;

            //Сохраняем результат разделения строки input через метод split в массив parts типа String согласно условию
            String[] parts = input.split(" ");
            //Переменная вводимая Пользователем, номер продукта начиная с 0
            int productNumber = Integer.parseInt(parts[0]) - 1;
            //Переменная вводимая Пользователем, количество товара
            int productCount = Integer.parseInt(parts[1]);
            int currentPrice = prices[productNumber];

            //Увеличиваем количество выбранного товара
            cart[productNumber] += productCount;

        }

        System.out.println("Ваша корзина: ");
        //Переменная totalCost будет хранить общую стоимость всех товаров
        int totalCost = 0;
        for (int i = 0; i < products.length; i++) {
            if (cart[i] > 0) {
                //Вычисляем стоимость выбранного количества товара
                int cost = cart[i] * prices[i];
                System.out.println(products[i] + " " + cart[i] + " шт. " + prices[i] + " руб/шт " + cost + " руб в сумме");
                //Увеличиваем сумму общей стоимости корзины
                totalCost += cost;
            }
        }
        System.out.println("Итого " + totalCost + " руб");
    }
}
