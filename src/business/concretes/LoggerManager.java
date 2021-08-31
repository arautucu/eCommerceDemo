package business.concretes;

import business.abstracts.LoggerService;

public class LoggerManager implements LoggerService {
    @Override
    public void log(String message) {
        System.out.println("Logged: " + message);
    }
}
