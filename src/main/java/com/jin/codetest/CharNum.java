//package com.jin.codetest;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//
//public class CharNum {
//
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        String string = input.nextLine();
//        if (string == null || string.isEmpty()) {
//            System.out.println("/");
//            return;
//        }
//
//        String[] array = string.split(",");
//        String head = array[0];
//        String tail = array[1];
//
//        // 前缀为空并且后缀为空
//        if (((head == null || head.isEmpty()) && (tail == null || tail.isEmpty()))) {
//            System.out.println("/");
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        if (head != null && !head.isEmpty()) {
//            if (head.charAt(head.length() - 1) == '/') {
//                head = head.substring(0, head.length() - 1);
//            }
//            sb.append(head);
//        }
//
//        if (tail != null && !tail.isEmpty()) {
//            if (tail.charAt(0) != '/') {
//                tail = "/" + tail;
//            }
//            sb.append(tail);
//        }
//
//        System.out.println(sb.toString());
//
//    }
//
//}
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        if (nums == null || nums.length < 2) {
//            return new int[]{-1, -1};
//        }
//        int[] res = new int[]{-1, -1};
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                res[0] = map.get(target - nums[i]);
//                res[1] = i;
//            }
//            map.put(nums[i], i);
//        }
//        return res;
//    }
//}
//}
