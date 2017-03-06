package stg.configuration;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by rickjackson on 3/5/17.
 */
@Configuration
@ImportResource("classpath:/aws-config.xml")
@EnableRdsInstance(databaseName = "${database-name:}",
                   dbInstanceIdentifier = "${db-instance-identifier:}",
                   password = "${rdsPassword:}")
public class AwsResourceConfiguration {
    
    
}
