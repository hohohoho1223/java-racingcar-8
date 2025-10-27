package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("랜덤값이 4 이상이면 전진")
    @ValueSource(ints = {4, 5, 9})
    void move_forward_when_ge_4(int rand) {
        Car car = new Car("pobi");
        car.move(rand);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 3 이하면 정지")
    @ValueSource(ints = {0, 1, 2, 3})
    void stay_when_lt_4(int rand) {
        Car car = new Car("pobi");
        car.move(rand);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @DisplayName("유효한 이름(1~5자)")
    @CsvSource({"a","ab","abc","abcd","abcde"})
    void valid_name(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("공백/빈 문자열이면 예외")
    @ValueSource(strings = {"", " ", "   "})
    void blank_name_throws(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @ParameterizedTest
    @DisplayName("null 이름이면 예외(도메인 방어)")
    @NullSource
    void null_name_throws(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름 5자 초과면 예외")
    @ValueSource(strings = {"abcdef", "123456"})
    void over_five_throws(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }
}