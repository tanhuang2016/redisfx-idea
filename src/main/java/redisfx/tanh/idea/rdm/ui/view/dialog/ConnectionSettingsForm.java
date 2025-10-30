package redisfx.tanh.idea.rdm.ui.view.dialog;

import javax.swing.*;

public class ConnectionSettingsForm {
    private JTabbedPane tabbedPane;
    private JPanel rootPane;
    private JTextField name;
    private JTextField host;
    private JTextField port;
    private JTextField auth;
    private JCheckBox clusterCheckBox;
    private JScrollPane generalScrollPane;


    public JComponent getContent() {
        generalScrollPane.setBorder(null);
//        generalScrollPane.setViewportBorder(null);
        return rootPane;
    }
}
