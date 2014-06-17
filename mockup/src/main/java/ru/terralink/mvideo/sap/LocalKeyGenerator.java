/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */
package ru.terralink.mvideo.sap;

@SuppressWarnings("all")
public  class LocalKeyGenerator extends com.sybase.sup.client.persistence.LocalKeyGenerator implements com.sybase.reflection.ClassWithMetaData
{
    static
    {
        kgMap.put("mvideo5:1.0", new ru.terralink.mvideo.sap.LocalKeyGenerator());
    }
    
    public LocalKeyGenerator()
    {
        super(ru.terralink.mvideo.sap.Mvideo5DB.getDelegate(), "co_mvideo5_1_0_localkeygenerator", 100000);
    }
    
    /** Begin code region: MetaData **/
    private static ru.terralink.mvideo.sap.intrnl.LocalKeyGeneratorMetaData META_DATA = new ru.terralink.mvideo.sap.intrnl.LocalKeyGeneratorMetaData();
    
    /**
     * return MetaData object  
     */
    public com.sybase.reflection.ClassMetaData getClassMetaData()
    {
        return META_DATA;
    }
    
    /**
     * return MetaData object  
     */
    public static com.sybase.reflection.EntityMetaData getMetaData()
    {
        return META_DATA;
    }
    
    /** End code region: MetaData **/
    
    protected static com.sybase.sup.client.persistence.EntityDelegate DELEGATE = 
        com.sybase.sup.client.persistence.DelegateFactory.createEntityDelegate("LocalKeyGenerator", ru.terralink.mvideo.sap.LocalKeyGenerator.class, "mvideo5.LocalKeyGenerator", META_DATA, ru.terralink.mvideo.sap.Mvideo5DB.getDelegate());
        
    /**
     * Generate surrogate key.  
     */
    public static long generateId()
    {
        return ru.terralink.mvideo.sap.Mvideo5DB.getDelegate().generateLocalId();
    }
    
    public static String generateGuid()
    {
    	return com.sybase.afx.util.StringUtil.guid32();
    }
}