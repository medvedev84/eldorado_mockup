/**
 * Generated by Sybase AFX Compiler with templateJ
 * Compiler version - 2.3.0.183
 * mbs - false 
 */  
package ru.terralink.mvideo.sap.intrnl;

@SuppressWarnings("all")
public class OrdersMetaData extends com.sybase.reflection.EntityMetaDataEx
{
    /**
     * Sybase internal use only.
     */
    public OrdersMetaData()
    {
        super(ru.terralink.mvideo.sap.Mvideo5DB.getMetaData());
        _init();
    }
    protected void _init()
    {
        setId(6);
        setAttributes(new com.sybase.reflection.AttributeMetaDataList());
        setAttributeMap(new com.sybase.reflection.AttributeMap());
        com.sybase.reflection.AttributeMetaData EVENT_CODE_attribute = addAttributeWithParams
        	(108, "EVENT_CODE", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"a\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData TOR_ID_attribute = addAttributeWithParams
        	(109, "TOR_ID", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"b\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData REQ_START_DATE_attribute = addAttributeWithParams
        	(110, "REQ_START_DATE", "date?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"c\"", "date", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData REQ_START_TIME_attribute = addAttributeWithParams
        	(111, "REQ_START_TIME", "time?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"d\"", "time", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData REQ_END_DATE_attribute = addAttributeWithParams
        	(112, "REQ_END_DATE", "date?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"e\"", "date", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData REQ_END_TIME_attribute = addAttributeWithParams
        	(113, "REQ_END_TIME", "time?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"f\"", "time", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData XPOS_attribute = addAttributeWithParams
        	(114, "XPOS", "double", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"g\"", "double precision", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData YPOS_attribute = addAttributeWithParams
        	(115, "YPOS", "double", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"h\"", "double precision", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData EXECUTION_attribute = addAttributeWithParams
        	(116, "EXECUTION", "string", 
        	2, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"i\"", "varchar(8)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData DDTEXT_attribute = addAttributeWithParams
        	(117, "DDTEXT", "string", 
        	60, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"j\"", "varchar(240)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData NAME1_attribute = addAttributeWithParams
        	(118, "NAME1", "string", 
        	40, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"l\"", "varchar(160)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData NAME2_attribute = addAttributeWithParams
        	(119, "NAME2", "string", 
        	40, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"m\"", "varchar(160)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData NAME3_attribute = addAttributeWithParams
        	(120, "NAME3", "string", 
        	40, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"n\"", "varchar(160)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData NAME4_attribute = addAttributeWithParams
        	(121, "NAME4", "string", 
        	40, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"o\"", "varchar(160)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData TEL_NUMBER_attribute = addAttributeWithParams
        	(122, "TEL_NUMBER", "string", 
        	30, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"p\"", "varchar(120)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ZTEL_NUMBER2_attribute = addAttributeWithParams
        	(123, "ZTEL_NUMBER2", "string", 
        	30, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"q\"", "varchar(120)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData SMTP_ADDR_attribute = addAttributeWithParams
        	(124, "SMTP_ADDR", "string", 
        	241, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"r\"", "varchar(964)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData REGION_attribute = addAttributeWithParams
        	(125, "REGION", "string", 
        	3, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"s\"", "varchar(12)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData CITY1_attribute = addAttributeWithParams
        	(126, "CITY1", "string", 
        	40, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"t\"", "varchar(160)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData POST_CODE1_attribute = addAttributeWithParams
        	(127, "POST_CODE1", "string", 
        	10, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"u\"", "varchar(40)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData STREET_attribute = addAttributeWithParams
        	(128, "STREET", "string", 
        	60, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"v\"", "varchar(240)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData HOUSE_NUM1_attribute = addAttributeWithParams
        	(129, "HOUSE_NUM1", "string", 
        	10, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"w\"", "varchar(40)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData HOUSE_NUM2_attribute = addAttributeWithParams
        	(130, "HOUSE_NUM2", "string", 
        	10, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"x\"", "varchar(40)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData BUILDING_attribute = addAttributeWithParams
        	(131, "BUILDING", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"y\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData FLOOR_attribute = addAttributeWithParams
        	(132, "FLOOR", "string", 
        	10, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"z\"", "varchar(40)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ROOMNUMBER_attribute = addAttributeWithParams
        	(133, "ROOMNUMBER", "string", 
        	10, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"ba\"", "varchar(40)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ZCOMMENTS_attribute = addAttributeWithParams
        	(134, "ZCOMMENTS", "string", 
        	255, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bb\"", "varchar(1020)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ZSALES_OBJECT_attribute = addAttributeWithParams
        	(135, "ZSALES_OBJECT", "string", 
        	4, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bc\"", "varchar(16)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ZEXT_NUM1_attribute = addAttributeWithParams
        	(136, "ZEXT_NUM1", "string", 
        	12, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bd\"", "varchar(48)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ZEXT_NUM2_attribute = addAttributeWithParams
        	(137, "ZEXT_NUM2", "string", 
        	12, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"be\"", "varchar(48)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData LOCNO_attribute = addAttributeWithParams
        	(138, "LOCNO", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bf\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData DEPARTURE_FROM_LOC_DATE_attribute = addAttributeWithParams
        	(139, "DEPARTURE_FROM_LOC_DATE", "date?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bg\"", "date", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData DEPARTURE_FROM_LOC_TIME_attribute = addAttributeWithParams
        	(140, "DEPARTURE_FROM_LOC_TIME", "time?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bh\"", "time", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ARRIVAL_AT_LOC_DATE_attribute = addAttributeWithParams
        	(141, "ARRIVAL_AT_LOC_DATE", "date?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bi\"", "date", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ARRIVAL_AT_LOC_TIME_attribute = addAttributeWithParams
        	(142, "ARRIVAL_AT_LOC_TIME", "time?", 
        	-1, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bj\"", "time", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData IV_FO_TOR_ID_attribute = addAttributeWithParams
        	(143, "IV_FO_TOR_ID", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bl\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData IV_FU_TOR_ID_attribute = addAttributeWithParams
        	(144, "IV_FU_TOR_ID", "string", 
        	20, 
        	false, false, false, false, false, 
        	false,false, 
        	"\"bm\"", "varchar(80)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData relations_attribute = addAttributeWithParams
        	(146, "relations", "ru.terralink.mvideo.sap.Relations", 
        	-1, 
        	false, false, false, true, false, 
        	false,false, 
        	"\"none\"", "LONG VARCHAR", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData ordersProductss_attribute = addAttributeWithParams
        	(147, "ordersProductss", "ru.terralink.mvideo.sap.Products*", 
        	-1, 
        	false, false, false, true, false, 
        	false,false, 
        	"\"bp\"", "LONG VARCHAR", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData pending_attribute = addAttributeWithParams
        	(20001, "pending", "boolean", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"pending\"", "tinyint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData pendingChange_attribute = addAttributeWithParams
        	(20002, "pendingChange", "char", 
        	1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"_pc\"", "char(1)", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData replayPending_attribute = addAttributeWithParams
        	(20005, "replayPending", "long", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"_rp\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData replayFailure_attribute = addAttributeWithParams
        	(20006, "replayFailure", "long", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"_rf\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData cvpOperation_attribute = addAttributeWithParams
        	(718, "cvpOperation", "bigString?", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"cvp_operation_header\"", "long varchar", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData cvpOperationLobs_attribute = addAttributeWithParams
        	(719, "cvpOperationLobs", "bigString?", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"cvp_operation_lobs\"", "long varchar", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData relationsFK_attribute = addAttributeWithParams
        	(792, "relationsFK", "long?", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"relationsFK\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData relationsValid_attribute = addAttributeWithParams
        	(796, "relationsValid", "boolean", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"none\"", "tinyint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData surrogateKey_attribute = addAttributeWithParams
        	(145, "surrogateKey", "long", 
        	-1, 
        	false, true, false, false, false, 
        	false,false, 
        	"\"bn\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.GLOBAL,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData replayCounter_attribute = addAttributeWithParams
        	(20004, "replayCounter", "long", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"_rc\"", "bigint", "_rc", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData disableSubmit_attribute = addAttributeWithParams
        	(20003, "disableSubmit", "boolean", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"_ds\"", "tinyint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData cvpOperationLength_attribute = addAttributeWithParams
        	(1277, "cvpOperationLength", "long", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"cvpOperation_length\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        com.sybase.reflection.AttributeMetaData cvpOperationLobsLength_attribute = addAttributeWithParams
        	(1278, "cvpOperationLobsLength", "long", 
        	-1, 
        	false, false, true, false, false, 
        	false,false, 
        	"\"cvpOperationLobs_length\"", "bigint", "", 0, 0, 
        	com.sybase.reflection.AttributeMetaData.GENERATED_SCHEME.NONE,
        	"", "null", com.sybase.reflection.PersonalizationMetaData.PersonalizationType.None,
        	false, false, false);
        initAttributeMapFromAttributes();
        setName("Orders");
        setTable("\"mvideo5_1_0_orders\"");
        setSynchronizationGroup("default");
        com.sybase.reflection.IndexMetaData findByPrimaryKeyIndex_index = new com.sybase.reflection.IndexMetaData();
        findByPrimaryKeyIndex_index.setName("findByPrimaryKeyIndex");
        findByPrimaryKeyIndex_index.getAttributes().add(IV_FO_TOR_ID_attribute);
        findByPrimaryKeyIndex_index.getAttributes().add(IV_FU_TOR_ID_attribute);
        this.getIndice().add(findByPrimaryKeyIndex_index);
        com.sybase.reflection.IndexMetaData relationsFK_index = new com.sybase.reflection.IndexMetaData();
        relationsFK_index.setName("relationsFK");
        relationsFK_index.getAttributes().add(relationsFK_attribute);
        this.getIndice().add(relationsFK_index);
        this.getKeyAttributes().add((surrogateKey_attribute));
        ((com.sybase.reflection.AssociationMetaData)relations_attribute).setInverseEntity("Relations");
        ((com.sybase.reflection.AssociationMetaData)relations_attribute).setInverseAttribute("relationsOrderss");
        ((com.sybase.reflection.AssociationMetaData)relations_attribute).setForeignKey(relationsFK_attribute);
        ((com.sybase.reflection.AssociationMetaData)ordersProductss_attribute).setInverseEntity("Products");
        ((com.sybase.reflection.AssociationMetaData)ordersProductss_attribute).setInverseAttribute("orders");
    }
    
    /**
     * Sybase internal use only.
     */
    public  boolean isEntity()
    {
        return true;
    }
    
    /**
     * Sybase internal use only.
     */
    public  boolean isService()
    {
        return false;
    }
}