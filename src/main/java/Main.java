import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        OptionalInt maxSalary = staff.stream()
                .filter(employee -> employee.getWorkStart().getYear() == 2017)
                .mapToInt(Employee::getSalary)
                .max();

        if (maxSalary.isPresent()) {
            System.out.println("Max salary in 2017: " + maxSalary.getAsInt());
        } else {
            System.out.println("No employees has been hired in 2017.");
        }

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
            LocalDateTime dateNow = LocalDateTime.now();

            return airport.getTerminals().stream()
                    .flatMap(terminal -> terminal.getFlights().stream())
                    .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                    .filter(flight -> modifiedDate(flight)
                            .isAfter(dateNow) && modifiedDate(flight)
                            .isBefore(dateNow.plusHours(2)))
                    .collect(Collectors.toList());
        }

        public static LocalDateTime modifiedDate(Flight date) {
            return LocalDateTime
                    .ofInstant(date.getDate().toInstant(), ZoneId.systemDefault());
        }
    }

}