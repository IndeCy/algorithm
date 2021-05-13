package easy.最小栈155;

import java.util.Stack;


/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 此方法同步出栈入栈 只有元素小于辅助栈顶元素是才入栈 否则继续入栈 栈顶的最小元素 出栈不用判断直接出栈保持同步
 */
public class MinStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    private Integer min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int x) {
        data.add(x);
        if(helper.isEmpty() || x < helper.peek()){
            helper.add(x);
        }else {
            helper.add(helper.peek());
        }

    }

    /* 此方式非同步出栈入栈 小于栈顶元素是入栈 否则不入栈 （⚠️等于栈顶元素时也要入栈）
    public void push(int x) {
        data.add(x);
        if(helper.isEmpty() || x <= helper.peek()){
            helper.add(x);
        }
    }

    出栈时判断元素是否相等 相等才出栈 (⚠️这里有个小坑 不能使用 data.pop() == helper.peek() Integer包装类用==比较时比较的时内存地址导致helper未出栈，应该使用equals比较值)
    public void pop() {
        if(helper.peek().equals(data.pop())){
            helper.pop();
        }
    }
    */


    public void pop() {
        data.pop();
        helper.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
