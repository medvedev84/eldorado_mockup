/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */  
package ru.terralink.mvideo.sap.intrnl;

@SuppressWarnings("all")
public class SISSubscriptionKeyMetaData extends com.sybase.reflection.ClassMetaData
{
    /**
     * Sybase internal use only.
     */
    public SISSubscriptionKeyMetaData()
    {
        super(ru.terralink.mvideo.sap.Mvideo5DB.getMetaData());
        _init();
    }
    protected void _init()
    {
        setId(19);
        setAttributes(new com.sybase.reflection.AttributeMetaDataList());
        setAttributeMap(new com.sybase.reflection.AttributeMap());
        com.sybase.reflection.AttributeMetaData domain_attribute = addAttributeWithParams
        	(415, "domain", "string", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData package_attribute = addAttributeWithParams
        	(416, "package", "string", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData syncGroup_attribute = addAttributeWithParams
        	(417, "syncGroup", "string", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData clientId_attribute = addAttributeWithParams
        	(418, "clientId", "string", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        initAttributeMapFromAttributes();
        setName("SISSubscriptionKey");
        setSuperClassDefined(true);
        
    }
    
    /**
     * Sybase internal use only.
     */
    public  boolean isEntity()
    {
        return false;
    }
    
    /**
     * Sybase internal use only.
     */
    public  boolean isService()
    {
        return false;
    }
}