package org.qi4j.library.webx;

import org.apache.polygene.bootstrap.ApplicationAssembler;

public record ApplicationDefinition(ApplicationAssembler assembler, String webLayerName, String restModuleName )
{
}
