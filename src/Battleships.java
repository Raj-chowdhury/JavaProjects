import java.util.Scanner;

public class Battleships {
    public static void main(String[] args) {
        boolean loopy = false;
        String[][] map = new String[7][7];
        String ship1 = "ASCE";
        String ship2 = "ZORO";
        String ship3 = "VIVI";
        while (!loopy) {
            for (int row = 0; row < map.length; row++)
            {
                for (int col = 0; col < map[row].length; col++)
                {
                    map[row][col] = "_";
                }
            }

            int coinflip1 = (int)(Math.random()*2);
            int coinflip2 = (int)(Math.random()*2);
            int coinflip3 = (int)(Math.random()*2);
            int len1 =  (int)(Math.random()*7);
            int len2 =  (int)(Math.random()*7);
            int len3 =  (int)(Math.random()*7);
            int vert1 =  (int)(Math.random()*7);
            int vert2 =  (int)(Math.random()*7);
            int vert3 =  (int)(Math.random()*7);
            Battleship_Loop bat1 = new Battleship_Loop();
            bat1.set(coinflip1, ship1, len1, vert1, map);
            Battleship_Loop bat2 = new Battleship_Loop();
            bat2.set(coinflip2, ship2, len2, vert2, map);
            Battleship_Loop bat3 = new Battleship_Loop();
            bat3.set(coinflip3, ship3, len3, vert3, map);
            int count = 0;
            //visual, only for me to adjust code
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length; col++)
                {
                    System.out.print( map[row][col] );
                }
                System.out.println(" ");
            }
            System.out.println(" ");

            String[][] clear =  new String[7][7];
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length; col++) {
                    clear[row][col] = map[row][col];
                }
            }

//            System.arraycopy( map, 0, clear, 0, map.length );
            for (int row = 0; row < clear.length; row++) {
                for (int col = 0; col < clear[row].length; col++) {
                    for (int i=0; i< ship1.length(); i++) {
                        String try1 = String.valueOf(ship1.charAt(i));
                        String try2 = String.valueOf(ship2.charAt(i));
                        String try3 = String.valueOf(ship3.charAt(i));
                        if (clear[row][col].equals(try1)) {
                            clear[row][col] = "_";
                            count++;
                        }  else if (clear[row][col].equals(try2)) {
                            clear[row][col] = "_";
                            count++;
                        } else if (clear[row][col].equals(try3)) {
                            clear[row][col] = "_";
                            count++;
                        }
                    }
                    System.out.print(map[row][col]);
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            if (count == ship1.length() + ship2.length() + ship3.length()) {
                loopy = true;
            }
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length; col++)
                {
                    System.out.print(map[row][col]);
                }
                System.out.println(" ");
            }
            System.out.println(" ");

        }
        //Develop guessing part
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        while (true) {
            int done = 0;
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length; col++)
                {
                    if (map[row][col].equals("*") || map[row][col].equals("_")) {
                        done++;
                    }
                }
            }
            if (done == 49) {
                System.out.print("You win! You have sunk all the ships!");
                System.exit(1);
            }

            String value;
            System.out.print("Guess the coordinates of the ships: ");
            Scanner val = new Scanner(System.in);
            value = (val.nextLine()).toUpperCase();
            if (value.length() != 2) {
                System.out.println("Invalid input, try again");
                continue;
            }

            String pos = Character.toString(value.charAt(0));
            int pos1;
            int pos2 = Integer.valueOf(Character.toString(value.charAt(1)));
            if (pos2>6) {
                System.out.println("Invalid Input, please try again");
                continue;
            }
            if (pos.equals("A")) {
                pos1 = 0;
            } else if (pos.equals("B")) {
                pos1 = 1;
            } else if (pos.equals("C")) {
                pos1 = 2;
            } else if (pos.equals("D")) {
                pos1 = 3;
            } else if (pos.equals("E")) {
                pos1 = 4;
            } else if (pos.equals("F")) {
                pos1 = 5;
            } else if (pos.equals("G")) {
                pos1 = 6;
            } else {
                System.out.println("Invalid Input, please try again");
                continue;
            }
            String fpos = map[pos1][pos2];

            for (char ch = 'A'; ch<='Z'; ch++) {
                String test = Character.toString(ch);
                if (fpos.equals(test)) {
                    System.out.println("You hit a ship!");
                    map[pos1][pos2] = "*";
                    if (ship1.contains(fpos)) {
                        count1++;
                        if (count1 == 4) {
                            System.out.println("You have sunk ship ASCE!");
                        }
                    } else if (ship2.contains(fpos)) {
                        count2++;
                        if (count2 == 4) {
                            System.out.println("You have sunk ship ZORO!");
                        }
                    } else if (ship3.contains(fpos)) {
                        count3++;
                        if (count3 == 4) {
                            System.out.println("You have sunk ship VIVI!");
                        }
                    }
                    break;
                }
            }



            if (fpos.equals("*")) {
                System.out.println("You have hit these coordinates before, try again");
            } else if (fpos.equals("_")) {
                System.out.println("That's a miss, try again");
                map[pos1][pos2] = "*";
            }

        }
    }
}
