package org.hedhman.qi4jwebdemo.bootstrap;

import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.layered.LayerAssembler;
import org.apache.polygene.bootstrap.layered.LayeredLayerAssembler;
import org.apache.polygene.bootstrap.layered.ModuleAssembler;
import org.hedhman.qi4jwebdemo.bootstrap.config.ConfigModule;

public class ConfigLayer  extends LayeredLayerAssembler
{
    public static final String NAME = "Config Layer";

    @Override
    public LayerAssembly assemble(LayerAssembly layer)
        throws AssemblyException
    {
        createModule(layer, ConfigModule.class);
        return layer;
    }
}
