package dev.sk.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private static BundleContext context;

    private ServiceTracker httpServiceTracker;

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("OSGI Bundle Start...");
        System.out.println("bundleContext is null? " + (bundleContext==null) );
        Activator.context = bundleContext;
        httpServiceTracker = new HttpServiceTracker(context);
        httpServiceTracker.open();
        System.out.println("Finished OSGI Bundle start...");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("OSGI Bundle Stop...");
        Activator.context = null;
        httpServiceTracker.close();
    }

}