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

        // �������ĳɼ�����
        Comparator<mysort> chineseComparator = Comparator.comparing(mysort::getChineseScore);
        Collections.sort(mysorts, chineseComparator);
        System.out.println("�������ĳɼ�����:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getChineseScore());
        }
        System.out.println();
        
        // ������ѧ�ɼ�����
        Comparator<mysort> mathComparator = Comparator.comparing(mysort::getMathScore);
        Collections.sort(mysorts, mathComparator);
        System.out.println("������ѧ�ɼ�����:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getMathScore());
        }

        // �����ܳɼ�����
        Comparator<mysort> totalComparator = Comparator.comparing(mysort::getTotalScore);
        Collections.sort(mysorts, totalComparator);
        System.out.println("�����ܳɼ�����:");
        for (mysort mysort : mysorts) {
            System.out.println(mysort.getName() + " " + mysort.getTotalScore());
        }
    }
}
