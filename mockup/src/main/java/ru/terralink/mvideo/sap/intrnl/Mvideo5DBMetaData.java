package ru.terralink.mvideo.sap.intrnl;

public  class Mvideo5DBMetaData extends com.sybase.reflection.DatabaseMetaData
{
    /**
     * Sybase internal use only.
     */
    public Mvideo5DBMetaData(com.sybase.sup.client.persistence.DatabaseDelegate dbDelegate)
    {
        this.setDelegate(dbDelegate);
        _init();	
    }
    
    protected void _init()
    {
        setId(18);
        setAttributes(new com.sybase.reflection.AttributeMetaDataList());
        setAttributeMap(new com.sybase.reflection.AttributeMap());
        initAttributeMapFromAttributes();
        setName("Mvideo5DB");
        com.sybase.reflection.ClassMetaDataList _classList = new com.sybase.reflection.ClassMetaDataList(20);
        com.sybase.reflection.ClassMap _classMap = new com.sybase.reflection.ClassMap();
        setClassList(_classList);
        setClassMap(_classMap);
        ru.terralink.mvideo.sap.intrnl.OperDayMetaData _OperDayMetaData = (ru.terralink.mvideo.sap.intrnl.OperDayMetaData)(ru.terralink.mvideo.sap.OperDay.getMetaData());
        _classList.add(_OperDayMetaData);
        _classMap.add("OperDay", _OperDayMetaData);
        ru.terralink.mvideo.sap.intrnl.OrdersMetaData _OrdersMetaData = (ru.terralink.mvideo.sap.intrnl.OrdersMetaData)(ru.terralink.mvideo.sap.Orders.getMetaData());
        _classList.add(_OrdersMetaData);
        _classMap.add("Orders", _OrdersMetaData);
        ru.terralink.mvideo.sap.intrnl.ProductsMetaData _ProductsMetaData = (ru.terralink.mvideo.sap.intrnl.ProductsMetaData)(ru.terralink.mvideo.sap.Products.getMetaData());
        _classList.add(_ProductsMetaData);
        _classMap.add("Products", _ProductsMetaData);
        ru.terralink.mvideo.sap.intrnl.RelationsMetaData _RelationsMetaData = (ru.terralink.mvideo.sap.intrnl.RelationsMetaData)(ru.terralink.mvideo.sap.Relations.getMetaData());
        _classList.add(_RelationsMetaData);
        _classMap.add("Relations", _RelationsMetaData);
        ru.terralink.mvideo.sap.intrnl.StatusesDictMetaData _StatusesDictMetaData = (ru.terralink.mvideo.sap.intrnl.StatusesDictMetaData)(ru.terralink.mvideo.sap.StatusesDict.getMetaData());
        _classList.add(_StatusesDictMetaData);
        _classMap.add("StatusesDict", _StatusesDictMetaData);
        ru.terralink.mvideo.sap.intrnl.UpdateStatusMetaData _UpdateStatusMetaData = (ru.terralink.mvideo.sap.intrnl.UpdateStatusMetaData)(ru.terralink.mvideo.sap.UpdateStatus.getMetaData());
        _classList.add(_UpdateStatusMetaData);
        _classMap.add("UpdateStatus", _UpdateStatusMetaData);
        ru.terralink.mvideo.sap.intrnl.LogRecordImplMetaData _LogRecordImplMetaData = (ru.terralink.mvideo.sap.intrnl.LogRecordImplMetaData)(ru.terralink.mvideo.sap.LogRecordImpl.getMetaData());
        _classList.add(_LogRecordImplMetaData);
        _classMap.add("LogRecordImpl", _LogRecordImplMetaData);
        ru.terralink.mvideo.sap.intrnl.OperationReplayMetaData _OperationReplayMetaData = (ru.terralink.mvideo.sap.intrnl.OperationReplayMetaData)(ru.terralink.mvideo.sap.intrnl.OperationReplay.getMetaData());
        _classList.add(_OperationReplayMetaData);
        _classMap.add("OperationReplay", _OperationReplayMetaData);
        ru.terralink.mvideo.sap.intrnl.SISSubscriptionKeyMetaData _SISSubscriptionKeyMetaData = (ru.terralink.mvideo.sap.intrnl.SISSubscriptionKeyMetaData)(ru.terralink.mvideo.sap.intrnl.SISSubscriptionKey.getMetaData());
        _classList.add(_SISSubscriptionKeyMetaData);
        _classMap.add("SISSubscriptionKey", _SISSubscriptionKeyMetaData);
        ru.terralink.mvideo.sap.intrnl.SISSubscriptionMetaData _SISSubscriptionMetaData = (ru.terralink.mvideo.sap.intrnl.SISSubscriptionMetaData)(ru.terralink.mvideo.sap.intrnl.SISSubscription.getMetaData());
        _classList.add(_SISSubscriptionMetaData);
        _classMap.add("SISSubscription", _SISSubscriptionMetaData);
        ru.terralink.mvideo.sap.intrnl.PackagePropertiesMetaData _PackagePropertiesMetaData = (ru.terralink.mvideo.sap.intrnl.PackagePropertiesMetaData)(ru.terralink.mvideo.sap.PackageProperties.getMetaData());
        _classList.add(_PackagePropertiesMetaData);
        _classMap.add("PackageProperties", _PackagePropertiesMetaData);
        ru.terralink.mvideo.sap.intrnl.ChangeLogKeyMetaData _ChangeLogKeyMetaData = (ru.terralink.mvideo.sap.intrnl.ChangeLogKeyMetaData)(ru.terralink.mvideo.sap.ChangeLogKey.getMetaData());
        _classList.add(_ChangeLogKeyMetaData);
        _classMap.add("ChangeLogKey", _ChangeLogKeyMetaData);
        ru.terralink.mvideo.sap.intrnl.ChangeLogImplMetaData _ChangeLogImplMetaData = (ru.terralink.mvideo.sap.intrnl.ChangeLogImplMetaData)(ru.terralink.mvideo.sap.ChangeLogImpl.getMetaData());
        _classList.add(_ChangeLogImplMetaData);
        _classMap.add("ChangeLogImpl", _ChangeLogImplMetaData);
        ru.terralink.mvideo.sap.intrnl.OfflineAuthenticationMetaData _OfflineAuthenticationMetaData = (ru.terralink.mvideo.sap.intrnl.OfflineAuthenticationMetaData)(ru.terralink.mvideo.sap.OfflineAuthentication.getMetaData());
        _classList.add(_OfflineAuthenticationMetaData);
        _classMap.add("OfflineAuthentication", _OfflineAuthenticationMetaData);
        ru.terralink.mvideo.sap.intrnl.OperDaySynchronizationParametersMetaData _OperDaySynchronizationParametersMetaData = (ru.terralink.mvideo.sap.intrnl.OperDaySynchronizationParametersMetaData)(ru.terralink.mvideo.sap.OperDaySynchronizationParameters.getMetaData());
        _classList.add(_OperDaySynchronizationParametersMetaData);
        _classMap.add("OperDaySynchronizationParameters", _OperDaySynchronizationParametersMetaData);
        ru.terralink.mvideo.sap.intrnl.OperDay_pull_pqMetaData _OperDay_pull_pqMetaData = (ru.terralink.mvideo.sap.intrnl.OperDay_pull_pqMetaData)(ru.terralink.mvideo.sap.intrnl.OperDay_pull_pq.getMetaData());
        _classList.add(_OperDay_pull_pqMetaData);
        _classMap.add("OperDay_pull_pq", _OperDay_pull_pqMetaData);
        ru.terralink.mvideo.sap.intrnl.UpdateStatusSynchronizationParametersMetaData _UpdateStatusSynchronizationParametersMetaData = (ru.terralink.mvideo.sap.intrnl.UpdateStatusSynchronizationParametersMetaData)(ru.terralink.mvideo.sap.UpdateStatusSynchronizationParameters.getMetaData());
        _classList.add(_UpdateStatusSynchronizationParametersMetaData);
        _classMap.add("UpdateStatusSynchronizationParameters", _UpdateStatusSynchronizationParametersMetaData);
        ru.terralink.mvideo.sap.intrnl.UpdateStatus_pull_pqMetaData _UpdateStatus_pull_pqMetaData = (ru.terralink.mvideo.sap.intrnl.UpdateStatus_pull_pqMetaData)(ru.terralink.mvideo.sap.intrnl.UpdateStatus_pull_pq.getMetaData());
        _classList.add(_UpdateStatus_pull_pqMetaData);
        _classMap.add("UpdateStatus_pull_pq", _UpdateStatus_pull_pqMetaData);
        ru.terralink.mvideo.sap.intrnl.KeyPackageNameMetaData _KeyPackageNameMetaData = (ru.terralink.mvideo.sap.intrnl.KeyPackageNameMetaData)(ru.terralink.mvideo.sap.KeyPackageName.getMetaData());
        _classList.add(_KeyPackageNameMetaData);
        _classMap.add("KeyPackageName", _KeyPackageNameMetaData);
        ru.terralink.mvideo.sap.intrnl.PersonalizationParametersMetaData _PersonalizationParametersMetaData = (ru.terralink.mvideo.sap.intrnl.PersonalizationParametersMetaData)(ru.terralink.mvideo.sap.PersonalizationParameters.getMetaData());
        _classList.add(_PersonalizationParametersMetaData);
        _classMap.add("PersonalizationParameters", _PersonalizationParametersMetaData);
        ru.terralink.mvideo.sap.intrnl.KeyGeneratorMetaData _KeyGeneratorMetaData = (ru.terralink.mvideo.sap.intrnl.KeyGeneratorMetaData)(ru.terralink.mvideo.sap.KeyGenerator.getMetaData());
        _classList.add(_KeyGeneratorMetaData);
        _classMap.add("KeyGenerator", _KeyGeneratorMetaData);
        ru.terralink.mvideo.sap.intrnl.LocalKeyGeneratorMetaData _LocalKeyGeneratorMetaData = (ru.terralink.mvideo.sap.intrnl.LocalKeyGeneratorMetaData)(ru.terralink.mvideo.sap.LocalKeyGenerator.getMetaData());
        _classList.add(_LocalKeyGeneratorMetaData);
        _classMap.add("LocalKeyGenerator", _LocalKeyGeneratorMetaData);
        com.sybase.reflection.EntityMetaDataList _entityList = new com.sybase.reflection.EntityMetaDataList(20);
        com.sybase.reflection.EntityMap _entityMap = new com.sybase.reflection.EntityMap();
        setEntityList(_entityList);
        setEntityMap(_entityMap);
        _entityList.add(_LocalKeyGeneratorMetaData);
        _entityMap.add("LocalKeyGenerator", _LocalKeyGeneratorMetaData);
        _entityList.add(_UpdateStatusSynchronizationParametersMetaData);
        _entityMap.add("UpdateStatusSynchronizationParameters", _UpdateStatusSynchronizationParametersMetaData);
        _entityList.add(_OperDaySynchronizationParametersMetaData);
        _entityMap.add("OperDaySynchronizationParameters", _OperDaySynchronizationParametersMetaData);
        _entityList.add(_OfflineAuthenticationMetaData);
        _entityMap.add("OfflineAuthentication", _OfflineAuthenticationMetaData);
        _entityList.add(_KeyGeneratorMetaData);
        _entityMap.add("KeyGenerator", _KeyGeneratorMetaData);
        _entityList.add(_UpdateStatus_pull_pqMetaData);
        _entityMap.add("UpdateStatus_pull_pq", _UpdateStatus_pull_pqMetaData);
        _entityList.add(_OperDay_pull_pqMetaData);
        _entityMap.add("OperDay_pull_pq", _OperDay_pull_pqMetaData);
        _entityList.add(_ChangeLogImplMetaData);
        _entityMap.add("ChangeLogImpl", _ChangeLogImplMetaData);
        _entityList.add(_PackagePropertiesMetaData);
        _entityMap.add("PackageProperties", _PackagePropertiesMetaData);
        _entityList.add(_SISSubscriptionMetaData);
        _entityMap.add("SISSubscription", _SISSubscriptionMetaData);
        _entityList.add(_OperationReplayMetaData);
        _entityMap.add("OperationReplay", _OperationReplayMetaData);
        _entityList.add(_LogRecordImplMetaData);
        _entityMap.add("LogRecordImpl", _LogRecordImplMetaData);
        _entityList.add(_UpdateStatusMetaData);
        _entityMap.add("UpdateStatus", _UpdateStatusMetaData);
        _entityList.add(_StatusesDictMetaData);
        _entityMap.add("StatusesDict", _StatusesDictMetaData);
        _entityList.add(_OperDayMetaData);
        _entityMap.add("OperDay", _OperDayMetaData);
        _entityList.add(_RelationsMetaData);
        _entityMap.add("Relations", _RelationsMetaData);
        _entityList.add(_OrdersMetaData);
        _entityMap.add("Orders", _OrdersMetaData);
        _entityList.add(_ProductsMetaData);
        _entityMap.add("Products", _ProductsMetaData);
        com.sybase.collections.StringList _publications = new com.sybase.collections.StringList(20);
        com.sybase.reflection.EntityListMap _publicationsToEntities = new com.sybase.reflection.EntityListMap();
        _publications.add("default");
        com.sybase.reflection.EntityMetaDataList defaultEntities = new com.sybase.reflection.EntityMetaDataList(20);
        defaultEntities.add(_OperDayMetaData);
        defaultEntities.add(_OrdersMetaData);
        defaultEntities.add(_ProductsMetaData);
        defaultEntities.add(_RelationsMetaData);
        defaultEntities.add(_StatusesDictMetaData);
        defaultEntities.add(_UpdateStatusMetaData);
        defaultEntities.add(_LogRecordImplMetaData);
        defaultEntities.add(_OperationReplayMetaData);
        defaultEntities.add(_SISSubscriptionMetaData);
        defaultEntities.add(_PackagePropertiesMetaData);
        defaultEntities.add(_ChangeLogImplMetaData);
        defaultEntities.add(_OperDay_pull_pqMetaData);
        defaultEntities.add(_UpdateStatus_pull_pqMetaData);
        defaultEntities.add(_KeyGeneratorMetaData);
        _publicationsToEntities.add("default", defaultEntities);
        _publications.add("unsubscribe");
        com.sybase.reflection.EntityMetaDataList unsubscribeEntities = new com.sybase.reflection.EntityMetaDataList(20);
        unsubscribeEntities.add(_OperDay_pull_pqMetaData);
        unsubscribeEntities.add(_UpdateStatus_pull_pqMetaData);
        unsubscribeEntities.add(_LogRecordImplMetaData);
        unsubscribeEntities.add(_OperationReplayMetaData);
        unsubscribeEntities.add(_SISSubscriptionMetaData);
        unsubscribeEntities.add(_PackagePropertiesMetaData);
        unsubscribeEntities.add(_KeyGeneratorMetaData);
        _publicationsToEntities.add("unsubscribe", unsubscribeEntities);
        _publications.add("system");
        com.sybase.reflection.EntityMetaDataList systemEntities = new com.sybase.reflection.EntityMetaDataList(20);
        systemEntities.add(_LogRecordImplMetaData);
        systemEntities.add(_OperationReplayMetaData);
        systemEntities.add(_SISSubscriptionMetaData);
        systemEntities.add(_PackagePropertiesMetaData);
        systemEntities.add(_KeyGeneratorMetaData);
        _publicationsToEntities.add("system", systemEntities);
        _publications.add("initialSync");
        com.sybase.reflection.EntityMetaDataList initialSyncEntities = new com.sybase.reflection.EntityMetaDataList(20);
        initialSyncEntities.add(_PackagePropertiesMetaData);
        initialSyncEntities.add(_KeyGeneratorMetaData);
        _publicationsToEntities.add("initialSync", initialSyncEntities);
        setDatabaseFile("mvideo41_0.ulj");
        setDatabaseName("mvideo41_0");
        initEntityListMap(_publicationsToEntities);
        setSynchronizationGroups(_publications);
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