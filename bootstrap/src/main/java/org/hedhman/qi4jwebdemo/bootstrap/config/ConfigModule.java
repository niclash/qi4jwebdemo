package org.hedhman.qi4jwebdemo.bootstrap.config;

import org.apache.polygene.api.common.Visibility;
import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.bootstrap.layered.ModuleAssembler;
import org.apache.polygene.entitystore.memory.assembly.MemoryEntityStoreAssembler;

import static org.apache.polygene.api.common.Visibility.application;

public class ConfigModule
    implements ModuleAssembler
{
    public static final String NAME = "Config Module";

    @Override
    public ModuleAssembly assemble(LayerAssembly layer, ModuleAssembly module)
        throws AssemblyException
    {
        new MemoryEntityStoreAssembler().visibleIn(application).assemble(module);
        return module;
    }
}
