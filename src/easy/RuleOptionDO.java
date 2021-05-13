package easy;

import com.alibaba.fastjson.annotation.JSONField;

public class RuleOptionDO {

    private String fact;
    private Integer integerMatch;
    private String optStringMatch;
    @JSONField(serialize = false)
    private Integer invert;

    public RuleOptionDO(String fact, Integer integerMatch,Integer invert){
        this.fact = fact;
        this.integerMatch = integerMatch;
        this.invert = invert;
    }

    public RuleOptionDO(){

    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getIntegerMatch() {
        return integerMatch;
    }

    public void setIntegerMatch(Integer integerMatch) {
        this.integerMatch = integerMatch;
    }

    public String getOptStringMatch() {
        return optStringMatch;
    }

    public Integer getInvert() {
        return invert;
    }

    public void setInvert(Integer invert) {
        this.invert = invert;
    }

    public void setOptStringMatch(String optStringMatch) {
        this.optStringMatch = optStringMatch;
    }

    @JSONField(deserialize = false)
    public String getTestSer(){
        String aa = "aaaa";
        return aa;
    }
}
