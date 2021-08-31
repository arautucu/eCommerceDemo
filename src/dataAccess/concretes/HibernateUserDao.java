package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;


public class HibernateUserDao implements UserDao {

    private List<String> emails = new ArrayList<>();

    @Override
    public void login(User user) {
        System.out.println(user.getFirstName() + " " + user.getLastName() + " has successfully logged in to the system.");
    }

    @Override
    public void signUp(User user) {
        emails.add(user.getEmail());
        System.out.println("Kullanıcıya doğrulama e-postası gönderildi.");
        System.out.println("Üyelik tamamlandı.");
    }

    @Override
    public boolean isEmailUsed(User user) {
        for (String email:emails) {
            if(email.equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }
}
