import java.io.*;
import java.util.Random;

public class CreateTest {
    public static void main(String[] args) throws IOException {
        int N = 1000000;
        Random rand = new Random();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = rand.nextInt();
        //for (int i = 0; i < N; i++) a[i] = i;
        //for (int i = 0; i < N; i++) a[i] = N / 2 - i - 1;
        //for (int i = 0; i < N; i++) a[i] = 7;
        for (int i = 0; i < N; i++) System.out.println(a[i]);

        File file = new File("C:\\Users\\nguye\\IdeaProjects\\DSA\\DataTest\\1MRandInts.txt");
        OutputStream outputStream = new FileOutputStream(file);
        //OutputStream outputStream = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        for (int i = 0; i < N; i++) {
            outputStreamWriter.write(String.valueOf(a[i]));
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
    }

}
