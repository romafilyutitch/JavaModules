<b>Module #2 Java 8,9,10,11+ Task</b>
<br>
<ol>
    (1-2 stars)
    <li>Create maven project with 5 modules (see Java 9 modules)
    <ul>
    <li>jmp-bank-api</li>
    <li>jmp-service-api</li>
    <li>jmp-cloud-bank-impl</li>
    <li>jmp-cloud-service-impl</li>
    <li>jmp-dto</li>
    </ul>    
    </li>
    <li>Create the following classes under jmp-dto module
    <ul>
    <li>
    User (String name, String surname, LocalDate birthday)    
    </li>    
    <li>
    BankCard (String number, User user)    
    </li>
    <li>
    Subscription (String bankcard, LocalDate startDate)
    </li>
    </ul>
    </li>
    <li>Extend BankCard class with:<ul><li>CreditBankCard</li><li>DebitBankCard</li></ul></li>
    <li>Create enum: <ul><li>BankCardType (CREDIT, DEBIT)</li></ul></li>
    <li>Add Bank interface to jmp-bank-api with:<ul><li>BankCard createBankCard(User, BankCardType)</li></ul></li>
    <li>Add module-info.java with:<ul><li>requires jmp-dto</li><li>export Bank interface</li></ul></li>
    <li>Implement Bank into jmp-cloud-bank-impl. Method should create a new class depending on the type</li>
    <li>Add module-info.java which:<ul><li>requires transitive module with Bank interface</li><li>requires jmp-dto</li><li>exports implementation of Bank interface</li></ul></li>
    <li>Add Service to jmp-service-api with:<ul><li>void subscribe(BankCard)</li><li>Optional&lt;Subscription&gt; getSubscriptionByBankCardNumber(String)</li><li>List&lt;User&gt; getAllUsers()</li></ul></li>
    <li>Add module-info.java which: <ul><li>requires jmp-dto</li><li>export Service interface</li></ul></li>
    <li>Implement Service into jmp-cloud-service-impl. Use Stream API, You can use Memory/DB for data storing:</li>
    <li>Add module-info.java which:<ul><li>requires transitive module with Service interface</li><li>requires jmp-dto</li><li>exports implementation of Service interface</li></ul></li>
    <li>Use var for definition of local variables wherever it's applicable</li>
    <li>Use lambda and Java 8 features wherever it's applicable</li>
    <li>Create application module</li>
    <li>Add module-info.java which:<ul><li>use interfaces</li><li>requires module with Bank implementation</li><li>requires module with Service implementation</li><li>requires jmp.dto</li></ul></li>
    <li>Demonstrate functionality of created classes</li>
    (3-4 stars)
    <li>Add a new default method for Service interface, which uses getAllUsers. Use LocalDate.now(), ChronoUnit and mapToLong<ul><li>double getAverageUserAge()</li></ul></li>
    <li>Add a new static method for Service interface, which returns true, if the user is over 18 years old<ul><li>boolean isPayableUser(User)</li></ul></li>
    <li>Use Collectors.toUnmodifiableList() and method reference if it's applicable</li>
    (5 stars)
    <li>Create Exception class which will be used into orElseThrow for Optional from getSubscriptionByBankCardNumber()</li>
    <li>Add a new method for Service interface and implement it. Demonstrate this method into application module<ul>List&lt;Subscription&gt; getAllSubscriptionsByCondition(Predicate&lt;Subscription&gt;)</ul></li>
    <li>Reimplement createBankCard with method reference (ex: CreditBankCard::new)</li>
    <li>Add to module-info.java for each implementation module:<ul><li>provide [interface] with [implementation]</li></ul></li>
    <li>Add a module with Service implementation. Try to use ServiceLoader.load() for module loading</li>
</ol>
