package pl.obol007.projekt1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;
import pl.obol007.projekt1.dto.BusinessRegistrationDTO;

@Service
@Transactional //kazda metoda publiczna jest transakcja (kazdy zapis, odczyt
//zawsze powinien byc
@Slf4j // logger

public class BusinessRegistrationService {

    private final BusinessRepository businessRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public BusinessRegistrationService(BusinessRepository businessRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.businessRepository = businessRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public void registerBusiness(BusinessRegistrationDTO businessData){

        log.debug("Dane do rejestracji biznesu: {}",businessData);
        Business business = new Business();
//        business.setUsername(data.getUsername());
//        business.setPassword(passwordEncoder.encode(data.getPassword()));
//        business.setActive(true);
        business.setEmail(businessData.getEmail());
        business.setBusinessName(businessData.getBusinessName());
        business.setFirstName(businessData.getFirstName());
        business.setLastName(businessData.getLastName());

        business.setNip(businessData.getNip());

        business.setCategory(businessData.getCategory());

        log.debug("Uzyskany obiekt użytkownika typu business: {}", business);

        businessRepository.save(business);


        User user = new User();
        user.setPassword(passwordEncoder.encode(businessData.getPassword()));
        user.setUsername(businessData.getUsername());
        user.setActive(true);
        user.setRole("BUSINESS");
        userRepository.save(user);

        business.setUser(user);

        businessRepository.save(business);

        log.debug("Zarejestrowany uzytkownik: {}", user);
        log.debug("Zarejestrowany użytkownik typu business: {}", business);
    }



}
