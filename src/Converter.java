public class Converter {

    public static double stepToDistance (int steps){
        return (steps * 0.75)/1000;
    }

    public static double stepToCalories (int steps){
        return (double) (steps * 50)/1000;
    }

}
