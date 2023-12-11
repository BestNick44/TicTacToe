import java.util.Scanner;  
import java.util.*;  
class Main {
  public static void main(String[] args) {
    List<String> spaces = new ArrayList<String>();
    
    for(int i = 0; i < 11; i++) {
      spaces.add("-");
    }
    String win = spaces.get(10);
    board(spaces);
    guessLogic(spaces);
    board(spaces);
    while(win.equals("-")){
      spaces.set(9, "-");
      if(win.equals("-")){
        enemyLogic(spaces);
        board(spaces);
      }
      win = spaces.get(10);
      if(win.equals("-")){
        guessLogic(spaces);
        board(spaces);
      }
      win = spaces.get(10);
      
      
    }
  }
  public static void guessLogic(List<String> spaces) {
    Scanner input = new Scanner(System.in);
    String fail = spaces.get(9);
    int change;
    while(fail.equals("-")){
      System.out.println("Please guess a space");
      System.out.println();
      String g = input.nextLine();
      String before;
      fail = spaces.set(9, "0");
      
      correctGuessLogic(g, spaces, "1a", "a1", 0);
      correctGuessLogic(g, spaces, "1b", "b1", 0);
      correctGuessLogic(g, spaces, "1c", "c1", 0);
      correctGuessLogic(g, spaces, "2a", "a2", 0);
      correctGuessLogic(g, spaces, "2b", "b2", 0);
      correctGuessLogic(g, spaces, "2c", "c2", 0);
      correctGuessLogic(g, spaces, "3a", "a3", 0);
      correctGuessLogic(g, spaces, "3b", "b3", 0);
      correctGuessLogic(g, spaces, "3c", "c3", 0);
      
      fail = spaces.get(9);
    }
  }
  public static void correctGuessLogic(String g, List<String> spaces, String one, String two, int space) {
    String fail = spaces.get(9);
    if(g.equals(one)||g.equals(two)){
        guessLogicInside(spaces, space);
      }
      else{
        fail = spaces.set(9, "-");
        error();
      }
  }
  public static void guessLogicInside(List<String> spaces, int change) {
    
    String before = spaces.get(change);
    if(before.equals("-")){
      spaces.set(change, "X");
    }
    else{
      spaces.set(9, "-");
      error();
    }
  }
  public static void enemyLogic(List<String> spaces) {
    int done = 0;
    while(done <= 1000){
      int random = (int)(Math.random() * 9);
      System.out.println(random);
      String before = spaces.get(random);
        if(before.equals("-")){
          spaces.set(random, "o");
          done = 1002;
        }
        else{
          done ++;
        }
      if(done == 1001){
        System.out.println("You have tied");
        spaces.set(10, "0");
      }
    }
  }
  public static void winLogic(List<String> spaces, String one, String two, String three, String four, String five, String six, String seven, String eight, String nine, String guess, String outcome) {

    if(one.equals(guess) && two.equals(guess) && three.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(four.equals(guess) && five.equals(guess) && six.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(seven.equals(guess) && eight.equals(guess) && nine.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(one.equals(guess) && four.equals(guess) && seven.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(two.equals(guess) && five.equals(guess) && eight.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(three.equals(guess) && six.equals(guess) && nine.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(one.equals(guess) && five.equals(guess) && nine.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
    else if(three.equals(guess) && five.equals(guess) && seven.equals(guess)){
      spaces.set(10, "0");
      System.out.println("You " + outcome);
    }
  }
  public static void board(List<String> spaces) {

    String one = spaces.get(0);
    String two = spaces.get(1);
    String three = spaces.get(2);
    String four = spaces.get(3);
    String five = spaces.get(4);
    String six = spaces.get(5);
    String seven = spaces.get(6);
    String eight = spaces.get(7);
    String nine = spaces.get(8);
    
    
    System.out.println("               a     b     c");
    System.out.println("                  |     |    ");
    System.out.println("          1    " + one + "  |  " + two + "  |  " + three);
    System.out.println("             _____|_____|_____");
    System.out.println("                  |     |    ");
    System.out.println("          2    " + four + "  |  " + five + "  |  " + six);
    System.out.println("             _____|_____|_____");
    System.out.println("                  |     |    ");
    System.out.println("          3    " + seven + "  |  " + eight + "  |  " + nine);
    System.out.println("                  |     |    ");
    winLogic(spaces, one, two, three, four, five, six, seven, eight, nine, "X", "Win");
    winLogic(spaces, one, two, three, four, five, six, seven, eight, nine, "o", "Lose");
   
  }
  public static void error() {
    System.out.println();
    System.out.println("Invalid comand");
    System.out.println("Or");
    System.out.println("The spot is selected already");
    System.out.println();
  }
}
