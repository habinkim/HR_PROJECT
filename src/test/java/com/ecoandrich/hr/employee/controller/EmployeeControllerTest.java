package com.ecoandrich.hr.employee.controller;

import com.ecoandrich.hr.base.ControllerBaseTest;
import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.MessageCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static com.ecoandrich.hr.common.response.MessageCode.NOT_FOUND_EMPLOYEE;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EmployeeControllerTest extends ControllerBaseTest {

    @Transactional
    @Test
    @Order(1)
    @DisplayName("특정 사원 현재 정보 조회, 성공")
    void infoSuccess() throws Exception {

        String uri = Uris.EMPLOYEE_ROOT + Uris.REST_NAME_ID;
        Integer employeeId = 101;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))

                .andExpect(jsonPath("$.result.id", notNullValue()))
                .andExpect(jsonPath("$.result.firstName", notNullValue()))
                .andExpect(jsonPath("$.result.lastName", notNullValue()))
                .andExpect(jsonPath("$.result.email", notNullValue()))
                .andExpect(jsonPath("$.result.phoneNumber", notNullValue()))
                .andExpect(jsonPath("$.result.hireDate", notNullValue()))
                .andExpect(jsonPath("$.result.jobId", notNullValue()))
                .andExpect(jsonPath("$.result.jobTitle", notNullValue()))
                .andExpect(jsonPath("$.result.salary", notNullValue()))
                .andExpect(jsonPath("$.result.commissionPct", nullValue()))
                .andExpect(jsonPath("$.result.managerId", notNullValue()))
                .andExpect(jsonPath("$.result.managerFirstName", notNullValue()))
                .andExpect(jsonPath("$.result.managerLastName", notNullValue()))
                .andExpect(jsonPath("$.result.departmentId", notNullValue()))
                .andExpect(jsonPath("$.result.departmentName", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.id", is(employeeId)))
                .andExpect(jsonPath("$.result.firstName", is("Neena")))
                .andExpect(jsonPath("$.result.lastName", is("Kochhar")))
                .andExpect(jsonPath("$.result.email", is("NKOCHHAR")))
                .andExpect(jsonPath("$.result.phoneNumber", is("515.123.4568")))
                .andExpect(jsonPath("$.result.hireDate", is("1989-09-21")))
                .andExpect(jsonPath("$.result.jobId", is("AD_VP")))
                .andExpect(jsonPath("$.result.jobTitle", is("Administration Vice President")))
                .andExpect(jsonPath("$.result.salary", is(17000.00)))
                .andExpect(jsonPath("$.result.managerId", is(100)))
                .andExpect(jsonPath("$.result.managerFirstName", is("Steven")))
                .andExpect(jsonPath("$.result.managerLastName", is("King")))
                .andExpect(jsonPath("$.result.departmentId", is(90)))
                .andExpect(jsonPath("$.result.departmentName", is("Executive")))

                .andDo(restDocs.document(
                        pathParameters(
                                parameterWithName("id").description("사원 ID")
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result").description("오브젝트"),
                                fieldWithPath("result.id").description("사원 ID"),
                                fieldWithPath("result.firstName").description("성"),
                                fieldWithPath("result.lastName").description("이름"),
                                fieldWithPath("result.email").description("이메일"),
                                fieldWithPath("result.phoneNumber").description("전화번호"),
                                fieldWithPath("result.hireDate").description("고용일"),
                                fieldWithPath("result.jobId").description("업무 ID"),
                                fieldWithPath("result.jobTitle").description("업무명"),
                                fieldWithPath("result.salary").description("봉급"),
                                fieldWithPath("result.commissionPct").description("커미션 비율"),
                                fieldWithPath("result.managerId").description("상사 ID"),
                                fieldWithPath("result.managerFirstName").description("상사 성"),
                                fieldWithPath("result.managerLastName").description("상사 이름"),
                                fieldWithPath("result.departmentId").description("부서 ID"),
                                fieldWithPath("result.departmentName").description("부서명")
                        )
                ));
    }

    @Transactional
    @Test
    @Order(2)
    @DisplayName("특정 사원 현재 정보 조회, 실패")
    void infoFail() throws Exception {

        String uri = Uris.EMPLOYEE_ROOT + Uris.REST_NAME_ID;
        Integer employeeId = 999;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.code", notNullValue()))
                .andExpect(jsonPath("$.message", is(messageSourceUtil.getMessage(NOT_FOUND_EMPLOYEE.getCode()))))
                .andExpect(jsonPath("$.code", is(NOT_FOUND_EMPLOYEE.getCode())));
    }

}
