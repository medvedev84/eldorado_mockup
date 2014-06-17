/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */
package ru.terralink.mvideo.sap;

@SuppressWarnings("all")
public  class Relations extends com.sybase.persistence.AbstractEntity implements com.sybase.persistence.MobileBusinessObject, com.sybase.reflection.ClassWithMetaData
{
    /** Begin code region: MetaData **/
    private static ru.terralink.mvideo.sap.intrnl.RelationsMetaData META_DATA = new ru.terralink.mvideo.sap.intrnl.RelationsMetaData();
    
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
        com.sybase.sup.client.persistence.DelegateFactory.createEntityDelegate("Relations", ru.terralink.mvideo.sap.Relations.class, "mvideo5.Relations", META_DATA, ru.terralink.mvideo.sap.Mvideo5DB.getDelegate());
    
    
    /** Begin code region: Properties **/
    private java.lang.String __FO_TOR_ID ;  
    
    private java.lang.String __FU_TOR_ID ;  
    
    private java.lang.String __IV_VEHICLE_NUMB ;  
    
    private java.sql.Date __IV_BEGDA ;  
    
    private ru.terralink.mvideo.sap.OperDay __operDay ;  
    
    private com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> __relationsOrderss ;  
    
      
    
      
    
      
    
      
    
    private com.sybase.persistence.BigString __cvpOperation ;  
    
    private com.sybase.persistence.BigString __cvpOperationLobs ;  
    
    private java.lang.Long __operDayFK ;  
    
    private boolean __operDayValid ;  
    
    private long __surrogateKey ;  
    
      
    
      
    
    private long __cvpOperationLength ;  
    
    private long __cvpOperationLobsLength ;  
    
    public long getAttributeLong(int id)
    {
        switch(id)
        {
        case 222:
            return getSurrogateKey();
        case 1327:
            return getCvpOperationLength();
        case 1328:
            return getCvpOperationLobsLength();
        default:
            return super.getAttributeLong(id);
        }
    }
    
    public void setAttributeLong(int id, long v)
    {
        switch(id)
        {
        case 222:
            setSurrogateKey((long)v);
            break;
        case 1327:
            setCvpOperationLength((long)v);
            break;
        case 1328:
            setCvpOperationLobsLength((long)v);
            break;
        default:
            super.setAttributeLong(id, v);
            break;
        }
    }
    public com.sybase.persistence.BigString getAttributeNullableBigString(int id)
    {
        switch(id)
        {
        case 758:
            return getCvpOperation();
        case 759:
            return getCvpOperationLobs();
        default:
            return super.getAttributeNullableBigString(id);
        }
    }
    
    public java.lang.String getAttributeString(int id)
    {
        switch(id)
        {
        case 218:
            return getFO_TOR_ID();
        case 219:
            return getFU_TOR_ID();
        case 220:
            return getIV_VEHICLE_NUMB();
        default:
            return super.getAttributeString(id);
        }
    }
    
    public void setAttributeString(int id, java.lang.String v)
    {
        switch(id)
        {
        case 218:
            setFO_TOR_ID((java.lang.String)v);
            break;
        case 219:
            setFU_TOR_ID((java.lang.String)v);
            break;
        case 220:
            setIV_VEHICLE_NUMB((java.lang.String)v);
            break;
        default:
            super.setAttributeString(id, v);
            break;
        }
    }
    public java.lang.Long getAttributeNullableLong(int id)
    {
        switch(id)
        {
        case 783:
            return getOperDayFK();
        default:
            return super.getAttributeNullableLong(id);
        }
    }
    
    public void setAttributeNullableLong(int id, java.lang.Long v)
    {
        switch(id)
        {
        case 783:
            setOperDayFK((java.lang.Long)v);
            break;
        default:
            super.setAttributeNullableLong(id, v);
            break;
        }
    }
    public java.sql.Date getAttributeNullableDate(int id)
    {
        switch(id)
        {
        case 221:
            return getIV_BEGDA();
        default:
            return super.getAttributeNullableDate(id);
        }
    }
    
