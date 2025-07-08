package io.github.arxtd.branchflow_api.infra.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item not found");
    }
    public ItemNotFoundException(final String message) {super(message);}
}
