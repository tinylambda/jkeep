package pb;


import static java.util.Objects.requireNonNull;

import javax.annotation.Nullable;

import com.example.grpc.gencode.GENDER;
import com.example.grpc.gencode.OLD_GENDER;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PBEnum {
    @Nullable
    public static GENDER getGender(int oldCode) {
        OLD_GENDER oldGender = OLD_GENDER.forNumber(oldCode);
        requireNonNull(oldGender, "OLD_GENDER with value " + oldCode + " not defined");

        switch (oldGender) {
            case MAN:
                return GENDER.MALE;
            case WOMAN:
                return GENDER.FEMALE;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        int oldCode = 0;
        GENDER gender = getGender(oldCode);
        requireNonNull(gender, "oldCode(" + oldCode + ") not mapped properly");

        log.info("{}", gender);
        log.info("{}", gender.getNumber());
    }
}
