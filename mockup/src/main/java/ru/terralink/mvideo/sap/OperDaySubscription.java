/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */
package ru.terralink.mvideo.sap;

@SuppressWarnings("all")
public  class OperDaySubscription extends com.sybase.persistence.AbstractStructure 
{
    private java.sql.Date __sp_date ;  
    
    private java.lang.String __sp_numb ;  
    
    public java.lang.String getAttributeNullableString(int id)
    {
        switch(id)
        {
        case 509:
            return getSp_numb();
        default:
            return super.getAttributeNullableString(id);
        }
    }
    
    public void setAttributeNullableString(int id, java.lang.String v)
    {
        switch(id)
        {
        case 509:
            setSp_numb((java.lang.String)v);
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
        case 508:
            return getSp_date();
        default:
            return super.getAttributeNullableDate(id);
        }
    }
    
    public void setAttributeNullableDate(int id, java.sql.Date v)
    {
        switch(id)
        {
        case 508:
            setSp_date((java.sql.Date)v);
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
    
    private boolean _userDefinedForSp_date = false;
    /**
     * get the value of sp_date  
     */
    public java.sql.Date getSp_date()
    {
        if (!_userDefinedForSp_date)
        {
            ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq pq = new ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq();
            java.sql.Date result = pq.getSp_dateParam();
            return result;
        }
        return __sp_date;
    }
    
    /**
     * Set the value of sp_date  
     */
    public void setSp_date(java.sql.Date value)
    {
        __sp_date = value;  
        _userDefinedForSp_date = true;
    }
    
    private boolean _userDefinedForSp_numb = false;
    /**
     * get the value of sp_numb  
     */
    public java.lang.String getSp_numb()
    {
        if (!_userDefinedForSp_numb)
        {
            ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq pq = new ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq();
            java.lang.String result = pq.getSp_numbParam();
            return result;
        }
        return __sp_numb;
    }
    
    /**
     * Set the value of sp_numb  
     */
    public void setSp_numb(java.lang.String value)
    {
        __sp_numb = value;  
        _userDefinedForSp_numb = true;
    }
}