/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */
package ru.terralink.mvideo.sap;

@SuppressWarnings("all")
public  class KeyGeneratorPK extends com.sybase.persistence.AbstractStructure implements com.sybase.reflection.ClassWithMetaData
{
    private static ru.terralink.mvideo.sap.intrnl.KeyGeneratorPKMetaData META_DATA = new ru.terralink.mvideo.sap.intrnl.KeyGeneratorPKMetaData();
    
    /**
     * Return MetaData instance.  
     */
    public com.sybase.reflection.ClassMetaData getClassMetaData()
    {
        return META_DATA;
    }
    
    /**
     * Return MetaData instance.  
     */
    public static com.sybase.reflection.ClassMetaData getMetaData()
    {
        return META_DATA;
    }
    protected static com.sybase.sup.client.persistence.ClassDelegate DELEGATE = 
        new com.sybase.sup.client.persistence.ClassDelegate("KeyGeneratorPK", ru.terralink.mvideo.sap.KeyGeneratorPK.class, META_DATA, ru.terralink.mvideo.sap.Mvideo5DB.getDelegate());
    
    /**
     * Creates an instance of ru.terralink.mvideo.sap.KeyGeneratorPK  
     */
    public KeyGeneratorPK()
    {
        this.setClassDelegate(DELEGATE);
        _init();
    }
    protected void _init()
    {
        
    }
    
    private java.lang.String __remoteId ;  
    
    private long __batchId ;  
    
    public long getAttributeLong(int id)
    {
        switch(id)
        {
        case 1160:
            return getBatchId();
        default:
            return super.getAttributeLong(id);
        }
    }
    
    public void setAttributeLong(int id, long v)
    {
        switch(id)
        {
        case 1160:
            setBatchId((long)v);
            break;
        default:
            super.setAttributeLong(id, v);
            break;
        }
    }
    public java.lang.String getAttributeString(int id)
    {
        switch(id)
        {
        case 1159:
            return getRemoteId();
        default:
            return super.getAttributeString(id);
        }
    }
    
    public void setAttributeString(int id, java.lang.String v)
    {
        switch(id)
        {
        case 1159:
            setRemoteId((java.lang.String)v);
            break;
        default:
            super.setAttributeString(id, v);
            break;
        }
    }
    
    public Object getAttributeJson(int id)
    {
        switch(id)
        {
        default:
            return super.getAttributeJson(id);
        }
    }
    
    public void setAttributeJson(int id, Object value)
    {
        switch(id)
        {
        default:
            super.setAttributeJson(id, value);
            break;
        }
    }
    
    /**
     * get the value of remoteId  
     */
    public java.lang.String getRemoteId()
    {
        
        return __remoteId;
    }
    
    /**
     * Set the value of remoteId  
     */
    public void setRemoteId(java.lang.String value)
    {
        __remoteId = value;
    }
    
    /**
     * get the value of batchId  
     */
    public long getBatchId()
    {
        
        return __batchId;
    }
    
    /**
     * Set the value of batchId  
     */
    public void setBatchId(long value)
    {
        __batchId = value;
    }
}