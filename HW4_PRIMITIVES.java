import java.util.Scanner;

public class HW4_PRIMITIVES {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int earnings = 0; //доходы
        int spendings = 0; // расходы

        while (true) {
            System.out.println();
            System.out.println("Добавьте операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");

            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String moneyStr = scan.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расходов: ");
                    String spendStr = scan.nextLine();
                    int spend = Integer.parseInt(spendStr);
                    spendings += spend;
                    break;
                case 3:
                    // результат вычисления налогов в статических методах сохраняем в переменные типа инт
                    int taxEarning = taxesEarning(earnings, spendings);
                    int taxSpendig = taxesEarningMinusSpending(earnings, spendings);

                    if (taxEarning < taxSpendig) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxEarning);
                        System.out.println("Налог на другой системе: " + taxSpendig);
                        System.out.println("Экономия: " + (taxSpendig - taxEarning));

                    } else if (taxSpendig < taxEarning) {
                        System.out.println("Мы советуем вам УСН доход минус расходы");
                        System.out.println("Ваш налог составит: " + taxSpendig);
                        System.out.println("Налог на другой системе: " + taxEarning);
                        System.out.println("Экономия: " + (taxEarning - taxSpendig));
                    } else {
                        System.out.println("Можете выбрать любую систему налогооблажения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");

            }
        }
    }

    public static int taxesEarning(int earnings, int spendings) {

        System.out.println("Программа рассчитала налог УСН доходы.");
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxesEarningMinusSpending(int earnings, int spendings) {
        System.out.println("Программа рассчитала налог УСН доходы минус расходы.");
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

}