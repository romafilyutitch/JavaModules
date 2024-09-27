package com.romanfill.modules.dto;

import java.util.function.BiFunction;

public enum BankCardType {

    CREDIT(CreditBankCard::new), DEBIT(DebitBankCard::new);

    private BiFunction<String, User, BankCard> bankCardSupplier;

    BankCardType(BiFunction<String, User, BankCard> bankCardSupplier) {
        this.bankCardSupplier = bankCardSupplier;
    }

    public BiFunction<String, User, BankCard> getBankCardBuilder() {
        return bankCardSupplier;
    }
}
