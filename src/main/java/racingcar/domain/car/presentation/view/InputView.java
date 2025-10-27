package racingcar.domain.car.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.presentation.util.InputParser;
import racingcar.domain.car.presentation.util.InputValidator;
import racingcar.global.error.CarException;
import racingcar.global.message.MessageCode;

/**
 * 사용자 입력을 처리하는 콘솔 기반 뷰 클래스.
 * <p>
 * 프로그램 실행에 필요한 데이터를 생성한다.
 */
public class InputView {

    private InputView() {
    }

    /**
     * 사용자로부터 자동차 이름 목록을 입력받는다.
     * <p>
     * 입력 형식: 이름1,이름2,이름3 … 입력받은 문자열을 파싱 및 검증 후 {@link Car} 객체 리스트로 반환한다.
     *
     * @return 자동차 리스트
     */
    public static List<Car> inputCars() {
        System.out.println(MessageCode.INPUT_CAR_NAMES);

        String input = Console.readLine();
        List<String> carNames = InputParser.parseCarNames(input);
        InputValidator.validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    /**
     * 사용자로부터 시도 횟수를 입력받는다.
     * <p>
     * 입력값을 숫자로 파싱 및 검증 후 반환한다.
     *
     * @return 시도 횟수 (long)
     */
    public static long inputAttemptCount() {
        System.out.println(MessageCode.INPUT_ATTEMPT_COUNT);

        String input = Console.readLine();
        long count = InputParser.parseAttemptCount(input);
        InputValidator.validateAttemptCount(count);

        return count;
    }
}
