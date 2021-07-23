package userbusiness;

public class UserLogin {

    private static AccountDirectory accounts;

    public UserLogin(AccountDirectory ad) {
        accounts = ad;
    }

    public static Account validLogin(String username, int password, String role) {

        Account account = accounts.searchAccount(username);
        return (account != null && account.getPassword() == password && account.getRole().equals(role)) ? account : null;
    } 

}
