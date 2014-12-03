public class CreditCard
{
  public int findType (String num)
{
    String first1 = num.substring(0,1);
    String first2 = num.substring(0,2);
    String first3 = num.substring(0,3);
    String first4 = num.substring(0,4);
    if (first1.equals("4")) //if first num is 4, return 2
          return 2;
    else if (Integer.parseInt(first2) <= 55 && Integer.parseInt(first2) >= 51) //if card starts with 51-55, return 1
          return 1;
    else if (first2.equals("34") || first2.equals("37")) //else if first 2 num is 34/37, return 3
          return 3;
    else if (first4.equals("6011"))   //else if first 4 num is 6011, return 4
          return 4;
    else if (first2.equals("36") || first2.equals("38") || Integer.parseInt(first3) <= 305 || Integer.parseInt(first3) >= 300)  //else if first 2 number is 36/38 or first 3 num is 300-305, return 5
          return 5;
    else 
     return 0;
}
public String verify (String num)
  {
  String[] odd;
  String[] even;
  if (num.length() % 2 == 0) //if there is an even amount of numbers, half of it are odd and half are even
  {
  odd = new String[num.length()/2];
  even = new String [num.length()/2];
  }
  else // if there is an odd amount of numbers, the length/2 + 1 are odd and the length/2 are even since the number are ints
  {
  odd = new String[num.length()/2 + 1];
  even = new String [num.length()/2];
  }
  
  int temp = num.length();
  int pos = 0;
  if (num.length() % 2 == 0)
  {
    while (temp >= 2)//split each number in the string and put them into their respective array
    {
      odd[pos] = num.substring(temp - 1, temp);
      even[pos] = num.substring(temp - 2, temp - 1);
        temp -=2;
      pos++;
    }
  }
  else
  {
     while (temp >= 2)//split each number in the string and put them into their respective array
    {
      odd[pos] = num.substring(temp - 1, temp);
      even[pos] = num.substring(temp - 2, temp - 1);
        temp -=2;
      pos++;
    }
     odd[odd.length - 1] = num.substring(0,1); // puts the first digit from the right of num into odd since the loop doesn't do that
  }
    
    int oddtemp = odd.length;
    int oddpos = 0;
    int oddsum = 0;
    while (oddtemp >= 1) // add up all the odd numbers
    {
      oddsum += Integer.parseInt(odd[oddpos]); // changes the strings into ints
      oddpos++;
      oddtemp--;
    }
    int eventemp = even.length;
    int evenind = 0;
    int evenpos = 0;
    int evensum = 0;
    while (eventemp >= 1)
    {
      evenind =  Integer.parseInt(even[evenpos]);  //changes the strings into ints
      if (evenind == 5) // if 5, turns into 1 since 2*5 = 10 and 1+0=1
        evenind = 1;
      else if (evenind == 6)//if 6, turns into 3 since 2*6 = 12 and 1+2=3
        evenind = 3; 
      else if (evenind == 7)//if 7, turns into 5 since 2*7 = 14 and 1+4=5
        evenind = 5;
      else if (evenind == 8)//if 8, turns into 7 since 2*8 = 16 and 1+6=7
        evenind = 7;
      else if (evenind == 9)//if 9, turns into 9 since 2*9 = 18 and 1+8=9
         evenind = 9;
      else 
      {
       evenind = 2 * evenind;// multiply all other numbers by 2
      }
      
      evensum += evenind; // add up all the processed numbers
      evenpos++;
      eventemp--;
    }
 if ((evensum + oddsum) % 10 == 0) //if the sum of the even processed numbers and the sum of the odd numbers is a multiple of 10, return "valid", otherwise "invalid"
 {
   return "valid";
 }
 else 
   return "invalid";
    }
  }
