package com.certificate.rotation.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.certificate.rotation.entity.CertificateDto;
import com.certificate.rotation.entity.CertificateEntity;
import com.certificate.rotation.exception.ResourceNotFoundException;

@Repository
public class CertificateRepositoryImpl implements CertificateRepository {

	@Autowired
	private EntityManager em;

	public CertificateDto retrieveCertificateById(String id) {
		CertificateEntity certificateEntity = getCertificateEntity(id);

		return mapToDto(certificateEntity);
	}

	public List<CertificateDto> retrieveCertificates() {

		TypedQuery<CertificateEntity> query = em.createNamedQuery("CertificateEntity.getAllCertificates",
				CertificateEntity.class);
		List<CertificateEntity> certificateList = query.getResultList();

		return certificateList.stream().map(n -> mapToDto(n)).collect(Collectors.toList());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public CertificateDto createCertificate(CertificateDto certificate) {
		CertificateEntity certificateEntity = maptoEntity(certificate);

		em.persist(certificateEntity);

		return mapToDto(certificateEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public CertificateDto updateCertificate(CertificateDto certificate) {

		CertificateEntity udpatedCertificateEntity = em.merge(maptoEntity(certificate));

		return mapToDto(udpatedCertificateEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteCertificate(String id) {
		CertificateEntity certificateEntity = getCertificateEntity(id);

		em.remove(certificateEntity);

	}

	private CertificateEntity getCertificateEntity(String id) {
		CertificateEntity certificateEntity = null;
		TypedQuery<CertificateEntity> query = em.createNamedQuery("CertificateEntity.getCertificateById",
				CertificateEntity.class);
		query.setParameter("certificateid", Long.valueOf(id).longValue());

		try {
			certificateEntity = query.getSingleResult();
		} catch (NoResultException nre) {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		} catch (NonUniqueResultException nue) {
			throw new NonUniqueResultException("Duplicate Record found with id : " + id);
		}
		return certificateEntity;
	}

	static CertificateDto mapToDto(CertificateEntity certificateEntity) {
		return CertificateDto.builder().id(certificateEntity.getId()).podHostName(certificateEntity.getPodHostName())
				.podIpAddress(certificateEntity.getPodIpAddress())
				.certCreationDate(certificateEntity.getCertCreationDate())
				.certInstallationDate(certificateEntity.getCertInstallationDate())
				.certExpirationDate(certificateEntity.getCertExpirationDate()).status(certificateEntity.getStatus())
				.certificate(certificateEntity.getCertificate()).build();
	}

	static CertificateEntity maptoEntity(CertificateDto certificate) {
		return CertificateEntity.builder().podHostName(certificate.getPodHostName())
				.podIpAddress(certificate.getPodIpAddress()).certCreationDate(certificate.getCertCreationDate())
				.certInstallationDate(certificate.getCertInstallationDate())
				.certExpirationDate(certificate.getCertExpirationDate()).status(certificate.getStatus())
				.certificate(certificate.getCertificate()).build();

	}
}
