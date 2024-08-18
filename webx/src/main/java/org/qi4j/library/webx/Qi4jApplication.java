package org.qi4j.library.webx;

import org.apache.polygene.api.injection.scope.Structure;
import org.apache.polygene.api.object.ObjectFactory;
import org.apache.polygene.api.structure.Application;
import org.apache.polygene.api.structure.Module;
import org.apache.polygene.api.structure.TypeLookup;
import org.apache.polygene.bootstrap.Energy4Java;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class Qi4jApplication extends AbstractBinder
{
    private final Module restModule;

    public Qi4jApplication(ApplicationDefinition def)
    {
        Application application = new Energy4Java().newApplication(def.assembler());
        restModule = application.findModule(def.webLayerName(), def.restModuleName());
    }

    @Override
    protected void configure()
    {
        TypeLookup typeLookup = restModule.typeLookup();
        typeLookup.allObjects().forEach( descriptor -> {
            Class<?> type = descriptor.types().findFirst().get();
            ResourceFactory resourceFactory = restModule.objectFactory().newObject(ResourceFactory.class, type);
            bindFactory(resourceFactory).to(type);
        });
        typeLookup.allServices().forEach( descriptor ->
        {
            Class<?> type = descriptor.types().findFirst().get();
            ServiceResourceFactory resourceFactory = restModule.objectFactory().newObject(ServiceResourceFactory.class, type);
            bindFactory(resourceFactory).to(type);
        });
    }
}
