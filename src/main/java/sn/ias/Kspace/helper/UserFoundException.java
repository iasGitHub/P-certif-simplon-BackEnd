package sn.ias.Kspace.helper;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("Un utilisateur avec ce NU existe déjà !! essayez un autre nom ");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
