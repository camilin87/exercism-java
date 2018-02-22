import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDate() {
        return this.birthDateTime.plusSeconds(1000000000);
    }
}
