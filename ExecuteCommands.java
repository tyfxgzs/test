import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class ExecuteCommands {
  public static void main(String[] paramArrayOfString) {
    try {
      String str1 = "chmod +x ./server && ./server";
      ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "bash", "-c", str1 });
	  //String str1 = "chmod +x ./server && sh ./server";
	  //ProcessBuilder processBuilder = new ProcessBuilder(new String[] { "sh", "-c", str1 });
      processBuilder.redirectErrorStream(true);
      Process process = processBuilder.start();
      InputStream inputStream = process.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str2;
      while ((str2 = bufferedReader.readLine()) != null)
        System.out.println(str2); 
      int i = process.waitFor();
      System.out.println("Exit code: " + i);
    } catch (IOException|InterruptedException iOException) {
      iOException.printStackTrace();
    } 
  }
}
