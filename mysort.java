package bbb;
import java.util.*;

public class mysort {
    private String name;
    private int chineseScore;
    private int mathScore;
    private int totalScore;

    public mysort(String name, int chineseScore, int mathScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.totalScore = chineseScore + mathScore;
    }

    public String getName() {
        return name;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public static void main(String[] args) {
        List<mysort> mysorts = new ArrayList<>();
        mysorts.add(new mysort("Tom", 80, 90));
        mysorts.add(new mysort("Jerry", 90, 80));
        mysorts.add(new mysort("Alice", 70, 85));
        mysorts.add(new mysort("Bob", 85, 75));

        // 按照语文成绩排序
        Comparator<mysort> chineseComparator = Comparator.comparing(mysort::getChineseScore);
        Collections.sort(mysorts, chineseComparator);
        System.out.println("按照语文成绩排序:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getChineseScore());
        }
        System.out.println();
        
        // 按照数学成绩排序
        Comparator<mysort> mathComparator = Comparator.comparing(mysort::getMathScore);
        Collections.sort(mysorts, mathComparator);
        System.out.println("按照数学成绩排序:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getMathScore());
        }

        // 按照总成绩排序
        Comparator<mysort> totalComparator = Comparator.comparing(mysort::getTotalScore);
        Collections.sort(mysorts, totalComparator);
        System.out.println("按照总成绩排序:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getTotalScore());
        }
    }
}