    public void setAttributeNullableDate(int id, java.sql.Date v)
    {
        switch(id)
        {
        case 221:
            setIV_BEGDA((java.sql.Date)v);
            break;
        default:
            super.setAttributeNullableDate(id, v);
            break;
        }
    }
    public boolean getAttributeBoolean(int id)
    {
        switch(id)
        {
        case 787:
            return getOperDayValid();
        default:
            return super.getAttributeBoolean(id);
        }
    }
    
    public void setAttributeBoolean(int id, boolean v)
    {
        switch(id)
        {
        case 787:
            setOperDayValid((boolean)v);
            break;
        default:
            super.setAttributeBoolean(id, v);
            break;
        }
    }
    public java.lang.Object getAttributeObject(int id, boolean loadFromDBIfInvalid)
    {
        switch(id)
        {
        case 223:
            if(loadFromDBIfInvalid)
            {
                return getOperDay();
            }
            else
            {
                return __operDay;
            }
        case 224:
            if(loadFromDBIfInvalid)
            {
                return getRelationsOrderss();
            }
            else
            {
                return __relationsOrderss;
            }
        default:
            return super.getAttributeObject(id);
        }
    }
    
    public void setAttributeObject(int id, java.lang.Object v)
    {
        switch(id)
        {
        case 223:
            setOperDay((ru.terralink.mvideo.sap.OperDay)v);
            break;
        case 224:
            setRelationsOrderss((com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders>)v);
            break;
        default:
            super.setAttributeObject(id, v);
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
     * Creates an instance of ru.terralink.mvideo.sap.Relations  
     */
    public Relations()
    {
        setEntityDelegate(DELEGATE);
        _init();
    }
    protected void _init()
    {
        
    }
    /** End code region: Constructor and init **/
    
    /**
     * get the value of FO_TOR_ID  
     */
    public java.lang.String getFO_TOR_ID()
    {
        
        return __FO_TOR_ID;
    }
    
    /**
     * Set the value of FO_TOR_ID  
     */
    public void setFO_TOR_ID(java.lang.String value)
    {
        if ((__FO_TOR_ID == null) != (value == null) || (value != null && ! value.equals(__FO_TOR_ID)))
        {
            _isDirty = true;
        }
        __FO_TOR_ID = value;
    }       
    /**
     * get the value of FU_TOR_ID  
     */
    public java.lang.String getFU_TOR_ID()
    {
        
        return __FU_TOR_ID;
    }
    
    /**
     * Set the value of FU_TOR_ID  
     */
    public void setFU_TOR_ID(java.lang.String value)
    {
        if ((__FU_TOR_ID == null) != (value == null) || (value != null && ! value.equals(__FU_TOR_ID)))
        {
            _isDirty = true;
        }
        __FU_TOR_ID = value;
    }       
    /**
     * get the value of IV_VEHICLE_NUMB  
     */
    public java.lang.String getIV_VEHICLE_NUMB()
    {
        
        return __IV_VEHICLE_NUMB;
    }
    
    /**
     * Set the value of IV_VEHICLE_NUMB  
     */
    public void setIV_VEHICLE_NUMB(java.lang.String value)
    {
        if ((__IV_VEHICLE_NUMB == null) != (value == null) || (value != null && ! value.equals(__IV_VEHICLE_NUMB)))
        {
            _isDirty = true;
        }
        __IV_VEHICLE_NUMB = value;
    }       
    /**
     * get the value of IV_BEGDA  
     */
    public java.sql.Date getIV_BEGDA()
    {
        
        return __IV_BEGDA;
    }
    
    /**
     * Set the value of IV_BEGDA  
     */
    public void setIV_BEGDA(java.sql.Date value)
    {
        if ((__IV_BEGDA == null) != (value == null) || (value != null && ! value.equals(__IV_BEGDA)))
        {
            _isDirty = true;
        }
        __IV_BEGDA = value;
    }       
    /**
     * get the value of operDay  
     */
    public ru.terralink.mvideo.sap.OperDay getOperDay()
    {
        if (! __operDayValid)
        {
            if( (__operDayFK != null))
            {
                __operDay = ru.terralink.mvideo.sap.OperDay.find(__operDayFK);
            }
            __operDayValid = true;
        }
        return __operDay;
    }
    
    /**
     * Set the value of operDay  
     */
    public void setOperDay(ru.terralink.mvideo.sap.OperDay value)
    {
        if (getOperDay() != null)
        {
            if( !__operDay.equals(value) )
            {
                _isDirty = true;
            }
        }
        else if(value != null)
        {
            _isDirty = true;
        }
        if(__operDay != null)
        {
            __operDay.setDirty(_isDirty);
        }
        if (value == null)
        {
            __operDayFK = null;
        }
        else
        {
            value.setDirty(_isDirty);
            __operDayFK = value._pk();
            __FO_TOR_ID = value.getTOR_ID();
            __IV_VEHICLE_NUMB = value.getIV_VEHICLE_NUMB();
            __IV_BEGDA = value.getIV_BEGDA();
        }
        __operDayValid = true;
        __operDay = value;
    }       
    /**
     * Get the value of relationsOrderss  
     */
    public com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> getRelationsOrderss()
    {
        return getRelationsOrderss(false,false);
    }
    /**
     * Sybase internal use only.
     */
    public com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> getRelationsOrderss(boolean ignoreNonPending,boolean ignoreDisableSubmit)
    {
        if (__relationsOrderss == null)
        {
            __relationsOrderss = ru.terralink.mvideo.sap.Orders.getRelationsOrderss_for_Relations(new java.lang.Long(getSurrogateKey()));
        }
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders>)filterChildren(__relationsOrderss, ignoreNonPending, ignoreDisableSubmit, new com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders>());
    }
    /**
     * Set the value of relationsOrderss  
     */
    public void setRelationsOrderss(com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> x)
    {
        __relationsOrderss = x;
    }
    /**
     * return relationsOrderss filtering by query objects  
     */
    public com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> getRelationsOrderssFilterBy(com.sybase.persistence.Query query)
    {
        return ru.terralink.mvideo.sap.Orders.findWithQuery(initChildrenQuery(query, new String[]{"relationsFK"}));
    }
    
    /**
     * return MBO count filter by query object  
     */
    public int getRelationsOrderssSize(com.sybase.persistence.Query query)
    {
        return ru.terralink.mvideo.sap.Orders.getSize(initChildrenQuery(query, new String[]{"relationsFK"}));
    }       
    /**
     * get the value of cvpOperation  
     */
    public com.sybase.persistence.BigString getCvpOperation()
    {
        
        if(__cvpOperation==null)
        {
        	__cvpOperation = new com.sybase.persistence.internal.BigStringImpl(this, "cvpOperation");
        }
        return __cvpOperation;
    }       
    /**
     * get the value of cvpOperationLobs  
     */
    public com.sybase.persistence.BigString getCvpOperationLobs()
    {
        
        if(__cvpOperationLobs==null)
        {
        	__cvpOperationLobs = new com.sybase.persistence.internal.BigStringImpl(this, "cvpOperationLobs");
        }
        return __cvpOperationLobs;
    }       
    /**
     * get the value of operDayFK  
     */
    public java.lang.Long getOperDayFK()
    {
        
        return __operDayFK;
    }
    
    /**
     * Set the value of operDayFK  
     */
    public void setOperDayFK(java.lang.Long value)
    {
        if ((__operDayFK == null) != (value == null) || (value != null && ! value.equals(__operDayFK)))
        {
            __operDayValid = false;
            _isDirty = true;
        }
        __operDayFK = value;
    }       
    /**
     * get the value of operDayValid  
     */
    private boolean getOperDayValid()
    {
        
        return __operDayValid;
    }
    
    /**
     * Set the value of operDayValid  
     */
    private void setOperDayValid(boolean value)
    {
        __operDayValid = value;
    }       
    /**
     * get the value of surrogateKey  
     */
    public long getSurrogateKey()
    {
        
        return __surrogateKey;
    }
    
    /**
     * Set the value of surrogateKey  
     */
    public void setSurrogateKey(long value)
    {
        if(__surrogateKey != value)
        {
            _isDirty = true;
        }
        __surrogateKey = value;
    }       
    /**
     * get the value of cvpOperationLength  
     */
    public long getCvpOperationLength()
    {
        
        return __cvpOperationLength;
    }
    
    /**
     * Set the value of cvpOperationLength  
     */
    public void setCvpOperationLength(long value)
    {
        if(__cvpOperationLength != value)
        {
            _isDirty = true;
        }
        __cvpOperationLength = value;
    }       
    /**
     * get the value of cvpOperationLobsLength  
     */
    public long getCvpOperationLobsLength()
    {
        
        return __cvpOperationLobsLength;
    }
    
    /**
     * Set the value of cvpOperationLobsLength  
     */
    public void setCvpOperationLobsLength(long value)
    {
        if(__cvpOperationLobsLength != value)
        {
            _isDirty = true;
        }
        __cvpOperationLobsLength = value;
    }       
    
    private java.util.List filterChildren(java.util.List childrenList, boolean ignoreNonPending, boolean ignoreDisableSubmit, java.util.List filteredList)
    {
        if(ignoreNonPending || ignoreDisableSubmit)
        {
            java.util.Iterator<Object> it = childrenList.iterator();
            while (it.hasNext())
            {
                final Object __o = (Object)(it.next());
                com.sybase.persistence.AbstractEntity __e = (com.sybase.persistence.AbstractEntity)__o;
                boolean __addObj = true;
                if (ignoreNonPending && !__e.isPending())
                {
                    __addObj = false;
                }
                else if (ignoreDisableSubmit && __e.getDisableSubmit())
                {
                    __addObj = false;
                }
                if(__addObj)
                {
                    filteredList.add(__e);
                }
            }
            return filteredList;
        }
        else
        {
            return childrenList;
        }
    }
    
    /**
     * Search mobile business object using surrogateKey
     * @param id surrogateKey
     * @return mobile business object
     */
    public static ru.terralink.mvideo.sap.Relations find(long id)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.find()";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
            Object[] keys = new Object[]{id};
            return (ru.terralink.mvideo.sap.Relations)(DELEGATE.findEntityWithKeys(keys));
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
    public static ru.terralink.mvideo.sap.Relations load(long id)
    {
        return (ru.terralink.mvideo.sap.Relations)(DELEGATE.load(id));
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
     * return MBO count filter by query object  
     */
    public static int getSize(com.sybase.persistence.Query query)
    {
        return DELEGATE.getSize(query);
    }
    
    /**
     * Find a List of Relations
     * @param query The query to be filter.
     * @exception PersistenceException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findWithQuery(com.sybase.persistence.Query query)
    {
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)DELEGATE.findWithQuery(query, ru.terralink.mvideo.sap.Relations.class);
    }
    
    /**
     * Find a List of Ru.terralink.mvideo.sap.Relations
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findAll(int skip, int take)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.findAll";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
            String _selectSQL = "select " + " x.\"a\",x.\"b\",x.\"c\",x.\"d\",x.\"pending\",x.\"_pc\",x.\"_rp\",x.\"_rf\",x.\"operDayFK\",x.\"e\",x.\"_rc\",x.\"_ds\",x.\"cvpOperation_length\",x.\"cvpOperationLobs_length\" FROM \"mvideo5_1_0_relations\" x where (((x.\"pending\" = 1 or not exists (select x_os.\"e\" from \"mvideo5_1_0_relations_os\" x_"
                                                + "os where x_os.\"e\" = x.\"e\"))))"; 
            return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)DELEGATE.findWithSQL(skip, take, _selectSQL, ru.terralink.mvideo.sap.Relations.class);
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
     * Find a list of ru.terralink.mvideo.sap.Relations  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findAll()
    {
        return findAll(0, Integer.MAX_VALUE);
    }
    /**
     * Find a List of Ru.terralink.mvideo.sap.Relations
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findByFO_TOR_ID(java.lang.String FO_TOR_ID, int skip, int take)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.findByFO_TOR_ID";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = " x.\"a\",x.\"b\",x.\"c\",x.\"d\",x.\"pending\",x.\"_pc\",x.\"_rp\",x.\"_rf\",x.\"operDayFK\",x.\"e\",x.\"_rc\",x.\"_ds\",x.\"cvpOperation_length\",x.\"cvpOperationLobs_length\" FROM \"mvideo5_1_0_relations\" x WHERE (((x.\"pending\" = 1 or not exists (select x_os.\"e\" from \"mvideo5_1_0_relations_os\" x_"
                                        + "os where x_os.\"e\" = x.\"e\")))) and ( x.\"a\" = ?)";
                _selectSQL = "select " + _selectSQL;
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                    com.sybase.reflection.DataType.forName("string"),
                };
                Object[] values = new Object[] { 
                    FO_TOR_ID,
                };
                com.sybase.collections.GenericList<Object> res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, skip, take, ru.terralink.mvideo.sap.Relations.class);
                return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)res;
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
     * Find a list of ru.terralink.mvideo.sap.Relations  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findByFO_TOR_ID(java.lang.String FO_TOR_ID)
    {
        return findByFO_TOR_ID(FO_TOR_ID, 0, Integer.MAX_VALUE);
    }
    /**
     * Find a List of Ru.terralink.mvideo.sap.Relations
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findByFU_TOR_ID(java.lang.String FU_TOR_ID, int skip, int take)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.findByFU_TOR_ID";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = " x.\"a\",x.\"b\",x.\"c\",x.\"d\",x.\"pending\",x.\"_pc\",x.\"_rp\",x.\"_rf\",x.\"operDayFK\",x.\"e\",x.\"_rc\",x.\"_ds\",x.\"cvpOperation_length\",x.\"cvpOperationLobs_length\" FROM \"mvideo5_1_0_relations\" x WHERE (((x.\"pending\" = 1 or not exists (select x_os.\"e\" from \"mvideo5_1_0_relations_os\" x_"
                                        + "os where x_os.\"e\" = x.\"e\")))) and ( x.\"b\" = ?)";
                _selectSQL = "select " + _selectSQL;
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                    com.sybase.reflection.DataType.forName("string"),
                };
                Object[] values = new Object[] { 
                    FU_TOR_ID,
                };
                com.sybase.collections.GenericList<Object> res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, skip, take, ru.terralink.mvideo.sap.Relations.class);
                return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)res;
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
     * Find a list of ru.terralink.mvideo.sap.Relations  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> findByFU_TOR_ID(java.lang.String FU_TOR_ID)
    {
        return findByFU_TOR_ID(FU_TOR_ID, 0, Integer.MAX_VALUE);
    }
    /**
     * Find a mobile business object Ru.terralink.mvideo.sap.Relations
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static ru.terralink.mvideo.sap.Relations findByPrimaryKey(java.lang.String FO_TOR_ID
                                                                     ,java.lang.String FU_TOR_ID)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.findByPrimaryKey";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = "SELECT x.\"a\",x.\"b\",x.\"c\",x.\"d\",x.\"pending\",x.\"_pc\",x.\"_rp\",x.\"_rf\",x.\"operDayFK\",x.\"e\",x.\"_rc\",x.\"_ds\",x.\"cvpOperation_length\",x.\"cvpOperationLobs_length\" FROM \"mvideo5_1_0_relations\" x WHERE (((x.\"pending\" = 1 or not exists (select x_os.\"e\" from \"mvideo5_1_0_relations_"
                                        + "os\" x_os where x_os.\"e\" = x.\"e\")))) and ( x.\"a\" = ? AND x.\"b\" = ?)";
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                    com.sybase.reflection.DataType.forName("string"),
                    com.sybase.reflection.DataType.forName("string"),
                };
                Object[] values = new Object[] { 
                    FO_TOR_ID,
                    FU_TOR_ID,
                };
                Object res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, ru.terralink.mvideo.sap.Relations.class);
                return (ru.terralink.mvideo.sap.Relations)res;
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
     * Find a List of Ru.terralink.mvideo.sap.Relations
     * @exception PersistentException Thrown if unable to retrieve mobile business object.
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> getOperDayRelations_for_OperDay(java.lang.Long surrogateKey, int skip, int take)
    {
        String intervalName = null;
        if(com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.isEnabled)
        {
            intervalName = "Relations.getOperDayRelations_for_OperDay";
            com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.getInstance().startInterval(intervalName, com.sybase.mobile.util.perf.impl.PerformanceAgentServiceImpl.PersistenceRead);
        }
        try
        {
    
            
                String _selectSQL = " x.\"a\",x.\"b\",x.\"c\",x.\"d\",x.\"pending\",x.\"_pc\",x.\"_rp\",x.\"_rf\",x.\"operDayFK\",x.\"e\",x.\"_rc\",x.\"_ds\",x.\"cvpOperation_length\",x.\"cvpOperationLobs_length\" from \"mvideo5_1_0_relations\" x where (((x.\"pending\" = 1 or not exists (select x_os.\"e\" from \"mvideo5_1_0_relations_os\" x_"
                                        + "os where x_os.\"e\" = x.\"e\")))) and ( x.\"operDayFK\"=?)";
                _selectSQL = "select " + _selectSQL;
                String[] ids = new String[0];
                com.sybase.reflection.DataType[] dts = new com.sybase.reflection.DataType[]{    
                    com.sybase.reflection.DataType.forName("long?"),
                };
                Object[] values = new Object[] { 
                    surrogateKey,
                };
                com.sybase.collections.GenericList<Object> res = DELEGATE.findWithSQL(_selectSQL, dts, values, ids, skip, take, ru.terralink.mvideo.sap.Relations.class);
                return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)res;
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
     * Find a list of ru.terralink.mvideo.sap.Relations  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> getOperDayRelations_for_OperDay(java.lang.Long surrogateKey)
    {
        return getOperDayRelations_for_OperDay(surrogateKey, 0, Integer.MAX_VALUE);
    }
    
    /**
     * Returns the MBOs that are updated locally but not submitted.  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> getPendingObjects(int skip, int take)
    {
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)DELEGATE.getPendingObjects(skip, take);
    }
    
    /**
     * Returns the MBOs that are updated locally but not submmited.  
     */
    public static com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations> getPendingObjects()
    {
        return (com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Relations>)(Object)DELEGATE.getPendingObjects();
    }
    
    /** End code region: Finder methods **/
    /**
     * Returns the log record list.  
     */
    public com.sybase.collections.GenericList<com.sybase.persistence.LogRecord> getLogRecords()
    {
        return ru.terralink.mvideo.sap.LogRecordImpl.findByEntity("Relations", keyToString());
    }
    
    
    
    
    
    public void create()
    {
        throw new com.sybase.persistence.NoSuchOperationException(com.sybase.persistence.NoSuchOperationException.NO_SUCH_OPERATION);
    }
    
    public void update()
    {
        throw new com.sybase.persistence.NoSuchOperationException(com.sybase.persistence.NoSuchOperationException.NO_SUCH_OPERATION);
    }      
    
    public void delete()
    {
        throw new com.sybase.persistence.NoSuchOperationException(com.sybase.persistence.NoSuchOperationException.NO_SUCH_OPERATION);
    }      
    
    
    
    
    /**
     * Submit pending operations of the mobile business object (ready for sending to server)  
     */
    public static void submitPendingOperations()
    {
        DELEGATE.submitPendingOperations();
    }
    
    /**
     * Cancel all the pending operations (not submitted operation).  
     */
    public static void cancelPendingOperations()
    {
        DELEGATE.cancelPendingOperations();
    }
    
    /**
     * Get the last called operation of the mobile business object  
     */
    public String getLastOperation()
    {
        if (!getCvpOperation().isNull())
        {
            com.sybase.afx.json.JsonObject cvpOperation = (com.sybase.afx.json.JsonObject)(com.sybase.afx.json.JsonReader.parse(__cvpOperation.getValue()));
            return (String)cvpOperation.get("cvp_name");
        }
        if (getPendingChange() == 'C')
        {
        }
        else if (getPendingChange() == 'D')
        {
        }
        else if (getPendingChange() == 'U')
        {
        }
        return null;
    }
    
    public ru.terralink.mvideo.sap.Relations getDownloadState()
    {
        return (ru.terralink.mvideo.sap.Relations)i_getDownloadState();
    }
    
    public ru.terralink.mvideo.sap.Relations getOriginalState()
    {
        return (ru.terralink.mvideo.sap.Relations)i_getOriginalState();
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