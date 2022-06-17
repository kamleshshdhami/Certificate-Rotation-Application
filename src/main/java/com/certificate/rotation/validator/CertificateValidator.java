package com.certificate.rotation.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.certificate.rotation.entity.CertificateDto;
import com.certificate.rotation.exception.ValidationException;

@Component
public class CertificateValidator {

	private void validatePodHostName(CertificateDto certificateDto) {

		if (StringUtils.isEmpty(certificateDto.getPodHostName())) {
			throw new ValidationException("Pod Host Name is mandatory.");
		}

	}

	public CertificateDto podIpAddress(CertificateDto certificateDto) {

		if (StringUtils.isEmpty(certificateDto.getPodIpAddress())) {
			throw new ValidationException("Pod IP Adddress is mandatory.");
		}

		return certificateDto;
	}

	public CertificateDto certCreationDate(CertificateDto certificateDto) {

		if (certificateDto.getCertCreationDate() == null) {
			throw new ValidationException("Creation Date is mandatory.");
		}

		return certificateDto;
	}

	public CertificateDto certInstallationDate(CertificateDto certificateDto) {

		if (certificateDto.getCertInstallationDate() == null) {
			throw new ValidationException("Installation Date is mandatory.");
		}

		return certificateDto;
	}

	public CertificateDto certExpirationDate(CertificateDto certificateDto) {

		if (certificateDto.getCertExpirationDate() == null) {
			throw new ValidationException("Expiration Date is mandatory.");
		}

		return certificateDto;
	}

	public CertificateDto certstatus(CertificateDto certificateDto) {

		if (certificateDto.getStatus() == null) {
			throw new ValidationException("Status is mandatory.");
		}

		return certificateDto;
	}
	
	
	public void validateCreateCertificateRecord(CertificateDto certificate) {
		validatePodHostName(certificate);
	}

}
