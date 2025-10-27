package racingcar.domain.car.presentation.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.global.error.CarException;
import racingcar.global.error.ErrorCode;

/**
 * 사용자 입력값을 검증하는 유틸리티 클래스.
 * <p>
 * 자동차 이름 및 시도 횟수의 유효성을 검사하며,
 * 잘못된 입력이 있을 경우 {@link CarException}을 발생시킨다.
 */
public class InputValidator {

    private InputValidator() {
    }

    /**
     * 자동차 이름 목록의 유효성을 검증한다.
     * <p>
     * 검증 기준:
     * <ul>
     *   <li>입력 리스트가 비어 있지 않아야 한다.</li>
     *   <li>각 이름은 1자 이상, 5자 이하이어야 한다.</li>
     *   <li>중복된 이름이 존재해서는 안 된다.</li>
     * </ul>
     *
     * @param names 자동차 이름 리스트
     * @throws CarException {@link ErrorCode#INVALID_CAR_NAME_LENGTH} 또는 {@link ErrorCode#DUPLICATE_CAR_NAME} 발생
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
     * 시도 횟수의 유효성을 검증한다.
     * <p>
     * 검증 기준:
     * <ul>
     *   <li>시도 횟수는 1 이상이어야 한다.</li>
     * </ul>
     *
     * @param count 사용자 입력 시도 횟수
     * @throws CarException {@link ErrorCode#INVALID_ATTEMPT_COUNT} 발생
     */
    public static void validateAttemptCount(long count) {
        if (count <= 0) {
            throw new CarException(ErrorCode.INVALID_ATTEMPT_COUNT);
        }
    }
}
