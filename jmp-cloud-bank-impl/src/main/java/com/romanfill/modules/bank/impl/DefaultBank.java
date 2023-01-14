package com.romanfill.modules.bank.impl;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.dto.*;

import java.util.Random;

public class DefaultBank implements Bank {
    private Random rand = new Random();

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        final String cardNumber = Integer.toString(rand.nextInt(100));
        if (cardType == BankCardType.CREDIT) {
            return new CreditBankCard(cardNumber, user);
        } else if (cardType == BankCardType.DEBIT) {
            return new DebitBankCard(cardNumber, user);
        }
        throw new IllegalArgumentException();
    }
}
