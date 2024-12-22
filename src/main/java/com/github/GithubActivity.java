package com.github;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.github.exception.UserActivityException;
import com.github.model.Activity;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Command(
        name = "github-activity",
        description = "Track user activity on Github."
)
class GithubActivity implements Callable<Integer> {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Parameters(index = "0", description = "Github user name.")
    private String username;

    @Override
    public Integer call() throws Exception {
        List<Activity> activities = getUserActivities();
        if (activities.isEmpty()) {
            throw new UserActivityException("Cannot get user activity.");
        }

        activities = activities.stream()
                .filter(activity -> activity.getCreatedAt().toLocalDate().equals(LocalDate.now()))
                .collect(Collectors.toList());

        System.out.println(username + " has " + activities.size() + " public activities today!");

        return 0;
    }

    private List<Activity> getUserActivities() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + username + "/events"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), new TypeReference<List<Activity>>() {});
            }
        } catch (Exception e) {
            throw new UserActivityException("Cannot get user activity.", e);
        }

        return new ArrayList<>();
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new GithubActivity()).execute(args);
        System.exit(exitCode);
    }
}