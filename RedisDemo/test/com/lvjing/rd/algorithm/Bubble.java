package com.lvjing.rd.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 常用算法测试类
 */
public class Bubble {

    /**
     * 冒泡排序算法
     * @param array int数组
     * @return 经过排序后的数组
     */
    private int[] BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] > array[j]) {
                    int tem = array[i];
                    array[i] = array[j];
                    array[j] = tem;
                }
            }
        }
        return array;
    }

    /**
     * 去除list集合中重复的元素
     * @param list list集合
     * @return 去重后的list集合
     */
    private List<String> removeDuplicate(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    @Test(timeout = 500)
    public void testBubbleSort() {
        int[] array = {5,6,4,1,2,3,8,7,9};
        int[] sort = BubbleSort(array);
        System.out.println(Arrays.toString(sort));
    }

    @Test
    public void testRD() {
        List<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小红");
        list.add("小李");
        list.add("小明");
        list.add("小红");
        list.add("小李");
        list.add("小丽");
        list.add("小明");
        // 方法1：通过两层for循环去除重复元素
        List<String> list1 = removeDuplicate(list);
        System.out.println(list1);

        // 方法2：通过HashSet去除重复元素
       /* HashSet<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);*/
    }
}
