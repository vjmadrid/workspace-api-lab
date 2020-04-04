package com.acme.api.company.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyService;
import com.acme.architecture.common.util.ListUtil;
import com.acme.model.api.company.entity.CompanyResponse;

@RestController
@RequestMapping(CompanyControllerConstant.BASE_FILTER_URL)
@CrossOrigin(origins = "*")
public class CompanyFilterController {

	@Autowired
	private CompanyService companyService;

	@GetMapping(params = CompanyControllerConstant.URL_VAR_ID_LIST, value = CompanyControllerConstant.BASE_FILTER_LIST_URL)
	public ResponseEntity<List<CompanyResponse>> findByIdList(@RequestParam List<String> ids) {

		List<Long> idList = ListUtil.getNumericList(ids).stream().map(id -> Long.parseLong(id))
				.collect(Collectors.toList());

		final List<CompanyResponse> companyResponseList = companyService.findByPKList(idList);

		if (companyResponseList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(companyResponseList);
	}

}