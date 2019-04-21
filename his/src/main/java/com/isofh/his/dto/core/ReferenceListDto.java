package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.model.core.Reference;
import com.isofh.his.model.core.ReferenceListAccess;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class ReferenceListDto extends BaseDto {

    public ReferenceListDto() {
    }

    private int value;

    private String name;

    private ReferenceDto referenceDto;

    private String description;

    private boolean strictAccess;

    private List<ReferenceListAccess> referenceListAccesses;
}
