package io.github.mfaisalkhatri;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

public class CustomTestLauncher {

    public static void main (String[] args) {
        LauncherDiscoveryRequest launcherrequest = LauncherDiscoveryRequestBuilder.request ()
            .selectors (DiscoverySelectors.selectClasses (BillingServiceTest.class))
            .build ();

        Launcher launcher = LauncherFactory.create ();
        launcher.execute (launcherrequest);
    }
}