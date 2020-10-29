package com.casestudy.service.user;

import com.casestudy.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IAppUserService {

    Iterable<AppUser> findAll();

    AppUser save(AppUser appUser);

    Optional<AppUser> findOne(Long id);

    void remove(Long id);

}
