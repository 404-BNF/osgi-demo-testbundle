package dev.sk.bundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;


public class HttpServiceTracker extends ServiceTracker {

    private BundleContext context;

    public HttpServiceTracker(BundleContext context) {
        super(context, HttpService.class.getName(), null);
        this.context = context;
    }

    public Object addingService(ServiceReference reference) {
        HttpService httpService = (HttpService) context.getService(reference);
        System.out.println("Adding HTTP Service");
        try {
            httpService.registerServlet(TestServlet.SERVLET_ALIAS, new TestServlet(), null, null);
//        } catch (ServletException | NamespaceException e) {
        } catch (Exception e) {
            System.err.println("Servlet couldn't be registered: " + e.getMessage());
        }
        return httpService;
    }

    public void removedService(ServiceReference reference, Object service) {
        super.removedService(reference, service);
    }
}