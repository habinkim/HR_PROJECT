package com.ecoandrich.hr.common.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class CommonBeans {

    @Bean
    public MessageSource messageSource() {
        String basename = "messages/messages";
        String charSet = "UTF-8";
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(basename);
        messageSource.setDefaultEncoding(charSet);
        return messageSource;
    }

}
