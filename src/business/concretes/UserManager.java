package business.concretes;

import business.abstracts.LoggerService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

    private UserDao userDao;

    private LoggerService loggerService;

    //private List<String> emails = new ArrayList<String>();

    public UserManager(UserDao userDao, LoggerService loggerService) {
        this.userDao = userDao;
        this.loggerService = loggerService;
    }

    @Override
    public void login(User user) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()){
            loggerService.log("Giriş başarısız. E-posta ve parola alanı zorunludur.");
        } else {
            loggerService.log("Giriş başarılı.");
            userDao.login(user);
        }
    }

    @Override
    public void signUp(User user) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        if(
                user.getPassword().length() < 6 ||
                !matcher.matches() ||
                userDao.isEmailUsed(user) ||
                user.getFirstName().length() < 2 ||
                user.getLastName().length() < 2
        ){
            loggerService.log("Üyelik başarısız. Lütfen girdiğiniz bilgileri kontrol edin.");
        } else {
            loggerService.log("Üyelik başarılı");
            userDao.signUp(user);
        }
    }
}
