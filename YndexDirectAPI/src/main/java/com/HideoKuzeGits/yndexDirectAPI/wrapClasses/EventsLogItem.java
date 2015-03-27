package com.HideoKuzeGits.yndexDirectAPI.wrapClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class EventsLogItem extends AbstractWrap{

    @Expose
    private String Timestamp;
    @Expose
    private Long BannerID;
    @Expose
    private Attributes Attributes;
    @Expose
    private Long PhraseID;
    @Expose
    private Long CampaignID;
    @Expose
    private String EventType;
    @Expose
    private String EventName;
    @Expose
    private String TextDescription;
    @Expose
    private Long AccountID;



    public String getTextDescription() {
        return TextDescription;
    }

    public void setTextDescription(String textDescription) {
        this.TextDescription = textDescription;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    public Long getBannerID() {
        return BannerID;
    }

    public void setBannerID(Long BannerID) {
        this.BannerID = BannerID;
    }

    public com.HideoKuzeGits.yndexDirectAPI.wrapClasses.Attributes getAttributes() {
        return Attributes;
    }

    public void setAttributes(com.HideoKuzeGits.yndexDirectAPI.wrapClasses.Attributes Attributes) {
        this.Attributes = Attributes;
    }

    public Object getPhraseID() {
        return PhraseID;
    }

    public void setPhraseID(Long PhraseID) {
        this.PhraseID = PhraseID;
    }

    public Long getCampaignID() {
        return CampaignID;
    }

    public void setCampaignID(Long CampaignID) {
        this.CampaignID = CampaignID;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String EventType) {
        this.EventType = EventType;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

}