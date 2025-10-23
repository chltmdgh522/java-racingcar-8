package racingcar.domain.car.presentation.view;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import racingcar.domain.car.domain.entity.Car;

public class OutputView {

    /**
     * 최종 우승자 출력
     */
    public static void printWinners(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        long maxDistance = 0L;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                sb = new StringBuilder();
                maxDistance = car.getDistance();
                sb.append(car.getName()).append(",");
            } else if (Objects.equals(car.getDistance(), maxDistance)) {
                sb.append(car.getName()).append(",");
            }
        }

        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print("최종 우승자 : ");
        System.out.println(sb.toString().trim());
    }

    /**
     * 각 턴 결과 출력
     */
    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(Math.toIntExact(car.getDistance())));
        }
        System.out.println();
    }
}
