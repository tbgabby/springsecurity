package com.tb.directoryapp.repositories;


import com.tb.directoryapp.model.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;


public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);

}
