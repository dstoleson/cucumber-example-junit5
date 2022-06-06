package parallel;


import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

import java.io.FileWriter;
import java.io.IOException;

public class FailedTagsHandler implements EventListener {

    private static final String FAILED_TAGS_FILE_NAME = "failed_tags.txt";

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, event -> {
        });

        publisher.registerHandlerFor(TestRunFinished.class, event -> {
            try (final FileWriter failureFileWriter = new FileWriter(FAILED_TAGS_FILE_NAME)) {
                System.out.format("Writing Failed Tags File: %s", FAILED_TAGS_FILE_NAME);
                failureFileWriter.write(String.join(" and ", CucumberHookHandler.getFailedTags()));
                failureFileWriter.write("\n");
            } catch (IOException e) {
                throw new RuntimeException("Problem writing to tags file: " + FAILED_TAGS_FILE_NAME, e.getCause());
            }
        });
    }
}