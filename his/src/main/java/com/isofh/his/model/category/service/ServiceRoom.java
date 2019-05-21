package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.Room;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_service_room")
public class ServiceRoom extends BaseCategoryModel {

    @Id
    @GeneratedValue(generator = "service_room_generator")
    @SequenceGenerator(
            name = "service_room_generator",
            sequenceName = "service_room_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_id", nullable = false)
    @Audited
    private Long serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceSource service;

    @Column(name = "room_id", nullable = false)
    @Audited
    private Long roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceSource getService() {
        return service;
    }

    public void setService(ServiceSource service) {
        this.service = service;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
