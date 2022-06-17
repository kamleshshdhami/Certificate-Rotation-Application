package com.certificate.rotation.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
//http://localhost:8080/h2-console/login.do?jsessionid=d2842b7600ff5408c3d9c8a44ddcedf5

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Certificate")
@Table(name = "CERTIFICATE")
@NamedQueries({
		@NamedQuery(name = "CertificateEntity.getAllCertificates", query = "select a from Certificate a "
				+ "order by a.id"),
		@NamedQuery(name = "CertificateEntity.getCertificateById", query = "select a from Certificate a "
				+ "where a.id in (:certificateid) order by a.id") })

public class CertificateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, columnDefinition = "NUMBER(10)")
	private long id;

	@Column(name = "POD_HOSTNAME", nullable = false, columnDefinition = "VARCHAR2(256)", length = 256)
	private String podHostName;

	@Column(name = "POD_IP_ADDRESS", nullable = false, columnDefinition = "VARCHAR2(256)", length = 256)
	private String podIpAddress;

	@Column(name = "CERT_CREATION_DATE")
	@Type(type = "org.hibernate.type.ZonedDateTimeType")
	private ZonedDateTime certCreationDate;

	@Column(name = "CERT_INSTALLATION_DATE")
	@Type(type = "org.hibernate.type.ZonedDateTimeType")
	private ZonedDateTime certInstallationDate;

	@Column(name = "CERT_EXPIRATION_DATE")
	@Type(type = "org.hibernate.type.ZonedDateTimeType")
	private ZonedDateTime certExpirationDate;

	@Column(name = "STATUS", columnDefinition = "VARCHAR2(256)", length = 256)
	private String status;

	@Column(name = "CERTIFICATE", columnDefinition = "BLOB")
	private byte[] certificate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPodHostName() {
		return podHostName;
	}

	public void setPodHostName(String podHostName) {
		this.podHostName = podHostName;
	}

	public String getPodIpAddress() {
		return podIpAddress;
	}

	public void setPodIpAddress(String podIpAddress) {
		this.podIpAddress = podIpAddress;
	}

	public ZonedDateTime getCertCreationDate() {
		return certCreationDate;
	}

	public void setCertCreationDate(ZonedDateTime certCreationDate) {
		this.certCreationDate = certCreationDate;
	}

	public ZonedDateTime getCertInstallationDate() {
		return certInstallationDate;
	}

	public void setCertInstallationDate(ZonedDateTime certInstallationDate) {
		this.certInstallationDate = certInstallationDate;
	}

	public ZonedDateTime getCertExpirationDate() {
		return certExpirationDate;
	}

	public void setCertExpirationDate(ZonedDateTime certExpirationDate) {
		this.certExpirationDate = certExpirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getCertificate() {
		return certificate;
	}

	public void setCertificate(byte[] certificate) {
		this.certificate = certificate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CertificateEntity other = (CertificateEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
