package com.github.bertramn.sso.authenticators.browser;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;

import java.util.List;

public class CustomUsernamePasswordFormFactory implements AuthenticatorFactory {

  public static final String PROVIDER_NAME = "auth-custom-username-password-form";
  public static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
    AuthenticationExecutionModel.Requirement.REQUIRED,
    AuthenticationExecutionModel.Requirement.DISABLED
  };
  private static final Logger log = Logger.getLogger(CustomUsernamePasswordFormFactory.class);
  private static final String WEBSITE_URL_PROP_NAME = "custom_website_url";
  /**
   * the provider configuration metadata definition
   */
  private static final List<ProviderConfigProperty> configMetadata;

  static {
    configMetadata = ProviderConfigurationBuilder.create()

      // add the data source name property
      .property()
      .name(WEBSITE_URL_PROP_NAME)
      .type(ProviderConfigProperty.STRING_TYPE)
      .label("Csutom Website URL")
      .defaultValue("https://www.example.com/site")
      .helpText("The base URL of the custom website. Error messages will generate links back to this location.")
      .add()

      .build();
  }

  private String siteURL;

  @Override
  public String getId() {
    return PROVIDER_NAME;
  }

  @Override
  public Authenticator create(KeycloakSession session) {
    return new CustomUsernamePasswordForm(siteURL);
  }

  @Override
  public void close() {
    if (log.isDebugEnabled()) {
      log.debugf("Closing %s authenticator factory %d", PROVIDER_NAME, hashCode());
    }
  }

  @Override
  public String getReferenceCategory() {
    return UserCredentialModel.PASSWORD;
  }

  //region Authenticator Configuration

  @Override
  public boolean isConfigurable() {
    return true;
  }

  @Override
  public void init(Config.Scope config) {
    if (log.isDebugEnabled()) {
      log.debugf("Create %s authenticator factory %d", PROVIDER_NAME, hashCode());
    }
    siteURL = config.get(WEBSITE_URL_PROP_NAME);
  }

  @Override
  public void postInit(KeycloakSessionFactory factory) {
    if (log.isDebugEnabled()) {
      log.debugf("Post create %s authenticator factory %d", PROVIDER_NAME, hashCode());
    }
  }

  @Override
  public List<ProviderConfigProperty> getConfigProperties() {
    return configMetadata;
  }

  //endregion

  @Override
  public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
    return REQUIREMENT_CHOICES;
  }

  @Override
  public String getDisplayType() {
    return "Custom Username Password Form";
  }

  @Override
  public String getHelpText() {
    return "Validates a username and password from login form.";
  }


  @Override
  public boolean isUserSetupAllowed() {
    return false;
  }

}
