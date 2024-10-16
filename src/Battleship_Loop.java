public class Battleship_Loop {
    public static void main(String[] args) {

    }
    public static void set(int coinflip, String ship, int len, int vert, String[][] mapp) {
        if (coinflip < 1) {
            for (int i = 0; i < ship.length(); i++) {
                if (len > 3) {
                        mapp[len - i][vert] = ship.substring(i, i + 1);
                } else {
                    mapp[len + i][vert] = ship.substring(i, i + 1);
                }
            }
        } else {
            for (int i = 0; i < ship.length(); i++) {
                if (vert > 3) {
                    mapp[len][vert - i] = ship.substring(i, i + 1);
                } else {
                    mapp[len][vert + i] = ship.substring(i, i + 1);
                }
            }

        }
    }
}
