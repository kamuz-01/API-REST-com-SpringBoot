package org.ProjetoSpringBoot.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespostaError {
	 private int status;
	 private String error;
	 private String message;
	 private String path;
	 private String timestamp;
}