package object;


import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectPrint {
    @Data
    static class A {
        private long x=100;
    }

    static class B extends A {
        @Override
        public long getX() {
            return super.getX() * 100;
        }
    }

    public static void main(String[] args) {
        B b3 = new B();
        List<B> bs = Lists.newArrayList(new B(), new B(), b3);
        log.info("{}", bs);
        log.info("{}", b3.getClass().getName());
    }
}
