package com.HideoKuzeGits.YndexDirectAutobroker.domain.strategies;

import com.HideoKuzeGits.YndexDirectAutobroker.strategies.Position;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by root on 23.07.14.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ServiceStrategy extends Strategy {


    @NotNull
    @NotEmpty
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private List<Position> positions;

    @NotNull
    private Boolean highestPosition;

    @NotNull
    @Range(min = 0, max = 5)
    private Double rmax;


    private Long campaignId;
    private Long bannerId;


    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public boolean isHighestPosition() {
        return highestPosition;
    }

    public void setHighestPosition(boolean highestPosition) {
        this.highestPosition = highestPosition;
    }

    public Double getRmax() {
        return rmax;
    }

    public void setRmax(Double rmax) {
        this.rmax = rmax;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignID) {
        this.campaignId = campaignID;
    }

    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerID) {
        this.bannerId = bannerID;
    }


}