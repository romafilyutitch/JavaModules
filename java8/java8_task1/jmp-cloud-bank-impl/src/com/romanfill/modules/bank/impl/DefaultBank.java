package com.romanfill.modules.bank.impl;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.BankCardType;
import com.romanfill.modules.dto.User;

import java.util.Random;
import java.util.function.BiFunction;

public class DefaultBank implements Bank {
    private static final int CARD_NUMBER_UPPER_BOUND = 100;
    private static final String INVALID_CREDIT_CARD_TYPE = "Invalid credit card type provided";
    private final Random rand = new Random();

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        if (cardType == null) {
            throw new IllegalArgumentException(INVALID_CREDIT_CARD_TYPE);
        }
        final String cardNumber = Integer.toString(rand.nextInt(CARD_NUMBER_UPPER_BOUND));
        final BiFunction<String, User, BankCard> bankCardSupplier = cardType.getBankCardBuilder();
        return bankCardSupplier.apply(cardNumber, user);
    }
}
