package racingcar.global.error;

public class CarException extends IllegalArgumentException {
    private final ErrorCode errorCode;
    private final String detail;

    public CarException(ErrorCode errorCode, String detail) {
        super(errorCode.getMessage().replace("{0}", detail));
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDetail() {
        return detail;
    }
}
