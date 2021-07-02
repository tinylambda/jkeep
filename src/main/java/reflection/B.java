package reflection;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class B extends A {
    private static final String DEFAULT_DAY_FORMAT = "yyyyMMdd";

    public static long yyyyMMddOf(long timestamp) {
        if (timestamp == 0) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
        return Long.parseLong(simpleDateFormat.format(timestamp));
    }

    @JsonIgnore  // <- key point
    public long getXY() {
        return  getX() * getY();
    }

    @Override
    public long getTs() {
        return yyyyMMddOf(super.getTs());
    }
}
