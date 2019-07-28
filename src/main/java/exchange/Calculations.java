package exchange;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculations {
    long startTime = System.nanoTime();

    public Calculations() {
        findNumberBanknotes();
    }

    public void findNumberBanknotes() {
        System.out.print("Enter which amount of money would you like to exchange: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] note_quantity = new int[9];
        List<Integer> values = createListOfNoteValues();

        for (int i = 0; i < values.size(); i++) {
            if (input >= values.get(i)) {
                note_quantity[i] = input / values.get(i);
                input -= note_quantity[i] * values.get(i);
            }
        }

        for (int i = 0; i < values.size(); i++) {
            if (note_quantity[i] != 0) {
                System.out.println("You will get " +  note_quantity[i]+ " notes denominated "+ values.get(i) + " UA");
            }
        }
        long endTime = System.nanoTime() - startTime;
        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.print("\nTo calculate it, programme needed " + formatter.format((endTime) / 1000d) + " nanoseconds\n");
    }

    private List<Integer>createListOfNoteValues(){
        List<Integer> values = new ArrayList<Integer>();
        values.add(Notes.FIVE_HUNDRED.getValue());
        values.add(Notes.TWO_HUNDRED.getValue());
        values.add(Notes.HUNDRED.getValue());
        values.add(Notes.FIFTY.getValue());
        values.add(Notes.TWENTY.getValue());
        values.add(Notes.TEN.getValue());
        values.add(Notes.FIVE.getValue());
        values.add(Notes.TWO.getValue());
        values.add(Notes.ONE.getValue());
        return values;
    }
}
