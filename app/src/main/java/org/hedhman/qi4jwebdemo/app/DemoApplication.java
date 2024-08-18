package org.hedhman.qi4jwebdemo.app;

import jakarta.inject.Singleton;
import jakarta.ws.rs.ApplicationPath;
import org.apache.polygene.api.structure.Application;
import org.apache.polygene.bootstrap.ApplicationAssembler;
import org.apache.polygene.bootstrap.ApplicationAssembly;
import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.layered.LayeredApplicationAssembler;
import org.glassfish.jersey.server.ResourceConfig;
import org.hedhman.qi4jwebdemo.bootstrap.ConfigLayer;
import org.hedhman.qi4jwebdemo.bootstrap.InfrastructureLayer;
import org.hedhman.qi4jwebdemo.bootstrap.ModelLayer;
import org.hedhman.qi4jwebdemo.bootstrap.RestLayer;
import org.hedhman.qi4jwebdemo.bootstrap.rest.WebxModule;
import org.qi4j.library.webx.ApplicationDefinition;
import org.qi4j.library.webx.Qi4jApplication;

import java.util.Map;
import java.util.Set;

@ApplicationPath("/api")
@Singleton
public class DemoApplication extends /* jakarta.ws.rs.core.Application */ ResourceConfig
{

    public DemoApplication()
    {
        ApplicationAssembler assembler = new LayeredApplicationAssembler("Demo App", "1.0", Application.Mode.development)
        {
            @Override
            protected void assembleLayers(ApplicationAssembly assembly)
                throws AssemblyException
            {
                LayerAssembly restLayer = createLayer(RestLayer.class);
                LayerAssembly modelLayer = createLayer(ModelLayer.class);
                LayerAssembly infraLayer = createLayer(InfrastructureLayer.class);
                LayerAssembly configLayer = createLayer(ConfigLayer.class);
                restLayer.uses(modelLayer);
                modelLayer.uses(infraLayer);
                infraLayer.uses(configLayer);
            }
        };
        Qi4jApplication qi4jApplication = new Qi4jApplication(new ApplicationDefinition(assembler, RestLayer.NAME, WebxModule.NAME));
        register(qi4jApplication);
    }
}