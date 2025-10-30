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
    private JCheckBox clusterCheckBox;
    private JScrollPane generalScrollPane;


    public JComponent getContent() {
        return rootPane;
    }

    private void createUIComponents() {
        generalScrollPane = new JBScrollPane();
        generalScrollPane.setBorder(null);
    }
}
