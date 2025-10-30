package redisfx.tanh.idea.rdm.ui.view.dialog;

import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;

public class ConnectionSettingsForm {
    private JTabbedPane tabbedPane;
    private JPanel rootPane;
    private JTextField name;
    private JTextField host;
    private JTextField port;
    private JTextField auth;
    private JScrollPane generalScrollPane;
    private JPasswordField password;
    private JCheckBox clusterCheckBox;
    private JCheckBox sentinelCheckBox;
    private JTextField masterName;
    private JPasswordField passwordField1;


    public JComponent getContent() {
        return rootPane;
    }

    private void createUIComponents() {
        generalScrollPane = new JBScrollPane();
        generalScrollPane.setBorder(null);
    }
}
