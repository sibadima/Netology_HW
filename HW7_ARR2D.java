import java.util.Random;
import java.util.Scanner;

public class HW7_ARR2D {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Заполняем матрицу colors случайными числами от 0 до 255
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        //Выводим исходную матрицу
        printMatrix(colors);

        //Создаем пустой массив для повернутой матрицы
        int[][] rotatedColors = new int[SIZE][SIZE];

        while (true) {
            System.out.println("\nВыберите пункт на сколько градусов хотите повернуть матрицу или введи 'end':");
            System.out.println("1. 90 градусов по часовой стрелке");
            System.out.println("2. 180 градусов по часовой стрелке");
            System.out.println("3. 270 градусов по часовой стрелке");
            System.out.println("4. Выход из программы");

            int input = scanner.nextInt();

            if (input == 1) {
                rotatedColors = rotate90(colors);
                System.out.println("Матрица повернута на 90 градусов по часовой стрелке");
                break;
            } else if (input == 2) {
                rotatedColors = rotate180(colors);
                System.out.println("Матрица повернута на 180 градусов по часовой стрелке");
                break;
            } else if (input == 3) {
                rotatedColors = rotate270(colors);
                System.out.println("Матрица повернута на 270 градусов по часовой стрелке");
                break;
            } else if (input == 4) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Ошибка. Введите корректный пункт меню (1, 2, 3 или 4)");
            }
        }
        //Выводим перевернутую программу
        printMatrix(rotatedColors);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //Метод для поворота матрицы на 90 градусов по часовой стрелке
    public static int[][] rotate90(int[][] colors) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[j][SIZE - i - 1] = (colors[i][j]);
            }
        }
        return rotatedColors;
    }

    //Метод для поворота матрицы на 180 градусов по часовой стрелке
    public static int[][] rotate180(int[][] colors) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[SIZE - i - 1][SIZE - j - 1] = colors[i][j];
            }
        }
        return rotatedColors;
    }

    //Метод для поворота матрицы на 270 градусов по часовой стрелке
    public static int[][] rotate270(int[][] colors) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[SIZE - j - 1][i] = (colors[i][j]);
            }
        }
        return rotatedColors;
    }
}

