package core;

import GoogleSignUp.GoogleSignUpManager;
import entities.concretes.User;

public class GoogleSignUpAdapter implements GoogleSignUpService{
    @Override
    public void signInWithGoogle(User user) {
        GoogleSignUpManager googleSignUpManager = new GoogleSignUpManager();
        googleSignUpManager.signUp(user.getEmail());
    }
}
