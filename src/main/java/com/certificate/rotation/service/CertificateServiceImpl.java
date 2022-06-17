package com.certificate.rotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certificate.rotation.entity.CertificateDto;
import com.certificate.rotation.exception.ValidationException;
import com.certificate.rotation.repository.CertificateRepository;
import com.certificate.rotation.validator.CertificateValidator;

@Service
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private CertificateRepository certificateRepository;
	
	@Autowired
	private CertificateValidator certificateValidator;

	public CertificateDto retrieveCertificateById(String id) {

		return certificateRepository.retrieveCertificateById(id);
	}

	public List<CertificateDto> retrieveCertificates() {

		return certificateRepository.retrieveCertificates();
	}

	public CertificateDto createCertificate(CertificateDto certificate) {
		
		
		
		certificateValidator.validateCreateCertificateRecord(certificate);
		
		return certificateRepository.createCertificate(certificate);
	}

	public CertificateDto updateCertificate(CertificateDto certificate,String id) {
		
		
		certificate.setId(Long.valueOf(id));
		return certificateRepository.updateCertificate(certificate);
	}

	public void deleteCertificate(String id) {
		certificateRepository.deleteCertificate(id);
	}
}
