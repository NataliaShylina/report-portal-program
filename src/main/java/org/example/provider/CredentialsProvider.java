package org.example.provider;

import org.example.domain.Credentials;
import org.example.domain.UserType;
import org.example.reader.PropertyReader;

public class CredentialsProvider {

    public Credentials provideByUserType(UserType userType) {
        PropertyReader propertyReader = new PropertyReader(userType.getPropertyName());
        return new Credentials(propertyReader.getProperty("login"), propertyReader.getProperty("password"));
    }
}
