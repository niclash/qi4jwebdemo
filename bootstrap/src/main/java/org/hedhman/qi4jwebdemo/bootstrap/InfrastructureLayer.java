package org.hedhman.qi4jwebdemo.bootstrap;

import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.bootstrap.layered.LayeredLayerAssembler;
import org.hedhman.qi4jwebdemo.bootstrap.config.ConfigModule;
import org.hedhman.qi4jwebdemo.bootstrap.infra.IndexingModule;
import org.hedhman.qi4jwebdemo.bootstrap.infra.StorageModule;

public class InfrastructureLayer extends LayeredLayerAssembler
{
    public static final String NAME = "Infrastructure Layer";

    @Override
    public LayerAssembly assemble(LayerAssembly layer)
        throws AssemblyException
    {
        ModuleAssembly configModule = layer.application().layer(ConfigLayer.NAME).module(ConfigModule.NAME);
        createModule( layer, StorageModule.class, configModule);
        createModule(layer, IndexingModule.class);

        return layer;
    }
}
