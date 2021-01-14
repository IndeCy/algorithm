package easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class JSONtest {


    public static void main(String[] args) {


        List<Rule> ruleOptions = JSON.parseArray(generateString(),Rule.class);

        System.out.println(JSON.toJSONString(ruleOptions));

    }

    public static String generateString(){
        String[] s1 = "".split(" ");
        RuleOptionDO a = new RuleOptionDO();
        a.setFact("licenseNo");
        a.setOptStringMatch("string");
        a.setInvert(0);
        RuleOptionDO b = new RuleOptionDO();
        b.setFact("licenseNo");
        b.setOptStringMatch("test");
        b.setInvert(0);
//        easy.RuleOptionDO c = new easy.RuleOptionDO("C",3);
//        easy.RuleOptionDO d = new easy.RuleOptionDO("D",4);


        System.out.println(JSON.toJSONString(a));

        List<RuleOptionDO> ruleOptions1DO = new ArrayList<>();
        ruleOptions1DO.add(a);
        ruleOptions1DO.add(b);
        Rule rule1 = new Rule(1, ruleOptions1DO);
        List<RuleOptionDO> ruleOptions2DO = new ArrayList<>();
//        ruleOptions2DO.add(d);
//        ruleOptions2DO.add(c);
        Rule rule2 = new Rule(1, ruleOptions2DO);
        Rule[] rules = new Rule[]{rule1};
        String s = JSON.toJSONString(rules);
        System.out.println(s);
        return s;
    }

}
