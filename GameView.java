import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Reference to the view of the board
     */
    private BoardView board;
    private GameModel gameModel;
    
    private JButton redoButton;
    private JButton undoButton;
   
    private final JPanel control;
    
    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {
        super("Circle the Dot");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBackground(Color.WHITE);

        gameModel = model;
    	board = new BoardView(model, gameController);
    	add(board, BorderLayout.CENTER);

    	
        JButton buttonReset = new JButton("Reset");
        buttonReset.setFocusPainted(false);
        buttonReset.addActionListener(gameController);

        JButton buttonExit = new JButton("Quit");
        buttonExit.setFocusPainted(false);
        buttonExit.addActionListener(gameController);
        
        redoButton = new JButton("Redo");
        redoButton.setFocusPainted(false);
        redoButton.addActionListener(gameController);
        
        undoButton = new JButton("Undo");
        undoButton.setFocusPainted(false);
        undoButton.addActionListener(gameController);
        
    	control = new JPanel();
    	control.setBackground(Color.WHITE);
        control.add(buttonReset);
        control.add(buttonExit);
        control.add(redoButton);
        control.add(undoButton);
    	add(control, BorderLayout.SOUTH);
    
    	pack();
    	setResizable(false);
    	setVisible(true);
    }
  

    /**
     * Create a method to update the gameModel
     * @param gameModel
     */
    public void updateModel(GameModel gameModel){
    	board.updateModel(gameModel);
    }
    /**
     * Create a method to update the BoardView
     */
    public void update(){
        board.update();
    }
}
