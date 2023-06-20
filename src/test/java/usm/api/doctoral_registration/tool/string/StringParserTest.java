package usm.api.doctoral_registration.tool.string;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.tools.string.StringParser;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StringParserTest {

    @Autowired
    private StringParser stringParser;

    @Test
    void shouldConvertCorrectStringToSupervisor() {
        String correctString = "Zbanț Ludmila, prof. univ., dr. hab. în filologie";
        String firstName = "Ludmila";
        String lastName = "Zbanț";

        Supervisor supervisor = stringParser.parseStringToSupervisor(correctString);

        assertEquals(firstName, supervisor.getFirstName());
        assertEquals(lastName, supervisor.getLastName());
    }

    @Test
    void shouldConvertCorrectStringToSteeringCommittee() {
        String correctString = """
                Tarnovschi Ana, conf. univ., dr. în psihologie (anterior Tolstaia Svetlana, conf. univ., dr. în psihologie)
                , conf. univ., dr. în psihologie
                Pavlenco Lilia, conf. univ., dr. în psihologie
                """;
        Set<String> committeeNames = new HashSet<>(Set.of("Tarnovschi Ana", "Antoci Diana", "Pavlenco Lilia"));

        Set<Supervisor> steeringCommittee = stringParser.parseStringToSteeringCommittee(correctString);
        for (Supervisor s : steeringCommittee) {
            assertTrue(committeeNames.contains(s.getLastName() + " " + s.getFirstName()));
        }
    }
}
