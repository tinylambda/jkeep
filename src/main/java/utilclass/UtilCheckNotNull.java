package utilclass;

import static com.google.common.base.Preconditions.checkNotNull;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-24
 */
@Slf4j
@AllArgsConstructor
public class UtilCheckNotNull {
    private Long x;
    private Long y;

    private void validate() {
        checkNotNull(x, "x should not be null");
        checkNotNull(y, "y should not be null");
    }

    public void doWork() {
        validate();
        log.info("x + y = {}", x + y);
    }

    public static void main(String[] args) {
        UtilCheckNotNull notNull = new UtilCheckNotNull(100L, 200L);
        notNull.doWork();

        notNull = new UtilCheckNotNull(100L, null);
        notNull.doWork();  // will throw NPE
    }
}
