package com.romanfill.modules.app;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.bank.impl.DefaultBank;
import com.romanfill.modules.cloud.service.impl.DefaultService;
import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.BankCardType;
import com.romanfill.modules.dto.Subscription;
import com.romanfill.modules.dto.User;
import com.romanfill.modules.service.api.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public class App {
    public static void main(String[] args) {
        ServiceLoader<Bank> bankServiceLoader = ServiceLoader.load(Bank.class);
        ServiceLoader<Service> serviceServiceLoader = ServiceLoader.load(Service.class);
        final Bank bank = bankServiceLoader.findFirst().get();
        final Service service = serviceServiceLoader.findFirst().get();
        final User roman = new User("Roman", "Filiyutich", LocalDate.of(1999, Month.MARCH, 5));
        final User james = new User("James", "Baley", LocalDate.of(1990, Month.AUGUST, 20));
        final User john = new User("John", "Tompson", LocalDate.of(2000, Month.APRIL, 15));

        final BankCard romansBankCard = bank.createBankCard(roman, BankCardType.CREDIT);
        final BankCard jamessBankCard = bank.createBankCard(james, BankCardType.CREDIT);
        final BankCard johnsBankCard = bank.createBankCard(john, BankCardType.DEBIT);

        service.subscribe(romansBankCard);
        service.subscribe(jamessBankCard);
        service.subscribe(johnsBankCard);

        final List<User> allUsers = service.getAllUsers();
        System.out.println("Bank users:");
        allUsers.forEach(System.out::println);

        final Optional<Subscription> optionalSub = service.getSubscriptionByBankCardNumber(romansBankCard.getNumber());
        try {
            final Subscription foundSubscription = optionalSub.orElseThrow(SubscriptionNotFoundException::new);
            System.out.println("Subscription found: " + foundSubscription);
        } catch (SubscriptionNotFoundException exception) {
            System.out.println("Subscription not found");
        }

        final List<Subscription> thisYearSubscriptions = service.getAllSubscriptionsByCondition(subscription -> subscription.getStartDate().getYear() == LocalDate.now().getYear());
        System.out.println("Subscriptions which have been made this year: ");
        thisYearSubscriptions.forEach(System.out::println);
    }
}
