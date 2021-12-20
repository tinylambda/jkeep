package playground.gentree;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-13
 */
@Slf4j
public class GenTree {
    private static void fillTree(CategoryItem categoryItem, Category category) {
//        categoryItem.setName();
    }

    private static List<CategoryItem> generateCategoryTree(List<Category> categories) {
        List<CategoryItem> categoryItems = newArrayList();
        int size = CollectionUtils.size(categories);
        if (size > 0) {
            Category category = categories.get(0);
            String label = category.getFirstLevelName();
        }
        categories.sort(Comparator.comparing(Category::getFirstLevelId));
        Long currentFirstLevelId = null;
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Category> categories = newArrayList(
                new Category(1L, "B", 2L, "B1", 3L, "B13", 7L),
                new Category(2L, "B", 2L, "B1", 3L, "B14", 8L),
                new Category(3L, "B", 2L, "B1", 3L, "B15", 9L),
                new Category(4L, "A", 1L, "A1", 2L, "A11", 3L),
                new Category(5L, "A", 1L, "A2", 2L, "A12", 4L),
                new Category(6L, "A", 1L, "A2", 2L, "A121", 5L),
                new Category(7L, "A", 1L, "A3", 2L, "A13", 6L)
        );

        log.info("{}", generateCategoryTree(categories));
    }
}
