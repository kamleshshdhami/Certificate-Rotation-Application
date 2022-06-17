package com.certificate.rotation.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.certificate.rotation.entity.Certificate;
import com.certificate.rotation.entity.CertificateDto;
import com.certificate.rotation.service.CertificateService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/", produces = "application/json; charset=UTF-8")
@Tag(name = "Certificate")
public class CertificateController {

	@Autowired
	private CertificateService certificateService;

	@GetMapping(value = "certificates/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CertificateDto> retrieveCertificateById(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(certificateService.retrieveCertificateById(id));
	}

	@GetMapping("certificates")
	public ResponseEntity<List<CertificateDto>> retrieveCertificates() {
		return ResponseEntity.ok().body(certificateService.retrieveCertificates());
	}

	@PostMapping("certificates")
	public ResponseEntity<String> createCertificate(@RequestBody Certificate certificate) throws URISyntaxException {

		CertificateDto certificateResponse = certificateService.createCertificate(maptoDto(certificate));
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(certificateResponse.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("certificates/{id}")
	public ResponseEntity<CertificateDto> updateCertificate(@PathVariable String id,
			@RequestBody Certificate certificate) throws URISyntaxException {

		return ResponseEntity.ok(certificateService.updateCertificate(maptoDto(certificate), id));
	}

	@DeleteMapping("certificates/{id}")
	public ResponseEntity<String> deleteCertificate(@PathVariable String id) throws URISyntaxException {

		certificateService.deleteCertificate(id);

		return ResponseEntity.ok().build();
	}

	static CertificateDto maptoDto(Certificate certificate) {

		return CertificateDto.builder().podHostName(certificate.getPodHostName())
				.podIpAddress(certificate.getPodIpAddress()).certCreationDate(certificate.getCertCreationDate())
				.certInstallationDate(certificate.getCertInstallationDate())
				.certExpirationDate(certificate.getCertExpirationDate()).status(certificate.getStatus())
				.certificate(certificate.getCertificate())
				.build();

	}
}
