import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Frame extends JFrame {
    public String path = null;
    public String pc_name = null;
    public String game_name = null;

    public JPanel frame_panel;
    Frame() {

        this.setTitle("GAME5");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);


        frame_panel = new JPanel();
        frame_panel.setPreferredSize(new Dimension(800, 600));
        frame_panel.setBackground(Color.BLUE);
        frame_panel.setLayout(new FlowLayout());

        game_name = this.getTitle();
        try
        {
            Inet4Address address = (Inet4Address) Inet4Address.getLocalHost();
            pc_name = address.getHostName();
        }catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        path = "C:\\Users\\User\\Saved Games\\"+ game_name;
        File dir = new File(path);
//        dir.mkdir();
        if(dir.exists()){
            frame_panel.setLayout(new BorderLayout());
            NewPage(new Map(this));
        }
        else
        {
            //kapag wala pang acc
            frame_panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;


            //lalagyan ng policy
            JPanel policy = new JPanel();
            policy.setPreferredSize(new Dimension(600,400));
            policy.setLayout(new BorderLayout());

            //lalagyan ng terms of policy
            JPanel policyContainer = new JPanel();
             policyContainer.setLayout(new BorderLayout());
            policyContainer.add(new Policy());




            JPanel btn_container = new JPanel();
            btn_container.setPreferredSize(new Dimension(0,50));
            btn_container.setBackground(Color.green);

            JButton accept = new JButton("accept");
            accept.addActionListener((e)->{
                frame_panel.setLayout(new BorderLayout());
                NewPage(new Map(this));
                dir.mkdir();
            });
            btn_container.add(accept);

            policy.add(policyContainer, BorderLayout.CENTER);
            policy.add(btn_container, BorderLayout.SOUTH);

            //iadd ang policy
            frame_panel.add(policy, gbc);
        }
        //frame panel
        this.add(frame_panel);




        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void NewPage(Component p){
        frame_panel.removeAll();
        frame_panel.add(p, BorderLayout.CENTER);
        frame_panel.revalidate();
        frame_panel.repaint();
    }
}
