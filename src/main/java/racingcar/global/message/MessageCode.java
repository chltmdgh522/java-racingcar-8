package racingcar.global.message;

public enum MessageCode {
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
