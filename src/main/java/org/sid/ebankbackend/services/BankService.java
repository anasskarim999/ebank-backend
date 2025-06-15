package org.sid.ebankbackend.services;


import jakarta.transaction.Transactional;
import org.sid.ebankbackend.entities.BanckAccount;
import org.sid.ebankbackend.entities.CurrentAccount;
import org.sid.ebankbackend.entities.SavingAccount;
import org.sid.ebankbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){

        BanckAccount banckAccount =
                bankAccountRepository.findById("06e62b76-6244-40a4-a4fe-1b5171b9efd1").orElse(null);
        if (banckAccount != null) {
            System.out.println("*****************************");
            System.out.println(banckAccount.getId());
            System.out.println(banckAccount.getBalance());
            System.out.println(banckAccount.getStatus());
            System.out.println(banckAccount.getCreatedAt());
            System.out.println(banckAccount.getCustomer().getName());
            System.out.println(banckAccount.getClass().getSimpleName());
            if(banckAccount instanceof CurrentAccount){
                System.out.println (((CurrentAccount)banckAccount).getOverdraft());
            }
            else if(banckAccount instanceof SavingAccount){
                System.out.println ( ((SavingAccount)banckAccount).getInterestRate());
            }
            banckAccount.getAccountOperations().forEach(op->{
                System.out.println(op.getType()+"\t"+op.getOperationDte()+"\t"+op.getAmount());
            });
        }
    }
}


