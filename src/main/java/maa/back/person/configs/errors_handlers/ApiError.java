package maa.back.person.configs.errors_handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
class ApiError {

    private HttpStatus status;
    private Timestamp timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private ApiError() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
@Data
@EqualsAndHashCode
@AllArgsConstructor
class ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiSubError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}