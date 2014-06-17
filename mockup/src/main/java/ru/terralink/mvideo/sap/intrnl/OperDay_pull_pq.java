/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */
package ru.terralink.mvideo.sap.intrnl;

@SuppressWarnings("all")
public  class OperDay_pull_pq extends com.sybase.sup.client.persistence.RbsAbstractPersistentQuery implements com.sybase.reflection.ClassWithMetaData
{
    /** Begin code region: MetaData **/
    private static ru.terralink.mvideo.sap.intrnl.OperDay_pull_pqMetaData META_DATA = new ru.terralink.mvideo.sap.intrnl.OperDay_pull_pqMetaData();
    
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
        com.sybase.sup.client.persistence.DelegateFactory.createEntityDelegate("OperDay_pull_pq", ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq.class, "mvideo5.OperDay_pull_pq", META_DATA, ru.terralink.mvideo.sap.Mvideo5DB.getDelegate());
    public static com.sybase.sup.client.persistence.EntityDelegate getEntityDelegateForPQ()
    {
        return DELEGATE;
    }
    
    
    /** Begin code region: Properties **/
    private java.lang.String __username ;  
    
    private java.lang.String __remoteId ;  
    
    private java.sql.Date __sp_dateParam  = com.sybase.afx.json.JsonValue.getNullableDate("2014-04-23");  
    
    private java.lang.String __sp_numbParam  = com.sybase.afx.json.JsonValue.getNullableString("");  
    
    private long __id ;  
    
    public long getAttributeLong(int id)
    {
        switch(id)
        {
        case 523:
            return getId();
        default:
            return super.getAttributeLong(id);
        }
    }
    
    public void setAttributeLong(int id, long v)
    {
        switch(id)
        {
        case 523:
            setId((long)v);
            break;
        default:
            super.setAttributeLong(id, v);
            break;
        }
    }
    public java.lang.String getAttributeNullableString(int id)
    {
        switch(id)
        {
        case 524:
            return getUsername();
        case 525:
            return getRemoteId();
        case 529:
            return getSp_numbParam();
        default:
            return super.getAttributeNullableString(id);
        }
    }
    
    public void setAttributeNullableString(int id, java.lang.String v)
    {
        switch(id)
        {
        case 524:
            setUsername((java.lang.String)v);
            break;
        case 525:
            setRemoteId((java.lang.String)v);
            break;
        case 529:
            setSp_numbParam((java.lang.String)v);
            break;
        default:
            super.setAttributeNullableString(id, v);
            break;
        }
    }
    public java.sql.Date getAttributeNullableDate(int id)
    {
        switch(id)
        {
        case 528:
            return getSp_dateParam();
        default:
            return super.getAttributeNullableDate(id);
        }
    }
    
    public void setAttributeNullableDate(int id, java.sql.Date v)
    {
        switch(id)
        {
        case 528:
            setSp_dateParam((java.sql.Date)v);
            break;
        default:
            super.setAttributeNullableDate(id, v);
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
    /** End code region: Properties **/
    
    /** Begin code region: Constructor and init **/
    /**
     * Creates an instance of ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq  
     */
    public OperDay_pull_pq()
    {
        setEntityDelegate(DELEGATE);
        _init();
    }
    protected void _init()
    {
        
    }
    /** End code region: Constructor and init **/
    
    /**
     * get the value of username  
     */
    public java.lang.String getUsername()
    {
        
        return __username;
    }
    
    /**
     * Set the value of username  
     */
    public void setUsername(java.lang.String value)
    {
        if ((__username == null) != (value == null) || (value != null && ! value.equals(__username)))
        {
            _isDirty = true;
        }
        __username = value;
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
        if ((__remoteId == null) != (value == null) || (value != null && ! value.equals(__remoteId)))
        {
            _isDirty = true;
        }
        __remoteId = value;
    }       
    /**
     * get the value of sp_dateParam  
     */
    public java.sql.Date getSp_dateParam()
    {
        
        return __sp_dateParam;
    }
    
    /**
     * Set the value of sp_dateParam  
     */
    public void setSp_dateParam(java.sql.Date value)
    {
        if ((__sp_dateParam == null) != (value == null) || (value != null && ! value.equals(__sp_dateParam)))
        {
            _isDirty = true;
        }
        __sp_dateParam = value;
    }       
    /**
     * get the value of sp_numbParam  
     */
    public java.lang.String getSp_numbParam()
    {
        
        return __sp_numbParam;
    }
    
    /**
     * Set the value of sp_numbParam  
     */
    public void setSp_numbParam(java.lang.String value)
    {
        if ((__sp_numbParam == null) != (value == null) || (value != null && ! value.equals(__sp_numbParam)))
        {
            _isDirty = true;
        }
        __sp_numbParam = value;
    }       
    /**
     * get the value of id  
     */
    public long getId()
    {
        
        return __id;
    }
    
    /**
     * Set the value of id  
     */
    public void setId(long value)
    {
        if(__id != value)
        {
            _isDirty = true;
        }
        __id = value;
    }
    
    /**
     * Search mobile business object using surrogateKey
     * @param id surrogateKey
     * @return mobile business object
     */
    public static ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq find(long id)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "OperDay_pull_pq.find()";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
            Object[] keys = new Object[]{id};
            return (ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq)(DELEGATE.findEntityWithKeys(keys));
        }
        finally
        {
            if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
            {
                com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().stopInterval(intervalName);
            }
        }
    }
    
