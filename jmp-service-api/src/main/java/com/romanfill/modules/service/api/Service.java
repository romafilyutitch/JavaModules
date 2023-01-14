package com.romanfill.modules.service.api;

import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.Subscription;
import com.romanfill.modules.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();
}
