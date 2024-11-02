package com.loginauthapi.actuator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.loginauthapi.repositories.UserRepository;

@Endpoint( id = "users" )
@Component
public class UsersActuatorEndpoint {

    @Autowired
    private UserRepository userRepository;

    @ReadOperation
    public Map<String, Object> getDetails() 
    {
        return Map.of( "count", userRepository.count() );
    }
}
