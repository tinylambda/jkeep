package string;

public class StringIndex {
    public static String getFileType(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.') + 1;
            if ((dot > 0) && (dot < (filename.length()))) {
                return filename.substring(dot);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String filename = "/tmp/a.zip";
        String fileType = getFileType(filename);
        System.out.println(fileType);
    }
}
