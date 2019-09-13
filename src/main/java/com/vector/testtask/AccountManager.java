package com.vector.testtask;

public class AccountManager {

    private String login;
    private String encryptedPassword;

   /* public void register(String login, String password) throws NoSuchAlgorithmException, SQLException {

        SQLManager.getInstance().executeUpdate("INSERT INTO accounts (login, pass) " +
                "VALUES ('" + login + "','" + encryptPassword("MD5", password) + "')");
    }

    public void login(String login, String password) throws SQLException, NoSuchAlgorithmException, FailedLoginException {

        password = encryptPassword("MD5", password);
        ResultSet result = SQLManager.getInstance().executeQuery("SELECT * FROM accounts " +
                "WHERE login = '"+ login +"' AND pass = '"+ password +"'");

        if (result.next() == false){
            throw new FailedLoginException();
        } else {
            this.login = login;
            this.encryptedPassword = password;
        }
    }

    private String encryptPassword(String algorithm, String password) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        messageDigest.update(password.getBytes());
        byte[] bytes = messageDigest.digest();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i< bytes.length ;i++) {
            stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {

        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];

        secureRandom.nextBytes(salt);

        return salt;
    }
    */
}
