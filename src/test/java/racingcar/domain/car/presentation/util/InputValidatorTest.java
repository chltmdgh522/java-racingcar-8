package racingcar.domain.car.presentation.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.error.CarException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("유효한 자동차 이름 목록 검증 성공")
    void validateValidCarNames() {
        // Given
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        // Then
        assertThatCode(() -> InputValidator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빈 자동차 이름 목록 검증 시 예외 발생")
    void validateEmptyCarNames() {
        // Given
        List<String> names = Collections.emptyList();

        // Then
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(CarException.class);
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름 검증 시 예외 발생")
    void validateTooLongCarName() {
        // Given
        List<String> names = Arrays.asList("pobi", "javaji", "woni");

        // Then
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(CarException.class);
    }

    @Test
    @DisplayName("중복된 자동차 이름 검증 시 예외 발생")
    void validateDuplicateCarNames() {
        // Given
        List<String> names = Arrays.asList("pobi", "woni", "pobi");

        // Then
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(CarException.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 3, 10, 100})
    @DisplayName("유효한 시도 횟수 검증 성공")
    void validateValidAttemptCount(long count) {
        // Then
        assertThatCode(() -> InputValidator.validateAttemptCount(count))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, -10})
    @DisplayName("0 이하의 시도 횟수 검증 시 예외 발생")
    void validateInvalidAttemptCount(long count) {
        // Then
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(count))
                .isInstanceOf(CarException.class);
    }
}