package cn.mh.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author: mahao
 * @date: 2020/7/25
 */
public class ForeachTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        };
        //原理就是方法的回调。
        list.forEach(consumer);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "aa");
        hashMap.put("b", "bb");
        hashMap.put("c", "cc");
        hashMap.forEach((k, v) -> {
            System.out.println(k + " ----- " + v);
        });
    }
}
