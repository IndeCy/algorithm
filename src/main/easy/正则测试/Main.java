package easy.正则测试;

public class Main {

    /**
     * 身份证号正则
     */
    static final String idCardRegex = "^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

    public static void main(String[] args) {
        String idCard = "320623199504164117";
        System.out.println(idCard.matches(idCardRegex));
        System.out.println(idCard.matches("^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$"));
    }
}
