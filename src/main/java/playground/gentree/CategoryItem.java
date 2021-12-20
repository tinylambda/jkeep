package playground.gentree;

import java.util.List;

import lombok.Data;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-13
 */
@Data
public class CategoryItem {
    private String name;
    private List<CategoryItem> children;
}
