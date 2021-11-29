package yaml.classes;

import java.util.Map;

import lombok.Data;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-26
 */
@Data
public class Point {
    private int x;
    private int y;
    private boolean marked;
    private Map<String, String> extra;
}
