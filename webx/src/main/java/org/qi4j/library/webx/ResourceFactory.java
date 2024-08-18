package org.qi4j.library.webx;

import org.apache.polygene.api.injection.scope.Structure;
import org.apache.polygene.api.injection.scope.Uses;
import org.apache.polygene.api.object.ObjectFactory;
import org.glassfish.hk2.api.Factory;

public class ResourceFactory
    implements Factory
{
    @Uses
    Class<?> type;

    @Structure
    ObjectFactory obf;

    @Override
    public Object provide()
    {
        return obf.newObject(type);
    }

    @Override
    public void dispose(Object o)
    {
    }
}
