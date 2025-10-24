package racingcar.domain.car.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.presentation.util.InputParser;
import racingcar.domain.car.presentation.util.InputValidator;
import racingcar.global.error.CarException;
import racingcar.global.error.ErrorCode;
import racingcar.global.message.MessageCode;

/**
 * 사용자로부터 입력을 받는 뷰 클래스 콘솔 입력을 처리하고 사용자에게 안내 메시지 출력
 */
public class InputView {

    private InputView() {

    }

    /**
     * 자동차 이름 입력
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
     * 시도 횟수 입력
     */
    public static long inputAttemptCount() {
        System.out.println(MessageCode.INPUT_ATTEMPT_COUNT);

        String input = Console.readLine();
        long count = InputParser.parseAttemptCount(input);
        InputValidator.validateAttemptCount(count);

        return count;
    }


}

