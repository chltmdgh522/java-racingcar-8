package racingcar.domain.car.presentation.view;

import java.util.List;
import racingcar.domain.car.domain.entity.Car;
import racingcar.global.message.MessageCode;

/**
 * 자동차 경주의 결과를 콘솔에 출력하는 뷰 클래스.
 * <p>
 * 각 턴의 진행 상황, 최종 우승자, 오류 메시지 등을
 * 정해진 형식에 따라 출력한다.
 */
public class OutputView {

    private OutputView() {
    }

    /**
     * 각 턴의 자동차 경주 결과를 출력한다.
     * <p>
     * 자동차 이름과 이동 거리에 따라 '-' 문자를 반복 출력하여
     * 진행 상태를 시각적으로 표시한다.
     *
     * @param cars 현재 턴의 자동차 리스트
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
     * 최종 우승자를 출력한다.
     * <p>
     * 여러 명의 우승자가 있을 경우 이름을 쉼표(,)로 구분하여 표시한다.
     *
     * @param cars 우승한 자동차 리스트
     */
    public static void printWinners(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(",");
        }

        // 마지막 쉼표 제거
        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(MessageCode.RACE_WINNER_HEADER.getMessage());
        System.out.println(sb.toString().trim());
    }

    /**
     * 오류 메시지를 지정된 형식에 맞춰 출력한다.
     *
     * @param message 출력할 오류 메시지
     */
    public static void printError(String message) {
        System.out.println(String.format(MessageCode.ERROR_FORMAT.getMessage(), message));
    }
}
