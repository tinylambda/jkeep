package playground.gentree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-13
 */
@AllArgsConstructor
@Data
public class Category {
    private Long id;
    private String firstLevelName;
    private Long firstLevelId;

    private String secondLevelName;
    private Long secondLevelId;

    private String thirdLevelName;
    private Long thirdLevelId;
}
