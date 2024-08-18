package org.hedhman.qi4jwebdemo.bootstrap.rest;

import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.bootstrap.layered.ModuleAssembler;
import org.qi4j.library.webx.WebxAssembler;

public class WebxModule
    implements ModuleAssembler
{
    public static final String NAME = "Webx Module";

    @Override
    public ModuleAssembly assemble(LayerAssembly layer, ModuleAssembly module)
        throws AssemblyException
    {
        new WebxAssembler().assemble(module);
        return module;
    }
}
