import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // 创建一个存储字符串的ArrayList对象
        ArrayList<String> list = new ArrayList<String>();

        // 向ArrayList中添加元素
        list.add("apple");
        list.add("banana");
        list.add("orange");

        // 获取ArrayList中指定位置的元素
        String fruit = list.get(1);
        System.out.println(fruit);  // 输出"banana"

        // 删除ArrayList中指定位置的元素
        list.remove(0);
        System.out.println(list);   // 输出"[banana, orange]"

        // 获取ArrayList中元素的个数
        int size = list.size();
        System.out.println(size);   // 输出"2"
    }
}
