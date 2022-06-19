import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) { // 1. Ввести количество шагов за определённый день
                int month =0;
                int day = 0;
                int steps = 0;

                while (true){
                    System.out.println("Введите месяц от 1 до 12");
                    month = scanner.nextInt();
                    if (month < 1 || month > 12){
                        System.out.println("Значение выходит из диапазона от 1 до 12");
                   }
                    else break;
                }

                while (true) {
                    System.out.println("Введите день от 1 до 30");
                    day = scanner.nextInt();
                    if (day < 1 || day > 30) {
                        System.out.println("Значение выходит из диапазона от 1 до 30");
                    } else break;
                }

                while (true) {
                    System.out.println("Введите количество шагов");
                    steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Значение должно быть не отрицательным");
                    } else break;
                }

                tracker.setSteps(month, day, steps);

            }

            if (userInput == 2) { // 2. Напечатать статистику за определённый месяц
               int month = 0;
                while (true){
                    System.out.println("Введите месяц от 1 до 12");
                    month = scanner.nextInt();
                    if (month < 1 || month > 12){
                        System.out.println("Значение выходит из диапазона от 1 до 12");
                    }
                    else break;
                }
                tracker.printStatistic(month);
            }

            if (userInput == 3) { // 3. Изменить цель по количеству шагов в день
              while (true) {
                  System.out.println("Введите значение");
                  int value = scanner.nextInt();
                  if (!tracker.setTargetNumberOfStepsPerDay(value)){
                      System.out.println("Значение не должно быть отрицательным");
                  }
                  else break;
              }
            }

            if (userInput > 3 || userInput < 0) {
                System.out.println("Такой команды нет");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() { // Печать меню
        System.out.println();
        System.out.println();
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }
} 