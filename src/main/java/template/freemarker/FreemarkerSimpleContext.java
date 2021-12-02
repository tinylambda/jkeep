package template.freemarker;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreemarkerSimpleContext {
    private Integer x;
    private Integer y;
    List<String> items;
}
