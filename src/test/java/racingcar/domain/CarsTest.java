package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("")
    void moveAll_moves_each_car_with_corresponding_random() {
        Cars cars = new Cars(List.of("a","b","c"));
        cars.moveAll(List.of(4, 3, 9)); // a:+1, b:+0, c:+1

        assertThat(cars.getCars())
                .extracting(Car::getName, Car::getPosition)
                .containsExactly(
                        tuple("a", 1),
                        tuple("b", 0),
                        tuple("c", 1)
                );
    }

    @Test
    void findWinners_returns_all_ties() {
        Cars cars = new Cars(List.of("pobi","woni","jun"));
        cars.moveAll(List.of(4, 4, 3)); // pobi:+1, woni:+1, jun:+0

        assertThat(cars.findWinners())
                .containsExactlyInAnyOrder("pobi","woni");
    }
}