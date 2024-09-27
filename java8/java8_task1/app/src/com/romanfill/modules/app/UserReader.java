package com.romanfill.modules.app;

import com.romanfill.modules.dto.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserReader {

    private static final Path USERS_FILE_PATH = Paths.get("java8/java8_task1/app/resources/users.txt");

    public static List<User> readUsers() {
        try {
            final List<String> lines = Files.readAllLines(USERS_FILE_PATH);
            return lines.stream()
                    .map(UserReader::buildUser)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private static User buildUser(String line) {
        final String[] userData = line.split("\\s+");
        final String firstName = userData[0];
        final String lastName = userData[1];
        final int year = Integer.parseInt(userData[2]);
        final Month month = Month.valueOf(userData[3].toUpperCase());
        final int day = Integer.parseInt(userData[4]);
        return new User(firstName, lastName, LocalDate.of(year, month, day));
    }
}
