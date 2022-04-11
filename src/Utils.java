public class Utils {
    public static boolean isBetween(int value, int min, int max){
        return ((value >= min) && (value <= max));
    }

    public static String displayField(int length, int width, String[][] field) {
        //TODO
        //Call this method and print out the current field
        //hint write code to nicely display this.field

        System.out.println("Here is your field:");

        String printField = null;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                printField = field[i][j] + " ";
            }
            System.out.println();
        }
        return printField;
    }
}

