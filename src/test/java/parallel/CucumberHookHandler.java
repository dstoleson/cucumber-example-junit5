package parallel;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CucumberHookHandler implements En {

//    private static final List<String> failedTags = new ArrayList<>();

    CucumberHookHandler() {
        Before(() -> {
        });

        After((Scenario scenario) -> {
            System.out.format("AFTER Scenario: %s, status: %s, with tags: %s\n",
                    scenario.getName(),
                    scenario.getStatus(),
                    scenario.getSourceTagNames());
//            if (scenario.isFailed()) {
//                failedTags.add(String.format("(%s)", String.join(" and ", scenario.getSourceTagNames())));
//            }
        });

        BeforeStep((Scenario scenario) -> {
            System.out.format("BEFORE Step: %s, line: %d\n",
                    scenario.getName(),
                    scenario.getLine());
        });

        AfterStep((Scenario scenario) -> {
            System.out.format("AFTER Step: %s, line %d, status: %s\n",
                    scenario.getName(),
                    scenario.getLine(),
                    scenario.getStatus());
        });
    }

    public static List<String> getFailedTags() {
        return Arrays.stream("x,x".split(",")).toList();
//        return failedTags.stream().toList();
    }
}
