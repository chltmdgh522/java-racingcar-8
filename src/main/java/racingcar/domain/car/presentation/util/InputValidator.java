package racingcar.domain.car.presentation.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.global.error.CarException;
import racingcar.global.error.ErrorCode;

public class InputValidator {

    private InputValidator() {
    }

    /**
     * 자동차 이름 검증
     */
    public static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new CarException(ErrorCode.INVALID_CAR_NAME_LENGTH);
        }

        Set<String> unique = new HashSet<>();
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new CarException(ErrorCode.INVALID_CAR_NAME_LENGTH);
            }
            if (!unique.add(name)) {
                throw new CarException(ErrorCode.DUPLICATE_CAR_NAME);
            }
        }
    }

    /**
     * 시도 횟수 검증
     */
    public static void validateAttemptCount(long count) {
        if (count <= 0) {
            throw new CarException(ErrorCode.INVALID_ATTEMPT_COUNT);
        }
    }
}
