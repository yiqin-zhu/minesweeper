public class Game {
    public static void main(String[] args) {

        int length = 0;
        int width = 0;
        MineField g = new MineField(length, width, MineField.numOfMine);
//        Utils.displayField(length, width, MineField.numOfMine);

        System.out.println("Enter length, width, and action (CLICK or PLACE_FLAG) seperated with a space.");

        g.enter();


    }
}
