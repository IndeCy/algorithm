package StackDemo;

public class StackTest {

    public static void main(String[] args) {
//        convert(2007);
        try {

            System.out.printf(KuohaoPipet("{[]()}")+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convert(int i){
        Stack s = new StackSLinked();
        while (i>0){
            s.push(i%8+"");
            i=i/8;
        }
        while (!s.isEmpty()) {
            try {
                Object object = s.pop();
                System.out.print(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean KuohaoPipet(String s) throws Exception{
        Stack stack = new StackSLinked();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(':stack.push((int) c);break;
                case '}':
                    if(!stack.isEmpty()&&(Integer)stack.pop()=='{')
                        break;
                    else return false;
                case ']':
                    if(!stack.isEmpty()&& (Integer) stack.pop() =='[')
                        break;
                    else return false;
                case ')':
                    if(!stack.isEmpty()&& (Integer) stack.pop() =='(')
                        break;
                    else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
