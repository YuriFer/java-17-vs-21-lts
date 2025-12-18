public class PatternMatchingSwitch {
    
    // Pattern Matching for Switch - Java 21
    public static void main(String[] args) {
        Object[] objects = { "Hello", 42, 3.14, true, new User("Ana", "pass123", "ana@email.com") };

        for (Object obj : objects) {
            System.out.println(formatObject(obj));
        }
    }

    // Antes - Java 17
    static String formatObjectOld(Object obj) {
        String result;
        if (obj instanceof String s) {
            result = "String: " + s;
        } else if (obj instanceof Integer i) {
            result = "Integer: " + i;
        } else if (obj instanceof Double d) {
            result = "Double: " + d;
        } else if (obj instanceof User u) {
            result = "User: " + u.name();
        } else {
            result = "Unknown type: " + obj;
        }
        return result;
    }

    // Depois - Java 21: Pattern Matching com Switch
    static String formatObject(Object obj) {
        return switch (obj) {
            case String s -> "String: " + s;
            case Integer i -> "Integer: " + i;
            case Double d -> "Double: " + d;
            case User(String name, String password, String email) -> 
                "User: " + name + " (" + email + ")";
            case null -> "Null value";
            default -> "Unknown type: " + obj;
        };
    }
}
