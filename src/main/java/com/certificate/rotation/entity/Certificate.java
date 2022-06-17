package com.certificate.rotation.entity;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {
	
	private String podHostName;

	private String podIpAddress;

	private ZonedDateTime certCreationDate;

	private ZonedDateTime certInstallationDate;

	private ZonedDateTime certExpirationDate;

	private String status;

	private byte[] certificate;



}
