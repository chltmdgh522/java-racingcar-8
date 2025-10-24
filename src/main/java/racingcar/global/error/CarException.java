package racingcar.global.error;

public class CarException extends IllegalArgumentException {
    private final ErrorCode errorCode;

    public CarException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
