package usm.api.doctoral_registration.tools.string;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.exception.entity.SupervisorNotFoundException;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class StringParser {

    private final SupervisorRepository supervisorRepository;

    public Supervisor parseStringToSupervisor(String s) {
        Supervisor supervisor = new Supervisor();

        try {
            String pattern = "[A-ZА-ЯĂÂÎȘȚ][a-zA-ZĂÂÎȘȚăâîșțA-Za-z]*";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(s);

            int count = 0;
            List<String> fullName = new ArrayList<>(2);

            while (matcher.find()) {
                fullName.add(matcher.group());

                if (count < 2) {
                    count++;
                } else {
                    break;
                }
            }
            if (count < 2) {
                throw new RuntimeException("Incorrect data in string");
            }
            supervisor = supervisorRepository.findByFirstNameAndLastName(fullName.get(1), fullName.get(0))
                    .orElseThrow(() -> new SupervisorNotFoundException(fullName.get(0) + " " + fullName.get(1)));
        } catch (RuntimeException e) {
            return supervisor;
        }

        return supervisor;
    }

    public Set<Supervisor> parseStringToSteeringCommittee(String s) {
        Set<Supervisor> steeringCommittee = new HashSet<>();

        try {
            String pattern = "^[A-ZА-ЯĂÂÎȘȚ][a-zA-ZĂÂÎȘȚăâîșțA-Za-z]*\\b\\s+\\b[A-ZА-ЯĂÂÎȘȚ][a-zA-ZĂÂÎȘȚăâîșțA-Za-z]*";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(s);

            List<String> fullNames = new ArrayList<>();

            while (matcher.find()) {
                fullNames.add(matcher.group());
            }
            for (String fullName : fullNames) {
                String firstName = fullName.split(" ")[1];
                String lastName = fullName.split(" ")[0];
                Supervisor supervisor = supervisorRepository.findByFirstNameAndLastName(firstName, lastName)
                        .orElseThrow(() -> new SupervisorNotFoundException(fullName));
                steeringCommittee.add(supervisor);
            }
        } catch (RuntimeException e) {

        }

        return steeringCommittee;


    }
}
