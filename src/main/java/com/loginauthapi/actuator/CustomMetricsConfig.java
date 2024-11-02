package com.loginauthapi.actuator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loginauthapi.repositories.UserRepository;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Configuration
public class CustomMetricsConfig
{
    @Bean
    public MeterBinder customMetrics( UserRepository userRepository ) 
    {
        return (meterRegistry) ->  Gauge.builder( "user.qtd", userRepository::count )
                                        .register( meterRegistry );
    }
    
    @Bean
    public CountedAspect countedAspect( MeterRegistry meterRegistry )
    {
        return new CountedAspect( meterRegistry );
    }
    
    @Bean
    public TimedAspect timedAspect( MeterRegistry meterRegistry )
    {
        return new TimedAspect( meterRegistry );
    }
}