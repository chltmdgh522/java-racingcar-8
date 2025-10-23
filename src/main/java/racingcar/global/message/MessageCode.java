package racingcar.global.message;

public enum MessageCode {
    INPUT_GUIDE("덧셈할 문자열을 입력해 주세요."),
    RESULT_FORMAT("결과 : %d"),
    ERROR_FORMAT("오류: %s");

    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
