package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final int MAKE_ONE_DIGIT_MULTIPLIER = 10;

    private final List<Car> cars;

    public Participants() {
        this.cars = new ArrayList<>();
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }

    public Integer participateSize() {
        return this.cars.size();
    }

    public void race() {
        for (RacingCar car : cars) {
            car.tryMove(makeRandomNumberBetweenZeroAndNine());
        }
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Name> findRacingWinners() {
        Integer maxPosition = findMaxPosition();
        return  cars.stream()
                .filter(car -> car.isWinnerPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Integer findMaxPosition() {
        return Collections
                .max(cars.stream()
                        .map(Car::getCarPosition)
                        .collect(Collectors.toList())
                );
    }

    private int makeRandomNumberBetweenZeroAndNine() {
        return (int) (Math.random() * MAKE_ONE_DIGIT_MULTIPLIER);
    }
}