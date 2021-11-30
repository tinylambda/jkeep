package template.freemarker;

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
}
