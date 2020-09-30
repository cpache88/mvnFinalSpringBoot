package com.promineotech.mvnFinalSpringBoot.transformer;

import com.promineotech.mvnFinalSpringBoot.Dto.AdmissionDTO;
import com.promineotech.mvnFinalSpringBoot.entity.Admission;
import java.util.ArrayList;
import java.util.List;

public class AdmissionTransformer {
	public static AdmissionDTO getAdmissionDTO(Admission admission) {
		AdmissionDTO admissionDTO = new AdmissionDTO();
		if (admission.getId() != null) {
			admissionDTO.setId(admission.getId());
		}
		if (admission.getDate() != null) {
			admissionDTO.setDate(admission.getDate());
		}
		if (admission.getHospital() != null) {
			admissionDTO.setHospitalDTO(HospitalTransformer.getHospitalDTO(admission.getHospital()));
		}
		return admissionDTO;
	}

	public static AdmissionDTO getAdmissionDTOForHospital(Admission admission) {
		AdmissionDTO admissionDTO = new AdmissionDTO();
		if (admission.getId() != null) {
			admissionDTO.setId(admission.getId());
		}
		if (admission.getDate() != null) {
			admissionDTO.setDate(admission.getDate());
		}
		if (admission.getPatient() != null) {
			admissionDTO.setPatientDTO(PatientTransformer.getPatientDTOForHospital(admission.getPatient()));
		}
		return admissionDTO;
	}

	public static AdmissionDTO getAdmissionDToForAdmision(Admission admission) {
		AdmissionDTO admissionDTO = new AdmissionDTO();
		if (admission.getId() != null) {
			admissionDTO.setId(admission.getId());
		}
		if (admission.getDate() != null) {
			admissionDTO.setDate(admission.getDate());
		}
		if (admission.getPatient() != null) {
			admissionDTO.setPatientDTO(PatientTransformer.getPatientDTOForHospital(admission.getPatient()));
		}
		if (admission.getHospital() != null) {
			admissionDTO.setHospitalDTO(HospitalTransformer.getHospitalDTO(admission.getHospital()));
		}
		return admissionDTO;
	}

	public static List<AdmissionDTO> getAdmissionDTOList(List<Admission> admissionList) {
		List<AdmissionDTO> admissionDTOS = new ArrayList<>();
		for (int i = 0; i < admissionList.size(); i++) {
			admissionDTOS.add(AdmissionTransformer.getAdmissionDToForAdmision(admissionList.get(i)));
		}
		return admissionDTOS;
	}
}
