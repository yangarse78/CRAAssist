//package com.tourguide.model;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//@Entity
//@Table(name = "TREATMENT_PER_VISIT")
//public class TreatmentPerVisit {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
//	@GenericGenerator(name = "native", strategy = "native")
//	private Long id;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "trial_visit_def_id")
//	private TrialVisitDef trialVisitDef;
//	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "treatment_id")
//    private List<VisitTreatment> treatments;
//
//	public TreatmentPerVisit() {}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public TrialVisitDef getTrialVisitDef() {
//		return trialVisitDef;
//	}
//
//	public void setTrialVisitDef(TrialVisitDef trialVisitDef) {
//		this.trialVisitDef = trialVisitDef;
//	}
//
//	public List<VisitTreatment> getTreatments() {
//		return treatments;
//	}
//
//	public void setTreatments(List<VisitTreatment> treatments) {
//		this.treatments = treatments;
//	}
//	
//}
