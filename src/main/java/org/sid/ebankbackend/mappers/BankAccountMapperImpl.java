package org.sid.ebankbackend.mappers;

import org.sid.ebankbackend.dtos.AccountOperationDTO;
import org.sid.ebankbackend.dtos.CurrentBanckAccountDTO;
import org.sid.ebankbackend.dtos.CustomerDTO;
import org.sid.ebankbackend.dtos.SavingBanckAccountDTO;
import org.sid.ebankbackend.entities.AccountOperation;
import org.sid.ebankbackend.entities.CurrentAccount;
import org.sid.ebankbackend.entities.Customer;
import org.sid.ebankbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer (Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        return customerDTO;
    }
    public Customer fromCustomerDTO  (CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
    public SavingBanckAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBanckAccountDTO savingBankAccountDTO = new SavingBanckAccountDTO();
        BeanUtils.copyProperties(savingAccount, savingBankAccountDTO);
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDTO;

    }

    public SavingAccount fromSavingBankAccountDTO (SavingBanckAccountDTO savingAccountDTO){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingAccountDTO, savingAccount);
        savingAccount.setCustomer(fromCustomerDTO(savingAccountDTO.getCustomerDTO()));
        return savingAccount;

    }
    public CurrentBanckAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBanckAccountDTO currentBankAccountDTO = new CurrentBanckAccountDTO();
        BeanUtils.copyProperties(currentAccount, currentBankAccountDTO);
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDTO;


    }
    public CurrentAccount fromCurrentBankAccountDTO(CurrentBanckAccountDTO currentBanckAccountDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentBanckAccountDTO, currentAccount);
        currentAccount.setCustomer(fromCustomerDTO(currentBanckAccountDTO.getCustomerDTO()));
        return currentAccount;


    }

    public AccountOperationDTO fromAccountOperation (AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation, accountOperationDTO);
        return accountOperationDTO;
    }

}
