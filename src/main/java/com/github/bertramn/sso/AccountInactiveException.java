package com.github.bertramn.sso;

public class AccountInactiveException extends RuntimeException {

  private String username;
  private String status;

  public AccountInactiveException(String username, String status) {
    super("Account " + username + " is " + status + ".");
    this.username = username;
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public String getStatus() {
    return status;
  }

}

