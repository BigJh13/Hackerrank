import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    int maiorScores = 0;
    int piorScores = 0;    
    int countPartidas = 0;
    
    List<Integer> resultScores = new ArrayList<>();
    resultScores.add(0);
    resultScores.add(0);
    
    do{
        if(countPartidas != 0){
            if(maiorScores<scores.get(countPartidas)){
                maiorScores = scores.get(countPartidas);
                resultScores.set(0, resultScores.get(0)+1);
            }
            else if(piorScores>scores.get(countPartidas)){
                piorScores = scores.get(countPartidas);
                resultScores.set(1, resultScores.get(1)+1);
            }
        }
        else{
            maiorScores = scores.get(0);
            piorScores = scores.get(0);
        }
        countPartidas++;
    }while(scores.size()>countPartidas);
    
    return resultScores;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
