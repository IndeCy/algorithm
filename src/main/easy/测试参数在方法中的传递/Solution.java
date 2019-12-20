package easy.测试参数在方法中的传递;

import easy.二叉树的最小深度111.TreeNode;

public class Solution {

    /**
     * 传的基本数据类型传的是值 test中的i跟传进来的i已经不是同一个引用 不会相互影响
     * @param i
     */
    static void test(int i){
        i++;
        System.out.println("test:i="+i);
    }

    /**
     * 传的是对象的引用 test2和main方法用同一个对象改变属性会相互影响
     * @param node
     */
    static void test2(TreeNode node){
        node.val = 1314;
        System.out.println("test2:treeval="+node.val);
    }

    /**
     * 由于自动开箱机制存在 故传递的Integer对象仍然是值
     * @param i
     */
    static void test3(Integer i){
        i = i+new Integer(1);
        System.out.println("test3:i="+i);
    }

    /**
     * string也可以理解为传递的值 新方法中使用不会改变原方法
     * @param i
     * @param j
     */
    static void test4(String i,String j){
        i = i+"a";
        j=j.replace('2','b');
        System.out.println("test4:i="+i+",j="+j);
    }

    public static void main(String[] args) {
        int i = 8;
        test(i);
        System.out.println("main:i="+i);
        TreeNode root = new TreeNode(510);
        test2(root);
        System.out.println("main2:treeval="+root.val);
        Integer a = new Integer(4);
        test3(a);
        System.out.println("main3:i="+a);
        String b = "123";
        String c = new String("123");
        test4(b,c);
        System.out.println("main4:i="+b+",j="+c);
    }
}
