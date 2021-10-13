package playground.tao;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-09
 */
@Slf4j
public class Biz {
    private static final Map<Goods, Integer> STORE = newHashMap();
    static {
        STORE.put(new Goods("商品1", 100.0), 78);
        STORE.put(new Goods("商品2", 100.0), 69);
        STORE.put(new Goods("商品3", 100.0), 54);
    }

    public void buy(String productId, Integer num) {
    }

    public static void main(String[] args) {
        Biz pm = new Biz();
    }
}
