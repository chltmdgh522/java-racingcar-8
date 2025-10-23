package racingcar.global.config;

import racingcar.domain.car.application.service.CarDataService;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.application.service.impl.CarDataServiceImpl;
import racingcar.domain.car.application.service.impl.RacingCarServiceImpl;
import racingcar.domain.car.domain.repository.CarRepository;
import racingcar.domain.car.presentation.controller.CarController;

/**
 * 애플리케이션의 객체 생성 및 의존성 주입을 담당하는 팩토리 클래스
 */
public class ApplicationFactory {

    /**
     * 인스턴스화 방지
     */
    private ApplicationFactory() {
    }

    /**
     * 애플리케이션 실행기를 생성하고 필요한 의존성을 주입
     *
     * @return 구성된 ApplicationRunner 객체
     */
    public static ApplicationRunner createApplicationRunner() {
        CarRepository carRepository = createCarRepository();
        CarDataService carDataService = createCarCrudService(carRepository);
        RacingCarService racingCarService = createRacingCarService(carDataService);
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
     * @param carDataService 자동차 데이터 구현체
     * @return 구성된 RacingCarService 객체
     */
    private static RacingCarService createRacingCarService(CarDataService carDataService) {
        return new RacingCarServiceImpl(carDataService);
    }

    /**
     * 레이싱카 조회 및 저장 서비스 구현체 생성
     *
     * @param carRepository DB 구현체
     * @return 구성된 CarCrudService 객체
     */
    private static CarDataService createCarCrudService(CarRepository carRepository) {
        return new CarDataServiceImpl(carRepository);
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