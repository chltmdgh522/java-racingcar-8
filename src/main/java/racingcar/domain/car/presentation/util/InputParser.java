package racingcar.domain.car.presentation.util;

import java.util.Arrays;
import java.util.List;
import racingcar.global.error.CarException;
import racingcar.global.error.ErrorCode;

public class InputParser {

    private InputParser() {
    }

    /**
     * 자동차 이름 문자열을 ',' 기준으로 분리 후 리스트로 반환
     */
    public static List<String> parseCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new CarException(ErrorCode.EMPTY_CAR_NAME_INPUT);
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        // 입력값이 쉼표만 있는 경우 예외
        if (carNames.isEmpty() || carNames.stream().allMatch(String::isBlank)) {
            throw new CarException(ErrorCode.EMPTY_CAR_NAME_INPUT);
        }

        return carNames;
    }

    /**
     * 시도 횟수 입력값을 long으로 파싱
     */
    public static long parseAttemptCount(String input) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new CarException(ErrorCode.INVALID_ATTEMPT_COUNT_FORMAT);
        }
    }
}
