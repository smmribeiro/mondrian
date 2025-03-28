/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package mondrian.rolap;

import mondrian.olap.Util;
import mondrian.util.*;

/**
 * Globally unique identifier for the metadata content of a schema.
 *
 * <p>Two schemas have the same content if they have same schema XML.
 * But schemas are also deemed to have the same content if they are read from
 * the same URL (subject to rules about how often the contents of a URL change)
 * or if their content has the same MD5 hash.</p>
 *
 * @see SchemaKey
 *
 * @author jhyde
 */
class SchemaContentKey extends StringKey {
    private SchemaContentKey(String s) {
        super(s);
    }

    static SchemaContentKey create(
        final Util.PropertyList connectInfo,
        final String catalogUrl,
        final String catalogContents)
    {
        final String catalogContentProp =
            RolapConnectionProperties.CatalogContent.name();
        final String dynamicSchemaProp =
            RolapConnectionProperties.DynamicSchemaProcessor.name();

        StringBuilder buf = new StringBuilder();
        if (!Util.isEmpty(connectInfo.get(catalogContentProp))
            || !Util.isEmpty(connectInfo.get(dynamicSchemaProp)))
        {
            ConnectionKey.attributeValue(buf, "catalogStr", catalogContents);
        } else {
            ConnectionKey.attributeValue(buf, "catalog", catalogUrl);
        }
        return new SchemaContentKey(
            new ByteString(Util.digestMd5(buf.toString())).toString());
    }
}

// End SchemaContentKey.java
