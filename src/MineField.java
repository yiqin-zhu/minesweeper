import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


/*
 *   MineField game = new MineField(3, 10, 1);
 *
 *   In the beginning, call "game.displayField()" and Java should print
 *   o o o o o o o o o o
 *   o o o o o o o o o o
 *   o o o o o o o o o o
 *
 *   game.enter(0, 2, "CLICK");
 *   game.displayField();
 *   If there are 1 mines around
 *   o o 1 o o o o o o o
 *   o o o o o o o o o o
 *   o o o o o o o o o o
 *
 *   If is a mine
 *   o o X o o o o o o o
 *   o o o o o o o o o o
 *   o o o o o o o o o o
 *
 *   game.enter(0, 2, "SET_FLAG");
 *   game.displayField()
 *   o o F o o o o o o o
 *   o o o o o o o o o o
 *   o o o o o o o o o o
 *
 */

public class MineField {

    private static int length;
    private static int width;
    static int numOfMine;
    private String[][] field;
    private Set<coordiate> mineCoordiate = new HashSet<>();

    private final Set<String> allowedActions = new HashSet<String>() {{
        add("CLICK");
        add("PLACE_FLAG");
    }};

    class types {
        String clickable = "o";
        String flag = "F";
        String mine = "X";
        //number is also a type but no need to define specifically
    }

    class coordiate {
        int x;
        int y;

        public coordiate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x = " + x + "; y = " + y;
        }
    }

    public MineField(int length, int width, int numOfMine) {
        //TODO
        //write some code here to make sure your inputs are valid
        //hint: use while loop to keep asking for the valid inputs

        System.out.println("Welcome to Kaboom!\n" +
                "Enter length, width, and number of mines with a space in between each value.\n" +
                "Length and width should be equal or more than 3 and equal or less than 10.\n" +
                "Mines can be no more than 30% of board.");

        Scanner input = new Scanner(System.in);
        int[] nums = new int[3];

        while ((!(Utils.isBetween(nums[0], 3, 10)) ||
                (!(Utils.isBetween(nums[1], 3, 10)) ||
                        (!(Utils.isBetween(nums[2], 1, (int) (nums[0] * nums[1] * 0.3))))))) {

            System.out.println("Enter new values.");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = input.nextInt();
            }
        }

        MineField.length = nums[0];
        MineField.width = nums[1];
        MineField.numOfMine = nums[2];

        initMineCoordiate();
        initField();
    }

    private void initMineCoordiate() {
        //TODO
        //randomly genreate mines in the field based on length, width, numOfMine
        //save the mine coordiates in this.mineCoordiate.

        int mineXCord = 0;
        int mineYCord = 0;
        int mineNum = 0;

        for (int i = 0; i < numOfMine; i++) {
            mineNum = ThreadLocalRandom.current().nextInt(0, length * width);
            mineXCord = mineNum / width;
            mineYCord = mineNum % width;

            coordiate newCord = new coordiate(mineXCord, mineYCord);
            mineCoordiate.add(newCord);
            System.out.println("Random number: " + mineNum);
            System.out.println("Mine Cords: " + mineCoordiate);
        }
    }

    private void initField() {
        //TODO
        //fill your field

        field = new String[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = "o";
            }
        }
        System.out.println(Arrays.deepToString(field));
    }

    public void enter() {
        //TODO
        //enter your action to specific place in the field and this should alter the field
        //make sure your input x, y, and action are valid
        //hint: modify your this.field based on your input x, y, and action.

        Scanner input = new Scanner(System.in);
        String[] inputs = new String[3];

        do {
            System.out.println("Enter next command.");
            for (int i = 0; i < inputs.length; i++) {
                if (i == 0 || i == 1) {
                    inputs[i] = String.valueOf(input.nextInt());
                } else {
                    inputs[i] = input.next();
                }
            }
            System.out.println("Command: " + Arrays.toString(inputs));
        } while (!(Utils.isBetween(Integer.parseInt(inputs[0]), 0, width)) ||
                (!(Utils.isBetween(Integer.parseInt(inputs[1]), 0, length)) ||
                        (!(Objects.equals(inputs[2], "CLICK") || Objects.equals(inputs[2], "PLACE_FLAG")))));

        int xEnteredCord = Integer.parseInt(inputs[0]);
        int yEnteredCord = Integer.parseInt(inputs[1]);
        coordiate enteredCord = new coordiate(xEnteredCord, yEnteredCord);
        System.out.println(enteredCord);

        if (inputs[2].equals("CLICK")) {
            if (mineCoordiate.contains(enteredCord)) {
                field[xEnteredCord][yEnteredCord] = "X";
                System.out.println("Game Over!");
                Utils.displayField(length, width, field);
            } else {
                // show num of mines aroundgit i
                // check mines algo here
                // check mines algo here
                // check mines algo here
                // check mines algo here
                // check mines algo here
                // check mines algo here
            }
        } else if (inputs[2].equals("PLACE_FLAG")) {
            field[xEnteredCord][yEnteredCord] = "X";
        }
    }
}
