package com.pawan.config.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static com.pawan.utility.constants.AppConstants.PACKAGES_TO_SCAN;

@Configuration
@ComponentScan(basePackages=PACKAGES_TO_SCAN)
public class AppConfig {

}
