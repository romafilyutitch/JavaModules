package com.romanfill.modules.app;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.BankCardType;
import com.romanfill.modules.dto.Subscription;
import com.romanfill.modules.dto.User;
import com.romanfill.modules.service.api.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

    private static final String BANK_USERS_TEXT = "Bank users:";
    private static final String THIS_YEAR_SUBSCRIPTIONS_TEXT = "Subscriptions which have been made this year: ";
    private static final String FAKE_CARD_NUMBER = "12345";
    private static final String SUBSCRIPTION_NOT_FOUND_TEXT = "Subscription was not found";

    public static void main(String[] args) {
        final Bank bank = ServiceSupplier.getBankService();
        final Service service = ServiceSupplier.getServiceLoader();
        final List<User> users = UserReader.readUsers();

        List<BankCard> bankCards = users.stream()
                .map(user -> bank.createBankCard(user, BankCardType.CREDIT))
                .collect(Collectors.toList());
        bankCards.forEach(service::subscribe);

        final List<User> allUsers = service.getAllUsers();
        System.out.println(BANK_USERS_TEXT);
        allUsers.forEach(System.out::println);

        final List<Subscription> thisYearSubscriptions = service.getAllSubscriptionsByCondition(subscription -> subscription.getStartDate().getYear() == LocalDate.now().getYear());
        System.out.println(THIS_YEAR_SUBSCRIPTIONS_TEXT);
        thisYearSubscriptions.forEach(System.out::println);

        try {
            final Optional<Subscription> optionalSub = service.getSubscriptionByBankCardNumber(FAKE_CARD_NUMBER);
            final Subscription foundSubscription = optionalSub.orElseThrow(SubscriptionNotFoundException::new);
            System.out.println(foundSubscription);
        } catch (SubscriptionNotFoundException exception) {
            System.out.println(SUBSCRIPTION_NOT_FOUND_TEXT);
        }

    }
}
