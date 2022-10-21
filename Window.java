import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Window extends JFrame  {

    JPanel optionsPanel;
    JPanel gamePanel;

    JButton start;
    JButton exit;

    Board game;
    // Timer timer;

    public Window() {
        super("Chess");
        final int HEIGHT = 400;
        final int WIDTH = 600;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        //panel opcji
        optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.setBounds(new Rectangle(400, 100));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Opcje"));

        start = new JButton("start");
        start.setBounds(new Rectangle(0, 0, 100, 30));
        start.setVisible(true);
        start.addActionListener(this::handleStart);


        exit = new JButton("exit");
        exit.setBounds(new Rectangle(150, 0, 100, 30));
        exit.setVisible(true);
        exit.addActionListener(this::handleExit);

        optionsPanel.add(start);
        optionsPanel.add(exit);


        gamePanel = new JPanel(new GridLayout(8,8));
        gamePanel.setBounds(new Rectangle(400,500));
        gamePanel.setBorder(BorderFactory.createTitledBorder("Plansza"));

        //dodanie komponentow do frame
        this.add(optionsPanel, BorderLayout.PAGE_START);
        this.add(gamePanel, BorderLayout.CENTER);
        this.setVisible(true);

    }

    private void handleStart(ActionEvent e){
        initGame();
    }

    private void handleExit(ActionEvent e){
        dispose();
        System.exit(0);
    }

    private void initGame(){
        if(this.game != null) {
            this.game.remove();
            // this.timer.reset();
        }
        this.game = new Board(gamePanel);
        this.refresh();
        
    }

    public void refresh(){
        this.invalidate();
        this.revalidate();
        this.repaint();
    }



}
