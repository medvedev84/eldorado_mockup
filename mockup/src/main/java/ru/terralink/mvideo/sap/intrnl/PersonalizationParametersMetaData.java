/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */  
package ru.terralink.mvideo.sap.intrnl;

@SuppressWarnings("all")
public class PersonalizationParametersMetaData extends com.sybase.reflection.ClassMetaData
{
    /**
     * Sybase internal use only.
     */
    public PersonalizationParametersMetaData()
    {
        super(ru.terralink.mvideo.sap.Mvideo5DB.getMetaData());
        _init();
    }
    protected void _init()
    {
        setId(24);
        setAttributes(new com.sybase.reflection.AttributeMetaDataList());
        setAttributeMap(new com.sybase.reflection.AttributeMap());
        com.sybase.reflection.AttributeMetaData username_attribute = addAttributeWithParams
        	(654, "username", "string", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.Session,
        	false, false, true);
        com.sybase.reflection.AttributeMetaData usernameUserDefined_attribute = addAttributeWithParams
        	(655, "usernameUserDefined", "boolean", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"\"", "tinyint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "false", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData password_attribute = addAttributeWithParams
        	(656, "password", "string", 
        	-1, 
        	false, false, true, false, false, 
        	true,false, 
        	"\"\"", "varchar(300)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.Session,
        	true, false, true);
        com.sybase.reflection.AttributeMetaData passwordUserDefined_attribute = addAttributeWithParams
        	(657, "passwordUserDefined", "boolean", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"\"", "tinyint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "false", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        initAttributeMapFromAttributes();
        setName("PersonalizationParameters");
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