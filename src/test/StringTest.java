package test;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-02 15:38
 **/
public class StringTest {
    public static void main(String[] args) {
        // 会在堆中或者常量池中创建对象,如果常量池中没有的话,这两个引用不是同一个引用
        String s1 = new String("aaa");
        String s2 = "aaa" + "aaa";
        String s3 = "aaaaaa";
        // 这个只会在堆中创建对象,然后调用intern方法后会在常量池保留一个引用,这两个引用是同一个引用
        String s4 = new StringBuilder().append("aaaa").append("bbbb").toString();
        System.out.println(s4.intern() == s4);
        System.out.println(s1.intern() == s1);
    }
}
