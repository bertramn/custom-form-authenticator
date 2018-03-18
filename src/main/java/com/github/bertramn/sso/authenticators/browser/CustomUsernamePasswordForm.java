package com.github.bertramn.sso.authenticators.browser;

import com.github.bertramn.sso.AccountInactiveException;
import com.github.bertramn.sso.AccountLockedException;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.authenticators.browser.UsernamePasswordForm;
import org.keycloak.credential.CredentialInput;
import org.keycloak.events.Errors;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.representations.idm.CredentialRepresentation;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

public class CustomUsernamePasswordForm extends UsernamePasswordForm {

  /**
   * The error message id whe the users account is locked.
   */
  public static final String ACCOUNT_LOCKED = "lockedUserMessage";

  /**
   * The error message id whe the users account is inactive.
   */
  public static final String ACCOUNT_INACTIVE = "inactiveUserMessage";

  private String siteURL;

  public CustomUsernamePasswordForm(String siteURL) {
    this.siteURL = siteURL;
  }

  public boolean validatePassword(AuthenticationFlowContext context, UserModel user, MultivaluedMap<String, String> inputData) {
    List<CredentialInput> credentials = new LinkedList<>();
    String password = inputData.getFirst(CredentialRepresentation.PASSWORD);
    credentials.add(UserCredentialModel.password(password));

    if (isTemporarilyDisabledByBruteForce(context, user)) return false;

    try {
      if (password != null && !password.isEmpty() && context.getSession().userCredentialManager().isValid(context.getRealm(), user, credentials)) {
        return true;
      } else {
        context.getEvent().user(user);
        context.getEvent().error(Errors.INVALID_USER_CREDENTIALS);
        Response challengeResponse = invalidCredentials(context);
        context.failureChallenge(AuthenticationFlowError.INVALID_CREDENTIALS, challengeResponse);
        context.clearUser();
        return false;
      }
    } catch (AccountInactiveException ie) {
      context.getEvent().user(user);
      context.getEvent().error("account_inactive");
      Response challengeResponse = context.form()
        .setError(ACCOUNT_INACTIVE, siteURL).createLogin();
      context.failureChallenge(AuthenticationFlowError.INVALID_CREDENTIALS, challengeResponse);
      context.clearUser();
      return false;
    } catch (AccountLockedException le) {
      context.getEvent().user(user);
      context.getEvent().error("account_locked");
      Response challengeResponse = context.form()
        .setError(ACCOUNT_LOCKED, siteURL).createLogin();
      context.failureChallenge(AuthenticationFlowError.INVALID_CREDENTIALS, challengeResponse);
      context.clearUser();
      return false;
    }

  }

  /**
   * Had to copy that one to be able to override above, see KEYCLOAK-6869 .
   *
   * @param context the auth context
   * @param user    the user to check
   *
   * @return true if the account is temporarily suspended due to brute force protection
   */
  private boolean isTemporarilyDisabledByBruteForce(AuthenticationFlowContext context, UserModel user) {
    if (context.getRealm().isBruteForceProtected()) {
      if (context.getProtector().isTemporarilyDisabled(context.getSession(), context.getRealm(), user)) {
        context.getEvent().user(user);
        context.getEvent().error(Errors.USER_TEMPORARILY_DISABLED);
        Response challengeResponse = temporarilyDisabledUser(context);
        // this is not a failure so don't call failureChallenge.
        //context.failureChallenge(AuthenticationFlowError.USER_TEMPORARILY_DISABLED, challengeResponse);
        context.forceChallenge(challengeResponse);
        return true;
      }
    }
    return false;
  }

}
