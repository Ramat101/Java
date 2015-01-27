import java.util.*;

public class Body {

	public static void main(String[] args) {
            GameGui2 game = new GameGui2();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGui2().setVisible(true);
            }
            });
		ArrayList<Rocketship> enemy = Game.setUpGame();
		Game.playGame(enemy);
		// TODO Auto-generated method stub

	}

}
