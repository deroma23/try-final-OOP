import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class Policy extends JPanel {
    Policy() {
        this.setPreferredSize(new Dimension(600, 350));
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);

        JPanel title = new JPanel();
        title.setBackground(Color.ORANGE);
        title.setBounds(0,0, 600,75);
        title.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;


        JLabel title_label = new JLabel("GAME5");
        title_label.setFont(new Font("Arial", Font.BOLD, 30));
        title_label.setHorizontalAlignment(SwingConstants.CENTER);
        title.add(title_label, gbc);

        //terms
        JPanel terms = new JPanel();
        terms.setBounds(0,75, 600,200);
        terms.setLayout(null);
        terms.setBackground(Color.green);

        JPanel term_ofUsepanel = new JPanel();
        term_ofUsepanel.setBounds(0,0, 600,50);
        term_ofUsepanel.setLayout(new GridBagLayout());
        term_ofUsepanel.setBackground(Color.LIGHT_GRAY);

        //label
        JLabel term_label = new JLabel();
        term_label.setText("Terms of Use");
        term_label.setFont(new Font("Arial", Font.PLAIN, 18));
        term_ofUsepanel.add(term_label,gbc);

        JPanel panel_terms = new JPanel();
        panel_terms.setLayout(new GridBagLayout());
        panel_terms.setBounds(0,50,600,150);
        panel_terms.setBackground(Color.MAGENTA);

        JTextPane label = new JTextPane();
        label.setPreferredSize(new Dimension(250,100));
        label.setText(
                "To continue playing, you need to confirm that you agree to our terms of Use and have read our Privacy Policy"
        );
//        label.setPreferredSize(new Dimension(400,100));
//        label.setFont(new Font("Arial", Font.PLAIN, 14));
//        label.setLineWrap(true); // Enable line wrapping
//        label.setWrapStyleWord(true); // Wrap at word boundaries
//        label.setOpaque(false); // Make background transparent
//        label.setEditable(false); // Make it non-editable
//        label.setFocusable(false); // Remove focus for better UX
        GridBagConstraints detail_term = new GridBagConstraints();
        detail_term.gridx = 0;
        detail_term.gridy = 0;

        // Center align text
        StyledDocument doc = label.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // Disable editing (make it like a label)
        label.setEditable(false);
        label.setFocusable(false);
        label.setBackground(Color.magenta);
        label.setBorder(null);

        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setBorder(null);
        panel_terms.add(scrollPane, detail_term);


        terms.add(term_ofUsepanel);
        terms.add(panel_terms);

        //panel
        JPanel termsOfUsePanel = new JPanel();
        termsOfUsePanel.setLayout(new GridBagLayout());
        termsOfUsePanel.setBounds(0, 275, 600, 30);
        termsOfUsePanel.setBackground(Color.red);
        //label
        JLabel use_terms = new JLabel();
        use_terms.setText("Terms of Use");
        GridBagConstraints t = new GridBagConstraints();
        t.gridx = 0;
        t.gridy = 0;
        termsOfUsePanel.add(use_terms, t);


        //panel
        JPanel privacyPolicy = new JPanel();
        privacyPolicy.setLayout(new GridBagLayout());
        privacyPolicy.setBounds(0, 305, 600, 30);
        privacyPolicy.setBackground(Color.blue);
        //label
        JLabel policyLabel = new JLabel();
        policyLabel.setText("Privacy Policy");
        GridBagConstraints p = new GridBagConstraints();
        p.gridx = 0;
        p.gridy = 0;
        privacyPolicy.add(policyLabel, p);

        this.add(title);
        this.add(terms);
        this.add(termsOfUsePanel);
        this.add(privacyPolicy);

    }
}
