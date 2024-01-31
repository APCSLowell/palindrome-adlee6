import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String var = reverse(word);
  word = word.toLowerCase();
  var = var.toLowerCase();
  word = noSpace(word);
  var = noSpace(var);
  word = onlyChar(word);
  var = onlyChar(var);
  if(word.equals(var))
    return true;
  return false;
}
public String reverse(String str)
{
    String sNew = new String();
    for(int i = str.length(); i > 0; i--)
    sNew += str.substring(i-1, i);
    return sNew;
}
public String noSpace(String res)
{
 String result = new String();
  for(int i = 0; i < res.length(); i++)
    if(res.charAt(i) != ' ')
      result += res.charAt(i);
  return result;
}
public String onlyChar(String leg)
 {
   String vars = new String();
   for(int i = 0; i < leg.length(); i++)
     if(Character.isLetter(leg.charAt(i)))
       vars += leg.charAt(i);
   return vars;
 }
}
