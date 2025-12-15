public class RecordPatterns {
    public static void main(String[] args) {
        User mainUser = new User( "Yuri", "123321", "email_yuri@hotmail.com" );

        // Antes - Java 17
        if ( mainUser instanceof User user ) {
            String userNameString = user.name();
            String userPasswordString = user.password();
            String userEmailString = user.email();
            System.out.printf("%s, %s, %s%n", userNameString, userPasswordString, userEmailString );
        }

        // Depois - Java 21
        if ( mainUser instanceof User( String name, String password, String email ) ) {
            System.out.printf("%s, %s, %s%n", name, password, email );
        }
    }
}
