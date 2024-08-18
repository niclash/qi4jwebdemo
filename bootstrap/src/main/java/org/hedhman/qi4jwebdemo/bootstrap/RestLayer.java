package org.hedhman.qi4jwebdemo.bootstrap;

import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.layered.LayerAssembler;
import org.apache.polygene.bootstrap.layered.LayeredLayerAssembler;
import org.hedhman.qi4jwebdemo.bootstrap.config.ConfigModule;
import org.hedhman.qi4jwebdemo.bootstrap.rest.WebxModule;

public class RestLayer extends LayeredLayerAssembler
{
    public static final String NAME = "Rest Layer";

    @Override
    public LayerAssembly assemble(LayerAssembly layer)
        throws AssemblyException
    {
        createModule(layer, WebxModule.class);
        return layer;
    }
}
