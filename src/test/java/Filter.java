import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    /**
     * 是否展示
     */
    private boolean show;
    /**
     * 名字
     */
    private String name;
    /**
     * 节点
     */
    private Item obj;
    /**
     * 节点list
     */
    private List<Filter> list;


    public static void main(String[] args) {

        Filter filter = new Filter();
        filter.setShow(true);
        filter.setName("性别");

        List<Filter> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Filter o =new Filter();
            Item item = new Item();
            item.setId(Long.valueOf(i));
            String sex = "未知";
            if (i == 1) {
                sex = "男";
                List<Filter> list2 = new ArrayList<>();
                Filter f = new Filter();
                Item item1 = new Item();
                item1.setName("男一号");
                item1.setId(10L);
                f.setObj(item1);
                list2.add(f);


                Filter f1 = new Filter();
                ItemA item2 = new ItemA();
                item2.setName("男二号");
                item2.setId(10L);
                item2.setText("子类");
                f1.setObj(item2);
                list2.add(f1);

                o.setList(list2);


            } else if (i == 2) {
                sex = "女";
            }
            item.setName(sex);
            o.setObj(item);
            o.setShow(true);
            list1.add(o);
        }
        filter.setList(list1);
        String result = JSON.toJSONString(filter);
        System.out.println(result);

    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getObj() {
        return obj;
    }

    public void setObj(Item obj) {
        this.obj = obj;
    }

    public List<Filter> getList() {
        return list;
    }

    public void setList(List<Filter> list) {
        this.list = list;
    }
}

class Item {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ItemA extends Item {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
