package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private static final int SAME_CAR_COMPARE_VALUE = 0;
    private static final int MAX_MOVEMENT_VALUE = 9;

    private final List<Car> cars;

    public CarManager(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsRandomly() {
        this.cars.forEach(car -> car.move(makeRandomCarMove()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        final Car maxCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.compareTo(maxCar) == SAME_CAR_COMPARE_VALUE)
                .collect(Collectors.toList());
    }

    private CarMovement makeRandomCarMove() {
        final int randomCorrectionValue = 1;
        final int moveCount = (int) (Math.random() * MAX_MOVEMENT_VALUE + randomCorrectionValue);
        return new CarMovement(moveCount);
    }
}
