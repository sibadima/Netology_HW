import java.util.Scanner;

public class HW3_COND {
    public static void main(String[] args) throws Exception {

        Scanner console = new Scanner(System.in);
        int count = 0;
        System.out.println("Добро пожаловать в игру!");
        Thread.sleep(600);
        System.out.println("Правила игры: введи год в формате \"yyyy\"");
        Thread.sleep(600);
        System.out.println("Затем введи количество дней в этом году.");
        Thread.sleep(600);
        System.out.println("Если ответ верен ты получишь 1 балл.");
        Thread.sleep(600);
        System.out.println("Игра продолжится пока ты не ошибешься. Удачи!");
        Thread.sleep(600);
        System.out.println();

        while (true) {
            System.out.println("Введите год:");
            int year = console.nextInt();
            System.out.println("Введите количество дней:");
            int userDays = console.nextInt();

            int correctDays = calculate(year);

            if (userDays == correctDays) {
                count++;
            } else {
                System.out.println("Неправильно! В этом году " + correctDays + " дней!");
                break;
            }

        }
        System.out.println("Набрано очков: " + count);
    }

    //метод для вычисления количества дней в году
    public static int calculate(int year) {
        if (year % 400 == 0) {
            return 366;
        } else if ((year % 4 == 0) && (year % 100 != 0)) {
            return 366;
        } else {
            return 365;
        }
    }
}


