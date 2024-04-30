package roomescape.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReservationTest {

    @Test
    @DisplayName("올바른 입력시 객체를 생성한다.")
    void validReservation() {
        assertThat(new Reservation("abc", LocalDate.now(), new ReservationTime(LocalTime.now()))).isNotNull();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("예약자명에 대한 입력이 올바르지 않으면 예외가 발생한다.")
    void invalidNameReservation(String name) {
        assertThatThrownBy(() -> new Reservation(name, LocalDate.now(), new ReservationTime(LocalTime.now())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("날짜에 대한 입력이 올바르지 않으면 예외가 발생한다.")
    void invalidDate() {
        assertThatThrownBy(() -> new Reservation("abc", null, new ReservationTime(LocalTime.now())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예약시간이 올바르지 않으면 예외가 발생한다.")
    void invalidTime() {
        assertThatThrownBy(() -> new Reservation("abc", LocalDate.now(), null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}