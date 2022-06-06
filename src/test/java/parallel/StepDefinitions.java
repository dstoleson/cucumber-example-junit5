package parallel;

import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions implements En {

    public StepDefinitions() {
        Given("{string}", (String scenario) -> {
            System.out.format("Thread ID - %2d - %s\n",
                    Thread.currentThread().getId(), scenario);
            if (scenario.contains("Z") || scenario.contains("0")) {
                Assertions.fail("Nope.");
            }
        });
    }
}
