package org.jenkinsci.plugins.xunit;

import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.tasks.junit.TestResultAction;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestResultProjectAction;

public class XUnitProjectAction extends TestResultProjectAction {
    public XUnitProjectAction(AbstractProject<?, ?> project) {
        super(project);
    }

    public AbstractTestResultAction getLastTestResultAction() {
        final AbstractBuild<?,?> tb = project.getLastSuccessfulBuild();

        AbstractBuild<?,?> b=project.getLastBuild();
        while(b!=null) {
            AbstractTestResultAction a = b.getAction(TestResultAction.class);
            if(a!=null && (!b.isBuilding())) return a;
            if(b==tb)
                // if even the last successful build didn't produce the test result,
                // that means we just don't have any tests configured.
                return null;
            b = b.getPreviousBuild();
        }

        return null;
    }
}
