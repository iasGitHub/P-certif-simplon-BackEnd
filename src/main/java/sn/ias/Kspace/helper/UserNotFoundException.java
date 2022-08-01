package sn.ias.Kspace.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Un utilisateur avec ce NU est introuvable !! ");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
