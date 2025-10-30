package redisfx.tanh.idea.rdm.ui.view.dialog;

import javax.swing.*;

public class ConnectionSettingsForm {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField name;
    private JTextField host;
    private JTextField port;
    private JTextField auth;
    private JCheckBox clusterCheckBox;


    public JComponent getContent() {
        return panel1;
    }
}
