package redisfx.tanh.idea.rdm.ui.view.dialog;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;


public class ConnectionSettingsDialog extends DialogWrapper implements Disposable {

    private ConnectionSettingsForm form;

    public ConnectionSettingsDialog(@Nullable Project project) {
        super(project);
        this.setTitle("Connection Settings");
        this.setSize(500, 350);
        form= new ConnectionSettingsForm();
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return form.getContent();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        System.out.println(123);
    }
}
