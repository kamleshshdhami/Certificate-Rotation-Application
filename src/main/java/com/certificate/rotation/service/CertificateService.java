package com.certificate.rotation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certificate.rotation.entity.CertificateDto;

@Service
public interface CertificateService {

	public CertificateDto retrieveCertificateById(String id);

	public List<CertificateDto> retrieveCertificates();

	public CertificateDto createCertificate(CertificateDto certificate);

	public CertificateDto updateCertificate(CertificateDto certificate, String id);

	public void deleteCertificate(String id);
}
