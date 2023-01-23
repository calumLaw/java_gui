package chatgbt;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class chat {
	  public static void main(String[] args) {
	    String directory = "C:\\Users\\suppo\\Desktop\\review files\\hockey"; // Replace this with the directory specified by the user
	    String command = "cd documents"; // Replace this with the command you want to enter into the command prompt

	    try {
	      // Open command prompt from the specified directory
	      ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start", "cmd.exe", "/k", "cd", directory);
	      Process process = pb.start();

	      // Get the input stream of the command prompt
	      BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

	      // Enter the command into the command prompt
	      process.getOutputStream().write((command + "\r\n").getBytes());
	      process.getOutputStream().flush();
	      

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	


}
