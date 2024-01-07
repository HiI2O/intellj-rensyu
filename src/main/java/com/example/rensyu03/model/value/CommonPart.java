package com.example.rensyu03.model.value;

import com.example.rensyu03.exceptions.InvalidBillingPhoneValueException;
import com.example.rensyu03.exceptions.InvalidValueException;
import com.example.rensyu03.model.value.commonpart.*;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CommonPart {
    private final TransactionId transactionId;
    private final TransactionType transactionType;
    private final BillingPhone billingPhone1;
    private final BillingPhone billingPhone2;
    private final BillingPhone billingPhone3;
    private final BillingPhone billingPhone4;
    private final IspBusinessCode ispBusinessCode;
    private final BundleIdMain bundleIdMain;
    private final BundleIdIdentifier bundleIdIdentifier;
    private final BundleIdAggregationContract bundleIdAggregationContract;
    private final BundleIdAggregationBilling bundleIdAggregationBilling;
    private final CustomerTaxCategory customerTaxCategory;
    private final ProductSubscriptionCategory productSubscriptionCategory;
    private final ProductCode productCode;
    private final ServiceStartDate serviceStartDate;
    private final ServiceStartTime serviceStartTime;
    private final ServiceEndDate serviceEndDate;
    private final ServiceEndTime serviceEndTime;
    private final NumberChangeDate numberChangeDate;
    private final IndividualNumbers individualNumbers;

    private static final int NUM_EXPECTED_FIELDS = 24;

    private static final int TRANSACTION_ID_INDEX = 0;
    private static final int TRANSACTION_TYPE_INDEX = 1;
    private static final int BILLING_PHONE_NUMBER1_INDEX = 2;
    private static final int BILLING_PHONE_ID1_INDEX = 3;
    private static final int BILLING_PHONE_NUMBER2_INDEX = 4;
    private static final int BILLING_PHONE_ID2_INDEX = 5;
    private static final int BILLING_PHONE_NUMBER3_INDEX = 6;
    private static final int BILLING_PHONE_ID3_INDEX = 7;
    private static final int BILLING_PHONE_NUMBER4_INDEX = 8;
    private static final int BILLING_PHONE_ID4_INDEX = 9;
    private static final int ISP_BUSINESS_CODE_INDEX = 10;
    private static final int BUNDLE_ID_MAIN_INDEX = 11;
    private static final int BUNDLE_ID_IDENTIFIER_INDEX = 12;
    private static final int BUNDLE_ID_AGGREGATION_CONTRACT_INDEX = 13;
    private static final int BUNDLE_ID_AGGREGATION_BILLING_INDEX = 14;
    private static final int CUSTOMER_TAX_CATEGORY_INDEX = 15;
    private static final int PRODUCT_SUBSCRIPTION_CATEGORY_INDEX = 16;
    private static final int PRODUCT_CODE_INDEX = 17;
    private static final int SERVICE_START_DATE_INDEX = 18;
    private static final int SERVICE_START_TIME_INDEX = 19;
    private static final int SERVICE_END_DATE_INDEX = 20;
    private static final int SERVICE_END_TIME_INDEX = 21;
    private static final int NUMBER_CHANGE_DATE_INDEX = 22;
    private static final int INDIVIDUAL_NUMBERS_INDEX = 23;

    private static final String INSUFFICIENT_COMMON_PART_ERROR_CODE = "10002";


    private CommonPart(TransactionId transactionId,
                       TransactionType transactionType,
                       BillingPhone billingPhone1,
                       BillingPhone billingPhone2,
                       BillingPhone billingPhone3,
                       BillingPhone billingPhone4,
                       IspBusinessCode ispBusinessCode,
                       BundleIdMain bundleIdMain,
                       BundleIdIdentifier bundleIdIdentifier,
                       BundleIdAggregationContract bundleIdAggregationContract,
                       BundleIdAggregationBilling bundleIdAggregationBilling,
                       CustomerTaxCategory customerTaxCategory,
                       ProductSubscriptionCategory productSubscriptionCategory,
                       ProductCode productCode, ServiceStartDate serviceStartDate,
                       ServiceStartTime serviceStartTime,
                       ServiceEndDate serviceEndDate,
                       ServiceEndTime serviceEndTime,
                       NumberChangeDate numberChangeDate,
                       IndividualNumbers individualNumbers) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.billingPhone1 = billingPhone1;
        this.billingPhone2 = billingPhone2;
        this.billingPhone3 = billingPhone3;
        this.billingPhone4 = billingPhone4;
        this.ispBusinessCode = ispBusinessCode;
        this.bundleIdMain = bundleIdMain;
        this.bundleIdIdentifier = bundleIdIdentifier;
        this.bundleIdAggregationContract = bundleIdAggregationContract;
        this.bundleIdAggregationBilling = bundleIdAggregationBilling;
        this.customerTaxCategory = customerTaxCategory;
        this.productSubscriptionCategory = productSubscriptionCategory;
        this.productCode = productCode;
        this.serviceStartDate = serviceStartDate;
        this.serviceStartTime = serviceStartTime;
        this.serviceEndDate = serviceEndDate;
        this.serviceEndTime = serviceEndTime;
        this.numberChangeDate = numberChangeDate;
        this.individualNumbers = individualNumbers;
    }

    public static CommonPart createInstance(String[] requestBodyContents) {
        if (requestBodyContents.length < NUM_EXPECTED_FIELDS) {
            throw new InvalidValueException("共通部が項目数が24個より少ないです。", INSUFFICIENT_COMMON_PART_ERROR_CODE);
        }

        TransactionId transactionId = new TransactionId(requestBodyContents[TRANSACTION_ID_INDEX]);
        TransactionType transactionType = new TransactionType(requestBodyContents[TRANSACTION_TYPE_INDEX]);

        BillingPhones billingPhones = BillingPhones.createInstance(
                requestBodyContents[BILLING_PHONE_NUMBER1_INDEX], requestBodyContents[BILLING_PHONE_ID1_INDEX],
                requestBodyContents[BILLING_PHONE_NUMBER2_INDEX], requestBodyContents[BILLING_PHONE_ID2_INDEX],
                requestBodyContents[BILLING_PHONE_NUMBER3_INDEX], requestBodyContents[BILLING_PHONE_ID3_INDEX],
                requestBodyContents[BILLING_PHONE_NUMBER4_INDEX], requestBodyContents[BILLING_PHONE_ID4_INDEX]
        );

        BillingPhone billingPhone1 = billingPhones.getBillingPhone1();
        BillingPhone billingPhone2 = billingPhones.getBillingPhone2();
        BillingPhone billingPhone3 = billingPhones.getBillingPhone3();
        BillingPhone billingPhone4 = billingPhones.getBillingPhone4();

        IspBusinessCode ispBusinessCode = new IspBusinessCode(requestBodyContents[ISP_BUSINESS_CODE_INDEX]);
        BundleIdMain bundleIdMain = new BundleIdMain(requestBodyContents[BUNDLE_ID_MAIN_INDEX]);
        BundleIdIdentifier bundleIdIdentifier = new BundleIdIdentifier(requestBodyContents[BUNDLE_ID_IDENTIFIER_INDEX]);
        BundleIdAggregationContract bundleIdAggregationContract = new BundleIdAggregationContract(requestBodyContents[BUNDLE_ID_AGGREGATION_CONTRACT_INDEX], bundleIdIdentifier);
        BundleIdAggregationBilling bundleIdAggregationBilling = new BundleIdAggregationBilling(requestBodyContents[BUNDLE_ID_AGGREGATION_BILLING_INDEX], bundleIdIdentifier);
        CustomerTaxCategory customerTaxCategory = new CustomerTaxCategory(requestBodyContents[CUSTOMER_TAX_CATEGORY_INDEX]);
        ProductSubscriptionCategory productSubscriptionCategory = new ProductSubscriptionCategory(requestBodyContents[PRODUCT_SUBSCRIPTION_CATEGORY_INDEX]);
        ProductCode productCode = new ProductCode(requestBodyContents[PRODUCT_CODE_INDEX]);
        ServiceStartDate serviceStartDate = new ServiceStartDate(requestBodyContents[SERVICE_START_DATE_INDEX]);
        ServiceStartTime serviceStartTime = new ServiceStartTime(requestBodyContents[SERVICE_START_TIME_INDEX]);
        ServiceEndDate serviceEndDate = new ServiceEndDate(requestBodyContents[SERVICE_END_DATE_INDEX]);
        ServiceEndTime serviceEndTime = new ServiceEndTime(requestBodyContents[SERVICE_END_TIME_INDEX]);
        NumberChangeDate numberChangeDate = new NumberChangeDate(requestBodyContents[NUMBER_CHANGE_DATE_INDEX], productSubscriptionCategory);
        IndividualNumbers individualNumbers = new IndividualNumbers(requestBodyContents[INDIVIDUAL_NUMBERS_INDEX]);

        return new CommonPart(
                transactionId,
                transactionType,
                billingPhone1,
                billingPhone2,
                billingPhone3,
                billingPhone4,
                ispBusinessCode,
                bundleIdMain,
                bundleIdIdentifier,
                bundleIdAggregationContract,
                bundleIdAggregationBilling,
                customerTaxCategory,
                productSubscriptionCategory,
                productCode,
                serviceStartDate,
                serviceStartTime,
                serviceEndDate,
                serviceEndTime,
                numberChangeDate,
                individualNumbers);
    }


}