    /**
     * Get the mobile business object by surrogate key.
     * @param id surrogate key
     * @return the mobile business object for the surroget key
     * @exception ObjectNotFoundException Thrown if unable to retrieve mobile business object.
     */
    public static ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq load(long id)
    {
        return (ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq)(DELEGATE.load(id));
    }
    
    /**
     * Get surroget key of the mobile business object  
     */
    public java.lang.Long _pk()
    {
        return (java.lang.Long)i_pk();
    }
    
    /** Begin code region: Finder methods **/
    /**
     * Find a List of Ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq> findAll(int skip, int take)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "OperDay_pull_pq.findAll";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = " s.\"username\",s.\"remoteId\",s.\"sp_dateParam\",s.\"sp_numbParam\",s.\"id\" from \"mvideo5_1_0_operday_pull_pq\" s";
                _selectSQL = "select " + _selectSQL;
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                };
                Object[] values = new Object[] { 
                };
                com.sybase.collections.GenericList<Object> res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, skip, take, ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq.class);
                return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq>)(Object)res;
        }
        finally
        {
            if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
            {
                com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().stopInterval(intervalName);
            }
        }
    }
    /**
     * Find a list of ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq> findAll()
    {
        return findAll(0, Integer.MAX_VALUE);
    }
    /**
     * Find a mobile business object Ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq findSub(java.lang.String _username
                                                                         ,java.sql.Date sp_date
                                                                         ,java.lang.String sp_numb)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "OperDay_pull_pq.findSub";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = "select s.\"username\",s.\"remoteId\",s.\"sp_dateParam\",s.\"sp_numbParam\",s.\"id\" from \"mvideo5_1_0_operday_pull_pq\" s where s.\"username\" =? and ( s.\"sp_dateParam\"=? or (s.\"sp_dateParam\" IS NULL AND CAST(? AS date) IS NULL)) and ( s.\"sp_numbParam\"=? or (s.\"sp_numbParam\" IS NULL"
                                        + " AND CAST(? AS varchar(100)) IS NULL))";
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                    com.sybase.reflection.DataType.forName("string?"),
                    com.sybase.reflection.DataType.forName("date?"),
                    com.sybase.reflection.DataType.forName("date?"),
                    com.sybase.reflection.DataType.forName("string?"),
                    com.sybase.reflection.DataType.forName("string?"),
                };
                Object[] values = new Object[] { 
                    _username,
                    sp_date,
                    sp_date,
                    sp_numb,
                    sp_numb,
                };
                Object res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq.class);
                return (ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq)res;
        }
        finally
        {
            if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
            {
                com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().stopInterval(intervalName);
            }
        }
    }
    
    /**
     * Returns the MBOs that are updated locally but not submitted.  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq> getPendingObjects(int skip, int take)
    {
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq>)(Object)DELEGATE.getPendingObjects(skip, take);
    }
    
    /**
     * Returns the MBOs that are updated locally but not submmited.  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq> getPendingObjects()
    {
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq>)(Object)DELEGATE.getPendingObjects();
    }
    
    /** End code region: Finder methods **/
    /**
     * Returns the log record list.  
     */
    public com.sybase.collections.GenericList<com.sybase.persistence.LogRecord> getLogRecords()
    {
        return ru.terralink.mvideo.sap.LogRecordImpl.findByEntity("OperDay_pull_pq", keyToString());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Install a callback handler
     */
    public static void registerCallbackHandler(com.sybase.persistence.CallbackHandler handler)
    {
        DELEGATE.registerCallbackHandler(handler);
    }
    
    public static com.sybase.persistence.CallbackHandler getCallbackHandler()
    {
        return DELEGATE.getCallbackHandler();
    }
}