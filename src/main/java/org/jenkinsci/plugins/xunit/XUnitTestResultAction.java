package org.jenkinsci.plugins.xunit;

import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.tasks.junit.TestResult;
import hudson.tasks.junit.TestResultAction;

public class XUnitTestResultAction extends TestResultAction {
    public XUnitTestResultAction(AbstractBuild owner, TestResult result, BuildListener listener) {
        super(owner, result, listener);
    }

    @Override
    public String getUrlName() {
        return "xUnitTestReport";
    }

}
