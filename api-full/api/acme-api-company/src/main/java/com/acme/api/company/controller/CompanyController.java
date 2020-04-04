package com.acme.api.company.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyService;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

@RestController
@RequestMapping(CompanyControllerConstant.BASE_URL)
@CrossOrigin(origins = "*")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<CompanyResponse>> findAll() {

		List<CompanyResponse> companyResponseList = companyService.findAll();

		if (companyResponseList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(companyResponseList);
	}

	@GetMapping(CompanyControllerConstant.GET_BY_ID_PATH)
	public ResponseEntity<CompanyResponse> findById(
			@PathVariable(name = CompanyControllerConstant.URL_VAR_ID, required = true) Long id) {

		final Optional<CompanyResponse> companyResponse = companyService.findByPK(id);

		if (!companyResponse.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(companyResponse.get());
	}

	@PutMapping(CompanyControllerConstant.UPDATE_PATH)
	public ResponseEntity<CompanyResponse> update(@PathVariable(CompanyControllerConstant.URL_VAR_ID) Long id,
			@Valid @RequestBody CompanyRequest companyRequest, HttpServletRequest request) {

		// TODO: obtener ID del usuario a partir de la sesion o cabecera de la peticion
		String userId = "user 1";
		Optional<CompanyResponse> optionalCompanyResponse = companyService.update(id, companyRequest, userId);

		if (!optionalCompanyResponse.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<>(optionalCompanyResponse.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyResponse> insert(@Valid @RequestBody CompanyRequest companyRequest,
			HttpServletRequest request) {

		// TODO: obtener ID del usuario a partir de la sesion o cabecera de la peticion
		String userId = "user 1";
		return new ResponseEntity<>(companyService.create(companyRequest, userId), HttpStatus.CREATED);
	}

}
