package com.ecoandrich.hr.department.controller;

import com.ecoandrich.hr.base.ControllerBaseTest;
import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DepartmentControllerTest extends ControllerBaseTest {

    @Transactional
    @Test
    @Order(1)
    @DisplayName("부서 및 위치 정보 조회 - no Paging, 성공")
    void listSuccess() throws Exception {

        String uri = Uris.DEPARTMENT_ROOT + "/v1";

        mockMvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result[0]", notNullValue()))

                .andExpect(jsonPath("$.result[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result[0].departmentName", notNullValue()))
                .andExpect(jsonPath("$.result[0].managerId", notNullValue()))
                .andExpect(jsonPath("$.result[0].managerFirstName", notNullValue()))
                .andExpect(jsonPath("$.result[0].managerLastName", notNullValue()))
                .andExpect(jsonPath("$.result[0].managerEmail", notNullValue()))
                .andExpect(jsonPath("$.result[0].managerPhoneNumber", notNullValue()))
                .andExpect(jsonPath("$.result[0].locationId", notNullValue()))
                .andExpect(jsonPath("$.result[0].streetAddress", notNullValue()))
                .andExpect(jsonPath("$.result[0].postalCode", notNullValue()))
                .andExpect(jsonPath("$.result[0].city", notNullValue()))
                .andExpect(jsonPath("$.result[0].stateProvince", notNullValue()))
                .andExpect(jsonPath("$.result[0].countryId", notNullValue()))
                .andExpect(jsonPath("$.result[0].countryName", notNullValue()))
                .andExpect(jsonPath("$.result[0].regionId", notNullValue()))
                .andExpect(jsonPath("$.result[0].regionName", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result[0].departmentId", is(110)))
                .andExpect(jsonPath("$.result[0].departmentName", is("Accounting")))
                .andExpect(jsonPath("$.result[0].managerId", is(205)))
                .andExpect(jsonPath("$.result[0].managerFirstName", is("Shelley")))
                .andExpect(jsonPath("$.result[0].managerLastName", is("Higgins")))
                .andExpect(jsonPath("$.result[0].managerEmail", is("SHIGGINS")))
                .andExpect(jsonPath("$.result[0].managerPhoneNumber", is("515.123.8080")))
                .andExpect(jsonPath("$.result[0].locationId", is(1700)))
                .andExpect(jsonPath("$.result[0].streetAddress", is("2004 Charade Rd")))
                .andExpect(jsonPath("$.result[0].postalCode", is("98199")))
                .andExpect(jsonPath("$.result[0].city", is("Seattle")))
                .andExpect(jsonPath("$.result[0].stateProvince", is("Washington")))
                .andExpect(jsonPath("$.result[0].countryId", is("US")))
                .andExpect(jsonPath("$.result[0].countryName", is("United States of America")))
                .andExpect(jsonPath("$.result[0].regionId", is(2)))
                .andExpect(jsonPath("$.result[0].regionName", is("Americas")))

                .andDo(restDocs.document(
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result[]").description("오브젝트"),
                                fieldWithPath("result[].departmentId").description("부서 ID"),
                                fieldWithPath("result[].departmentName").description("부서명"),
                                fieldWithPath("result[].managerId").description("부서 관리자 ID").optional(),
                                fieldWithPath("result[].managerFirstName").description("부서 관리자 성").optional(),
                                fieldWithPath("result[].managerLastName").description("부서 관리자 이름").optional(),
                                fieldWithPath("result[].managerEmail").description("부서 관리자 이메일").optional(),
                                fieldWithPath("result[].managerPhoneNumber").description("부서 관리자 전화번호").optional(),
                                fieldWithPath("result[].locationId").description("주소 정보 ID"),
                                fieldWithPath("result[].streetAddress").description("주소"),
                                fieldWithPath("result[].postalCode").description("우편번호").optional(),
                                fieldWithPath("result[].city").description("도시"),
                                fieldWithPath("result[].stateProvince").description("주").optional(),
                                fieldWithPath("result[].countryId").description("국가 ID"),
                                fieldWithPath("result[].countryName").description("국가명"),
                                fieldWithPath("result[].regionId").description("지역 ID"),
                                fieldWithPath("result[].regionName").description("지역명")
                        )
                ));

    }

    @Transactional
    @Test
    @Order(2)
    @DisplayName("부서 및 위치 정보 조회 - with Paging, 성공")
    void listWithPagingSuccess() throws Exception {

        String uri = Uris.DEPARTMENT_ROOT + "/v2";

        mockMvc.perform(
                        get(uri)
                                .queryParam("size", "5")
                                .queryParam("page", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.content[0]", notNullValue()))

                .andExpect(jsonPath("$.result.content[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerId", nullValue()))
                .andExpect(jsonPath("$.result.content[0].managerFirstName", nullValue()))
                .andExpect(jsonPath("$.result.content[0].managerLastName", nullValue()))
                .andExpect(jsonPath("$.result.content[0].managerEmail", nullValue()))
                .andExpect(jsonPath("$.result.content[0].managerPhoneNumber", nullValue()))
                .andExpect(jsonPath("$.result.content[0].locationId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].streetAddress", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].postalCode", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].city", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].stateProvince", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].countryId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].countryName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].regionId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].regionName", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.content[0].departmentId", is(140)))
                .andExpect(jsonPath("$.result.content[0].departmentName", is("Control And Credit")))
                .andExpect(jsonPath("$.result.content[0].locationId", is(1700)))
                .andExpect(jsonPath("$.result.content[0].streetAddress", is("2004 Charade Rd")))
                .andExpect(jsonPath("$.result.content[0].postalCode", is("98199")))
                .andExpect(jsonPath("$.result.content[0].city", is("Seattle")))
                .andExpect(jsonPath("$.result.content[0].stateProvince", is("Washington")))
                .andExpect(jsonPath("$.result.content[0].countryId", is("US")))
                .andExpect(jsonPath("$.result.content[0].countryName", is("United States of America")))
                .andExpect(jsonPath("$.result.content[0].regionId", is(2)))
                .andExpect(jsonPath("$.result.content[0].regionName", is("Americas")))

                .andExpect(jsonPath("$.result.pageable.offset", is(5)))
                .andExpect(jsonPath("$.result.pageable.pageNumber", is(1)))
                .andExpect(jsonPath("$.result.pageable.pageSize", is(5)))
                .andExpect(jsonPath("$.result.pageable.paged", is(true)))
                .andExpect(jsonPath("$.result.pageable.unpaged", is(false)))

                .andExpect(jsonPath("$.result.pageable.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", is(true)))

                .andExpect(jsonPath("$.result.last", is(false)))
                .andExpect(jsonPath("$.result.totalPages", is(6)))
                .andExpect(jsonPath("$.result.totalElements", is(27)))
                .andExpect(jsonPath("$.result.first", is(false)))
                .andExpect(jsonPath("$.result.size", is(5)))
                .andExpect(jsonPath("$.result.number", is(1)))
                .andExpect(jsonPath("$.result.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.sort.sorted", is(true)))
                .andExpect(jsonPath("$.result.numberOfElements", is(5)))
                .andExpect(jsonPath("$.result.empty", is(false)))

                .andDo(restDocs.document(
                        queryParameters(
                                parameterWithName("size").description("페이지당 크기").optional()
                                        .attributes(
                                                key("default").value("10"),
                                                key("min").value("1")
                                        ),
                                parameterWithName("page").description("페이지 번호").optional()
                                        .attributes(
                                                key("default").value("0"),
                                                key("min").value("0")
                                        )
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result.content[]").description("오브젝트"),
                                fieldWithPath("result.content[].departmentId").description("부서 ID"),
                                fieldWithPath("result.content[].departmentName").description("부서명"),
                                fieldWithPath("result.content[].managerId").description("부서 관리자 ID").optional(),
                                fieldWithPath("result.content[].managerFirstName").description("부서 관리자 성").optional(),
                                fieldWithPath("result.content[].managerLastName").description("부서 관리자 이름").optional(),
                                fieldWithPath("result.content[].managerEmail").description("부서 관리자 이메일").optional(),
                                fieldWithPath("result.content[].managerPhoneNumber").description("부서 관리자 전화번호").optional(),
                                fieldWithPath("result.content[].locationId").description("주소 정보 ID"),
                                fieldWithPath("result.content[].streetAddress").description("주소"),
                                fieldWithPath("result.content[].postalCode").description("우편번호").optional(),
                                fieldWithPath("result.content[].city").description("도시"),
                                fieldWithPath("result.content[].stateProvince").description("주").optional(),
                                fieldWithPath("result.content[].countryId").description("국가 ID"),
                                fieldWithPath("result.content[].countryName").description("국가명"),
                                fieldWithPath("result.content[].regionId").description("지역 ID"),
                                fieldWithPath("result.content[].regionName").description("지역명"),

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
    @Order(3)
    @DisplayName("부서 및 위치 정보 조회 - with Paging And Filter, 성공")
    void listWithPagingAndFilterSuccess() throws Exception {

        String uri = Uris.DEPARTMENT_ROOT + "/v3";

        DepartmentPayloads.InfoRequest request = new DepartmentPayloads.InfoRequest(0, 10,
                null, null, null,
                null, null, null,
                null, "Germ", null, null);

        mockMvc.perform(
                        post(uri).content(toJson(request))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.content[0]", notNullValue()))

                .andExpect(jsonPath("$.result.content[0].departmentId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].departmentName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerFirstName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerLastName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerEmail", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].managerPhoneNumber", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].locationId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].streetAddress", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].postalCode", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].city", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].stateProvince", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].countryId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].countryName", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].regionId", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].regionName", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.content[0].departmentId", is(70)))
                .andExpect(jsonPath("$.result.content[0].departmentName", is("Public Relations")))
                .andExpect(jsonPath("$.result.content[0].managerId", is(204)))
                .andExpect(jsonPath("$.result.content[0].managerFirstName", is("Hermann")))
                .andExpect(jsonPath("$.result.content[0].managerLastName", is("Baer")))
                .andExpect(jsonPath("$.result.content[0].managerEmail", is("HBAER")))
                .andExpect(jsonPath("$.result.content[0].managerPhoneNumber", is("515.123.8888")))
                .andExpect(jsonPath("$.result.content[0].locationId", is(2700)))
                .andExpect(jsonPath("$.result.content[0].streetAddress", is("Schwanthalerstr. 7031")))
                .andExpect(jsonPath("$.result.content[0].postalCode", is("80925")))
                .andExpect(jsonPath("$.result.content[0].city", is("Munich")))
                .andExpect(jsonPath("$.result.content[0].stateProvince", is("Bavaria")))
                .andExpect(jsonPath("$.result.content[0].countryId", is("DE")))
                .andExpect(jsonPath("$.result.content[0].countryName", is("Germany")))
                .andExpect(jsonPath("$.result.content[0].regionId", is(1)))
                .andExpect(jsonPath("$.result.content[0].regionName", is("Europe")))

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
                .andExpect(jsonPath("$.result.totalElements", is(1)))
                .andExpect(jsonPath("$.result.first", is(true)))
                .andExpect(jsonPath("$.result.size", is(10)))
                .andExpect(jsonPath("$.result.number", is(0)))
                .andExpect(jsonPath("$.result.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.sort.sorted", is(true)))
                .andExpect(jsonPath("$.result.numberOfElements", is(1)))
                .andExpect(jsonPath("$.result.empty", is(false)))

                .andDo(restDocs.document(
                        requestFields(
                                fieldWithPath("size").type(JsonFieldType.NUMBER).description("페이지당 크기").optional()
                                        .attributes(
                                                key("default").value("10"),
                                                key("min").value("1")
                                        ),
                                fieldWithPath("page").type(JsonFieldType.NUMBER).description("페이지 번호").optional()
                                        .attributes(
                                                key("default").value("0"),
                                                key("min").value("0")
                                        ),
                                fieldWithPath("departmentId").type(JsonFieldType.NUMBER).description("부서 ID").optional()
                                        .attributes(
                                                key("query").value("EQ departmentId")
                                        ),
                                fieldWithPath("departmentName").type(JsonFieldType.STRING).description("부서명").optional()
                                        .attributes(
                                                key("query").value("LIKE departmentName")
                                        ),
                                fieldWithPath("managerId").type(JsonFieldType.NUMBER).description("부서 관리자 ID").optional()
                                        .attributes(
                                                key("query").value("EQ managerId")
                                        ),
                                fieldWithPath("managerName").type(JsonFieldType.STRING).description("부서 관리자 이름").optional()
                                        .attributes(
                                                key("query").value("LIKE managerFirstName OR LIKE managerLastName")
                                        ),
                                fieldWithPath("locationId").type(JsonFieldType.NUMBER).description("주소 정보 ID").optional()
                                        .attributes(
                                                key("query").value("EQ locationId")
                                        ),
                                fieldWithPath("streetAddress").type(JsonFieldType.STRING).description("주소").optional()
                                        .attributes(
                                                key("query").value("LIKE streetAddress")
                                        ),
                                fieldWithPath("countryId").type(JsonFieldType.STRING).description("국가 ID").optional()
                                        .attributes(
                                                key("query").value("EQ countryId")
                                        ),
                                fieldWithPath("countryName").type(JsonFieldType.STRING).description("국가명").optional()
                                        .attributes(
                                                key("query").value("LIKE countryName")
                                        ),
                                fieldWithPath("regionId").type(JsonFieldType.NUMBER).description("지역 ID").optional()
                                        .attributes(
                                                key("query").value("EQ regionId")
                                        ),
                                fieldWithPath("regionName").type(JsonFieldType.STRING).description("지역명").optional()
                                        .attributes(
                                                key("query").value("LIKE regionName")
                                        )
                        ),
                        responseFields(
                                fieldWithPath("message").description("시스템 메시지"),
                                fieldWithPath("result.content[]").description("오브젝트"),
                                fieldWithPath("result.content[].departmentId").description("부서 ID"),
                                fieldWithPath("result.content[].departmentName").description("부서명"),
                                fieldWithPath("result.content[].managerId").description("부서 관리자 ID").optional(),
                                fieldWithPath("result.content[].managerFirstName").description("부서 관리자 성").optional(),
                                fieldWithPath("result.content[].managerLastName").description("부서 관리자 이름").optional(),
                                fieldWithPath("result.content[].managerEmail").description("부서 관리자 이메일").optional(),
                                fieldWithPath("result.content[].managerPhoneNumber").description("부서 관리자 전화번호").optional(),
                                fieldWithPath("result.content[].locationId").description("주소 정보 ID"),
                                fieldWithPath("result.content[].streetAddress").description("주소"),
                                fieldWithPath("result.content[].postalCode").description("우편번호").optional(),
                                fieldWithPath("result.content[].city").description("도시"),
                                fieldWithPath("result.content[].stateProvince").description("주").optional(),
                                fieldWithPath("result.content[].countryId").description("국가 ID"),
                                fieldWithPath("result.content[].countryName").description("국가명"),
                                fieldWithPath("result.content[].regionId").description("지역 ID"),
                                fieldWithPath("result.content[].regionName").description("지역명"),

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

}
