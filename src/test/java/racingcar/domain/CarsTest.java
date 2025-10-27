package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("생성자가 전달받은 이름 리스트로 객체를 잘 생성했는지")
    void constructor_creates_cars_list_correctly() {
        Cars cars = new Cars(List.of("pobi", "woni"));
        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni");
    }

    @Test
    @DisplayName("랜덤값과 기준에 따라 각각의 자동차가 이동하는지")
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
    @DisplayName("단독 우승자만 반환하는지")
    void findWinners_returns_single_winner() {
        Cars cars = new Cars(List.of("pobi","woni","jun"));
        cars.moveAll(List.of(4, 3, 3)); // a:+1, b:+0, c:+0
        assertThat(cars.findWinners()).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자가 있으면 반환하는지")
    void findWinners_returns_all_ties() {
        Cars cars = new Cars(List.of("pobi","woni","jun"));
        cars.moveAll(List.of(4, 4, 3)); // pobi:+1, woni:+1, jun:+0

        assertThat(cars.findWinners())
                .containsExactlyInAnyOrder("pobi","woni");
    }
}