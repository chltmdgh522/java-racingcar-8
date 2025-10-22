package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.domain.entity.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        Map<String, Car> carRepository = inputCars();
        long attemptCount = inputAttemptCount();

        System.out.println("실행 결과\n");
        startRace(carRepository, attemptCount);
        printWinners(carRepository);
    }

    /** 자동차 이름 입력 및 저장 */
    private static Map<String, Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        Map<String, Car> cars = new LinkedHashMap<>();
        for (String name : carNames) {
            name = name.trim();
            validateCarName(name);
            Car car = new Car(name);
            cars.put(car.getId(), car);
        }
        return cars;
    }

    /** 시도 횟수 입력 */
    private static long inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        long count = Long.parseLong(Console.readLine());
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
        return count;
    }

    /** 자동차 경주 시작 */
    private static void startRace(Map<String, Car> carRepository, long attemptCount) {
        while (attemptCount-- > 0) {
            moveCars(carRepository);
            printRaceStatus(carRepository);
        }
    }

    /** 각 자동차 이동 처리 */
    private static void moveCars(Map<String, Car> carRepository) {
        for (Car car : carRepository.values()) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.move();
            }
        }
    }

    /** 각 턴 결과 출력 */
    private static void printRaceStatus(Map<String, Car> carRepository) {
        for (Car car : carRepository.values()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(Math.toIntExact(car.getDistance())));
        }
        System.out.println();
    }

    /** 최종 우승자 출력 */
    private static void printWinners(Map<String, Car> carRepository) {
        StringBuilder sb = new StringBuilder();
        long maxDistance = 0L;

        for (Car car : carRepository.values()) {
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

    /** 자동차 이름 유효성 검사 */
    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
