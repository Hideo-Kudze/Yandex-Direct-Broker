package com.HideoKuzeGits.YndexDirectAutobroker.xlsImport;

import com.HideoKuzeGits.yndexDirectAPI.wrapClasses.AbstractWrap;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by root on 29.08.14.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RegionEntry extends AbstractWrap{

    @Id
    private String regionName;
    private Long regionId;

    public RegionEntry() {
    }

    public RegionEntry(String regionName, Long regionId) {
        this.regionName = regionName;
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}
