
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StdDraw.setScale(0, 3);
        StdDraw.enableDoubleBuffering();
        addButtons();
        int runs = 0;
        while (runs < 50) {
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                if (x >= 0.25 && x <= 1.25 && y >= 2.25 && y <= 2.75) {
                    createTable();
                    addButtons();
                    StdDraw.show();
                    runs++;
                } else if (x >= 1.75 && x <= 2.75 && y >= 2.25 && y <= 2.75) {
                    generateNumber();
                    addButtons();
                    StdDraw.show();
                    runs++;
                }
            }
        }
    }
    public static void addButtons() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(0.75, 2.5, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.75, 2.5, "Create Table");
        StdDraw.show();
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(2.25, 2.5, 0.5, 0.25);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(2.25, 2.5, "Generate Number");
        StdDraw.show();
    }

    public static void createTable() {
        Integer trials = null;
        Integer divisions = null;
        while (trials == null || divisions == null) {
            System.out.println("Enter a number of trials and divisions: ");
            try {
                trials = sc.nextInt();
                divisions = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        ArrayList<Double> results = new ArrayList<>(trials);
        for (int i = 0; i < trials; i++) {
            results.add(Math.random());
        }
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < divisions; i++) {
            int count = 0;
            for (Double result : results) {
                if (result >= i * 1.0 / divisions && result < (i + 1) * 1.0 / divisions) {
                    count++;
                }
            }
            map.put(i, count * 1.0 / results.size());
        }
        StdDraw.clear();
        StdDraw.square(1.5, 1.5, 0.5);
        for (int i = 0; i < 11; i++) {
            StdDraw.text(0.9, 1 + i * 0.1, i * 10 + "%");
            if (i % 2 == 0) {
                StdDraw.text(1 + i * 0.1, 0.9, i * 10 + "%");
            }
        }
        for (int i = 0; i < divisions; i++) {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledRectangle(1 + (i + 0.5) / divisions, map.get(i) / 2.0 + 1, 0.5 / divisions, map.get(i) / 2.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.rectangle(1 + (i + 0.5) / divisions, map.get(i) / 2.0 + 1, 0.5 / divisions, map.get(i) / 2.0);
        }
    }

    public static void generateNumber() {
        Integer min = null;
        Integer max = null;
        while (min == null || max == null) {
            System.out.println("Enter min and max: ");
            try {
                min = sc.nextInt();
                max = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        int range = max - min + 1;
        StdDraw.text(1.5, 1.5, ((int)(Math.random() * range) + min)+ "");
    }
}