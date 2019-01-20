package com.yellowpages.utils;

import lombok.Getter;

/**
 * Created by Ruksad siddiqui on 10/2/18
 */
public enum ErrorCode {

    STATE_IS_MISSING("YPE101","State is missing in the request"),
    CITY_IS_MISSING("YPE102","City is missing in the request"),
    CATEGORY_IS_MISSING("YPE103","Category is missing in the request"),
    REQUEST_NOT_SERVED_FOR_STATE("YPE104","Request is not served in this State"),
    REQUEST_NOT_SERVED_FOR_CITY("YPE105","Request is not served in this City"),
    REQUEST_NOT_SERVED_FOR_CATEGORY("YPE106","Request is not served in this category"),
    REQUEST_NOT_SERVED_FOR_CITY_STATE_CATEGORY("YPE107","Category is not present for this city or state"),
    LOCALITY_IS_MISSING("YPE108","Please provide city for the locality"),
    OBJECTID_OR_PARENTID_IS_MISSING("YPE109","Please provide ObjectId or parent id"),
    PARENTID_IS_MISSING("YPE110","Parent Id is missing"),
    MODELID_IS_MISSING("YPE111","Model Id is missing"),
    ATTRIBUTES_ARE_MISSING("YPE112","Attributes are missing"),
    LEVEL_2_CATEGORY_ID_MISSING("YPE113","Category id is missing"),
    LEAF_NODE_CATEGORY_ID_MISSING("YPE114","Leaf node category i.e object type id is missing"),
    OBJECT_NAME_OR_DESCRIPTION_IS_MISSING("YPE115","Object name or description is missing"),
    USER_NAME_IS_MISSING("YPE116","User name is missing"),
    REGISTRATION_TYPE_IS_MISSING("YPE117","User registration type id  is missing"),
    REGISTRATION_GROUP_IS_MISSING("YPE117","User registration group id  is missing"),
    USER_WITH_SAME_USER_NAME_EXISTS("YPE118","User with same name is already preset"),
    PHONE_NUMBER_IS_NOT_VALID("YPE119","Supplied phone number is not valid"),
    ERROR_WHILE_SENDING_OPT("YPE120","Error while sending OPT to mobile number"),
    USER_NOT_EXIST("YPE121","No User exist with this Mobile number or Email");


    @Getter
    private final String message;
    @Getter
    private final String code;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code + " : " + message;
    }
}
