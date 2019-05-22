package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.category.*;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_service_technical")
@Where(clause = "deleted=0")
public class ServiceTechnical extends BaseModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private ServiceSource service;

    @Column(name = "department_id")
    @Audited
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "room_id")
    @Audited
    private Long roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @Column(name = "specialist_id")
    @Audited
    private Long specialistId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id", insertable = false, updatable = false)
    private Specialist specialist;

    @Column(name = "dye_method_id")
    @Audited
    private Long dyeMethodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dye_method_id", insertable = false, updatable = false)
    private DyeMethod dyeMethod;

    @Column(name = "report_template_id")
    @Audited
    private Long reportTemplateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_template_id", insertable = false, updatable = false)
    private ReportTemplate reportTemplate;

    @Column(name = "link_value")
    @Audited
    private String linkValue;

    @Column(name = "form_value")
    @Audited
    private String formValue;

    @Column(name = "surgery_form")
    @Audited
    private int surgeryForm;

    @Column(name = "use_in_reception", nullable = false)
    @Audited
    private boolean useInReception;

    @Column(name = "long_take_result", nullable = false)
    @Audited
    private boolean longTakeResult;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient;

    @Column(name = "outpatient", nullable = false)
    @Audited
    private boolean outpatient;

    @Column(name = "low_indicator")
    @Audited
    private Double lowIndicator;

    @Column(name = "high_indicator")
    @Audited
    private Double highIndicator;

    @Column(name = "male_low_indicator")
    @Audited
    private Double maleLowIndicator;

    @Column(name = "male_high_indicator")
    @Audited
    private Double maleHighIndicator;

    @Column(name = "female_low_indicator")
    @Audited
    private Double femaleLowIndicator;

    @Column(name = "female_high_indicator")
    @Audited
    private Double femaleHighIndicator;

    @Column(name = "normal_range")
    @Audited
    private String normalRange;

    @Column(name = "unit")
    @Audited
    private String unit;

    @Column(name = "report_name")
    @Audited
    private String reportName;

    @Column(name = "c43_value")
    @Audited
    private String c43Value;

    @Column(name = "c43_name")
    @Audited
    private String c43Name;

    @Column(name = "c37_value")
    @Audited
    private String c37Value;

    @Column(name = "c37_name")
    @Audited
    private String c37Name;

    @Column(name = "c37_note")
    @Audited
    private String c37Note;

    @Column(name = "machine_name")
    @Audited
    private String machineName;

    @Column(name = "conclusion_template")
    @Audited
    private String conclusionTemplate;

    @Column(name = "decision")
    @Audited
    private String decision;

    @Column(name = "decision_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date decisionDate;

    @Column(name = "using_object")
    @Audited
    private String usingObject;

    @Column(name = "print_order")
    @Audited
    private int printOrder;

    @Column(name = "on_request", nullable = false)
    @Audited
    private boolean onRequest;

    @Column(name = "time_keeping", nullable = false)
    @Audited
    private boolean timeKeeping;

    @Column(name = "specimens", nullable = false)
    @Audited
    private boolean specimens;

    @Column(name = "diagnostic", nullable = false)
    @Audited
    private boolean diagnostic;

    @Column(name = "auto_create_line", nullable = false)
    @Audited
    private boolean autoCreateLine;

    @Column(name = "in_department", nullable = false)
    @Audited
    private boolean inDepartment;

    @Column(name = "contract", nullable = false)
    @Audited
    private boolean contract;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ServiceSource getService() {
        return service;
    }

    public void setService(ServiceSource service) {
        this.service = service;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Long getDyeMethodId() {
        return dyeMethodId;
    }

    public void setDyeMethodId(Long dyeMethodId) {
        this.dyeMethodId = dyeMethodId;
    }

    public DyeMethod getDyeMethod() {
        return dyeMethod;
    }

    public void setDyeMethod(DyeMethod dyeMethod) {
        this.dyeMethod = dyeMethod;
    }

    public Long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Long reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public ReportTemplate getReportTemplate() {
        return reportTemplate;
    }

    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue;
    }

    public boolean isUseInReception() {
        return useInReception;
    }

    public void setUseInReception(boolean useInReception) {
        this.useInReception = useInReception;
    }

    public boolean isLongTakeResult() {
        return longTakeResult;
    }

    public void setLongTakeResult(boolean longTakeResult) {
        this.longTakeResult = longTakeResult;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public boolean isOutpatient() {
        return outpatient;
    }

    public void setOutpatient(boolean outpatient) {
        this.outpatient = outpatient;
    }

    public Double getLowIndicator() {
        return lowIndicator;
    }

    public void setLowIndicator(Double lowIndicator) {
        this.lowIndicator = lowIndicator;
    }

    public Double getHighIndicator() {
        return highIndicator;
    }

    public void setHighIndicator(Double highIndicator) {
        this.highIndicator = highIndicator;
    }

    public Double getMaleLowIndicator() {
        return maleLowIndicator;
    }

    public void setMaleLowIndicator(Double maleLowIndicator) {
        this.maleLowIndicator = maleLowIndicator;
    }

    public Double getMaleHighIndicator() {
        return maleHighIndicator;
    }

    public void setMaleHighIndicator(Double maleHighIndicator) {
        this.maleHighIndicator = maleHighIndicator;
    }

    public Double getFemaleLowIndicator() {
        return femaleLowIndicator;
    }

    public void setFemaleLowIndicator(Double femaleLowIndicator) {
        this.femaleLowIndicator = femaleLowIndicator;
    }

    public Double getFemaleHighIndicator() {
        return femaleHighIndicator;
    }

    public void setFemaleHighIndicator(Double femaleHighIndicator) {
        this.femaleHighIndicator = femaleHighIndicator;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getC43Value() {
        return c43Value;
    }

    public void setC43Value(String c43Value) {
        this.c43Value = c43Value;
    }

    public String getC43Name() {
        return c43Name;
    }

    public void setC43Name(String c43Name) {
        this.c43Name = c43Name;
    }

    public String getC37Value() {
        return c37Value;
    }

    public void setC37Value(String c37Value) {
        this.c37Value = c37Value;
    }

    public String getC37Name() {
        return c37Name;
    }

    public void setC37Name(String c37Name) {
        this.c37Name = c37Name;
    }

    public String getC37Note() {
        return c37Note;
    }

    public void setC37Note(String c37Note) {
        this.c37Note = c37Note;
    }

    public int getSurgeryForm() {
        return surgeryForm;
    }

    public void setSurgeryForm(int surgeryForm) {
        this.surgeryForm = surgeryForm;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getConclusionTemplate() {
        return conclusionTemplate;
    }

    public void setConclusionTemplate(String conclusionTemplate) {
        this.conclusionTemplate = conclusionTemplate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getUsingObject() {
        return usingObject;
    }

    public void setUsingObject(String usingObject) {
        this.usingObject = usingObject;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public boolean isOnRequest() {
        return onRequest;
    }

    public void setOnRequest(boolean onRequest) {
        this.onRequest = onRequest;
    }

    public boolean isTimeKeeping() {
        return timeKeeping;
    }

    public void setTimeKeeping(boolean timeKeeping) {
        this.timeKeeping = timeKeeping;
    }

    public boolean isSpecimens() {
        return specimens;
    }

    public void setSpecimens(boolean specimens) {
        this.specimens = specimens;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public boolean isDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(boolean diagnostic) {
        this.diagnostic = diagnostic;
    }

    public boolean isAutoCreateLine() {
        return autoCreateLine;
    }

    public void setAutoCreateLine(boolean autoCreateLine) {
        this.autoCreateLine = autoCreateLine;
    }

    public boolean isInDepartment() {
        return inDepartment;
    }

    public void setInDepartment(boolean inDepartment) {
        this.inDepartment = inDepartment;
    }
}
