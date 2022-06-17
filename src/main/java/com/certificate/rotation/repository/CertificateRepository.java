package com.certificate.rotation.repository;

import java.util.List;

import com.certificate.rotation.entity.CertificateDto;

public interface CertificateRepository {

	public CertificateDto retrieveCertificateById(String id);

	public List<CertificateDto> retrieveCertificates();

	public CertificateDto createCertificate(CertificateDto certificate);

	public CertificateDto updateCertificate(CertificateDto certificate);

	public void deleteCertificate(String id);
}
