import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortuneTellerFrame extends JFrame
{
    private JPanel mainPanel, topPanel, middlePanel, bottomPanel;
    private JLabel title;
    private ImageIcon imageIcon;
    private JLabel imageLable;
    private JTextArea fortuneTextArea;
    private JScrollPane scroll;
    private JButton quitButton, newFortuneButton;
    private ActionListener quit = new QuitListener();
    private ActionListener newFortune = new FortuneListener();

    private String[] fortunes =
    {
            "Love will find you", // 1
            "Death is over the horizon", // 2
            "I sense darkness in you", // 3
            "Love all, trust a few, do wrong to none", // 4
            "Life is filled with many things, be one that changes the world", // 5
            "Be someone you can be proud of", // 6
            "The end of the world is near", // 7
            "Happiness is coming", // 8
            "You favorite team will win next weekend", // 9
            "Life will give you a sign later today", // 10
            "This is the sign", // 11
            "Life will continue if you press the button again", // 12
    };

    public FortuneTellerFrame()
    {
        setTitle("Fortune Teller");
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        title = new JLabel("Welcome to the Fortune Teller");
        imageIcon = new ImageIcon("FortuneTellerPic.jpg");

        Image image = imageIcon.getImage();
        Image newIMG = image.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon((newIMG));

        imageLable = new JLabel(imageIcon);
        fortuneTextArea = new JTextArea(12,40);
        scroll = new JScrollPane(fortuneTextArea);
        newFortuneButton = new JButton("Read my New Fortune!");
        newFortuneButton.addActionListener(newFortune);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new GridLayout(1,2));

        topPanel.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        topPanel.add(imageLable);

        middlePanel.add(scroll);
        fortuneTextArea.setFont(new Font("Times New Roman", Font.BOLD, 25));

        bottomPanel.add(newFortuneButton);
        newFortuneButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        bottomPanel.add(quitButton);
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
    }

    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }

    private class FortuneListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int i = (int)((Math.random() * (12 - 1)) + 1);

            int timePressed = 0;
            while (i == timePressed)
            {
                i = (int)((Math.random() * (12 - 1)) + 1);
            }
            timePressed = i;

            fortuneTextArea.append(fortunes[i] + "\n");
        }
    }
}