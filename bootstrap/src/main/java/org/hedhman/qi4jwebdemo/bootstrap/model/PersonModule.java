package org.hedhman.qi4jwebdemo.bootstrap.model;

import org.apache.polygene.api.common.Visibility;
import org.apache.polygene.bootstrap.AssemblyException;
import org.apache.polygene.bootstrap.LayerAssembly;
import org.apache.polygene.bootstrap.ModuleAssembly;
import org.apache.polygene.bootstrap.layered.ModuleAssembler;
import org.hedhman.qi4jwebdemo.model.person.Person;

import static org.apache.polygene.api.common.Visibility.module;

public class PersonModule
    implements ModuleAssembler
{
    public static final String NAME = "Person Module";

    @Override
    public ModuleAssembly assemble(LayerAssembly layer, ModuleAssembly assembly)
        throws AssemblyException
    {
        Class[] entities = new Class[]{
            Person.class
        };

        assembly.entities(entities).visibleIn(module);
        assembly.values(entities).visibleIn(module);
        return assembly;
    }
}
