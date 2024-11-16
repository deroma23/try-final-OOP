import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map extends JPanel {

    JPanel top_panel;

    JLabel duration_label;

    Frame frame;

    Map(Frame fr) {
        this.frame = fr;
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());

        TopPanel();
        TopPanelRightSide();




        this.add(top_panel, BorderLayout.NORTH);
    }

    void TopPanel() {
        top_panel = new JPanel();
        top_panel.setLayout(new BorderLayout());
        top_panel.setPreferredSize(new Dimension(0, 50));
        top_panel.setBackground(Color.green);

        JPanel left_side_top_panep = new JPanel();
        left_side_top_panep.setLayout(null);
        left_side_top_panep.setBackground(Color.blue);
        left_side_top_panep.setPreferredSize( new Dimension(100, 0));//height 50

        int left_side_top_panep_width = 100;
        int left_side_top_panep_height = 50;



        //heart icon
        ImageIcon heartIcon = new ImageIcon("heart-icon.png");
        JLabel heart = new JLabel();
        heart.setIcon(heartIcon);
        heart.setText("0/5");
        heart.setPreferredSize(new Dimension(50,20));
        heart.setBackground(Color.LIGHT_GRAY);
        heart.setOpaque(true);
        heart.setBounds(
                20,
                (left_side_top_panep_height - heart.getPreferredSize().height)/2,
                50,
                20

        );
        left_side_top_panep.add(heart);

        //button
        JButton plusButton = new JButton();
        plusButton.setBackground(Color.lightGray);
        plusButton.setText("+");
        plusButton.setPreferredSize(new Dimension(50,20));
        plusButton.setBounds(
                70,
                (50- 20)/2,
                20,
                20
        );
        plusButton.setBorder(null);
        plusButton.setFocusable(false);
        plusButton.setFont(new Font("Arial", Font.BOLD, 14));
        left_side_top_panep.add(plusButton);





        duration_label = new JLabel("00:00");
        duration_label.setPreferredSize(new Dimension(50,20));
        duration_label.setBounds(
                70,
                ((50- 20)/2) + duration_label.getPreferredSize().height,
                25,
                10

        );
        duration_label.setFont(new Font("Arial", Font.PLAIN, 8));
        duration_label.setBackground(Color.gray);
        duration_label.setOpaque(true);
        left_side_top_panep.add(duration_label);


        top_panel.add(left_side_top_panep, BorderLayout.WEST);


    }

    void TopPanelRightSide(){
        // RIGHT PANEL INSIDE THE TOP PANEL
        JPanel right_panel_inside_top_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        right_panel_inside_top_panel.setBackground(Color.WHITE);

        //setting button
        JButton setting_btn = new JButton();
        setting_btn.setPreferredSize(new Dimension(50,40));
        setting_btn.setFocusable(false);
        ImageIcon setting_icon = new ImageIcon("setting-icon.png");
        setting_btn.setIcon(setting_icon);
        setting_btn.setBorderPainted(false);
        setting_btn.setBackground(Color.WHITE);

        //shop button
        JButton shop_button = new JButton();
        shop_button.setPreferredSize(new Dimension(50,40));
        shop_button.setBorderPainted(false);
        shop_button.setFocusable(false);
        shop_button.setBackground(Color.WHITE);
        ImageIcon shop_icon = new ImageIcon("shopping-cart.png");
        shop_button.setIcon(shop_icon);
        shop_button.addActionListener((e) -> {
            JPanel p = new JPanel();
            p.setBackground(Color.red);
            frame.NewPage(p);
        });


        //add shop button to the right side panel
        right_panel_inside_top_panel.add(shop_button/*, BorderLayout.WEST*/);
        //add setting button to the right side panel
        right_panel_inside_top_panel.add(setting_btn/*, BorderLayout.EAST*/);


        top_panel.add(right_panel_inside_top_panel, BorderLayout.EAST);

    }


}
