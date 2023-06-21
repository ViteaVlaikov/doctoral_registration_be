package usm.api.doctoral_registration.crosstab;

import usm.api.doctoral_registration.exception.request.UpperCriteriaNotFoundException;
import usm.api.doctoral_registration.repository.student.StudentFilter;

import java.util.*;

import static usm.api.doctoral_registration.repository.student.StudentFilter.*;

public class StudentCrossTab implements CrossTab {
    private static final List<StudentFilter> UPPER_CRITERIA = List.of(SPECIALITY_ID, PROFILE_ID, BRANCH_ID, DOMAIN_ID, SCHOOL_ID);
    private static final List<StudentFilter> LOWER_CRITERIA = List.of(GENDER, STATUS, FINANCING, REGISTRATION, STUDY_TYPE,
            YEAR, YEAR_BIRTH, YEAR_BEGIN, YEAR_END, FULL_NAME, EMAIL, IDENT_NUMBER, CITIZENSHIP, DIPLOMA,
            TELEPHONE_NUMBER, SUPERVISOR, STEERING_COMMITTEE);

    List<Item> items;

    @SuppressWarnings("unused")
    public StudentCrossTab(Map<String, String> params) {
//        StudentFilter upperCriteria = findUpperCriteria(params);
//        List<StudentFilter> leftCriteriaList = findLeftCriteriaList(params);
//        List<String> upperCriteriaList = parseStringToList(params.get(upperCriteria.getField()));
//        List<List<String>> list = leftCriteriaList.stream()
//                .map(StudentFilter::getField)
//                .map(criteria -> parseStringToList(params.get(criteria)))
//                .toList();
//        List<Map<Integer,String>> allCombinations = generateCombinations(list);
    }

    @SuppressWarnings("unused")
    private static List<Map<Integer, String>> generateCombinations(List<List<String>> lists) {
        List<Map<Integer, String>> result = new ArrayList<>();
        generateCombinationsHelper(lists, 0, new ArrayList<>(), result);
        return result;
    }
    private static void generateCombinationsHelper(List<List<String>> lists, int index, List<String> current,
                                                   List<Map<Integer, String>> result) {
        if (index == lists.size()) {
            Map<Integer, String> combination = new HashMap<>();
            for (int i = 0; i < current.size(); i++) {
                combination.put(i, current.get(i));
            }
            result.add(combination);
            return;
        }

        for (String element : lists.get(index)) {
            if (current.contains(element) && current.lastIndexOf(element) >= index) {
                continue;
            }
            current.add(element);
            generateCombinationsHelper(lists, index + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    @SuppressWarnings("unused")
    private List<String> parseStringToList(String string){
        return Arrays.stream(string.split(",")).map(String::new).toList();
    }

    private List<StudentFilter> findLeftCriteriaList(Map<String, String> params) {
        return params.keySet().stream()
                .map(StudentFilter::findByField)
                .filter(this::isLowerCriteria)
                .toList();
    }

    @SuppressWarnings("unused")
    private StudentFilter findUpperCriteria(Map<String, String> params) {
        return params.keySet().stream()
                .map(StudentFilter::findByField)
                .filter(this::isUpperCriteria)
                .findFirst()
                .orElseThrow(UpperCriteriaNotFoundException::new);
    }

    private boolean isLowerCriteria(StudentFilter criteria) {
        return LOWER_CRITERIA.contains(criteria);
    }

    private boolean isUpperCriteria(StudentFilter criteria) {
        return UPPER_CRITERIA.contains(criteria);
    }
}
