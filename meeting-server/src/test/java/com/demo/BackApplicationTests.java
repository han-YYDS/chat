package com.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @package: com.jie
 * @className: Test
 * @date: 2022/4/12 21:35
 * @version: 1.0
 */
@SpringBootTest
public class BackApplicationTests {
    //初始化
    @org.junit.jupiter.api.Test
    public void test(){

    }
    public void arrayMaxCount(int[]arr){
        int maxCount=0;
        int maxNumber=0;
        Map<Integer,Integer> map=new HashMap<>();
        //枚举
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int[] arrList=new int[map.size()];
        //统计最多遇到的元素
        for (int i = 0; i < arr.length; i++) {
            if (maxCount<map.get(arr[i])){
                maxNumber=arr[i];
            }
        }
        //去重数组
        int index=0;
        for (Integer num : map.keySet()) {
            arrList[index++]=num;
        }
        System.out.println(Arrays.toString(arrList));
        System.out.println(maxNumber);
    }

    public void tree(Tree node){
        if (node==null){
            return;
        }
        System.out.println(node.no);
        tree(node.left);
        tree(node.right);
    }


}
class Tree{
    public int no;
    public Tree left;
    public Tree right;
}
