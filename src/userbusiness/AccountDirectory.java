/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userbusiness;

import java.util.ArrayList;

/**
 *
 * @author fayelu
 */
public class AccountDirectory {

    public ArrayList<Account> accountList;

    public AccountDirectory() {
        this.accountList = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public Account addAccount(Account account) {

        accountList.add(account);
        return account;
    }

    public void deleteAccount(Account account) {
        accountList.remove(accountList.indexOf(account));

    }

    public Account searchAccount(String User) {
        for (Account account : accountList) {
            if (account.getUser().equals(User)) {
                return account;
            }
        }
        return null;
    }
}
