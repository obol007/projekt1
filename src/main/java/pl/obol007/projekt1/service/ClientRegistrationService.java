package pl.obol007.projekt1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.obol007.projekt1.domain.model.Client;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.ClientRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;
import pl.obol007.projekt1.dto.ClientRegistrationDTO;

@Service
@Transactional
@Slf4j // logger

public class ClientRegistrationService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public ClientRegistrationService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void registerClient(ClientRegistrationDTO data){

        log.debug("Dane do rejestracji klienta: {}",data);

        Client client = new Client();
        client.setAddress(data.getAddress());
        client.setEmail(data.getEmail());
        client.setFirstName(data.getFirstName());
        client.setLastName(data.getLastName());

        log.debug("Uzyskany obiekt użytkownika typu klient: {}", client);

        clientRepository.save(client);

        User user = new User();

        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setUsername(data.getUsername());
        user.setActive(true);
        user.setRole("CLIENT");
        userRepository.save(user);

        client.setUser(user);
        clientRepository.save(client);

        log.debug("Zarejestrowany uzytkownik: {}", user);
        log.debug("Zarejestrowany klient: {}", client);

    }
}
