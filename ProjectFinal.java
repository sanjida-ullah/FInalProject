  import java.util.regex.Matcher; 
  import java.util.regex.Pattern; 
  import java.util.Scanner;
  import java.io.*; 
  import java.util.*; 
  import java.util.TreeMap;
  import java.util.Set;
  import java.util.Iterator;
  import java.util.Map;

  /*Sanjida Ullah
  * Fall 2019
  * Final project */

  class ProjectFinal { 
    
    public static void main(String[] args) {
      
      Map<String,Integer> HashMap = new HashMap<String, Integer>();
      
      Scanner scan= new Scanner(System.in);
      System.out.println("Enter a string to match");
      String test= scan.nextLine();
      String SPLIT = "\\s";
      Pattern pattern = Pattern.compile(SPLIT);
      String[] result = pattern.split(test);
      
      // regex patterns to determine the input data
      Pattern identifierPattern = Pattern.compile("[a-zA-Z_]([a-zA-Z_]|[0-9])*");
      Pattern letter = Pattern.compile("[a-zA-Z_]([a-zA-Z_])"); 
      Pattern literalPattern = Pattern.compile("^[1-9][0-9]*|^0$"); 
      Pattern assignOperator = Pattern.compile("\\=");
      Pattern nonZeroDigit = Pattern.compile("1-9"); 
      Pattern digit = Pattern.compile("\\d");
      Pattern exp= Pattern.compile("[1-9](0-9)*(\\+|\\-|\\*)[0-9]*|[1-9]*");
      
      for     (int i=0;i<=result.length-1;i++){ 
        while ( i > result.length); {
          
          // will match for identifier
          Matcher m = identifierPattern.matcher(result[i]); {
            if (m.find()) { System.out.print(result[i]); 
            }
            
            // will match for assignment operator
            //Matcher m3 = assignOperator.matcher(result[i]);
            //if (m3.find())  System.out.print(" " + result[i]);
            
            // Matcher m2 = literalPattern.matcher(result[i]);{
            // if (m2.find()) { System.out.print(" " + result[i] + " ");
            
            //match input expression         
            Matcher m2 = exp.matcher(result[i]); {
            if (m2.find()) { System.out.print(" " + result[i] + " "); 
            }
      }
      }
        }
     
      }
       System.out.println();
      for(int i=0;i<=0;i++) { 
        
        // will take an identfier and return null val
        if (result.length == 1)  { 
          String identfier = result[0];
          System.out.println(identfier + " = " + HashMap.get(identfier));
        }
        
        // to only set a value to an identfier (ex: x=0)
        else if (result.length == 3) {
          String identfier = result[0];
          String eqSign   = result[1];
          String val1 = result[2];
          
          if (!eqSign.equals("=")) throw new RuntimeException("Please check assignment operator");
          int var1;
          
          if (HashMap.containsKey(val1)) var1 = HashMap.get(val1);
          
          else  var1 = Integer.parseInt(val1);
          HashMap.put(identfier, var1);
          System.out.println(identfier + " = " + HashMap.get(identfier));
        }
        //will store and return values for multiplcation, addition and subtraction
        else if (result.length == 5) {
          String identfier = result[0];
          String eqSign   = result[1];
          String val1 = result[2];
          String operation   = result[3];
          String val2 = result[4];
          
          if (!eqSign.equals("=")) throw new RuntimeException("Please check assignment operator");
          int var1;
          
          if (HashMap.containsKey(val1)) var1 = HashMap.get(val1);
          else var1 = Integer.parseInt(val1);
          int var2;
          if (HashMap.containsKey(val2)) var2 = HashMap.get(val2);
          else var2 = Integer.parseInt(val2);
          
          if (operation.equals("*")) HashMap.put(identfier, var1 * var2);
          else if (operation.equals("+"))  HashMap.put(identfier, var1 + var2);
          else if (operation.equals("-")) HashMap.put(identfier, var1 - var2);
          else if (operation.equals("*")) HashMap.put(identfier, var1 * var2);
          else throw new RuntimeException("Operation not Valid");
          System.out.println(identfier + " = " + HashMap.get(identfier));
        }
        else throw new RuntimeException("Input Incorrect");
      } 
    }
  }

  
