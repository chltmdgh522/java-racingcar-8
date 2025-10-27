package racingcar.domain.car.presentation.util;

import java.util.Arrays;
import java.util.List;
import racingcar.global.error.CarException;
import racingcar.global.error.ErrorCode;

/**
 * 사용자 입력값을 파싱하는 유틸리티 클래스.
 * <p>
 * 문자열 형태로 입력받은 자동차 이름과 시도 횟수를
 * 프로그램에서 사용 가능한 데이터 형태로 변환한다.
 */
public class InputParser {

    private InputParser() {
    }

    /**
     * 입력받은 자동차 이름 문자열을 쉼표(,) 기준으로 분리하여 리스트로 반환한다.
     * <p>
     * 파싱 과정에서 입력이 비어 있거나 공백만 있는 경우 예외를 발생시킨다.
     *
     * @param input 사용자 입력 문자열
     * @return 자동차 이름 리스트
     * @throws CarException {@link ErrorCode#EMPTY_CAR_NAME_INPUT} 발생 (빈 입력 또는 유효하지 않은 형식일 경우)
     */
    public static List<String> parseCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new CarException(ErrorCode.EMPTY_CAR_NAME_INPUT);
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        // 쉼표만 입력된 경우 또는 모든 값이 공백인 경우 예외 발생
        if (carNames.isEmpty() || carNames.stream().allMatch(String::isBlank)) {
            throw new CarException(ErrorCode.EMPTY_CAR_NAME_INPUT);
        }

        return carNames;
    }

    /**
     * 시도 횟수 입력값을 long 타입으로 변환한다.
     * <p>
     * 숫자 이외의 값이 입력된 경우 예외를 발생시킨다.
     *
     * @param input 사용자 입력 문자열
     * @return 변환된 시도 횟수(long)
     * @throws CarException {@link ErrorCode#INVALID_ATTEMPT_COUNT_FORMAT} 발생 (숫자 형식이 아닐 경우)
     */
    public static long parseAttemptCount(String input) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new CarException(ErrorCode.INVALID_ATTEMPT_COUNT_FORMAT);
        }
    }
}
