package com.github.bertramn.sso;

public class AccountLockedException extends RuntimeException {

  private String username;

  public AccountLockedException(String username) {
    super("Account " + username + " is locked.");
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

}
