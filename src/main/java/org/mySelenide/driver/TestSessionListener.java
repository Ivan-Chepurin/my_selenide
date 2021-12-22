package org.mySelenide.driver;

import org.junit.platform.launcher.*;

public class TestSessionListener implements LauncherSessionListener {

    private MyDriver driver;

    @Override
    public void launcherSessionOpened(LauncherSession session) {
        session.getLauncher().registerTestExecutionListeners(new TestExecutionListener() {
            @Override
            public void testPlanExecutionStarted(TestPlan testPlan) {
                if (driver == null) {
                    driver = MyDriver.getInstance();
                }
            }
        });
    }

    @Override
    public void launcherSessionClosed(LauncherSession session) {
        if (driver != null) {
            driver.shutDown();
            driver = null;
        }
    }
}
