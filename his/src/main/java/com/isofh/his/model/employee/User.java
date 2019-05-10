package com.isofh.his.model.employee;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "his_user", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"}), @UniqueConstraint(columnNames = {"name", "deleted"})})
public class User extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "password", nullable = false)
    @Audited
    private String password;

    @Column(name = "first_name", nullable = false)
    @Audited
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Audited
    private String lastName;

    @Column(name = "email")
    @Audited
    private String email;

    @Column(name = "department_id")
    @Audited
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "building_id")
    @Audited
    private Long buildingId;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "certificate_id")
    @Audited
    private Long certificateId;

    @ManyToOne
    @JoinColumn(name = "certificate_id", insertable = false, updatable = false)
    private Certificate certificate;

    @Column(name = "specialist_id")
    @Audited
    private Long specialistId;

    @ManyToOne
    @JoinColumn(name = "specialist_id", insertable = false, updatable = false)
    private Specialist specialist;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "academic_rank_id")
    @Audited
    private Long academicRankId;

    @ManyToOne
    @JoinColumn(name = "academic_rank_id", insertable = false, updatable = false)
    private AcademicRank academicRank;

    @Column(name = "time_keeping", nullable = false)
    @Audited
    private boolean timeKeeping = false;

    @Column(name = "enabled", nullable = false)
    @Audited
    private boolean enabled = true;

    @Column(name = "birthday")
    @Audited
    private Timestamp birthday;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Column(name = "account_number")
    @Audited
    private String accountNumber;

    @Column(name = "position_id")
    @Audited
    private Long positionId;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private Position position;

    @Column(name = "certificate_code")
    @Audited
    private String certificateCode;

    @Column(name = "supervisor_id")
    @Audited
    private Long supervisorId;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", insertable = false, updatable = false)
    private User supervisor;

    @Column(name = "award")
    @Audited
    private String award;

    @Column(name = "note")
    @Audited
    private String note;

    @ManyToMany
    @JoinTable(
            name = "his_users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            indexes = {
            @Index(name = "idx_users_roles_user_id", columnList = "user_id"),
            @Index(name = "idx_users_roles_role_id", columnList = "role_id")
    })
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "his_users_departments",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            indexes = {
                    @Index(name = "idx_users_departments_user_id", columnList = "user_id"),
                    @Index(name = "idx_users_departments_department_id", columnList = "department_id")
            })
    private List<Department> departments;

    @ManyToMany
    @JoinTable(
            name = "his_users_rooms",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            indexes = {
                    @Index(name = "idx_users_rooms_user_id", columnList = "user_id"),
                    @Index(name = "idx_users_rooms_room_id", columnList = "room_id")
            })
    private List<Room> rooms;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAcademicRankId() {
        return academicRankId;
    }

    public void setAcademicRankId(Long academicRankId) {
        this.academicRankId = academicRankId;
    }

    public AcademicRank getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(AcademicRank academicRank) {
        this.academicRank = academicRank;
    }

    public boolean isTimeKeeping() {
        return timeKeeping;
    }

    public void setTimeKeeping(boolean timeKeeping) {
        this.timeKeeping = timeKeeping;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
