import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Business {
    static Scanner sc = new Scanner(System.in);
    HashMap<String, String> map = new HashMap<>();
    String[][] arr = {{"o","o","o","o"},{"o","o","o","o"}};
     ArrayList<Parent> parent = new ArrayList<>();
    void start(){
        menuDisplay();
    }//end start

    void menuDisplay(){
        while(true) {
            System.out.println("-------------------");
            System.out.println("| Cinema Project |");
            System.out.println("-------------------");
            System.out.println();
            System.out.println("1.Booking Ticket");
            System.out.println("2.Search Seat");
            System.out.println("3.Change Seat");
            System.out.println("4.Cancel Ticket");
            System.out.println("5.Display Ticket");
            System.out.println("6.Reset");
            System.out.println("7.Exit");


            System.out.print("Select-->");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Select-->");
            }//end while
            int sel = sc.nextInt();


            switch (sel) {
                case 1:
                    booking();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    changeSeat();
                    break;
                case 4:
                    cancel();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    reset();
                    break;
                case 7:
                    System.exit(0);
            }//switch
        }//end while
    }//end menuDisplay



    int i = 0;
    void booking(){
        while(true){
            String name;
            System.out.println();
            do {
                System.out.print("What is ur name?--> ");
                name = sc.next();

                if (letter(name)) //CALL to validate function
                {
                    break; //or loop = false;
                } else // if function returns false
                {
                    System.out.println("Invalid Type, please try again");
                    continue;
                }
            }while(true);
            System.out.println();

            System.out.println("  1 2 3 4");
            for(int i = 0; i < arr.length; i++){
                System.out.print((char)(65+i) + " ");
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " "); // Front A, Back B
                }//end for
                System.out.println();
            }//end for

            String seat;
            do {
                System.out.println("What seat Do you want to take?(eg.A1)");
                System.out.print("Select--> ");
                seat = sc.next();

                if(seatVali(seat)){
                    break;
                }else{
                    System.out.println("Invalid Type, please try again");
                    continue;
                }//end else
            }while(true);

            int f = 0;
            if(seat.charAt(0) == 'A' || seat.charAt(0) == 'B') {
                f = (int) (seat.charAt(0)) - 65;
            }else if(seat.charAt(0) == 'a' || seat.charAt(0) == 'b'){
                f = (int) (seat.charAt(0)) - 97;
            }//end else if
            int s = Integer.parseInt(String.valueOf(seat.charAt(1)));

            if(arr[f][s-1] == "x"){
                System.out.println("The seat is unavailable. Pick again plz");
                continue;
            }

            map.put(name,seat);

            if(seat.contains("A") || seat.contains("a")){
                parent.add(new FrontSeats(name, seat));
            }//end if
            else if(seat.contains("B") || seat.contains("b")){
                parent.add(new BackSeats(name,seat));
            }//end else if

            arr[f][s-1] = "x";

            System.out.println("  1 2 3 4");
            for(int i = 0; i < arr.length; i++){
                System.out.print((char)(65+i) + " ");
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " "); // Front A, Back B
                }//end for
                System.out.println();
            }//end for

            try {
                System.out.println("Printing...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------------------");
            System.out.println("Name: " + name);
            System.out.println("Seat: " + seat);
            System.out.println("Price: " + parent.get(i).ticketPrice(seat));
            System.out.println("------------------------");


            System.out.println();
            String ans;
            do{
                System.out.println("Do you want to book more? (y/n)");
                ans = sc.next();
                if (asking(ans)) //CALL to validate function
                {

                    break; //or loop = false;
                }else // if function returns false
                {
                    System.out.println("Invalid answer, please try again");
                    continue;
                }
            }while(true);//validate ans
            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }//end while
    }//end input

    void search(){
        while(true) {
            String name;
            System.out.println();
            do {
                System.out.print("What is ur name?--> ");
                name = sc.next();

                if (letter(name)) //CALL to validate function
                {
                    break; //or loop = false;
                } else // if function returns false
                {
                    System.out.println("Invalid Type, please try again");
                    continue;
                }
            }while(true);

            if(map.get(name) == null){
                System.out.println("The name is not exist. Try again leter");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }//end if

            String seat = map.get(name);
            System.out.println("------------------------");
            System.out.println("Name: " + name);
            System.out.println("Seat: " + seat);
            System.out.println("------------------------");

            System.out.println();
            String ans;
            do{
                System.out.println("Do you want to search more? (y/n)");
                ans = sc.next();
                if (asking(ans)) //CALL to validate function
                {

                    break; //or loop = false;
                }else // if function returns false
                {
                    System.out.println("Invalid answer, please try again");
                    continue;
                }
            }while(true);//validate ans
            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }//end while
    }//end search

    void changeSeat(){
        while(true){
            String name;
            System.out.println();
            do {
                System.out.print("What is ur name?--> ");
                name = sc.next();

                if (letter(name)) //CALL to validate function
                {
                    break; //or loop = false;
                } else // if function returns false
                {
                    System.out.println("Invalid Type, please try again");
                    continue;
                }
            }while(true);

            if(map.get(name) == null){
                System.out.println("The name is not exist. Try again leter");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }//end if

            String pastSeat = map.get(name);

            System.out.println("  1 2 3 4");
            for(int i = 0; i < arr.length; i++){
                System.out.print((char)(65+i) + " ");
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " "); // Front A, Back B
                }//end for
                System.out.println();
            }//end for

            String seat;
            do {
                System.out.println("What seat Do you want to take?(eg.A1)");
                System.out.print("Select--> ");
                seat = sc.next();

                if(seatVali(seat)){
                    break;
                }else{
                    System.out.println("Invalid Type, please try again");
                    continue;
                }//end else
            }while(true);

            int f = 0;
            if(seat.charAt(0) == 'A' || seat.charAt(0) == 'B') {
                f = (int) (seat.charAt(0)) - 65;
            }else if(seat.charAt(0) == 'a' || seat.charAt(0) == 'b'){
                f = (int) (seat.charAt(0)) - 97;
            }//end else if

            int s = Integer.parseInt(String.valueOf(seat.charAt(1)));

            int pf = 0;
            if(pastSeat.charAt(0) == 'A' || pastSeat.charAt(0) == 'B') {
                pf = (int) (pastSeat.charAt(0)) - 65;
            }else if(pastSeat.charAt(0) == 'a' || pastSeat.charAt(0) == 'b'){
                pf = (int) (pastSeat.charAt(0)) - 97;
            }//end else if
            int ps = Integer.parseInt(String.valueOf(pastSeat.charAt(1)));


            if(arr[f][s-1] == arr[pf][ps-1]){
                System.out.println("The seat is same with previous seat. Pick again plz");
                continue;
            }
            if(arr[f][s-1] == "x"){
                System.out.println("The seat is unavailable. Pick again plz");
                continue;
            }

            map.remove(name);
            map.put(name,seat);

            for(int j = 0; j < parent.size(); j++){
                if(parent.get(j) == null){break;}
                if(parent.get(j).seat.equals(pastSeat)){
                    parent.remove(parent.get(j));
                    if(seat.contains("A") || seat.contains("a")){
                        parent.add(new FrontSeats(name, seat));
                    }//end if
                    else if(seat.contains("B") || seat.contains("b")){
                        parent.add(new BackSeats(name,seat));
                    }//end else if
                }//end if
            }//end for


            arr[pf][ps-1] = "o";
            arr[f][s-1] = "x";

            System.out.println("  1 2 3 4");
            for(int i = 0; i < arr.length; i++){
                System.out.print((char)(65+i) + " ");
                for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " "); // Front A, Back B
                }//end for
                System.out.println();
            }//end for

            try {
                System.out.println("Printing...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------------------");
            System.out.println("Name: " + name);
            System.out.println("Seat: " + seat);
            System.out.println("Price: " + parent.get(i).ticketPrice(seat));
            System.out.println("------------------------");



            System.out.println();
            String ans;
            do{
                System.out.println("Do you want to change more? (y/n)");
                ans = sc.next();
                if (asking(ans)) //CALL to validate function
                {

                    break; //or loop = false;
                }else // if function returns false
                {
                    System.out.println("Invalid answer, please try again");
                    continue;
                }
            }while(true);//validate ans
            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }//end while
    }//end change

    void cancel(){
        while(true){
            String name;
            System.out.println();
            do {
                System.out.print("What is ur name?--> ");
                name = sc.next();

                if (letter(name)) //CALL to validate function
                {
                    break; //or loop = false;
                } else // if function returns false
                {
                    System.out.println("Invalid Type, please try again");
                    continue;
                }
            }while(true);

            if(map.get(name) == null){
                System.out.println("The name is not exist. Try again leter");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }//end if

            String pastSeat = map.get(name);

            int pf = 0;
            if(pastSeat.charAt(0) == 'A' || pastSeat.charAt(0) == 'B') {
                pf = (int) (pastSeat.charAt(0)) - 65;
            }else if(pastSeat.charAt(0) == 'a' || pastSeat.charAt(0) == 'b'){
                pf = (int) (pastSeat.charAt(0)) - 97;
            }//end else if
            int ps = Integer.parseInt(String.valueOf(pastSeat.charAt(1)));


            if(map.get(name) == null){
                System.out.println("There is no reservation on your name. Check again");
                break;
            }//end if

            arr[pf][ps-1] = "o";

            map.remove(name);
            for(int j = 0; j < parent.size(); j++){
                if(parent.get(j) == null){break;}
                if(parent.get(j).seat.equals(pastSeat)){
                    parent.remove(parent.get(j));
                }//end if
            }//end for
            System.out.println("Your seat is canceled");

            System.out.println();
            String ans;
            do{
                System.out.println("Do you want to cancel more? (y/n)");
                ans = sc.next();
                if (asking(ans)) //CALL to validate function
                {

                    break; //or loop = false;
                }else // if function returns false
                {
                    System.out.println("Invalid answer, please try again");
                    continue;
                }
            }while(true);//validate ans
            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }//end while
    }//end cancel

    void display(){
        try {
            System.out.println("Printing...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(parent.size() == 0){
            System.out.println("There is no record");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }//end if
        for(int i = 0; i < parent.size(); i++){
            if(parent.get(i) == null){
                break;
            }//end if
            System.out.println("----------------------");
            System.out.println("Name- " + parent.get(i).custName + " Seat- " + parent.get(i).seat + " Price- " + parent.get(i).ticketPrice(parent.get(i).seat));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end for
    }//end display

    void reset(){
        String ans;
        do{
            System.out.println("Are u sure? (y/n)");
            ans = sc.next();
            if (asking(ans)) //CALL to validate function
            {
                break; //or loop = false;
            }else // if function returns false
            {
                System.out.println("Invalid answer, please try again");
                continue;
            }
        }while(true);//validate ans

        if(ans.equals("y")){
            arr = new String[][]{{"o", "o", "o", "o"}, {"o", "o", "o", "o"}};
            parent = new ArrayList<>();
            map = new HashMap<>();

            try {
                System.out.println("Reset...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("It's reset successfully");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end if
        else if(ans.equals("n")){
            return;
        }//end else
    }//end reset


    public static boolean letter (String s){
        s = s.toLowerCase();
        char testChar;
        String validChars = "abcdefghijklmnopqrstuvwxyz-'  ";
        for (int i = 0; i < s.length(); i++)
        {
            testChar = s.charAt(i);
            if (validChars.indexOf(testChar) < 0)
                return false;

        }//end for
        return true;
    }//end letter

    public static boolean asking (String a){
        a = a.toLowerCase();
        char testChar;
        String validChars = "yn";
        for (int j = 0; j < a.length(); j++)
        {
            testChar = a.charAt(j);
            if (validChars.indexOf(testChar) < 0)
                return false;

        }//end for
        return true;
    }//end asking

    public static boolean seatVali(String s){
        s = s.toLowerCase();
        char testChar;
        char testInt;

        if(s.length() == 2){
            String validChars = "ab";
            String validInteger = "1234";
            testChar = s.charAt(0);
            testInt = s.charAt(1);
            if (validChars.indexOf(testChar) < 0) {
                return false;
            }//end if
            else if(validInteger.indexOf(testInt) < 0){
                return false;
            }//end else if
        }//end if
        else return false;

        return true;
    }//end seatVali

}//end class