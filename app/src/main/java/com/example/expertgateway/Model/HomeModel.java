package com.example.expertgateway.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class HomeModel {


    @SerializedName("result")
    Result result;

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;


    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }




    public class Attachments {

        @SerializedName("id")
        int id;

        @SerializedName("imageUrl")
        String imageUrl;

        @SerializedName("isMobile")
        boolean isMobile;

        @SerializedName("isWeb")
        boolean isWeb;

        @SerializedName("isHorizontal")
        boolean isHorizontal;

        @SerializedName("isVeritical")
        boolean isVeritical;


        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setIsMobile(boolean isMobile) {
            this.isMobile = isMobile;
        }

        public boolean getIsMobile() {
            return isMobile;
        }

        public void setIsWeb(boolean isWeb) {
            this.isWeb = isWeb;
        }

        public boolean getIsWeb() {
            return isWeb;
        }

        public void setIsHorizontal(boolean isHorizontal) {
            this.isHorizontal = isHorizontal;
        }

        public boolean getIsHorizontal() {
            return isHorizontal;
        }

        public void setIsVeritical(boolean isVeritical) {
            this.isVeritical = isVeritical;
        }

        public boolean getIsVeritical() {
            return isVeritical;
        }
    }

    public class Sectionnew {

        @SerializedName("id")
        int id;

        @SerializedName("serviceName")
        String serviceName;

        @SerializedName("shortDesc")
        String shortDesc;

        @SerializedName("longDescription")
        String longDescription;

        @SerializedName("positionNo")
        int positionNo;

        @SerializedName("duration")
        int duration;

        @SerializedName("hasChild")
        boolean hasChild;

        @SerializedName("actualPrice")
        int actualPrice;

        @SerializedName("symbol")
        String symbol;

        @SerializedName("serviceSKU")
        String serviceSKU;

        @SerializedName("offerId")
        String offerId;

        @SerializedName("offerName")
        String offerName;

        @SerializedName("offerCountryId")
        String offerCountryId;

        @SerializedName("offerStartDate")
        String offerStartDate;

        @SerializedName("offerEndDate")
        String offerEndDate;

        @SerializedName("offerprice")
        String offerprice;

        @SerializedName("offerIsActive")
        String offerIsActive;

        @SerializedName("bannerIndustryId")
        String bannerIndustryId;

        @SerializedName("offerDiffPrice")
        int offerDiffPrice;

        @SerializedName("offerdiscountedPrice")
        int offerdiscountedPrice;

        @SerializedName("attachments")
        List<Attachments> attachments;


        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
        public String getServiceName() {
            return serviceName;
        }

        public void setShortDesc(String shortDesc) {
            this.shortDesc = shortDesc;
        }
        public String getShortDesc() {
            return shortDesc;
        }

        public void setLongDescription(String longDescription) {
            this.longDescription = longDescription;
        }
        public String getLongDescription() {
            return longDescription;
        }

        public void setPositionNo(int positionNo) {
            this.positionNo = positionNo;
        }
        public int getPositionNo() {
            return positionNo;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
        public int getDuration() {
            return duration;
        }

        public void setHasChild(boolean hasChild) {
            this.hasChild = hasChild;
        }
        public boolean getHasChild() {
            return hasChild;
        }

        public void setActualPrice(int actualPrice) {
            this.actualPrice = actualPrice;
        }
        public int getActualPrice() {
            return actualPrice;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
        public String getSymbol() {
            return symbol;
        }

        public void setServiceSKU(String serviceSKU) {
            this.serviceSKU = serviceSKU;
        }
        public String getServiceSKU() {
            return serviceSKU;
        }

        public void setOfferId(String offerId) {
            this.offerId = offerId;
        }
        public String getOfferId() {
            return offerId;
        }

        public void setOfferName(String offerName) {
            this.offerName = offerName;
        }
        public String getOfferName() {
            return offerName;
        }

        public void setOfferCountryId(String offerCountryId) {
            this.offerCountryId = offerCountryId;
        }
        public String getOfferCountryId() {
            return offerCountryId;
        }

        public void setOfferStartDate(String offerStartDate) {
            this.offerStartDate = offerStartDate;
        }
        public String getOfferStartDate() {
            return offerStartDate;
        }

        public void setOfferEndDate(String offerEndDate) {
            this.offerEndDate = offerEndDate;
        }
        public String getOfferEndDate() {
            return offerEndDate;
        }

        public void setOfferprice(String offerprice) {
            this.offerprice = offerprice;
        }
        public String getOfferprice() {
            return offerprice;
        }

        public void setOfferIsActive(String offerIsActive) {
            this.offerIsActive = offerIsActive;
        }
        public String getOfferIsActive() {
            return offerIsActive;
        }

        public void setBannerIndustryId(String bannerIndustryId) {
            this.bannerIndustryId = bannerIndustryId;
        }
        public String getBannerIndustryId() {
            return bannerIndustryId;
        }

        public void setOfferDiffPrice(int offerDiffPrice) {
            this.offerDiffPrice = offerDiffPrice;
        }
        public int getOfferDiffPrice() {
            return offerDiffPrice;
        }

        public void setOfferdiscountedPrice(int offerdiscountedPrice) {
            this.offerdiscountedPrice = offerdiscountedPrice;
        }
        public int getOfferdiscountedPrice() {
            return offerdiscountedPrice;
        }

        public void setAttachments(List<Attachments> attachments) {
            this.attachments = attachments;
        }
        public List<Attachments> getAttachments() {
            return attachments;
        }

    }

    public class SectionsDetails {

        @SerializedName("id")
        int id;

        @SerializedName("name")
        String name;

        @SerializedName("sectionTypeId")
        int sectionTypeId;

        @SerializedName("sectionTypeName")
        String sectionTypeName;

        @SerializedName("sectionVariationsId")
        int sectionVariationsId;

        @SerializedName("sectionVariationName")
        String sectionVariationName;

        @SerializedName("countryId")
        int countryId;

        @SerializedName("hasService")
        boolean hasService;

        @SerializedName("hasbanner")
        boolean hasbanner;

        @SerializedName("hasIndustry")
        boolean hasIndustry;

        @SerializedName("textValue")
        String textValue;

        @SerializedName("fontSize")
        int fontSize;

        @SerializedName("fontType")
        String fontType;

        @SerializedName("fontStyle")
        String fontStyle;

        @SerializedName("imageUrl")
        String imageUrl;

        @SerializedName("positionNo")
        int positionNo;

        @SerializedName("isShow")
        boolean isShow;

        @SerializedName("bannerServiceId")
        String bannerServiceId;

        @SerializedName("bannerofferId")
        String bannerofferId;

        @SerializedName("bannerUrl")
        String bannerUrl;

        @SerializedName("sectionnew")
        List<Sectionnew> sectionnew;


        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setSectionTypeId(int sectionTypeId) {
            this.sectionTypeId = sectionTypeId;
        }
        public int getSectionTypeId() {
            return sectionTypeId;
        }

        public void setSectionTypeName(String sectionTypeName) {
            this.sectionTypeName = sectionTypeName;
        }
        public String getSectionTypeName() {
            return sectionTypeName;
        }

        public void setSectionVariationsId(int sectionVariationsId) {
            this.sectionVariationsId = sectionVariationsId;
        }
        public int getSectionVariationsId() {
            return sectionVariationsId;
        }

        public void setSectionVariationName(String sectionVariationName) {
            this.sectionVariationName = sectionVariationName;
        }
        public String getSectionVariationName() {
            return sectionVariationName;
        }

        public void setCountryId(int countryId) {
            this.countryId = countryId;
        }
        public int getCountryId() {
            return countryId;
        }

        public void setHasService(boolean hasService) {
            this.hasService = hasService;
        }
        public boolean getHasService() {
            return hasService;
        }

        public void setHasbanner(boolean hasbanner) {
            this.hasbanner = hasbanner;
        }
        public boolean getHasbanner() {
            return hasbanner;
        }

        public void setHasIndustry(boolean hasIndustry) {
            this.hasIndustry = hasIndustry;
        }
        public boolean getHasIndustry() {
            return hasIndustry;
        }

        public void setTextValue(String textValue) {
            this.textValue = textValue;
        }
        public String getTextValue() {
            return textValue;
        }

        public void setFontSize(int fontSize) {
            this.fontSize = fontSize;
        }
        public int getFontSize() {
            return fontSize;
        }

        public void setFontType(String fontType) {
            this.fontType = fontType;
        }
        public String getFontType() {
            return fontType;
        }

        public void setFontStyle(String fontStyle) {
            this.fontStyle = fontStyle;
        }
        public String getFontStyle() {
            return fontStyle;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
        public String getImageUrl() {
            return imageUrl;
        }

        public void setPositionNo(int positionNo) {
            this.positionNo = positionNo;
        }
        public int getPositionNo() {
            return positionNo;
        }

        public void setIsShow(boolean isShow) {
            this.isShow = isShow;
        }
        public boolean getIsShow() {
            return isShow;
        }

        public void setBannerServiceId(String bannerServiceId) {
            this.bannerServiceId = bannerServiceId;
        }
        public String getBannerServiceId() {
            return bannerServiceId;
        }

        public void setBannerofferId(String bannerofferId) {
            this.bannerofferId = bannerofferId;
        }
        public String getBannerofferId() {
            return bannerofferId;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }
        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setSectionnew(List<Sectionnew> sectionnew) {
            this.sectionnew = sectionnew;
        }
        public List<Sectionnew> getSectionnew() {
            return sectionnew;
        }

    }

    public class Result {

        @SerializedName("sectionsDetails")
        List<SectionsDetails> sectionsDetails;


        public void setSectionsDetails(List<SectionsDetails> sectionsDetails) {
            this.sectionsDetails = sectionsDetails;
        }
        public List<SectionsDetails> getSectionsDetails() {
            return sectionsDetails;
        }

    }
}
