package com.romanfill.modules.api;

import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.BankCardType;
import com.romanfill.modules.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
