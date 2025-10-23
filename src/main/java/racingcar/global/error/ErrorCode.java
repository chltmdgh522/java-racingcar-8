package racingcar.global.error;

public enum ErrorCode {
    INVALID_CAR_NAME_LENGTH("자동차 이름 '{0}'은(는) 1자 이상 5자 이하만 가능합니다."),
    INVALID_ATTEMPT_COUNT("입력된 시도 횟수 '{0}'은(는) 1회 이상이어야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
