package io.github.arxtd.branchflow_api.infra.exception;

public class NullFieldException extends RuntimeException {
    public NullFieldException(String message) {
        super(message);
    }
}
