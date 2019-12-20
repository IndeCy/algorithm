package easy;

import java.util.List;

public class Rule {

    private Integer invert;

    private List<RuleOptionDO> ruleOptionDOList;


    public Rule(){
    }

    public Integer getInvert() {
        return invert;
    }

    //todo 序列化字符串的key 还跟get方法名字有关
    public List<RuleOptionDO> getRuleOptionDOList() {
        return ruleOptionDOList;
    }

    public void setInvert(Integer invert) {
        this.invert = invert;
    }

    public void setRuleOptionDOList(List<RuleOptionDO> ruleOptionDOList) {
        this.ruleOptionDOList = ruleOptionDOList;
    }

    public Rule(Integer invert, List<RuleOptionDO> ruleOptionDOList) {
        this.invert = invert;
        this.ruleOptionDOList = ruleOptionDOList;
    }
}
