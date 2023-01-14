package com.romanfill.modules.bank.impl;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.dto.*;

import java.util.Random;
import java.util.function.BiFunction;

public class DefaultBank implements Bank {
    private Random rand = new Random();
    private BiFunction<String, User, BankCard> creditCardSupplier = CreditBankCard::new;
    private BiFunction<String, User, BankCard> debitCardSupplier = DebitBankCard::new;


    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        final String cardNumber = Integer.toString(rand.nextInt(100));
        if (cardType == BankCardType.CREDIT) {
            return creditCardSupplier.apply(cardNumber, user);
        } else if (cardType == BankCardType.DEBIT) {
            return debitCardSupplier.apply(cardNumber, user);
        }
        throw new IllegalArgumentException();
    }
}
