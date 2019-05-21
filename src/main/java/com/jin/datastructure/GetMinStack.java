package com.jin.datastructure;

import java.util.Objects;
import java.util.Stack;

/**
 * 功能描述:获取栈的最小值
 *
 * @param
 * @return
 * @author haojie.jin
 * @date 12:20 2019-05-21
 * @since
 */
public class GetMinStack {

    /**数据栈*/
    private Stack<Integer> dataStack = new Stack<>();
    /**最小值栈*/
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer ele) {
        Integer minStackPopEle = null;
        if (!minStack.empty()) {
            minStackPopEle = minStack.peek();
        }
        if (null == minStackPopEle || ele <= minStackPopEle) {
            minStack.push(ele);
        }
        dataStack.push(ele);
    }

    public Integer pop() {
        Integer data = null;
        if (!dataStack.empty()) {
            data = dataStack.pop();
        }
        Integer min = null;
        if (!minStack.empty()) {
            min = minStack.peek();
        }
        if (Objects.equals(min, data)) {
            minStack.pop();
        }

        return data;
    }

    public Integer getMin() {
        if (dataStack.empty()) {
            return null;
        }
        Integer min = dataStack.peek();
        Integer minStackPopEle = minStack.peek();

        if (min != null && minStackPopEle != null) {
            if (min > minStackPopEle) {
                min = minStackPopEle;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(2);
        getMinStack.push(1);
        getMinStack.push(6);
        getMinStack.push(5);
        getMinStack.push(4);
        getMinStack.push(8);


        System.out.println(getMinStack.getMin());

    }

}
