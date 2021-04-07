package uuid;


import java.util.UUID;

public class UUIDGenerate {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.variant());
        System.out.println(uuid.version()); // v4
        String uuidAsString = uuid.toString();
        System.out.println(uuidAsString);
    }
}
