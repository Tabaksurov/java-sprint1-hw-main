public class StepTracker {
    int targetNumberOfStepsPerDay = 10000; // Целевое количество шагов в день.

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        // Заполните класс самостоятельно
        int[] days = new int[30];

    }
    public void setSteps(int month, int day, int steps){
       monthToData [month-1].days [day-1] = steps;
    }

    public void printStatistic (int month){
        int monthSteps = 0;
        int maxSteps = 0;
        int bestSeries = 0;
        int series = 0;
        for (int i =0; i < monthToData [month-1].days.length; i++) {
            int steps = monthToData [month-1].days[i];
            System.out.print ("День " + (i+1) + " " + steps + ", ");
            monthSteps = monthSteps + steps;
            if (steps > maxSteps){
                maxSteps = steps;
            }
            if (steps >= targetNumberOfStepsPerDay){
                series = series + 1;
            }
            else {
                series = 0;
            }
            if (series > bestSeries){
                bestSeries = series;
            }
        }
        System.out.println();
        System.out.println ("Общее количество шагов за месяц " + monthSteps);
        System.out.println ("Максимальное пройденное количество шагов в месяце " + maxSteps);
        System.out.println ("Среднее количество шагов " + (monthSteps/monthToData [month-1].days.length));
        System.out.println ("Пройденная дистанция (в км) " + Converter.stepToDistance(monthSteps));
        System.out.println ("Количество сожжённых килокалорий " + Converter.stepToCalories(monthSteps));
        System.out.println ("Лучшая серия: " + bestSeries);
    }
    public boolean setTargetNumberOfStepsPerDay (int value){
        if (value >= 0) {
            targetNumberOfStepsPerDay = value;
            return true;
        }
        return false;
    }
}