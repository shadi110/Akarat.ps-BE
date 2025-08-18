package com.akarati.ps.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akarati.ps.entities.User;
import com.akarati.ps.excptions.ResourceNotFoundException;
import com.akarati.ps.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByPhone(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
    
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // Update fields
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User addToFavorites(Long userId, Long realEstateId) {
		return null;
        // Implementation to add real estate to user's favorites
    }
    
    public User removeFromFavorites(Long userId, Long realEstateId) {
		return null;
        // Implementation to remove real estate from user's favorites
    }
}
