package com.acme.api.company.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyPagingService;
import com.acme.architecture.core.constant.PageableConstant;
import com.acme.architecture.core.response.PageableResponse;
import com.acme.architecture.core.util.AcmePageableUtil;
import com.acme.model.api.company.entity.CompanyResponse;

@RestController
@RequestMapping(CompanyControllerConstant.BASE_URL)
@CrossOrigin(origins = "*")
public class CompanyPagingController {

	@Autowired
	private CompanyPagingService companyPagingService;

	@GetMapping(path = CompanyControllerConstant.GET_PAGING, params = { PageableConstant.QUERY_PARAM_PAGE_NUMBER,
			PageableConstant.QUERY_PARAM_PAGE_SIZE, PageableConstant.QUERY_PARAM_SORT_PROPERTY,
			PageableConstant.QUERY_PARAM_SORT_ORDER })
	public ResponseEntity<PageableResponse> findPaginated(
			@RequestParam(name = PageableConstant.QUERY_PARAM_PAGE_NUMBER, required = true) @Min(value = PageableConstant.MIN_PARAM_PAGE_NUMBER) Integer pageNumber,
			@RequestParam(name = PageableConstant.QUERY_PARAM_PAGE_SIZE, required = true) @Min(value = PageableConstant.MIN_PARAM_PAGE_SIZE) Integer pageSize,
			@RequestParam(name = PageableConstant.QUERY_PARAM_SORT_PROPERTY, required = true) String sortProperty,
			@RequestParam(name = PageableConstant.QUERY_PARAM_SORT_ORDER, required = true) String sortOrder) {

		Page<CompanyResponse> body = companyPagingService.findAll(pageNumber, pageSize, sortProperty, sortOrder);

		if (body.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(AcmePageableUtil.buildPageableResponse(body));
	}

}
