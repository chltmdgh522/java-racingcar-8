package racingcar.domain.car.presentation.view;

import java.util.List;
import java.util.Objects;
import racingcar.domain.car.domain.entity.Car;
import racingcar.global.message.MessageCode;

public class OutputView {

    /**
     * 각 턴 결과 출력
     */
    public static void printRaceStatus(List<Car> cars) {
        System.out.println(MessageCode.RACE_STATUS_HEADER.getMessage());
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(Math.toIntExact(car.getDistance())));
        }
        System.out.println();
    }

    /**
     * 최종 우승자 출력
     */
    public static void printWinners(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(",");
        }

        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(MessageCode.RACE_WINNER_HEADER.getMessage());
        System.out.println(sb.toString().trim());
    }


    /**
     * 오류 메시지를 정해진 형식으로 출력
     *
     * @param message 출력할 오류 메시지
     */
    public static void printError(String message) {
        // 오류 형식에 메시지를 적용하여 출력
        System.out.println(String.format(MessageCode.ERROR_FORMAT.getMessage(), message));
    }
}
