package com.romanfill.modules.api;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
