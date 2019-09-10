import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        Map<A,B> map = new HashMap<>();

        A a1 = new A();
        a1.setId(1L);
        a1.setInvert(1);
        A a2 = new A();
        a2.setId(1L);
        a2.setInvert(1);
        B b1 = new B();
        b1.setValue(1);
        B b2 = new B();
        b2.setValue(2);

        map.put(a1,b1);
        map.put(a2,b2);

        System.out.println(JSON.toJSONString(map));

    }

    static class A{
        private Integer invert;
        private Long id;

        public Integer getInvert() {
            return invert;
        }

        public void setInvert(Integer invert) {
            this.invert = invert;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    static class B{
        private Integer value;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
