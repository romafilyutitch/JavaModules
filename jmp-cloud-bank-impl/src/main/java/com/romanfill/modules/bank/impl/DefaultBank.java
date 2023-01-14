package com.romanfill.modules.bank.impl;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.dto.*;

public class DefaultBank implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        if (cardType == BankCardType.CREDIT) {
            return new CreditBankCard(Integer.toString(cardType.ordinal()), user);
        } else if (cardType == BankCardType.DEBIT) {
            return new DebitBankCard(Integer.toString(cardType.ordinal()), user);
        }
        throw new IllegalArgumentException();
    }
}
