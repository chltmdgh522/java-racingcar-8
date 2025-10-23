package racingcar.domain.car.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.domain.entity.Car;

/**
 * 사용자로부터 입력을 받는 뷰 클래스 콘솔 입력을 처리하고 사용자에게 안내 메시지 출력
 */
public class InputView {

    private InputView() {

    }

    /**
     * 자동차 이름 입력 및 저장
     */
    public static List<Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            // validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }


    /**
     * 시도 횟수 입력
     */
    public static long inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        long count = Long.parseLong(Console.readLine());
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
        return count;
    }


    /**
     * 자동차 이름 유효성 검사
     */
    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}

