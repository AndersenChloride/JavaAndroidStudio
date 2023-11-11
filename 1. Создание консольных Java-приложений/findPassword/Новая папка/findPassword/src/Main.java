import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CRC32;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("10k-most-common.txt");
        Scanner scanner = new Scanner(file);
        long Hash = 0x0BA02B6E1L;
        CRC32 crc32 = new CRC32();

        ArrayList<String> fillArray = new ArrayList<>();
        while(scanner.hasNextLine()){
            fillArray.add(scanner.nextLine());
        }

        for(String word : fillArray){
            for(int i=1; i<=9999; i++){
                String password = word + i;
                crc32.reset();
                crc32.update(password.getBytes());
                long hash = crc32.getValue();
                if(hash == Hash){
                    System.out.println("Password found: " + password);
                    break;
                }
            }
        }
    }
}