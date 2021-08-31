import business.abstracts.LoggerService;
import business.abstracts.UserService;
import business.concretes.LoggerManager;
import business.concretes.UserManager;
import core.GoogleSignUpAdapter;
import core.GoogleSignUpService;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new HibernateUserDao();
        LoggerService loggerService = new LoggerManager();
        UserService userService = new UserManager(userDao, loggerService);
        User user = new User(1, "Ali", "Veli", "aliveli@gmail.com", "123456789");
        userService.login(user);

        User user2 = new User(2, "Ahmet", "Mehmet", "ahmetmehmet@gmail.com", "12345678");
        userService.signUp(user2);

        User user3 = new User(3, "Mehmet", "Ahmet", "ahmetmehmet@gmail.com", "87654321");
        userService.signUp(user3);


        User user4 = new User(2, "Ayşe", "Fatma", "ayse.fatma@google.com", "abcdefgh");
        GoogleSignUpService googleSignUpService = new GoogleSignUpAdapter();
        googleSignUpService.signInWithGoogle(user4);

    }
}
