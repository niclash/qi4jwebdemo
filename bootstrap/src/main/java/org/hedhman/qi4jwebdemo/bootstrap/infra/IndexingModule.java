package org.hedhman.qi4jwebdemo.bootstrap.infra;

import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.bootstrap.layered.ModuleAssembler;

public class IndexingModule implements ModuleAssembler
{
    @Override
    public ModuleAssembly assemble(LayerAssembly layer, ModuleAssembly module)
        throws AssemblyException
    {
        return module;
    }
}
