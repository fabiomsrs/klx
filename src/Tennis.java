import java.util.Locale;
import java.util.Map;

public class Tennis {

    public static class Player {
        public Integer score = 0;
    }

    public static void game(String input) {
        Player playerA = new Player();
        Player playerB = new Player();

        for (char result : input.toUpperCase(Locale.ROOT).toCharArray()) {
            if (result == 'A') {
                updateScore(playerA, playerB);
            } else if (result == 'B') {
                updateScore(playerB, playerA);
            }

            callResult(playerA, playerB);

        }

    }

    private static void callResult(Player playerA, Player playerB) {
        Map<Integer, String> scores = Map.of(0, "0",
                1, "15",
                2, "30",
                3, "40");

        if (playerA.score > 3 && (playerA.score - playerB.score >= 2)) {
            System.out.println("Player A wins the game");
        } else if (playerB.score > 3 && (playerB.score - playerA.score >= 2)) {
            System.out.println("Player B wins the game");
        } else {
            System.out.println("Player A: " + scores.getOrDefault(playerA.score, "Advantage") + " / Player B: " + scores.getOrDefault(playerB.score, "Advantage"));
        }
    }

    private static void updateScore(Player playerOne, Player playerTwo) {
        if (playerOne.score == 3) {
            if (playerTwo.score == 3) {
                playerOne.score = 4;
                return;
            } else if (playerTwo.score > 3) {
                playerTwo.score = 3;
                return;
            }
        }
        playerOne.score += 1;
    }

    public static void main(String[] args) {
        // Examples input
        String input = "ABABABABBB";
//        String input = "ABABABAA";
//        String input = "ABABABA";
//        String input = "aBABABABBB";
//        String input = "CBABABABB";
        game(input);
    }
}
