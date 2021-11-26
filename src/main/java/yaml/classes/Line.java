package yaml.classes;

import java.util.List;

import lombok.Data;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-26
 */
@Data
public class Line {
    private List<Point> points;
}
