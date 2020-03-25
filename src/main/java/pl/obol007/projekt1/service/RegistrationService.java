package pl.obol007.projekt1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.dto.RegistrationDataDTO;

@Service
@Transactional //kazda metoda publiczna jest transakcja (kazdy zapis, odczyt
//zawsze powinien byc
@Slf4j // logger

public class RegistrationService {

    private final BusinessRepository businessRepository;

    private final PasswordEncoder passwordEncoder;

    public RegistrationService(BusinessRepository businessRepository, PasswordEncoder passwordEncoder) {
        this.businessRepository = businessRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(RegistrationDataDTO data){
        log.debug("Dane do rejestracji: {}",data);
        Business business = new Business();
        business.setUsername(data.getUsername());
        business.setPassword(passwordEncoder.encode(data.getPassword()));
        business.setActive(true);
        business.setEmail(data.getEmail());
        log.debug("Uzyskany obiekt użytkownika: {}", business);

        businessRepository.save(business);
        log.debug("Zarejestrowany użytkownik: {}", business);
    }



}
