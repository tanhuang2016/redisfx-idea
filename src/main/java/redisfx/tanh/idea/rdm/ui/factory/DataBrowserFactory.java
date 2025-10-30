package redisfx.tanh.idea.rdm.ui.factory;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;
import redisfx.tanh.idea.rdm.ui.view.ToolWindows;

public  class DataBrowserFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolWindows toolWindows = new ToolWindows(project);
        ContentManager contentManager = toolWindow.getContentManager();
//        contentManager.getFactory().createContent(toolWindows.content(),"", true); 使用下面这种老方式，兼容旧版本idea
        ContentFactory contentFactory = ApplicationManager.getApplication().getService(ContentFactory.class);
        Content content = contentFactory.createContent(toolWindows.content(), "", true);
        contentManager.addContent(content);
    }
}
