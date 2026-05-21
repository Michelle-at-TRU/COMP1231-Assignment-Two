package ca.tru;

public interface PasswordLockable {

    // I don't like just being able to change the password without any security or
    // the old password, but since this is an interface on product and not it's own
    // class I can't just have the password be inmutable and change the reference.
    PasswordLockable setPassword(String password);

    // needing the password to lock also feel weird
    PasswordLockable lock(String password);

    PasswordLockable unlock(String password);

    boolean isLocked();
}
