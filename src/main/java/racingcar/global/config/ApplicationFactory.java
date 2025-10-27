package racingcar.global.config;

import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.application.service.impl.RacingCarServiceImpl;
import racingcar.domain.car.domain.repository.CarRepository;
import racingcar.domain.car.presentation.controller.CarController;

/**
 * 애플리케이션의 객체 생성 및 의존성 주입을 담당하는 팩토리 클래스
 */
public class ApplicationFactory {

    private ApplicationFactory() {
    }

    /**
     * 애플리케이션 실행기를 생성하고 필요한 의존성을 주입
     *
     * @return 구성된 ApplicationRunner 객체
     */
    public static ApplicationRunner createApplicationRunner() {
        CarRepository carRepository = createCarRepository();
        RacingCarService racingCarService = createRacingCarService(carRepository);
        CarController carController = createCarController(racingCarService);
        return new ApplicationRunner(carController);
    }

    /**
     * 레이싱카 컨트롤러 생성
     *
     * @param racingCarService 레이싱 서비스 구현체
     * @return 구성된 CarController 객체
     */
    private static CarController createCarController(RacingCarService racingCarService) {
        return new CarController(racingCarService);
    }

    /**
     * 레이싱 서비스 구현체 생성
     *
     * @param carRepository 자동차 저장 구현체
     * @return 구성된 RacingCarService 객체
     */
    private static RacingCarService createRacingCarService(CarRepository carRepository) {
        return new RacingCarServiceImpl(carRepository);
    }


    /**
     * 레이싱 서비스 구현체 생성
     *
     * @return 구성된 CarRepository 객체
     */
    private static CarRepository createCarRepository() {
        return new CarRepository();
    }
}