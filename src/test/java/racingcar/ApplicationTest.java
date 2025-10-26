package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("랜덤 값이 4 이상일 때만 자동차가 전진하는지 확인")
    void moveCar_WhenRandomIsAtLeastFour() {
        // Given: 랜덤 값이 4로 고정된 상태
        // When & Then: "pobi"라는 이름의 자동차로 1회 시도했을 때 출력에 "-"가 포함되어 있는지 확인
        assertRandomNumberInRangeTest(
                () -> {
                    // When
                    run("pobi", "1");

                    // Then
                    assertThat(output()).contains("pobi : -");
                },
                4 // 랜덤 값을 4로 설정 - 전진해야 함
        );
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 때는 자동차가 전진하지 않는지 확인")
    void moveCar_WhenRandomIsLessThanFour() {
        // Given: 랜덤 값이 3으로 고정된 상태
        // When & Then: "pobi"라는 이름의 자동차로 1회 시도했을 때 출력에 "-"가 없는지 확인
        assertRandomNumberInRangeTest(
                () -> {
                    // When
                    run("pobi", "1");

                    // Then
                    assertThat(output()).contains("pobi : ");
                    assertThat(output()).doesNotContain("pobi : -");
                },
                3 // 랜덤 값을 3으로 설정 - 전진하지 않아야 함
        );
    }

    @Test
    @DisplayName("기능 통합 테스트 - 전체 레이스 과정")
    void completeRaceIntegrationTest() {
        // Given: pobi는 항상 전진하고(4), woni는 항상 정지하는(3) 상태
        // When & Then: 두 자동차로 3회 시도했을 때 pobi가 우승자로 출력되는지 확인
        assertRandomNumberInRangeTest(
                () -> {
                    // When
                    run("pobi,woni", "3");

                    // Then
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                4, 4, 4,  // pobi 3번 전진
                3, 3, 3   // woni 0번 전진
        );
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void tiedWinners() {
        // Given: 모든 자동차가 항상 전진하는(4) 상태
        // When & Then: 두 자동차로 2회 시도했을 때 두 자동차가 공동 우승자로 출력되는지 확인
        assertRandomNumberInRangeTest(
                () -> {
                    // When
                    run("pobi,woni", "2");

                    // Then
                    assertThat(output()).contains("최종 우승자 : pobi,woni");
                },
                4, 4,  // pobi 2번 전진
                4, 4   // woni 2번 전진
        );
    }

    @Test
    @DisplayName("이름이 5자를 초과하는 자동차가 있을 경우 예외 발생")
    void validateCarNames_TooLong() {
        // Given: 5자를 초과하는 자동차 이름 "javaji"
        // When & Then: 실행 시 IllegalArgumentException 예외가 발생하는지 확인
        assertThatThrownBy(() -> {
            // When
            runException("pobi,javaji", "1");

            // Then: IllegalArgumentException이 발생해야 함
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외 발생")
    void validateDuplicateCarNames() {
        // Given: 중복된 자동차 이름 "pobi"가 포함된 입력
        // When & Then: 실행 시 IllegalArgumentException 예외가 발생하는지 확인
        assertThatThrownBy(() -> {
            // When
            runException("pobi,woni,pobi", "1");

            // Then: IllegalArgumentException이 발생해야 함
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 시도 횟수 입력시 예외 발생")
    void validateInvalidAttemptCount() {
        // Given: 0, -1, 숫자가 아닌 입력값 "abc"
        // When & Then: 각 경우에 대해 실행 시 IllegalArgumentException 예외가 발생하는지 확인

        // 시도 횟수가 0인 경우
        assertThatThrownBy(() -> {
            // When
            runException("pobi,woni", "0");

            // Then: IllegalArgumentException이 발생해야 함
        }).isInstanceOf(IllegalArgumentException.class);

        // 시도 횟수가 음수인 경우
        assertThatThrownBy(() -> {
            // When
            runException("pobi,woni", "-1");

            // Then: IllegalArgumentException이 발생해야 함
        }).isInstanceOf(IllegalArgumentException.class);

        // 시도 횟수가 숫자가 아닌 경우
        assertThatThrownBy(() -> {
            // When
            runException("pobi,woni", "abc");

            // Then: IllegalArgumentException이 발생해야 함
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
