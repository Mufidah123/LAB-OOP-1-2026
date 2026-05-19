package Nomor2;

// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.util.Random;

public class DataProcessor {
    public int process(String fileName){
        Random random = new Random();

        try {
            int delay = random.nextInt(1501) + 500;
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }

    //     try {
    //         String content = Files.readString(Paths.get(fileName));
    //         String[] words = content.trim().split("\\s+");
    //         return words.length;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return 0;
    //     }
    // }
    
        return random.nextInt(900) + 100;
    }
}
