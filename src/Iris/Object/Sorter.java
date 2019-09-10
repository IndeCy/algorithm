package Iris.Object;

import java.math.BigDecimal;

public class Sorter {
    private BigDecimal first;
    private BigDecimal second;

    public Sorter(BigDecimal first,BigDecimal second){
        this.first = first;
        this.second = second;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public void setSecond(BigDecimal second) {
        this.second = second;
    }
}
