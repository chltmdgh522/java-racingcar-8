package racingcar.domain.car.presentation.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.error.CarException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 파싱")
    void parseValidCarNames() {
        // Given
        String input = "pobi,woni,jun";

        // When
        List<String> carNames = InputParser.parseCarNames(input);

        // Then
        assertThat(carNames).hasSize(3);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어 있는 경우 정상적으로 처리")
    void parseCarNamesWithSpaces() {
        // Given
        String input = "pobi, woni , jun";

        // When
        List<String> carNames = InputParser.parseCarNames(input);

        // Then
        assertThat(carNames).hasSize(3);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ",", ",,", " , "})
    @DisplayName("빈 문자열이나 잘못된 구분자 입력 시 예외 발생")
    void parseInvalidCarNames(String input) {
        // Then
        assertThatThrownBy(() -> InputParser.parseCarNames(input))
                .isInstanceOf(CarException.class);
    }

    @Test
    @DisplayName("시도 횟수 파싱 테스트")
    void parseValidAttemptCount() {
        // Given
        String input = "5";

        // When
        long count = InputParser.parseAttemptCount(input);

        // Then
        assertThat(count).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "one"})
    @DisplayName("숫자가 아닌 시도 횟수 입력 시 예외 발생")
    void parseInvalidAttemptCount(String input) {
        // Then
        assertThatThrownBy(() -> InputParser.parseAttemptCount(input))
                .isInstanceOf(CarException.class);
    }
}