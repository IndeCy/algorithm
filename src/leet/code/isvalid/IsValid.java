package leet.code.isvalid;


import java.util.LinkedList;
import java.util.List;

public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValidMethed("{{{[])}}}"));
    }
    public static boolean isValidMethed(String s) {
        List<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        try {
            for(char c:chars){
                switch (c){
                    case'{':
                    case'[':
                    case'(':list.add(c);break;
                    case ')':
                        if((((LinkedList<Character>) list).removeLast().equals('('))){
                            break;
                        }else {
                            return false;
                        }
                    case ']':
                        if((((LinkedList<Character>) list).removeLast().equals('['))){
                            break;
                        }else {
                            return false;
                        }
                    case '}':
                        if((((LinkedList<Character>) list).removeLast().equals('{'))){
                            break;
                        }else {
                            return false;
                        }
                }
            }
        } catch (Exception e) {
            return false;
        }
        if(list.size()==0) {
            return true;
        }else{
            return false;
        }
    }
}
