package com.ecoandrich.hr.external.controller;

import com.ecoandrich.hr.base.ControllerBaseTest;
import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.payload.openapi.OpenAPIPayloads;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OpenAPIControllerTest extends ControllerBaseTest {

    @Test
    @Order(1)
    @DisplayName("서울특별시 동작구 횡단보도 정보조회, 성공")
    public void crossWalkOpenApiSuccess() throws Exception {
        String uri = Uris.OPEN_API_ROOT + "/crossWalk";

        mockMvc.perform(
                        get(uri)
                                .queryParam("size", "10")
                                .queryParam("page", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.numOfRows", notNullValue()))
                .andExpect(jsonPath("$.result.totalCount", notNullValue()))
                .andExpect(jsonPath("$.result.resultCode", notNullValue()))
                .andExpect(jsonPath("$.result.resultMsg", notNullValue()))

                .andExpect(jsonPath("$.result.body[0]", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CRSLK_MNG_NO", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CTPV_NM", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].SGG_NM", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].ROAD_NM", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LCTN_ROAD_NM_ADDR", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LCTN_LOTNO_ADDR", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CRSLK_KND_CD", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].BCR_CMBNAT_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].HGLND_APLCN_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LAT", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LOT", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LANE_CNT", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CRSLK_BT", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CRSLK_LT", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].PDSTRN_TFCLGHT_ENNC", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].PDSTRN_FNSGGR_ENNC", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].SNSGGR_INSTL_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].GREEN_SIGNL_HR", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].RED_SIGNL_HR", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].TRFCILND_ENNC", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].LWSDWK_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].BRLL_BLCK_ENNC", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CNCTR_LGHT_FCLT_ENNC", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].SMRT_CRSLK_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].BOARD_EXST_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].CCTV_EXST_YN", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].MNG_INST_NM", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].MNG_INST_TELNO", notNullValue()))
                .andExpect(jsonPath("$.result.body[0].DATA_CRTR_YMD", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.body[0].CRSLK_MNG_NO", is("06-0000003002")))
                .andExpect(jsonPath("$.result.body[0].CTPV_NM", is("서울특별시")))
                .andExpect(jsonPath("$.result.body[0].SGG_NM", is("동작구")))
                .andExpect(jsonPath("$.result.body[0].ROAD_NM", is("사당로23길")))
                .andExpect(jsonPath("$.result.body[0].LCTN_ROAD_NM_ADDR", is("서울특별시 동작구 사당로23길 2")))
                .andExpect(jsonPath("$.result.body[0].LCTN_LOTNO_ADDR", is("서울특별시 동작구 사당동 323-1")))
                .andExpect(jsonPath("$.result.body[0].CRSLK_KND_CD", is("01")))
                .andExpect(jsonPath("$.result.body[0].BCR_CMBNAT_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].HGLND_APLCN_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].LAT", is(37.4839520296)))
                .andExpect(jsonPath("$.result.body[0].LOT", is(126.9773586481)))
                .andExpect(jsonPath("$.result.body[0].LANE_CNT", is(4)))
                .andExpect(jsonPath("$.result.body[0].CRSLK_BT", is(5.7)))
                .andExpect(jsonPath("$.result.body[0].CRSLK_LT", is(28.1)))
                .andExpect(jsonPath("$.result.body[0].PDSTRN_TFCLGHT_ENNC", is("Y")))
                .andExpect(jsonPath("$.result.body[0].PDSTRN_FNSGGR_ENNC", is("Y")))
                .andExpect(jsonPath("$.result.body[0].SNSGGR_INSTL_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].GREEN_SIGNL_HR", is(40)))
                .andExpect(jsonPath("$.result.body[0].RED_SIGNL_HR", is(90)))
                .andExpect(jsonPath("$.result.body[0].TRFCILND_ENNC", is("N")))
                .andExpect(jsonPath("$.result.body[0].LWSDWK_YN", is("Y")))
                .andExpect(jsonPath("$.result.body[0].BRLL_BLCK_ENNC", is("Y")))
                .andExpect(jsonPath("$.result.body[0].CNCTR_LGHT_FCLT_ENNC", is("Y")))
                .andExpect(jsonPath("$.result.body[0].SMRT_CRSLK_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].BOARD_EXST_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].CCTV_EXST_YN", is("N")))
                .andExpect(jsonPath("$.result.body[0].MNG_INST_NM", is("서울특별시 동작구청")))
                .andExpect(jsonPath("$.result.body[0].MNG_INST_TELNO", is("02-820-1522")))
                .andExpect(jsonPath("$.result.body[0].DATA_CRTR_YMD", is("20221221")))

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
                                fieldWithPath("result").description("오브젝트"),
                                fieldWithPath("result.numOfRows").description("한 페이지 결과 수"),
                                fieldWithPath("result.totalCount").description("전체 결과 수"),
                                fieldWithPath("result.resultCode").description("결과코드"),
                                fieldWithPath("result.resultMsg").description("결과메시지"),

                                fieldWithPath("result.body[]").description("OpenAPI Repsonse Body"),
                                fieldWithPath("result.body[].CRSLK_MNG_NO").description("각 관리기관에서 부여하는 횡단보도 관리번호"),
                                fieldWithPath("result.body[].CTPV_NM").description("횡단보도가 위치한 광역시, 도 명칭"),
                                fieldWithPath("result.body[].SGG_NM").description("횡단보도가 위치한 시, 군, 구의 명칭"),
                                fieldWithPath("result.body[].ROAD_NM").description("횡단보도가 위치한 도로의 명칭"),
                                fieldWithPath("result.body[].LCTN_ROAD_NM_ADDR").description("횡단보도가 위치한 상세 도로명주소"),
                                fieldWithPath("result.body[].LCTN_LOTNO_ADDR").description("횡단보도가 위치한 상세 지번주소"),
                                fieldWithPath("result.body[].CRSLK_KND_CD").description("횡단보도 형태에 따른 종류"),
                                fieldWithPath("result.body[].BCR_CMBNAT_YN").description("자전거 횡단도와의 겸용 여부"),
                                fieldWithPath("result.body[].HGLND_APLCN_YN").description("횡단보도 고원식 적용 여부"),
                                fieldWithPath("result.body[].LAT").description("WGS(World Geodetic System)84위도좌표계 사용"),
                                fieldWithPath("result.body[].LOT").description("WGS(World Geodetic System)84경도 좌표계 사용"),
                                fieldWithPath("result.body[].LANE_CNT").description("횡단보도가 위치한 도로에서 차량이 통행할 수 있도록 차선으로 구분되는 차로의 수"),
                                fieldWithPath("result.body[].CRSLK_BT").description("횡단보도의 폭"),
                                fieldWithPath("result.body[].CRSLK_LT").description("횡단보도의 길이"),
                                fieldWithPath("result.body[].PDSTRN_TFCLGHT_ENNC").description("보행자신호등 유무"),
                                fieldWithPath("result.body[].PDSTRN_FNSGGR_ENNC").description("보행자 스스로 신호를 요청할 수 있는 누름버튼의 부착 여부"),
                                fieldWithPath("result.body[].SNSGGR_INSTL_YN").description("신호등의 음향신호기 설치 여부"),
                                fieldWithPath("result.body[].GREEN_SIGNL_HR").description("횡단보도 신호등의 녹색 신호 유지 시간(초 단위(SS)"),
                                fieldWithPath("result.body[].RED_SIGNL_HR").description("횡단보도 신호등의 적색 신호 유지 시간(초 단위(SS)"),
                                fieldWithPath("result.body[].TRFCILND_ENNC").description("횡단보도 내 교통섬 유무"),
                                fieldWithPath("result.body[].LWSDWK_YN").description("횡단보도 내 보도턱 낮춤 여부"),
                                fieldWithPath("result.body[].BRLL_BLCK_ENNC").description("횡단보도 내 점자블록 설치 여부"),
                                fieldWithPath("result.body[].CNCTR_LGHT_FCLT_ENNC").description("횡단보도 집중조명시설 설치 여부"),
                                fieldWithPath("result.body[].SMRT_CRSLK_YN").description("보행자 보호 솔루션, 바닥신호등, 스마트 라이트, 보행신호 보조장치, 바닥 스몸비 깨우미 등으로 구성되는 스마트횡단보도 설치 여부"),
                                fieldWithPath("result.body[].BOARD_EXST_YN").description("해당 시설물에 전광판 존재 여부"),
                                fieldWithPath("result.body[].CCTV_EXST_YN").description("해당 시설물에 CCTV 존재 여부"),
                                fieldWithPath("result.body[].MNG_INST_NM").description("횡단보도 관리·감독 기관명"),
                                fieldWithPath("result.body[].MNG_INST_TELNO").description("횡단보도 관리·감독 기관 전화번호"),
                                fieldWithPath("result.body[].DATA_CRTR_YMD").description("데이터 작성 기준일자")
                        )
                ));
    }

}
