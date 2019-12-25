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
        list.add(4);

        System.out.println(getSubsets(list).size());
        System.out.println(getSubsets(list));

    }

    public static  <T> ArrayList<ArrayList<T>> getSubsets(List<T> list) {
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
        // 去除空集
        if (result.get(0) == null || result.get(0).isEmpty()) {
            result.remove(0);
        }
        return result;
    }

}
