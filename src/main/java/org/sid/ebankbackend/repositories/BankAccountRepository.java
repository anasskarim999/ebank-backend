package org.sid.ebankbackend.repositories;

import org.sid.ebankbackend.entities.BanckAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BanckAccount, String> {
}