package com.romanfill.modules.app;

import com.romanfill.modules.api.Bank;
import com.romanfill.modules.service.api.Service;

import java.util.ServiceLoader;

public class ServiceSupplier {
    public static Bank getBankService() {
        ServiceLoader<Bank> bankServiceLoader = ServiceLoader.load(Bank.class);
        return bankServiceLoader.findFirst().get();
    }

    public static Service getServiceLoader() {
        ServiceLoader<Service> serviceServiceLoader = ServiceLoader.load(Service.class);
        return serviceServiceLoader.findFirst().get();
    }
}
