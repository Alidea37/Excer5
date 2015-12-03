package Excer5;
// code for string content
//http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file?rq=1


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.IllegalStateException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFile {
	// Fig. 15.6 ReadTextFile.java p. 647-648
		private static Scanner myscanner;
		
		
	public static void main(String[] args)
		{
			openFile();
			readRecords();
			createFile();
			closeFile();
		}
		
	// open files clients.txt
	public static void openFile()
			{
				try
				{
					myscanner = new Scanner(Paths.get("RFrost.txt"));
				}
			catch ( IOException ioException)
				{
					System.err.println("Error opening file. Terminating.");
					System.exit(1);
				}
			catch (SecurityException securityException)
				{
					System.err.println("Write permission denied. Terminating,");
					System.exit(1); // terminates the program
				}
			}
		
				private static String readFile(String string, Charset defaultCharset) {
					// TODO Auto-generated method stub
					return null;
			}

		// read record from file
		public static void readRecords()
			{
			
				System.out.printf("%s%n", "Dust of Snow");
				try
					{
						while (myscanner.hasNext()) // while there is more to read
						{
							
							// display record contents
								System.out.printf("%s%n", myscanner.next());
						}
					}
		
					catch (NoSuchElementException elementException)
				{
					System.err.println("File improperly formed. Terminating.");
				}
					catch (IllegalStateException stateException)
				{
						System.err.println("Error reading from file. Terminating.");
			
			} // end while
			
		} // end method addRecords
		
		public static void createFile()
		{
			File outFile = new File("Quote.txt"); // open the file
			FileOutputStream outFileStream;
		
			
			String content = readFile("RFrost.txt", Charset.defaultCharset());
			while (myscanner.hasNext()) // loop until end of file indicator
			{
				try
				{
					outFileStream = new FileOutputStream(outFile);
					PrintWriter outStream = new PrintWriter(outFileStream);

					
					// output new record to file; assumes valid input
					outStream.printf("%s%n", content,
					myscanner.next());
					
					outStream.close();
				}
				
				catch (FormatterClosedException formatterClosedException)
				{
					System.err.println("Error writing to file. Terminating.");
					break;
				}
				catch ( NoSuchElementException elementException)
				{
					System.err.println("Invalid input. Please try again.");
					myscanner.nextLine(); // discard input so user can try again
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					}
						}
		
		
		
		// close file and terminate application
		public static void closeFile()
		{
			if (myscanner != null)
				myscanner.close();
			
		}

} // end method readRecords
