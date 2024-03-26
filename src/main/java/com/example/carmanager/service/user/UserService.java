package com.example.carmanager.service.user;

import com.example.carmanager.model.user.User;
import com.example.carmanager.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService<User>, UserDetailsService {
    @Autowired
    private IUserRepo userRepo;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        List<GrantedAuthority> grantedAuthorityList =new ArrayList<>();
        grantedAuthorityList.add(user.getRole());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),grantedAuthorityList);
        return userDetails;
    }
}