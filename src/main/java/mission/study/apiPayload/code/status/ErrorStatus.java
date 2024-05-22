package mission.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.code.ErrorReasonDTO;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Member Error
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수입니다."),

    // Article Error
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다"),

    // Temp Error
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // Food Category Error
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "CATEGORY4001", "해당 카테고리를 찾을 수 없습니다"),

    // Region Error
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "해당 지역을 찾을 수 없습니다."),

    // Store Error
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "Store4001", "해당 가게를 찾을 수 없습니다."),

    // Mission Error
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "Mission4001", "해당 미션을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
