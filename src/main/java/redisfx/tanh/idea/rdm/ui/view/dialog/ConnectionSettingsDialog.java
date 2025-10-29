package redisfx.tanh.idea.rdm.ui.view.dialog;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;


public class ConnectionSettingsDialog extends DialogWrapper implements Disposable {

    protected ConnectionSettingsDialog(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return null;
    }

    @Override
    public void dispose() {

    }

}
