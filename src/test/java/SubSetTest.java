import java.util.ArrayList;
import java.util.List;

public class SubSetTest {

   public  static   <T> ArrayList<ArrayList<T>> getSub(List<T> list) {
        ArrayList<ArrayList<T>> result = new ArrayList<>();
        ArrayList<ArrayList<T>> temp = null;
        ArrayList<T> element = null;
        //添加为空的子集
        result.add(new ArrayList<T>());
        for (T aList : list) {
            temp = new ArrayList<>();
            for (ArrayList<T> aResult : result) {
                element = new ArrayList<>();
                element.add(aList);
                element.addAll(aResult);
                temp.add(element);
            }
            result.addAll(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(getSub(list));
        System.out.println(getSubsets(list));

    }


    public  static  <T> ArrayList<ArrayList<T>> getSubsets(List<T> list) {


        //TODO 需要动态规划去做
        if (list.size() > 7) {
            for (int i = 7; i < list.size(); i++ ) {
                list.remove(list.get(i));
            }
        }
        // write code here
        ArrayList<ArrayList<T>> lists = new ArrayList<ArrayList<T>>();
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (arrayList.size() == 0) {
                arrayList.add(list.get(i));
                lists.add(arrayList);
            } else {
                ArrayList<ArrayList<T>> list2s = new ArrayList<ArrayList<T>>();
                list2s.addAll(lists);
                for (int j = 0; j < lists.size(); j++) {
                    ArrayList<T> list2 = new ArrayList<>(lists.get(j));
                    list2.add(list.get(i));
                    list2s.add(list2);
                }
                ArrayList<T> ll = new ArrayList<T>();
                ll.add(list.get(i));
                list2s.add(ll);
                lists = list2s;
            }
        }
        return lists;
    }

}
