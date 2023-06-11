package com.ecoandrich.hr.payload.openapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

public class OpenAPIPayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        /**
         * 한 페이지 결과 수
         */
        private Integer numOfRows;

        /**
         * 전체 결과 수
         */
        private Integer totalCount;

        /**
         * 결과코드
         */
        private String resultCode;

        /**
         * 결과메시지
         */
        private String resultMsg;
    }

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CrossWalkResponse {
        private List<CrossWalkBody> body;

        @JsonUnwrapped
        private Header header;
    }

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CrossWalkBody {
        /**
         * 각 관리기관에서 부여하는 횡단보도 관리번호
         */
        @JsonProperty("CRSLK_MNG_NO")
        private String crslkMngNo;

        /**
         * 횡단보도가 위치한 광역시, 도 명칭
         */
        @JsonProperty("CTPV_NM")
        private String ctpvNm;

        /**
         * 횡단보도가 위치한 시, 군, 구의 명칭
         */
        @JsonProperty("SGG_NM")
        private String sggNm;

        /**
         * 횡단보도가 위치한 도로의 명칭
         */
        @JsonProperty("ROAD_NM")
        private String roadNm;

        /**
         * 횡단보도가 위치한 상세 도로명주소
         */
        @JsonProperty("LCTN_ROAD_NM_ADDR")
        private String lctnRoadNmAddr;

        /**
         * 횡단보도가 위치한 상세 지번주소
         */
        @JsonProperty("LCTN_LOTNO_ADDR")
        private String lctnLotnoAddr;

        /**
         * 횡단보도 형태에 따른 종류
         */
        @JsonProperty("CRSLK_KND_CD")
        private String crslkKndCd;

        /**
         * 자전거 횡단도와의 겸용 여부
         */
        @JsonProperty("BCR_CMBNAT_YN")
        private Yn bcrCmbnatYn;

        /**
         * 횡단보도 고원식 적용 여부
         */
        @JsonProperty("HGLND_APLCN_YN")
        private Yn hglndAplcnYn;

        /**
         * WGS(World Geodetic System)84 위도좌표계 사용
         */
        @JsonProperty("LAT")
        private BigDecimal lat;

        /**
         * WGS(World Geodetic System)84 경도 좌표계 사용
         */
        @JsonProperty("LOT")
        private BigDecimal lot;

        /**
         * 횡단보도가 위치한 도로에서 차량이 통행할 수 있도록 차선으로 구분되는 차로의 수
         */
        @JsonProperty("LANE_CNT")
        private Integer laneCnt;

        /**
         * 횡단보도의 폭
         */
        @JsonProperty("CRSLK_BT")
        private Float crslkBt;

        /**
         * 횡단보도의 길이
         */
        @JsonProperty("CRSLK_LT")
        private Float crslkLt;

        /**
         * 보행자신호등 유무
         */
        @JsonProperty("PDSTRN_TFCLGHT_ENNC")
        private Yn pdstrnTfclghtEnnc;

        /**
         * 보행자 스스로 신호를 요청할 수 있는 누름버튼의 부착 여부
         */
        @JsonProperty("PDSTRN_FNSGGR_ENNC")
        private Yn pdstrnFnsggrEnnc;

        /**
         * 신호등의 음향신호기 설치 여부
         */
        @JsonProperty("SNSGGR_INSTL_YN")
        private Yn snsggrInstlYn;

        /**
         * 횡단보도 신호등의 녹색 신호 유지 시간(초 단위(SS)
         */
        @JsonProperty("GREEN_SIGNL_HR")
        private Integer greenSignlHr;

        /**
         * 횡단보도 신호등의 적색 신호 유지 시간(초 단위(SS)
         */
        @JsonProperty("RED_SIGNL_HR")
        private Integer redSignlHr;

        /**
         * 횡단보도 내 교통섬 유무
         */
        @JsonProperty("TRFCILND_ENNC")
        private Yn trfcilndEnnc;

        /**
         * 횡단보도 내 보도턱 낮춤 여부
         */
        @JsonProperty("LWSDWK_YN")
        private Yn lwsdwkYn;

        /**
         * 횡단보도 내 점자블록 설치 여부
         */
        @JsonProperty("BRLL_BLCK_ENNC")
        private Yn brllBlckEnnc;

        /**
         * 횡단보도 집중조명시설 설치 여부
         */
        @JsonProperty("CNCTR_LGHT_FCLT_ENNC")
        private Yn cnctrLghtFcltEnnc;

        /**
         * 보행자 보호 솔루션, 바닥신호등, 스마트 라이트, 보행신호 보조장치, 바닥 스몸비 깨우미 등으로 구성되는 스마트횡단보도 설치 여부
         */
        @JsonProperty("SMRT_CRSLK_YN")
        private Yn smrtCrslkYn;

        /**
         * 해당 시설물에 전광판 존재 여부
         */
        @JsonProperty("BOARD_EXST_YN")
        private Yn boardExstYn;

        /**
         * 해당 시설물에 CCTV 존재 여부
         */
        @JsonProperty("CCTV_EXST_YN")
        private Yn cctvExstYn;

        /**
         * 횡단보도 관리·감독 기관명
         */
        @JsonProperty("MNG_INST_NM")
        private String mngInstNm;

        /**
         * 횡단보도 관리·감독 기관 전화번호
         */
        @JsonProperty("MNG_INST_TELNO")
        private String mngInstTelno;

        /**
         * 데이터 작성 기준일자
         */
        @JsonProperty("DATA_CRTR_YMD")
        private String dataCrtrYmd;
    }

    public enum Yn {
        Y, N
    }

}
