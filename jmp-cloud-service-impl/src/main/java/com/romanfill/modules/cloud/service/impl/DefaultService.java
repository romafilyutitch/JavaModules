package com.romanfill.modules.cloud.service.impl;

import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.Subscription;
import com.romanfill.modules.dto.User;
import com.romanfill.modules.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultService implements Service {

    private List<Subscription> subscriptions = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        final var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        final var user = bankCard.getUser();
        subscriptions.add(subscription);
        users.add(user);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getBankcard().equals(cardNumber))
                .findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return users.stream().collect(Collectors.toUnmodifiableList());
    }
}
