package racingcar.domain.car.application.service;

import java.util.List;
import racingcar.domain.car.domain.entity.Car;

/**
 * 자동차 경주 기능을 정의하는 서비스 인터페이스.
 * <p>
 * 경주 준비, 진행, 결과 조회 등의 핵심 메서드를 제공한다.
 */
public interface RacingCarService {

    /**
     * 경주를 시작하기 전에 자동차 목록을 초기화한다.
     *
     * @param car 경주에 참여할 자동차 리스트
     */
    void setupRace(List<Car> car);

    /**
     * 지정된 횟수만큼 자동차 경주를 진행한다.
     *
     * @param attemptCount 시도 횟수
     */
    void playRace(long attemptCount);

    /**
     * 가장 멀리 이동한 자동차(우승자) 목록을 반환한다.
     *
     * @return 우승 자동차 리스트
     */
    List<Car> winnerCars();
}
