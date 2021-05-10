package object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectHashCode {
    @Data
    static class Obj {
        private long id;

        public Obj(long id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Long.valueOf(getId()).hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return  true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Obj other = (Obj) o;
            return this.getId() == other.getId();
        }
    }

    public static void main(String[] args) {
        Obj o1 = new Obj(1000);
        Obj o2 = new Obj(2000);
        Obj o3 = new Obj(1000);

        Map<Obj, String> map = new HashMap<>();
        map.put(o1, "hello");
        log.info(map.containsKey(o2) + "");
        log.info(map.containsKey(o3) + "");

        List<Obj> objs = new ArrayList<>();
        objs.add(o1);
        log.info(objs.contains(o2) + "");
        log.info(objs.contains(o3) + "");
    }
}
