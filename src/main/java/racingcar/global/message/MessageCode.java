package racingcar.global.message;

public enum MessageCode {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),

    RACE_STATUS_HEADER("각 턴 결과"),
    RACE_WINNER_HEADER("최종 우승자 : "),
    ERROR_FORMAT("오류: %s");

    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
