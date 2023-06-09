package com.ecoandrich.hr.job.controller;

import com.ecoandrich.hr.base.ControllerBaseTest;
import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.MessageCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import static com.ecoandrich.hr.common.response.MessageCode.NOT_FOUND_EMPLOYEE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class JobControllerTest extends ControllerBaseTest {

    @Transactional
    @Test
    @Order(1)
    @DisplayName("특정 사원 업무 이력 정보 조회 - no Paging, 성공")
    void historySuccess() throws Exception {

        String uri = Uris.JOB_ROOT + "/v1" + Uris.REST_NAME_ID;
        Integer employeeId = 101;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result[0]", notNullValue()))

                .andExpect(jsonPath("$.result[0].employeeId", notNullValue()))
                .andExpect(jsonPath("$.result[0].firstName", notNullValue()))
                .andExpect(jsonPath("$.result[0].lastName", notNullValue()))
                .andExpect(jsonPath("$.result[0].startDate", notNullValue()))
                .andExpect(jsonPath("$.result[0].endDate", notNullValue()))
                .andExpect(jsonPath("$.result[0].jobId", notNullValue()))
                .andExpect(jsonPath("$.result[0].jobTitle", notNullValue()))
                .andExpect(jsonPath("$.result[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result[0].departmentName", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result[0].employeeId", is(employeeId)))
                .andExpect(jsonPath("$.result[0].firstName", is("Neena")))
                .andExpect(jsonPath("$.result[0].lastName", is("Kochhar")))
                .andExpect(jsonPath("$.result[0].startDate", is("1993-10-28")))
                .andExpect(jsonPath("$.result[0].endDate", is("1997-03-15")))
                .andExpect(jsonPath("$.result[0].jobId", is("AC_MGR")))
                .andExpect(jsonPath("$.result[0].jobTitle", is("Accounting Manager")))
                .andExpect(jsonPath("$.result[0].departmentId", is(110)))
                .andExpect(jsonPath("$.result[0].departmentName", is("Accounting")))

                .andDo(restDocs.document(
                        pathParameters(
                                parameterWithName("id").description("사원 ID")
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result[]").description("오브젝트"),
                                fieldWithPath("result[].employeeId").description("사원 ID"),
                                fieldWithPath("result[].firstName").description("성"),
                                fieldWithPath("result[].lastName").description("이름"),
                                fieldWithPath("result[].startDate").description("업무 시작일"),
                                fieldWithPath("result[].endDate").description("업무 종료일"),
                                fieldWithPath("result[].jobId").description("업무 ID"),
                                fieldWithPath("result[].jobTitle").description("업무명"),
                                fieldWithPath("result[].departmentId").description("부서 ID"),
                                fieldWithPath("result[].departmentName").description("부서명")
                        )
                ));

    }

    @Transactional
    @Test
    @Order(2)
    @DisplayName("특정 사원 업무 이력 정보 조회 - no Paging, 실패")
    void historyFail() throws Exception {

        String uri = Uris.JOB_ROOT + "/v1" + Uris.REST_NAME_ID;
        Integer employeeId = 999;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.code", notNullValue()))
                .andExpect(jsonPath("$.message", is(messageSourceUtil.getMessage(NOT_FOUND_EMPLOYEE.getCode()))))
                .andExpect(jsonPath("$.code", is(NOT_FOUND_EMPLOYEE.getCode())));

    }

    @Transactional
    @Test
    @Order(3)
    @DisplayName("특정 사원 업무 이력 정보 조회 - with Paging And Query Param, 성공")
    void historyWithPagingAndQueryParamSuccess() throws Exception {

        String uri = Uris.JOB_ROOT + "/v2" + Uris.REST_NAME_ID;
        Integer employeeId = 101;


        mockMvc.perform(
                        get(uri, employeeId)
                                .queryParam("size", "1")
                                .queryParam("page", "0")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.content[0]", notNullValue()))

                .andExpect(jsonPath("$.result.content[0].employeeId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].firstName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].lastName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].startDate", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].endDate", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].jobId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].jobTitle", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentName", notNullValue()))

                .andExpect(jsonPath("$.result.pageable", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.offset", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.pageNumber", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.pageSize", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.paged", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.unpaged", notNullValue()))

                .andExpect(jsonPath("$.result.pageable.sort", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.empty", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", notNullValue()))

                .andExpect(jsonPath("$.result.last", notNullValue()))
                .andExpect(jsonPath("$.result.totalPages", notNullValue()))
                .andExpect(jsonPath("$.result.totalElements", notNullValue()))
                .andExpect(jsonPath("$.result.first", notNullValue()))
                .andExpect(jsonPath("$.result.size", notNullValue()))
                .andExpect(jsonPath("$.result.number", notNullValue()))
                .andExpect(jsonPath("$.result.sort.empty", notNullValue()))
                .andExpect(jsonPath("$.result.sort.unsorted", notNullValue()))
                .andExpect(jsonPath("$.result.sort.sorted", notNullValue()))
                .andExpect(jsonPath("$.result.numberOfElements", notNullValue()))
                .andExpect(jsonPath("$.result.empty", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.content[0].employeeId", is(employeeId)))
                .andExpect(jsonPath("$.result.content[0].firstName", is("Neena")))
                .andExpect(jsonPath("$.result.content[0].lastName", is("Kochhar")))
                .andExpect(jsonPath("$.result.content[0].startDate", is("1993-10-28")))
                .andExpect(jsonPath("$.result.content[0].endDate", is("1997-03-15")))
                .andExpect(jsonPath("$.result.content[0].jobId", is("AC_MGR")))
                .andExpect(jsonPath("$.result.content[0].jobTitle", is("Accounting Manager")))
                .andExpect(jsonPath("$.result.content[0].departmentId", is(110)))
                .andExpect(jsonPath("$.result.content[0].departmentName", is("Accounting")))

                .andExpect(jsonPath("$.result.pageable.offset", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageNumber", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageSize", is(1)))
                .andExpect(jsonPath("$.result.pageable.paged", is(true)))
                .andExpect(jsonPath("$.result.pageable.unpaged", is(false)))

                .andExpect(jsonPath("$.result.pageable.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", is(true)))

                .andExpect(jsonPath("$.result.last", is(false)))
                .andExpect(jsonPath("$.result.totalPages", is(2)))
                .andExpect(jsonPath("$.result.totalElements", is(2)))
                .andExpect(jsonPath("$.result.first", is(true)))
                .andExpect(jsonPath("$.result.size", is(1)))
                .andExpect(jsonPath("$.result.number", is(0)))
                .andExpect(jsonPath("$.result.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.sort.sorted", is(true)))
                .andExpect(jsonPath("$.result.numberOfElements", is(1)))
                .andExpect(jsonPath("$.result.empty", is(false)))

                .andDo(restDocs.document(
                        pathParameters(
                                parameterWithName("id").description("사원 ID")
                        ),
                        queryParameters(
                                parameterWithName("size").description("페이지당 크기 [default = 10], >= 1").optional(),
                                parameterWithName("page").description("페이지 번호 [default = 0], >= 0").optional()
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result.content[]").description("오브젝트"),
                                fieldWithPath("result.content[].employeeId").description("사원 ID"),
                                fieldWithPath("result.content[].firstName").description("성"),
                                fieldWithPath("result.content[].lastName").description("이름"),
                                fieldWithPath("result.content[].startDate").description("업무 시작일"),
                                fieldWithPath("result.content[].endDate").description("업무 종료일"),
                                fieldWithPath("result.content[].jobId").description("업무 ID"),
                                fieldWithPath("result.content[].jobTitle").description("업무명"),
                                fieldWithPath("result.content[].departmentId").description("부서 ID"),
                                fieldWithPath("result.content[].departmentName").description("부서명"),

                                fieldWithPath("result.pageable").description("페이징 오브젝트"),
                                fieldWithPath("result.pageable.offset").description("offset"),
                                fieldWithPath("result.pageable.pageNumber").description("페이지 번호 (0부터 시작)"),
                                fieldWithPath("result.pageable.pageSize").description("요청한 페이지 당 크기"),
                                fieldWithPath("result.pageable.paged").description("페이징 여부"),
                                fieldWithPath("result.pageable.unpaged").description("미 페이징 여부"),
                                fieldWithPath("result.pageable.sort").description("정렬 정보"),
                                fieldWithPath("result.pageable.sort.empty").description("정렬 정보 미존재 여부"),
                                fieldWithPath("result.pageable.sort.unsorted").description("미정렬 여부"),
                                fieldWithPath("result.pageable.sort.sorted").description("정렬 여부"),

                                fieldWithPath("result.last").description("마지막 페이지 여부"),
                                fieldWithPath("result.totalPages").description("페이지 갯수"),
                                fieldWithPath("result.totalElements").description("총 요소 갯수"),
                                fieldWithPath("result.first").description("첫 페이지 여부"),
                                fieldWithPath("result.size").description("페이지 당 크기"),
                                fieldWithPath("result.number").description("페이지 번호 (0부터 시작)"),
                                fieldWithPath("result.sort.empty").description("정렬 정보 미존재 여부"),
                                fieldWithPath("result.sort.unsorted").description("미정렬 여부"),
                                fieldWithPath("result.sort.sorted").description("정렬 여부"),
                                fieldWithPath("result.numberOfElements").description("현재 페이지 요소 갯수"),
                                fieldWithPath("result.empty").description("현재 페이지 요소 미존재 여부")
                        )
                ));

    }

    @Transactional
    @Test
    @Order(4)
    @DisplayName("특정 사원 업무 이력 정보 조회 - with Paging, 성공")
    void historyWithPagingSuccess() throws Exception {

        String uri = Uris.JOB_ROOT + "/v2" + Uris.REST_NAME_ID;
        Integer employeeId = 101;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.content[0]", notNullValue()))

                .andExpect(jsonPath("$.result.content[0].employeeId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].firstName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].lastName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].startDate", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].endDate", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].jobId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].jobTitle", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentName", notNullValue()))

                .andExpect(jsonPath("$.result.pageable", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.offset", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.pageNumber", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.pageSize", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.paged", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.unpaged", notNullValue()))

                .andExpect(jsonPath("$.result.pageable.sort", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.empty", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", notNullValue()))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", notNullValue()))

                .andExpect(jsonPath("$.result.last", notNullValue()))
                .andExpect(jsonPath("$.result.totalPages", notNullValue()))
                .andExpect(jsonPath("$.result.totalElements", notNullValue()))
                .andExpect(jsonPath("$.result.first", notNullValue()))
                .andExpect(jsonPath("$.result.size", notNullValue()))
                .andExpect(jsonPath("$.result.number", notNullValue()))
                .andExpect(jsonPath("$.result.sort.empty", notNullValue()))
                .andExpect(jsonPath("$.result.sort.unsorted", notNullValue()))
                .andExpect(jsonPath("$.result.sort.sorted", notNullValue()))
                .andExpect(jsonPath("$.result.numberOfElements", notNullValue()))
                .andExpect(jsonPath("$.result.empty", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.content[0].employeeId", is(employeeId)))
                .andExpect(jsonPath("$.result.content[0].firstName", is("Neena")))
                .andExpect(jsonPath("$.result.content[0].lastName", is("Kochhar")))
                .andExpect(jsonPath("$.result.content[0].startDate", is("1993-10-28")))
                .andExpect(jsonPath("$.result.content[0].endDate", is("1997-03-15")))
                .andExpect(jsonPath("$.result.content[0].jobId", is("AC_MGR")))
                .andExpect(jsonPath("$.result.content[0].jobTitle", is("Accounting Manager")))
                .andExpect(jsonPath("$.result.content[0].departmentId", is(110)))
                .andExpect(jsonPath("$.result.content[0].departmentName", is("Accounting")))

                .andExpect(jsonPath("$.result.pageable.offset", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageNumber", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageSize", is(10)))
                .andExpect(jsonPath("$.result.pageable.paged", is(true)))
                .andExpect(jsonPath("$.result.pageable.unpaged", is(false)))

                .andExpect(jsonPath("$.result.pageable.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", is(true)))

                .andExpect(jsonPath("$.result.last", is(true)))
                .andExpect(jsonPath("$.result.totalPages", is(1)))
                .andExpect(jsonPath("$.result.totalElements", is(2)))
                .andExpect(jsonPath("$.result.first", is(true)))
                .andExpect(jsonPath("$.result.size", is(10)))
                .andExpect(jsonPath("$.result.number", is(0)))
                .andExpect(jsonPath("$.result.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.sort.sorted", is(true)))
                .andExpect(jsonPath("$.result.numberOfElements", is(2)))
                .andExpect(jsonPath("$.result.empty", is(false)))

                .andDo(restDocs.document(
                        pathParameters(
                                parameterWithName("id").description("사원 ID")
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result.content[]").description("오브젝트"),
                                fieldWithPath("result.content[].employeeId").description("사원 ID"),
                                fieldWithPath("result.content[].firstName").description("성"),
                                fieldWithPath("result.content[].lastName").description("이름"),
                                fieldWithPath("result.content[].startDate").description("업무 시작일"),
                                fieldWithPath("result.content[].endDate").description("업무 종료일"),
                                fieldWithPath("result.content[].jobId").description("업무 ID"),
                                fieldWithPath("result.content[].jobTitle").description("업무명"),
                                fieldWithPath("result.content[].departmentId").description("부서 ID"),
                                fieldWithPath("result.content[].departmentName").description("부서명"),

                                fieldWithPath("result.pageable").description("페이징 오브젝트"),
                                fieldWithPath("result.pageable.offset").description("offset"),
                                fieldWithPath("result.pageable.pageNumber").description("페이지 번호 (0부터 시작)"),
                                fieldWithPath("result.pageable.pageSize").description("요청한 페이지 당 크기"),
                                fieldWithPath("result.pageable.paged").description("페이징 여부"),
                                fieldWithPath("result.pageable.unpaged").description("미 페이징 여부"),
                                fieldWithPath("result.pageable.sort").description("정렬 정보"),
                                fieldWithPath("result.pageable.sort.empty").description("정렬 정보 미존재 여부"),
                                fieldWithPath("result.pageable.sort.unsorted").description("미정렬 여부"),
                                fieldWithPath("result.pageable.sort.sorted").description("정렬 여부"),

                                fieldWithPath("result.last").description("마지막 페이지 여부"),
                                fieldWithPath("result.totalPages").description("페이지 갯수"),
                                fieldWithPath("result.totalElements").description("총 요소 갯수"),
                                fieldWithPath("result.first").description("첫 페이지 여부"),
                                fieldWithPath("result.size").description("페이지 당 크기"),
                                fieldWithPath("result.number").description("페이지 번호 (0부터 시작)"),
                                fieldWithPath("result.sort.empty").description("정렬 정보 미존재 여부"),
                                fieldWithPath("result.sort.unsorted").description("미정렬 여부"),
                                fieldWithPath("result.sort.sorted").description("정렬 여부"),
                                fieldWithPath("result.numberOfElements").description("현재 페이지 요소 갯수"),
                                fieldWithPath("result.empty").description("현재 페이지 요소 미존재 여부")
                        )
                ));

    }

    @Transactional
    @Test
    @Order(5)
    @DisplayName("특정 사원 업무 이력 정보 조회 - with Paging, 실패")
    void historyWithPagingFail() throws Exception {

        String uri = Uris.JOB_ROOT + "/v2" + Uris.REST_NAME_ID;
        Integer employeeId = 999;


        mockMvc.perform(get(uri, employeeId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.code", notNullValue()))
                .andExpect(jsonPath("$.message", is(messageSourceUtil.getMessage(NOT_FOUND_EMPLOYEE.getCode()))))
                .andExpect(jsonPath("$.code", is(NOT_FOUND_EMPLOYEE.getCode())));

    }

}
