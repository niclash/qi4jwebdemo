package org.qi4j.library.webx;

import org.apache.polygene.api.injection.scope.Structure;
import org.apache.polygene.api.injection.scope.Uses;
import org.apache.polygene.api.structure.Module;
import org.glassfish.hk2.api.Factory;


public class ServiceResourceFactory
    implements Factory
{
    private final Object serviceInstance;

    public ServiceResourceFactory(
        @Structure Module module,
        @Uses Class<?> serviceType)
    {
        serviceInstance = module.serviceFinder().findService(serviceType).get();
    }

    @Override
    public Object provide()
    {
        return serviceInstance;
    }

    @Override
    public void dispose(Object o)
    {

    }
}
