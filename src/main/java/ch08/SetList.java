import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
            list2.add(i);
        }
        System.out.println("Before:");
        System.out.println("\tSet: " + set);
        System.out.println("\tList: " + list);
        System.out.println("\tList2: " + list2);

        for(int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
            list2.remove((Integer) i);
        }
        System.out.println("After:");
        System.out.println("\tSet: " + set);
        System.out.println("\tList: " + list);
        System.out.println("\tList2: " + list2);
    }
}
